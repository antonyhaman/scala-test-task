
class ConvertIntoFlightDataSetSpec extends BaseTest { def is = s2"""

 This is a specification to check the convertIntoFlightDataSet() function

 Resulting set should
   have 14 elements                         $e1
   have head element with year 2014         $e2
   have head element with quarter 1         $e3
   have head element with month 1           $e4
   have head element with dayOfMonth 15     $e5
   have head element with dayOfWeek 3       $e6
   have head element with flDate 2014-01-15 $e7
   have head element with origin DFW        $e8
   have head element with destination OGG   $e9
                                            """

  val elem = flightDataSet.head
  def e1 = flightDataSet must have size 14
  def e2 = elem.year must be_==(2014)
  def e3 = elem.quarter must be_==(1)
  def e4 = elem.month must be_==(1)
  def e5 = elem.dayOfMonth must be_==(15)
  def e6 = elem.dayOfWeek must be_==(3)
  def e7 = elem.flDate.toString must be_==("2014-01-15")
  def e8 = elem.origin must be_==("DFW")
  def e9 = elem.destination must be_==("OGG")
}
