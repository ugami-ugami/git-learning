package bank.step1; // Пакет — группируем код по шагам, удобно в IDE

// Класс без инкапсуляции — так делать нельзя (показательный антипример)
class BankAccountRaw {
    public String accountId;   // ПОЛЕ открыто для записи откуда угодно — можно подменить ID
    public double balance;     // ПОЛЕ деньги в double — ещё и нет проверок, можно уйти в минус

    // "Конструктор" принимает всё как есть — без проверок
    public BankAccountRaw(String accountId, double balance) {
        this.accountId = accountId; // присваиваем как пришло
        this.balance = balance;     // присваиваем как пришло
    }

    // Пополнение — без проверок (можно пополнить отрицательным числом)
    public void deposit(double amount) {
        balance += amount; // никакой валидации
    }

    // Списание — без проверок (можно уйти в минус)
    public void withdraw(double amount) {
        balance -= amount; // никакой валидации
    }
}

// Класс с main — запускаем отсюда
public class BankAccountStep1 {
    public static void main(String[] args) {
        // Создаём "сырое" состояние — нулевой баланс, валидность не проверяется
        BankAccountRaw acc = new BankAccountRaw("ACC-001", 0.0); // ОТКРЫТАЯ модель

        // Делаем пополнение, но... отрицательной суммой (это абсурдно, но код позволит)
        acc.deposit(-500.0); // баланс станет -500.0 — нарушение здравого смысла

        // Меняем ID счёта напрямую — внешнему коду вообще нельзя так уметь
        acc.accountId = "HACKED-ID"; // подмена идентификатора

        // Уходим в ещё больший минус
        acc.withdraw(200.0); // баланс станет -700.0

        // Печатаем "итог"
        System.out.println("AccountId = " + acc.accountId); // увидим HACKED-ID
        System.out.println("Balance   = " + acc.balance);   // увидим -700.0
    }
}

/*
Что здесь важно (коротко, по best practices)
	•	Поля public → инкапсуляции нет, объект легко «сломать».
	•	double для денег → плохо из-за ошибок округления, но пока оставляем как антипример.
	•	Нет проверок в deposit/withdraw → допускается отрицательное пополнение и перерасход.
*/