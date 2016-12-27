package helpers

import java.io.File

import com.github.tototoshi.csv.CSVReader

object FlightDataFileReader {

  def read(filePath: String): List[List[String]] = {
    CSVReader.open(new File(filePath)).all().drop(1)
  }
}
