package bankingkata;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class AccountTest {

    private Account account;
    private final TransactionLog transactionLog = mock(TransactionLog.class);

    @BeforeEach
    void setUp() {
        account = new Account(transactionLog);
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


}
