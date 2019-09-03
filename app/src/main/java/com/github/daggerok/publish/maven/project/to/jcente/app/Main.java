package com.github.daggerok.publish.maven.project.to.jcente.app;

import com.github.daggerok.publish.maven.project.to.jcenter.api.MyService;
import com.github.daggerok.publish.maven.project.to.jcenter.impl.ServiceImpl;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class Main {
    public static void main(String[] args) {
        String maybeName = args.length > 0 ? args[0] : null;
        MyService myService = new ServiceImpl();
        String greeting = myService.sayHello(maybeName);
        log.info(greeting);
    }
}
