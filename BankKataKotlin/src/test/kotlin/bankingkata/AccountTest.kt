package bankingkata

import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import io.mockk.verify
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
internal class AccountTest {

    @MockK(relaxUnitFun = true)
    private lateinit var transcationLog: TransactionLog
    private lateinit var account: Account

    @BeforeEach
    internal fun setUp() {
        account = Account(transcationLog)
    }

    @Test
    fun deposit() {
        account.deposit(200)

        verify {
            transcationLog.addDeposit(200)
        }
    }

    @Test
    fun withdraw() {
        account.withdraw(300)

        verify {
            transcationLog.addWithdraw(300)
        }
    }
}
