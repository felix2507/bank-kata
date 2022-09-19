package bankingkata

import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import io.mockk.verifyOrder
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
class PrintStatementFeatureTest {

    @MockK
    private lateinit var console: Console

    private lateinit var account: Account

    @BeforeEach
    fun before() {
        account = Account(TransactionLog())
    }

    @Test
    fun `prints all Statements to console`(){
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
