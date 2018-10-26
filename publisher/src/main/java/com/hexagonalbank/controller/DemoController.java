package com.hexagonalbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/demo")
@EnableBinding({Source.class})
class DemoController {

	@Autowired
	Source source;

	@PostMapping("/postMessage")
	@ResponseBody
	public String postMessage(@RequestBody String message) {
		source.output().send(MessageBuilder.withPayload(message).build());
			return "Message  "+ message +" registered through rest api";
	}

    @GetMapping("/welcome")
    @ResponseBody
    public String welcome() {
        return "Welcome to Hackathon Application";
    }
}
