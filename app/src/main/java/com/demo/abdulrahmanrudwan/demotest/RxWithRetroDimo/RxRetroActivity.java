package com.demo.abdulrahmanrudwan.demotest.RxWithRetroDimo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.demo.abdulrahmanrudwan.demotest.R;

import java.util.concurrent.TimeUnit;

import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.AsyncSubject;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.ReplaySubject;
import io.reactivex.subjects.Subject;

public class RxRetroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_retro);
        /*@subjects -->
         * Subjects are an extension of the Observable that also implements the Observer interface.
         * The idea may sound odd at first, but they make things a lot simpler in some cases. They can have events pushed to them (like observers),
         * which they then push further to their own subscribers (like observables).
         * This makes them ideal entry points into Rx code: when you have values coming in from outside of Rx, you can push them into a Subject,
         * turning them into an observable. You can think of them as entry points to an Rx pipeline.
         * Subject has two parameter types: the input type and the output type. This was designed so for the sake of abstraction
         * and not because the common uses for subjects involve transforming values. There are transformation operators to do that,
         * which we will see later..*/

        /*PublishSubject is the most straight-forward kind of subject. When a value is pushed into a PublishSubject,
         *the subject pushes it to every subscriber that is subscribed to it at that moment.*/
        PublishSubject<Integer> publishSubject = PublishSubject.create();
        publishSubject.subscribe(System.out::println);
        publishSubject.onNext(1);
        publishSubject.onNext(2);
        publishSubject.onNext(3);
        publishSubject.onComplete();


        /*
         * ReplaySubject has the special feature of caching all the values pushed to it. When a new subscription is made,
         * the event sequence is replayed from the start for the new subscriber.
         * After catching up, every subscriber receives new events as they come..*/
        ReplaySubject<Integer> replaySubject =
                ReplaySubject.create();
//              ReplaySubject.createWithSize(4);                                                  // create cashing reply with max size
//              ReplaySubject.createWithTime(23, TimeUnit.HOURS, Schedulers.io());                // create cashing reply with max time
//              ReplaySubject.createWithTimeAndSize(23,TimeUnit.HOURS,Schedulers.io(),4);         // create cashing reply with max time and size
        replaySubject.onNext(2);
        replaySubject.subscribe(System.out::print);
        replaySubject.subscribe(v -> System.out.println("Early:" + v));
        replaySubject.onNext(3);
        replaySubject.onNext(5);
        replaySubject.subscribe(v -> Log.i("LATE", v + ""));
        replaySubject.onNext(6);
        replaySubject.onNext(7);
        replaySubject.onComplete();

        /*BehaviorSubject only remembers the last value. It is similar to a ReplaySubject with a buffer of size
        1. An initial value can be provided on creation, therefore guaranteeing that a value always will be available immediately on subscription.*/
        BehaviorSubject<Integer>behaviorSubject= BehaviorSubject.create();
        behaviorSubject.onNext(3);
        behaviorSubject.onNext(4);
        behaviorSubject.subscribe(v -> System.out.print("behave: "+v));
        behaviorSubject.onNext(5);
        behaviorSubject.onNext(6);
        behaviorSubject.onComplete();
        //get just one old+the new : ---> output : 4,5,6




        /*AsyncSubject also caches the last value. The difference now is that it doesn't emit anything until the sequence completes.
        Its use is to emit a single value and immediately complete.*/

        AsyncSubject<Integer> s = AsyncSubject.create();
        s.subscribe(v -> System.out.println(v));
        s.onNext(0);
        s.onNext(1);
        s.onNext(2);
        s.onComplete();
        //only the last data before completed, starts in oncompletion ---> output : 2


        Subject<Integer> subject = ReplaySubject.create();
        subject.subscribe(v -> System.out.println(v));
        subject.onNext(0);
        subject.onComplete();
        subject.onNext(1);
        subject.onNext(2);
        // output : --> 0  , any emitted value after oncomplete or onError will be ignored
    }
    
}
