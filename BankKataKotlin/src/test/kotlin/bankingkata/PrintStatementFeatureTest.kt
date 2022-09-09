package bankingkata

import io.mockk.every
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.junit5.MockKExtension
import io.mockk.verifyOrder
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
class PrintStatementFeatureTest {


    @RelaxedMockK
    private lateinit var console: Console
    @RelaxedMockK
    private lateinit var systemDateProvoider: SystemDateProvider

    private lateinit var account: Account

    @BeforeEach
    fun before() {
        val transactionRepository = TransactionRepository(systemDateProvoider)
        val linePrinter = LinePrinter(console)
        val statementPrinter = StatementPrinter(linePrinter)
        account = Account(transactionRepository, statementPrinter)
    }

    @Test
    fun `prints all Statements to console`(){
        every { systemDateProvoider.todayAsString() } returnsMany listOf("01/04/2014", "02/04/2014", "10/04/2014")

        account.deposit(1000)
        account.withdraw(100)
        account.deposit(500)

        account.printStatement()

        verifyOrder {
            console.printLine("DATE | AMOUNT | BALANCE")
            console.printLine("10/04/2014 | 500.00 | 1400.00")
            console.printLine("02/04/2014 | -100.00 | 900.00")
            console.printLine("01/04/2014 | 1000.00 | 1000.00")
        }
    }


}
