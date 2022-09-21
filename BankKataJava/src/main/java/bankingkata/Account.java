package bankingkata;

public class Account {

    private final TransactionLog transactionLog;
    private StatementPrinter statementPrinter;

    public Account(TransactionLog transactionLog, StatementPrinter statementPrinter) {
        this.transactionLog = transactionLog;
        this.statementPrinter = statementPrinter;
    }

    public void withdraw(int amount) {
        transactionLog.addWithdraw(amount);
    }

    public void deposit(int amount) {
        transactionLog.addDeposit(amount);
    }

    public void printStatement() {
        statementPrinter.print(transactionLog.getAllTransactions());
    }

}
