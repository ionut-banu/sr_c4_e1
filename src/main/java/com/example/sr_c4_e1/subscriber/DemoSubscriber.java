package com.example.sr_c4_e1.subscriber;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class DemoSubscriber implements Subscriber<Integer> {

    private Subscription subscription;

    @Override
    public void onSubscribe(Subscription subscription) {
        System.out.println("Subscribed");
        this.subscription = subscription;
        subscription.request(1); // Backpressure
    }

    @Override
    public void onNext(Integer integer) {
        System.out.println("On next " + integer);
        subscription.request(1);
        if(integer == 3) throw new RuntimeException("Noooo");
    }

    @Override
    public void onError(Throwable t) {
        System.out.println("On error " + t);
    }

    @Override
    public void onComplete() {
        System.out.println("On complete");
    }

}
