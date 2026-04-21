package de.playground;

import org.apache.camel.saga.CamelSagaService;
import org.apache.camel.saga.InMemorySagaService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SagaConfig {

	@Bean
	public CamelSagaService camelSagaService() {

		org.apache.camel.service.lra.LRASagaService sagaService = new org.apache.camel.service.lra.LRASagaService();
		sagaService.setCoordinatorUrl("http://localhost:8090");
		sagaService.setLocalParticipantUrl("http://localhost:8087");

		return sagaService;
	}
}