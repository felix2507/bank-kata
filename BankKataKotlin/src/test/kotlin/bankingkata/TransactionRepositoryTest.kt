package bankingkata

import io.kotest.matchers.collections.shouldHaveSingleElement
import io.kotest.matchers.ints.shouldBeExactly
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
internal class TransactionRepositoryTest {

    companion object {
        const val TODAY = "31/08/2022"
    }

    @MockK
    private lateinit var systemDateProvoider: SystemDateProvider

    private lateinit var transactionRepository: TransactionRepository

    @BeforeEach
    internal fun setUp() {
        transactionRepository = TransactionRepository(systemDateProvoider)
        every { systemDateProvoider.todayAsString() } returns TODAY
    }

    @Test
    internal fun `create and store a deposit transaction`() {
        transactionRepository.addDeposit(100)

        val transactions: List<Transaction> = transactionRepository.allTransactions

        transactions.size shouldBeExactly 1
        transactions shouldHaveSingleElement Transaction(TODAY, 100)
    }

    @Test
    internal fun `create and store a withdraw transaction`() {
        transactionRepository.addWithdraw(100)

        val transactions: List<Transaction> = transactionRepository.allTransactions

        transactions.size shouldBeExactly 1
        transactions shouldHaveSingleElement Transaction(TODAY, -100)
    }


}
