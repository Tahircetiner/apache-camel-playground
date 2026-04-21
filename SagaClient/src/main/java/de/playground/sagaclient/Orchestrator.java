package de.playground.sagaclient;


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
			.to("http://localhost:8088/microservice1?httpMethod=POST")
			.to("http://localhost:8089/microservice2?httpMethod=POST")
			.log("Order Saga completed successfully");
	}
}
