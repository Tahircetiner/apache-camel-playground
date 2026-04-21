package de.playground;


import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.SagaPropagation;

public class Orchestrator extends RouteBuilder {


	@Override
	public void configure() {

		from("direct:startOrderSaga")
			.routeId("order-saga")
			.saga()
			.propagation(SagaPropagation.REQUIRED)
			.to("http://order-service/orders")
			.to("http://payment-service/payments/reserve")
			.to("http://inventory-service/inventory/reserve")
			.log("Order Saga completed successfully");
	}
}
