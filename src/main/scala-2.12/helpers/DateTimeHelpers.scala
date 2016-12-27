package helpers

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.temporal.WeekFields
import java.util.Locale

object DateTimeHelpers {

  private val dateTimeFormatter: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
  private val weekOfWeekyear = WeekFields.of(Locale.getDefault()).weekOfWeekBasedYear()

  def parse(str: String): LocalDate = {
    LocalDate.parse(str, dateTimeFormatter)
  }

  def getWeekOfWeekyear(dateTime: LocalDate): Int = {
    dateTime.get(weekOfWeekyear)
  }
}
