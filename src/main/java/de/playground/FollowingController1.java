package de.playground;

import org.apache.camel.ProducerTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/following1")
public class FollowingController1 {


	@PostMapping("")
	public ResponseEntity<String> startFollowing(@RequestBody Map<String, Object> payload) {

		return ResponseEntity.accepted()
			.body("Following transaction 1 completed successfully");
	}
}