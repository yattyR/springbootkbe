package com.okta.spring.springbootkbe;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Controller
public class RootController {
private static final Logger logger = LoggerFactory.getLogger("root");

    @GetMapping("/")
    @ResponseBody
    public Flux<String> getRoot() {
	     logger.info("I am alive");
        return Flux.just("Alive");
    }
}
