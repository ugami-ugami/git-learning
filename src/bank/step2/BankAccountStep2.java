package bank.step2;                                   // Группируем код по шагам

// Инкапсулированная модель банковского счёта (ещё на double, BigDecimal будет позже)
class BankAccount {
    private final String accountId;                   // private + final: ID задаётся один раз и больше не меняется
    private double balance;                           // private: внешнему коду недоступен прямой доступ к балансу

    public BankAccount(String accountId, double initialBalance) { // Конструктор: создаём валидный объект
        if (accountId == null || accountId.isEmpty()) {           // Проверяем корректность ID
            throw new IllegalArgumentException("accountId is required");
        }
        if (initialBalance < 0) {                                  // Нельзя открывать счёт с отрицательным балансом
            throw new IllegalArgumentException("initialBalance must be >= 0");
        }
        this.accountId = accountId;                                // Присваиваем валидный ID
        this.balance = initialBalance;                             // Присваиваем валидный стартовый баланс
    }

    public String getAccountId() {                 // Геттер: читаем ID (менять нельзя — поле final)
        return accountId;
    }

    public double getBalance() {                   // Геттер: читаем баланс (только просмотр)
        return balance;
    }

    public void deposit(double amount) {           // Пополнение — публичный метод (контролируем изменение)
        if (amount <= 0) {                         // Валидация: пополнять нужно положительной суммой
            throw new IllegalArgumentException("deposit amount must be > 0");
        }
        balance += amount;                         // Безопасное изменение инкапсулированного поля
    }

    public void withdraw(double amount) {          // Списание — публичный метод с проверками
        if (amount <= 0) {                         // Нельзя списывать ноль/отрицательное
            throw new IllegalArgumentException("withdraw amount must be > 0");
        }
        if (amount > balance) {                    // Нельзя уходить в минус (без овердрафта)
            throw new IllegalStateException("insufficient funds");
        }
        balance -= amount;                         // Корректируем баланс
    }
}

// Демонстрация
public class BankAccountStep2 {
    public static void main(String[] args) {
        BankAccount acc = new BankAccount("ACC-001", 1000.0);  // Создаём валидный счёт

        acc.deposit(250.0);                                    // +250 → 1250.0
        System.out.println(acc.getAccountId() + " balance = " + acc.getBalance());

        acc.withdraw(200.0);                                   // -200 → 1050.0
        System.out.println(acc.getAccountId() + " balance = " + acc.getBalance());

        // Ниже раскомментируй по очереди и убедись, что защита работает:
        // acc.deposit(0);                                      // IllegalArgumentException
        // acc.deposit(-10);                                    // IllegalArgumentException
        // acc.withdraw(0);                                     // IllegalArgumentException
        // acc.withdraw(999999);                                // IllegalStateException (insufficient funds)

        // Прямой доступ к полям запрещён компилятором:
        // acc.balance = -1;                                    // ❌ так нельзя (private)
        // acc.accountId = "HACKED";                            // ❌ так нельзя (private + final)
    }
}

/*
Почему так (best practices, коротко)
	•	private поля: внешнему коду недоступны «дырки» для записи мусора. Изменения только через методы с проверками.
	•	Валидация в конструкторе: объект сразу создаётся в корректном состоянии.
	•	ID final: идентификатор сущности неизменяем — это снижает класс ошибок.
	•	Методы-мутаторы с проверками: deposit/withdraw — единственная точка изменения баланса, здесь же бизнес-правила.
	•	Исключения по месту: чем раньше отловим некорректный ввод, тем лучше.
*/