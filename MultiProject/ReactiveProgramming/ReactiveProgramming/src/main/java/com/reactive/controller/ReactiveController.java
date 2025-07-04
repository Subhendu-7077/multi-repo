package com.reactive.controller;

import java.time.Duration;
import java.util.stream.IntStream;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.reactive.dto.MyResponse;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping(path = "rest/reactive")
@CrossOrigin("*")
public class ReactiveController {

	@GetMapping(path = "/test", produces = MediaType.APPLICATION_NDJSON_VALUE)
	public Flux<MyResponse> getReactiveJsonResponse() {
		return Flux.fromStream(IntStream.rangeClosed(1, 15)

				.mapToObj(i -> new MyResponse("test " + i, i))).delayElements(Duration.ofSeconds(3));

	}
}
