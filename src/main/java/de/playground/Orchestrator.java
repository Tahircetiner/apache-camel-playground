package de.playground;


import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.SagaPropagation;

import org.springframework.stereotype.Component;

@Component
public class Orchestrator extends RouteBuilder {


	@Override
	public void configure() {

		from("direct:startSaga")
			.saga()
			.propagation(SagaPropagation.REQUIRED)
			.to("direct:following1")
			.to("direct:following2")
			.log("Order Saga completed successfully");
	}
}
