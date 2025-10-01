package bank.step3;

import java.math.BigDecimal;

class BankAccount {
    private final String accountId;
    private BigDecimal balance;

    public BankAccount(String accountId, BigDecimal initialBalance) {
        if (accountId == null || accountId.isEmpty()) {
            throw new IllegalArgumentException("accountId is required");
        }
        if (initialBalance == null || initialBalance.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("initialBalance must be >= 0");
        }
        this.accountId = accountId;
        this.balance = initialBalance;
    }

    public String getAccountId() {
        return accountId;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void deposit(BigDecimal amount) {
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("deposit amount must be > 0");
        }
        balance = balance.add(amount);
    }
    public void withdraw(BigDecimal amount) {
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("withdraw amount must be > 0");
        }
        if (amount.compareTo(balance) > 0) {
                throw new IllegalArgumentException("insufficient funds");
        }
        balance = balance.subtract(amount);
    }
}

public class BankAccountStep3 {
    public static void main(String[] args) {
        BankAccount acc = new BankAccount("ACC-001", new BigDecimal("1000.0"));

        acc.deposit(new BigDecimal(250.0));
        System.out.println(acc.getAccountId() + "  balance = " + acc.getBalance());

        acc.withdraw(new BigDecimal(100.0));
        System.out.println(acc.getAccountId()+ " balance = " + acc.getBalance());
    }
}