package bankingkata

import java.time.LocalDate
import java.time.format.DateTimeFormatter

class SystemDateProvider(private val today: () -> LocalDate = LocalDate::now) {
    fun todayAsString(): String {
        val today = today()
        return today.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
    }


}
