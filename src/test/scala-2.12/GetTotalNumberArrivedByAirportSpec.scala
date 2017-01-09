import helpers.DataStructureConverter

class GetTotalNumberArrivedByAirportSpec extends BaseTest { def is = s2"""

 This is a specification to check the getTotalNumberArrivedByAirport() function

 Total number of arrived planes to airports map should
   have 7 elements                                                                                $e1
   have pairs "CLE" -> 0, "CLT" -> 1, "JFK" -> 2, "LAX" -> 2, "HNL" -> 2, "DFW" -> 2, "OGG" -> 5  $e2
                                                                                                  """

  private val totalNumberArrivedByAirportMap = DataStructureConverter.getTotalNumberArrivedByAirport(flightDataSet)

  def e1 = totalNumberArrivedByAirportMap must have size 7
  def e2 = totalNumberArrivedByAirportMap must havePairs("CLE" -> 0, "CLT" -> 1, "JFK" -> 2, "LAX" -> 2, "HNL" -> 2, "DFW" -> 2, "OGG" -> 5)
}