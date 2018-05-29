package jimsLoadTests

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

class basicRampUpTest extends Simulation {
	
	val httpConf = http.baseURL("https://YOUR_URL")
	
	val scn = scenario("My Scenario")
	  
	  .exec(
	  	http("My Request")
	      .get("/Stage?tickers=BNBBTC")
	      .check(status is 200))
	
	setUp(scn.inject(rampUsersPerSec(10) to 20 during (10 seconds) randomized).protocols(httpConf))
}