package bankingkata

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import java.time.LocalDate
import java.time.Month

internal class SystemDateProviderTest{

    private val systemDateProvider = SystemDateProvider { LocalDate.of(2022, Month.AUGUST, 21) }

    @Test
    internal fun `return today as dd_mm_yyyy`() {
        val todayAsString = systemDateProvider.todayAsString()

        todayAsString shouldBe "21/08/2022"
    }
}
