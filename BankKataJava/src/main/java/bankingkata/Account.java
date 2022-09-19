package bankingkata;

public class Account {

    private final TransactionLog transactionLog;

    public Account(TransactionLog transactionLog) {
        this.transactionLog = transactionLog;
    }

    public void withdraw(int amount) {
        transactionLog.addWithdraw(amount);
    }

    public void deposit(int amount) {
        transactionLog.addDeposit(amount);
    }

    public void printStatement() {
        throw new RuntimeException("Not yet implemented");
    }

}
