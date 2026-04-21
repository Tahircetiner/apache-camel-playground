package de.playground;

import org.apache.camel.ProducerTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/following2")
public class FollowingController2 {


	@PostMapping("")
	public ResponseEntity<String> startFollowing(@RequestBody Map<String, Object> payload) {

		return ResponseEntity.accepted()
			.body("Following transaction 2 completed successfully");
	}
}
