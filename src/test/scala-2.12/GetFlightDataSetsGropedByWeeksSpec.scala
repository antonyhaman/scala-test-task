import helpers.DataStructureConverter

class GetFlightDataSetsGropedByWeeksSpec extends BaseTest { def is = s2"""

 This is a specification to check the getFlightDataSetsGropedByWeeksSpec() function

 Flight data sets grouped by weeks should
   have 3 elements                                                         $e1
   have pair "1, Map("DFW" -> 2, "HNL" -> 2, "JFK" -> 2, "LAX" -> 2)"      $e2
   have pair "2, Map("OGG" -> 2)"                                          $e3
   have pair "3, Map("OGG" -> 2)"                                          $e4
                                                                           """

  private val flightDataSetGropedByWeeks = DataStructureConverter.getFlightDataSetsGropedByWeeks(flightDataSet)

  def e1 = flightDataSetGropedByWeeks must have size 3
  def e2 = flightDataSetGropedByWeeks must havePair(1, Map("DFW" -> 2, "HNL" -> 2, "JFK" -> 2, "LAX" -> 2))
  def e3 = flightDataSetGropedByWeeks must havePair(2 -> Map("OGG" -> 2))
  def e4 = flightDataSetGropedByWeeks must havePair(3 -> Map("OGG" -> 3))
}
