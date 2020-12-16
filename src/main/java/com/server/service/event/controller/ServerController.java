package com.server.service.event.controller;

import com.server.service.event.service.EventService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/server")
public class ServerController {

    private final Flux<Long> event;

    public ServerController(EventService eventService) {
        event = eventService.eventStream();
    }

    @GetMapping(value = "/stream", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<Long> stream() {
        return event;
    }
}
