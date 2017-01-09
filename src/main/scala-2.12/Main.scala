import helpers.{DataStructureConverter, FlightDataFileReader, FlightDataFileWriter}

object Main extends App {
  val rawFlightData = FlightDataFileReader.read("src/main/resources/palnes_log.csv")
  val flightDataSet = DataStructureConverter.convertIntoFlightDataSet(rawFlightData)

  new FlightDataFileWriter("task1.txt")
    .outputFileWriter(DataStructureConverter.getTotalNumberArrivedByAirport(flightDataSet)).close()

  new FlightDataFileWriter("task2.txt")
    .outputFileWriter(DataStructureConverter.getDifferenceBetweenArrivedAndLeft(flightDataSet)).close()

  new FlightDataFileWriter("task3.txt")
    .outputFileWriterExtended(DataStructureConverter.getTotalNumberArrivedByAirportGropedByWeeks(flightDataSet)).close()
}



