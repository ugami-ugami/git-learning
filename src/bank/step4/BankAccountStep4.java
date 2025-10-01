package bank.step4;

import java.math.BigDecimal;                     // Денежные суммы
import java.time.Instant;                        // Время операции
import java.util.ArrayList;                      // Внутреннее хранилище
import java.util.Collections;                    // Невозможность изменить список снаружи
import java.util.List;                           // Интерфейс списка
import java.util.Objects;                        // Быстрые null-проверки

// Доменная модель банковского счёта с историей операций
class BankAccount {
    private final String accountId;              // Идентификатор счёта — неизменяем
    private BigDecimal balance;                  // Баланс — закрыт инкапсуляцией

    // История операций хранится внутри и не отдаётся на изменение наружу
    private final List<Transaction> transactions = new ArrayList<>(); // внутренний "mutable" список

    public BankAccount(String accountId, BigDecimal initialBalance) {
        this.accountId = requireNonBlank(accountId, "accountId is required");         // приватная проверка строки
        this.balance   = requireNonNegative(initialBalance, "initialBalance >= 0");   // приватная проверка суммы
        addTransaction(TransactionType.OPEN, initialBalance);                         // фиксируем открытие счёта
    }

    // ===== Публичное API (чтение/операции) =====

    public String getAccountId() {               // Геттер ID
        return accountId;
    }

    public BigDecimal getBalance() {             // Геттер баланса
        return balance;
    }

    public void deposit(BigDecimal amount) {     // Пополнение
        amount = requirePositive(amount, "deposit amount > 0");   // приватная валидация
        balance = balance.add(amount);                             // изменение состояния только здесь
        addTransaction(TransactionType.DEPOSIT, amount);           // фиксируем операцию
    }

    public void withdraw(BigDecimal amount) {    // Списание
        amount = requirePositive(amount, "withdraw amount > 0");
        ensureSufficientFunds(amount);                                  // приватная бизнес-проверка
        balance = balance.subtract(amount);
        addTransaction(TransactionType.WITHDRAW, amount);
    }

    // Возвращаем НЕМЕНЯЕМЫЙ вид истории — внешнему коду нельзя ничего модифицировать
    public List<Transaction> getTransactions() {
        return Collections.unmodifiableList(transactions);              // защита коллекции
    }

    // Фильтрованная история с копией — безопасно для внешнего кода
    public List<Transaction> getTransactionsSince(Instant from) {
        Objects.requireNonNull(from, "from must not be null");          // точечная проверка
        List<Transaction> result = new ArrayList<>();
        for (Transaction t : transactions) {
            if (!t.timestamp().isBefore(from)) {
                result.add(t);
            }
        }
        return Collections.unmodifiableList(result);                    // тоже отдаём как readonly
    }

    // ===== Приватные вспомогательные методы (инкапсулированная служебная логика) =====

    private static String requireNonBlank(String s, String message) {   // проверка строк
        if (s == null || s.isEmpty()) {
            throw new IllegalArgumentException(message);
        }
        return s;
    }

    private static BigDecimal requireNonNegative(BigDecimal v, String message) { // ≥ 0
        if (v == null || v.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException(message);
        }
        return v;
    }

    private static BigDecimal requirePositive(BigDecimal v, String message) {    // > 0
        if (v == null || v.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException(message);
        }
        return v;
    }

    private void ensureSufficientFunds(BigDecimal amount) {             // бизнес-инвариант
        if (amount.compareTo(balance) > 0) {
            throw new IllegalStateException("insufficient funds");
        }
    }

    private void addTransaction(TransactionType type, BigDecimal amount) { // централизованное добавление записи
        transactions.add(new Transaction(type, amount, Instant.now(), balance));
    }
}

// Иммутабельная запись об операции
final class Transaction {
    private final TransactionType type;          // Тип операции
    private final BigDecimal amount;            // Сумма операции
    private final Instant timestamp;            // Время операции
    private final BigDecimal balanceAfter;      // Баланс после операции (для аудита)

    public Transaction(TransactionType type, BigDecimal amount, Instant timestamp, BigDecimal balanceAfter) {
        this.type = Objects.requireNonNull(type);
        this.amount = Objects.requireNonNull(amount);
        this.timestamp = Objects.requireNonNull(timestamp);
        this.balanceAfter = Objects.requireNonNull(balanceAfter);
    }

    // "Геттеры" в виде record-подобных методов (читается лаконично)
    public TransactionType type()      { return type; }
    public BigDecimal amount()         { return amount; }
    public Instant timestamp()         { return timestamp; }
    public BigDecimal balanceAfter()   { return balanceAfter; }
}

enum TransactionType { OPEN, DEPOSIT, WITHDRAW } // типы операций

// Демонстрация
public class BankAccountStep4 {
    public static void main(String[] args) {
        BankAccount acc = new BankAccount("ACC-004", new BigDecimal("1000.00"));

        acc.deposit(new BigDecimal("200.00"));      // +200 → 1200
        acc.withdraw(new BigDecimal("150.00"));     // -150 → 1050

        System.out.println(acc.getAccountId() + " balance = " + acc.getBalance());

        // Получаем историю — список только для чтения
        List<Transaction> history = acc.getTransactions();
        for (Transaction t : history) {
            System.out.println(t.timestamp() + "  " + t.type() + "  " + t.amount() + "  → balance " + t.balanceAfter());
        }

        // Попытка модификации извне — раскомментируй, чтобы увидеть исключение UnsupportedOperationException
        // history.clear(); // ❌ нельзя: история защищена unmodifiableList
    }
}