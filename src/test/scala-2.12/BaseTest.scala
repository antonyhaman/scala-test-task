import helpers.{DataStructureConverter, FlightDataFileReader}
import models.FlightData
import org.specs2.Specification

abstract class BaseTest extends Specification {
  val rawTestFlightData: List[List[String]] = FlightDataFileReader.read("src/test/resources/test_planes_log.csv")
  val flightDataSet: Set[FlightData] = DataStructureConverter.convertIntoFlightDataSet(rawTestFlightData)
}
