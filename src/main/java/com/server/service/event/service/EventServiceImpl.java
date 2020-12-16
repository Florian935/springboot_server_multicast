package com.server.service.event.service;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;

@Service
public class EventServiceImpl implements EventService {
    @Override
    public Flux<Long> eventStream() {
        return Flux
                .interval(Duration.ofMillis(1000))
                .share();
    }
}
