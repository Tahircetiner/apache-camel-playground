package de.playground.microserviceone;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/microservice1")
public class MicroserviceController1 {


	@PostMapping
	public ResponseEntity<String> startMicroservice1() {

		return ResponseEntity.accepted()
			.body("Microservice transaction 1 completed successfully");
	}
}