package bankingkata

import io.mockk.every
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.junit5.MockKExtension
import io.mockk.verify
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
internal class AccountTest {

    @RelaxedMockK
    private lateinit var statementPrinter: StatementPrinter
    @RelaxedMockK
    private lateinit var transactionRepository: TransactionRepository

    private lateinit var account: Account

    @BeforeEach
    internal fun setUp() {
        account = Account(transactionRepository, statementPrinter)
    }

    @Test
    internal fun `store a deposit transaction`() {
        account.deposit(100)
        verify {
            transactionRepository.addDeposit(100)
        }
    }

    @Test
    internal fun `store a withdraw transaction`() {
        account.withdraw(100)
        verify {
            transactionRepository.addWithdraw(100)
        }
    }

    @Test
    internal fun `print a Statement`() {
        val transactions: List<Transaction> = listOf(Transaction("31/08/2022",100))
        every { transactionRepository.allTransactions } returns transactions

        account.printStatement()

        verify {
            statementPrinter.print(transactions)
        }
    }
}
