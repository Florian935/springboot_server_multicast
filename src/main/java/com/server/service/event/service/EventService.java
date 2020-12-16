package com.server.service.event.service;

import reactor.core.publisher.Flux;

public interface EventService {

    Flux<Long> eventStream();
}
