package bankingkata;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.Mockito.*;

class AccountTest {

    private Account account;
    private final TransactionLog transactionLog = mock(TransactionLog.class);
    private final StatementPrinter statementPrinter = mock(StatementPrinter.class);

    @BeforeEach
    void setUp() {
        account = new Account(transactionLog, statementPrinter);
    }

    @Test
    void deposit() {
        account.deposit(500);

        verify(transactionLog).addDeposit(500);
    }

    @Test
    void withdraw() {
        account.withdraw(200);

        verify(transactionLog).addWithdraw(200);
    }

    @Test
    void printStatement() {
        List<Transaction> transactions = List.of(new Transaction());
        when(transactionLog.getAllTransactions()).thenReturn(transactions);

        account.printStatement();

        verify(statementPrinter).print(transactions);

    }
}
