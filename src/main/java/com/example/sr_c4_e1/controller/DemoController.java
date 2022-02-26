package com.example.sr_c4_e1.controller;

import com.example.sr_c4_e1.subscriber.DemoSubscriber;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

@RestController
public class DemoController {

    @GetMapping("/demo")
    public void demo() {

        Flux<Integer> f1 = Flux.just(1, 2, 3, 4, 5, 6);
        //        var f2 = Flux.fromStream(Stream.of(1, 2, 3, 4, 5, 6));
        //        var f3 = Flux.fromIterable(Set.of(1, 2, 3, 4, 5, 6));
        //
        //        var m1 = Mono.just(1);

        //        f1.doOnNext(n -> System.out.println("doOnNext " + n))
        //          .subscribe(c -> System.out.println("subscribe " + c));

        f1.subscribe(c -> System.out.println(c));

        f1.doOnNext(c -> {
            throw new RuntimeException("Noooo");
        }).subscribe(new DemoSubscriber());

        System.out.println(Long.MAX_VALUE);
    }
}
