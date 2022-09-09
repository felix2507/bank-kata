package bankingkata

import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.junit5.MockKExtension
import io.mockk.verify
import io.mockk.verifyOrder
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
internal class StatementPrinterTest {

    @RelaxedMockK
    private lateinit var linePrinter: LinePrinter

    private lateinit var statementPrinter: StatementPrinter

    @BeforeEach
    internal fun setUp() {
        statementPrinter = StatementPrinter(linePrinter)
    }

    @Test
    internal fun `should always print header`() {
        statementPrinter.print(emptyList())

        verify {
            linePrinter.printHeader()
        }
    }

    @Test
    internal fun `should print transaction in reverse chronological order`() {
        val deposit1 = Transaction("01/04/2022", 1000)
        val withdraw = Transaction("02/04/2022", -100)
        val deposit2 = Transaction("10/04/2022", 500)
        val transactions = listOf(deposit1, withdraw, deposit2)
        statementPrinter.print(transactions)

        verifyOrder {
            linePrinter.printHeader()
            linePrinter.print(StatementLine(deposit2, 1400))
            linePrinter.print(StatementLine(withdraw, 900))
            linePrinter.print(StatementLine(deposit1, 1000))
        }
    }
}
