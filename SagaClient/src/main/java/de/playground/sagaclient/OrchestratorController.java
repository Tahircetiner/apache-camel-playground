package de.playground.sagaclient;

import org.apache.camel.ProducerTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/orchestrator")
public class OrchestratorController {

	private final ProducerTemplate producerTemplate;

	public OrchestratorController(ProducerTemplate producerTemplate) {
		this.producerTemplate = producerTemplate;
	}

	@PostMapping()
	public ResponseEntity<String> startSaga() {
		producerTemplate.sendBody(
			"direct:startSaga",
			"payload=" + "test"
		);

		return ResponseEntity.accepted()
			.body("Saga started");
	}
}