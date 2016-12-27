package helpers

import java.io.{File, PrintWriter}

import scala.collection.immutable.TreeMap

class FlightDataFileWriter(fileName: String) {

  private val path: String = "target/output/"
  private val writer: PrintWriter = initialize()

  def outputFileWriterExtended(dataMap: TreeMap[Int, TreeMap[String, Int]]): PrintWriter = {
    for ((weekNumber, map) <- dataMap) {
      writer.write(s"\nWeek number: $weekNumber\n\n")
      outputFileWriter(map)
    }
    writer
  }

  def outputFileWriter(dataMap: TreeMap[String, Int]): PrintWriter = {
    var i = 0
    for ((airport, count) <- dataMap) {
      i += 1
      writer.write(s"$i. $airport $count\n")
    }
    writer
  }

  private def initialize(): PrintWriter = {
    val fileToWrite = new File(this.path + fileName)
    fileToWrite.mkdirs()
    if (fileToWrite.exists())
      fileToWrite.delete()
    fileToWrite.createNewFile()
    new PrintWriter(fileToWrite)
  }
}
