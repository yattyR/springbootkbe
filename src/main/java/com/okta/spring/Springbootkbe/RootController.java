package com.okta.spring.springbootkbe;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Date;

@Controller
public class RootController {
private static final Logger logger = LoggerFactory.getLogger("root");

    @GetMapping("/")
    @ResponseBody
    public Flux<String> getRoot() {
	     logger.info(getTime()+"I am alive");
        return Flux.just(getTime()+"Alive");
    }
    public static String getTime()
{
         DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
}
}
