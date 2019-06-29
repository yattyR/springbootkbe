package com.okta.spring.springbootkbe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Date;

@Controller
@RequestMapping(path = "/kayaks")
public class KayakController {
    private static final Logger logger = LoggerFactory.getLogger("kayak");

    private final KayakRepository kayakRepository;

    public KayakController(KayakRepository kayakRepository) {
        this.kayakRepository = kayakRepository;
    }

    @PostMapping()
    public @ResponseBody
    Mono<Kayak> addKayak(@RequestBody Kayak kayak) {
	    logger.info(getTime()+"in post");
        return kayakRepository.save(kayak);
    }

    @GetMapping()
    public @ResponseBody
    Flux<Kayak> getAllKayaks() {
	    logger.info(getTime()+"in get");
        Flux<Kayak> result = kayakRepository.findAll();
        return result;
    }
    public static String getTime()
{
	 DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
	return dateFormat.format(date);
}
}
