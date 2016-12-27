import helpers.DataStructureConverter

class GetDifferenceBetweenArrivedAndLeftSpec extends BaseTest { def is = s2"""

 This is a specification to check the getDifferenceBetweenArrivedAndLeft() function

 Difference between planes arrived and left for each airport map should
   have 3 elements                                                         $e1
   have tuples "DFW" -> -5, "HNL" -> 2, "OGG" -> 3                         $e2
                                                                           """

  private val differenceBetweenArrivedAndLeft = DataStructureConverter.getDifferenceBetweenArrivedAndLeft(flightDataSet)

  def e1 = differenceBetweenArrivedAndLeft must have size 3
  def e2 = differenceBetweenArrivedAndLeft must havePairs("DFW" -> -5, "HNL" -> 2, "OGG" -> 3)
}
