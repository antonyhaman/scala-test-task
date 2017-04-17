# scala-test-task
This is a test task for an interview executed using the Scala language. The task was as following:

>Problem:
>You are provided with the *.csv.gz file containing some data about plane flights.
> 
>Data has the following schema
>"YEAR","QUARTER","MONTH","DAY_OF_MONTH","DAY_OF_WEEK","FL_DATE","ORIGIN","DEST"
> 
>You'll need to extract several statistics out of the data file:
>List of all airports with total number of planes for the whole period that arrived to each airport
>Non-Zero difference in total number of planes that arrived to and left from the airport
>Do the point 1 but sum number of planes separately per each week
>Write some tests for the implemented functions
>Each point 1-3 should produce a separate output file.

# Technologies used
- Scala
- SBT 
- Scala-csv (as a csv reader)
- Specs2 (as a testing framework)

# How to install and run 
This is the SBT-based project so there's nothing special:
1. Clone the project
2. Execute 'sbt test run' in a command line, this will launch the tests and the Main if succeeded
3. Check the results in target/output
