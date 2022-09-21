package bankingkata

import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import io.mockk.verify
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
internal class AccountTest {

    @MockK(relaxUnitFun = true)
    private lateinit var statementPrinter: StatementPrinter

    @MockK(relaxUnitFun = true)
    private lateinit var transcationLog: TransactionLog
    private lateinit var account: Account

    @BeforeEach
    internal fun setUp() {
        account = Account(transcationLog, statementPrinter)
    }

    @Test
    internal fun deposit() {
        account.deposit(200)

        verify {
            transcationLog.addDeposit(200)
        }
    }

    @Test
    internal fun withdraw() {
        account.withdraw(300)

        verify {
            transcationLog.addWithdraw(300)
        }
    }

    @Test
    internal fun printStatement() {
        val transactions = listOf(Transaction())
        every {
            transcationLog.allTransactions
        } returns transactions
        account.printStatement()

        verify {
            statementPrinter.printAll(transactions)
        }
    }
}
