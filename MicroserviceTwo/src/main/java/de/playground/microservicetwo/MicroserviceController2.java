package de.playground.microservicetwo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/microservice2")
public class MicroserviceController2 {


	@PostMapping
	public ResponseEntity<String> startMicroservice2() {

		return ResponseEntity.accepted()
			.body("Microservice transaction 2 completed successfully");
	}
}
