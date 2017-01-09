import helpers.DataStructureConverter

class GetTotalNumberArrivedByAirportGropedByWeeksSpec extends BaseTest { def is = s2"""

 This is a specification to check the getTotalNumberArrivedByAirportGropedByWeeks() function

 Flight data sets grouped by weeks should
   have 4 elements                                                                     $e1
   have pair "1, Map("DFW" -> 2, "HNL" -> 2, "JFK" -> 2, "LAX" -> 2, "OGG" -> 0)"      $e2
   have pair "2, Map("DFW" -> 0, "OGG" -> 2)"                                          $e3
   have pair "3, Map("DFW" -> 0, "OGG" -> 4)"                                          $e4
   have pair "5, Map("CLE" -> 0, "CLT" -> 1)"                                          $e5
                                                                                       """

  private val flightDataSetGropedByWeeks = DataStructureConverter.getTotalNumberArrivedByAirportGropedByWeeks(flightDataSet)

  def e1 = flightDataSetGropedByWeeks must have size 4
  def e2 = flightDataSetGropedByWeeks must havePair(1, Map("DFW" -> 2, "HNL" -> 2, "JFK" -> 2, "LAX" -> 2, "OGG" -> 0))
  def e3 = flightDataSetGropedByWeeks must havePair(2 -> Map("DFW" -> 0, "OGG" -> 1))
  def e4 = flightDataSetGropedByWeeks must havePair(3 -> Map("DFW" -> 0, "OGG" -> 4))
  def e5 = flightDataSetGropedByWeeks must havePair(5 -> Map("CLE" -> 0, "CLT" -> 1))
}
