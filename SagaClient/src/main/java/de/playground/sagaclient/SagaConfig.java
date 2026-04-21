package de.playground.sagaclient;

import org.apache.camel.saga.CamelSagaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import org.apache.camel.CamelContext;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SagaConfig {

	@Autowired
	CamelContext camelContext;

	@Bean
	public CamelSagaService camelSagaService() throws Exception {

		org.apache.camel.service.lra.LRASagaService sagaService = new org.apache.camel.service.lra.LRASagaService();
		sagaService.setCoordinatorUrl("http://localhost:8090");
		sagaService.setLocalParticipantUrl("http://localhost:8087");

		camelContext.addService(sagaService);

		return sagaService;
	}


}