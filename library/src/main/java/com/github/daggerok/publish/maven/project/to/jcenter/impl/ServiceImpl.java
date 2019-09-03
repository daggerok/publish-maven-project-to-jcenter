package com.github.daggerok.publish.maven.project.to.jcenter.impl;

import com.github.daggerok.publish.maven.project.to.jcenter.api.MyService;
import lombok.extern.log4j.Log4j2;

import java.util.Optional;

@Log4j2
public class ServiceImpl implements MyService {

    @Override
    public String sayHello(String maybeName) {
        String name = Optional.ofNullable(maybeName)
                              .orElse("my fiend");
        String greeting = String.format("Hello, %s!", name);
        log.debug(greeting);
        return greeting;
    }
}
