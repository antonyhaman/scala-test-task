package helpers

import models.FlightData

import scala.collection.immutable.TreeMap

object DataStructureConverter {

  private var weekNumbersSet: Set[Int] = Set[Int]()

  def convertIntoFlightDataSet(list: List[List[String]]): Set[FlightData] = {
    var set = Set[FlightData]()
    list.foreach(line => {
      val date = DateTimeHelpers.parse(line(5))
      set += FlightData(line.head.toInt, line(1).toInt, line(2).toInt, line(3).toInt, line(4).toInt,
        date, line(6), line(7))
      weekNumbersSet += DateTimeHelpers.getWeekOfWeekyear(date)
    })
    set
  }

  def getDifferenceBetweenArrivedAndLeft(dataSet: Set[FlightData]): TreeMap[String, Int] = {
    var treeMap = TreeMap[String, Int]()
    dataSet.foreach(flightData => {
      val orig = flightData.origin
      val dest = flightData.destination
      if (!treeMap.contains(orig)) treeMap += (orig -> -1)
      else treeMap += (orig -> (treeMap(orig) - 1))
      if (!treeMap.contains(dest)) treeMap += (dest -> 1)
      else treeMap += (dest -> (treeMap(dest) + 1))
    })
    treeMap.filter((t) => t._2 != 0)
  }

  def getTotalNumberArrivedByAirportGropedByWeeks(flightDataSet: Set[FlightData]): TreeMap[Int, TreeMap[String, Int]] = {
    var treeMap = TreeMap[Int, TreeMap[String, Int]]()
    weekNumbersSet.foreach(weekNumber => {
      val flightDataByWeeks = filterFlightDataByWeeks(flightDataSet, weekNumber)
      treeMap = treeMap.insert(weekNumber, getTotalNumberArrivedByAirport(flightDataByWeeks))
    })
    treeMap
  }

  def getTotalNumberArrivedByAirport(flightDataSet: Set[FlightData]): TreeMap[String, Int] = {
    var totalNumberByAirport = TreeMap[String, Int]()
    flightDataSet.foreach(flight => {
      val orig = flight.origin
      val dest = flight.destination
      if (!totalNumberByAirport.contains(orig)) totalNumberByAirport += (orig -> 0)
      if (!totalNumberByAirport.contains(dest)) totalNumberByAirport += (dest -> 1)
      else totalNumberByAirport += (dest -> (totalNumberByAirport(dest) + 1))
    })
    totalNumberByAirport
  }

  def filterFlightDataByWeeks(flightDataSet: Set[FlightData], weekNumber: Int): Set[FlightData] = {
    flightDataSet.filter((flight) => DateTimeHelpers.getWeekOfWeekyear(flight.flDate) == weekNumber)
  }
}
