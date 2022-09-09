package bankingkata

import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.junit5.MockKExtension
import io.mockk.verify
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
internal class LinePrinterTest{

    @RelaxedMockK
    private lateinit var console: Console

    private lateinit var linePrinter: LinePrinter

    @BeforeEach
    internal fun setUp() {
        linePrinter = LinePrinter(console)
    }

    @Test
    internal fun `prints Header`() {
        linePrinter.printHeader()

        verify {
            console.printLine(LinePrinter.HEADER)
        }
    }

    @Test
    internal fun `prints statementLine formatted`() {
        val date = "31/08/2022"
        val runningBalance = 150
        val amount = 100
        val transaction = Transaction(date, amount)
        val statementLine = StatementLine(transaction, runningBalance)

        linePrinter.print(statementLine)

        verify {
            console.printLine("$date | $amount.00 | $runningBalance.00")
        }
    }
}
