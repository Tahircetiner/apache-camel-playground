package de.playground;

import org.apache.camel.saga.CamelSagaService;
import org.apache.camel.saga.InMemorySagaService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SagaConfig {

	@Bean
	public CamelSagaService camelSagaService() {
		return new InMemorySagaService();
	}
}