import helpers.DataStructureConverter

class GetDifferenceBetweenArrivedAndLeftSpec extends BaseTest { def is = s2"""

 This is a specification to check the getDifferenceBetweenArrivedAndLeft() function

 Difference between planes arrived and left for each airport map should
   have 5 elements                                                            $e1
   have pairs "CLE" -> -1, "CLT" -> 1, "DFW" -> -5, "HNL" -> 2, "OGG" -> 3    $e2
                                                                              """

  private val differenceBetweenArrivedAndLeft = DataStructureConverter.getDifferenceBetweenArrivedAndLeft(flightDataSet)

  def e1 = differenceBetweenArrivedAndLeft must have size 5
  def e2 = differenceBetweenArrivedAndLeft must havePairs("CLE" -> -1, "CLT" -> 1, "DFW" -> -5, "HNL" -> 2, "OGG" -> 3)
}
