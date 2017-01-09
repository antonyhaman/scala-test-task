package models

import java.time.LocalDate

case class FlightData(year: Int, quarter: Int, month: Int, dayOfMonth: Int, dayOfWeek: Int,
                      flDate: LocalDate, origin: String, destination: String) {}

