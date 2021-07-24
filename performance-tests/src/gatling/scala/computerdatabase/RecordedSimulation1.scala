package computerdatabase

import io.gatling.core.Predef._
import io.gatling.http.Predef._

class RecordedSimulation1 extends Simulation {

	val httpProtocol = http
		.baseUrl("https://computer-database.gatling.io")
		.inferHtmlResources(BlackList(""".*\.js""", """.*\.css""", """.*\.gif""", """.*\.jpeg""", """.*\.jpg""", """.*\.ico""", """.*\.woff""", """.*\.woff2""", """.*\.(t|o)tf""", """.*\.png""", """.*detectportal\.firefox\.com.*"""), WhiteList())
		.acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9")
		.acceptEncodingHeader("gzip, deflate")
		.acceptLanguageHeader("en,en-US;q=0.9,ru;q=0.8,uk;q=0.7")
		.upgradeInsecureRequestsHeader("1")
		.userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.77 Safari/537.36")

	val headers_0 = Map(
		"Cache-Control" -> "max-age=0",
		"Sec-Fetch-Dest" -> "document",
		"Sec-Fetch-Mode" -> "navigate",
		"Sec-Fetch-Site" -> "cross-site",
		"Sec-Fetch-User" -> "?1",
		"sec-ch-ua" -> """ Not;A Brand";v="99", "Google Chrome";v="91", "Chromium";v="91""",
		"sec-ch-ua-mobile" -> "?0")

	val headers_1 = Map(
		"Sec-Fetch-Dest" -> "document",
		"Sec-Fetch-Mode" -> "navigate",
		"Sec-Fetch-Site" -> "same-origin",
		"Sec-Fetch-User" -> "?1",
		"sec-ch-ua" -> """ Not;A Brand";v="99", "Google Chrome";v="91", "Chromium";v="91""",
		"sec-ch-ua-mobile" -> "?0")

	val headers_3 = Map(
		"Cache-Control" -> "max-age=0",
		"Origin" -> "https://computer-database.gatling.io",
		"Sec-Fetch-Dest" -> "document",
		"Sec-Fetch-Mode" -> "navigate",
		"Sec-Fetch-Site" -> "same-origin",
		"Sec-Fetch-User" -> "?1",
		"sec-ch-ua" -> """ Not;A Brand";v="99", "Google Chrome";v="91", "Chromium";v="91""",
		"sec-ch-ua-mobile" -> "?0")



	val scn = scenario("RecordedSimulation1")
		.exec(http("request_0")
			.get("/computers")
			.headers(headers_0))
		.pause(9)
		.exec(http("request_1")
			.get("/computers?f=Test")
			.headers(headers_1))
		.pause(2)
		.exec(http("request_2")
			.get("/computers/456")
			.headers(headers_1))
		.pause(4)
		.exec(http("request_3")
			.post("/computers/456")
			.headers(headers_3)
			.formParam("name", "Test2")
			.formParam("introduced", "2009-01-01")
			.formParam("discontinued", "2009-01-01")
			.formParam("company", "")
			.check(status.is(400)))
		.pause(7)
		.exec(http("request_4")
			.post("/computers/456")
			.headers(headers_3)
			.formParam("name", "Test")
			.formParam("introduced", "2009-01-01")
			.formParam("discontinued", "2023-01-01")
			.formParam("company", ""))
		.pause(2)
		.exec(http("request_5")
			.get("/computers/new")
			.headers(headers_1))
		.pause(21)
		.exec(http("request_6")
			.post("/computers")
			.headers(headers_3)
			.formParam("name", "Test")
			.formParam("introduced", "2012-01-20")
			.formParam("discontinued", "2023-03-14")
			.formParam("company", "4"))

	setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}