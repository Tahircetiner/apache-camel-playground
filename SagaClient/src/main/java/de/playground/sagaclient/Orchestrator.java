package de.playground.sagaclient;


import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.SagaPropagation;

import org.apache.camel.CamelContext;


import org.springframework.stereotype.Component;

@Component
public class Orchestrator extends RouteBuilder {


	@Override
	public void configure() {

		from("direct:startSaga")
			.saga()
			.propagation(SagaPropagation.REQUIRED)

			.circuitBreaker()
			.resilience4jConfiguration()
			.bulkheadEnabled(true)
			.failureRateThreshold(50)
			.slidingWindowSize(10)
			.waitDurationInOpenState(10000)
			.end()

			.multicast()
			.parallelProcessing()
			.executorService("bulkheadThreadPool")
			.to(
				"http://localhost:8088/microservice1?httpMethod=POST",
				"http://localhost:8089/microservice2?httpMethod=POST"
			)

			.end()
			.log("Order Saga completed successfully");

	}
}
