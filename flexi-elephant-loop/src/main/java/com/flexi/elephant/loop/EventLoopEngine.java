package com.flexi.elephant.loop;

import com.flexi.elephant.common.util.CollectionUtil;
import com.flexi.elephant.event.Event;
import com.flexi.elephant.event.EventCollector;
import com.flexi.elephant.event.EventConsumerStatus;
import com.flexi.elephant.event.EventListener;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.CountDownLatch;

/**
 * @author Lien6o
 * @date 2021/4/6 3:49 下午
 */
public class EventLoopEngine implements LifeCycle, EventLoop {

    private CountDownLatch threadStartWait;

    private final EventCollector eventCollector;

    private final EventListener eventListener;

    private Collection<Event> eventList;

    private EventLoopEngine(EventCollector executorSelector, EventListener eventListener) {
        this.eventListener = eventListener;
        this.eventCollector = executorSelector;
    }


    public static void main(String[] args) {
        EventLoopEngine build = EventLoopEngine.builder(ArrayList::new, event -> EventConsumerStatus.FAILURE).build();


        EventCollector eventCollector = new EventCollector() {
            @Override
            public Collection<Event> collect() {
                return null;
            }
        };

        Collection<Event> collect = eventCollector.collect();
    }

    /**
     * builder
     */
    public static EventLoopEngineBuilder builder(EventCollector eventCollector, EventListener eventListener) {
        return new EventLoopEngineBuilder(eventCollector, eventListener);


    }


    /**
     * start
     */
    private void start() {
        while (true) {
            if (CollectionUtil.isEmpty(eventList)) {
                return;
            }
            for (Event event : eventList) {
                eventListener.onEvent(event);
            }
        }
    }


    /**
     * Builder
     */
    private static class EventLoopEngineBuilder {

        private final EventCollector eventCollector;

        private final EventListener eventListener;

        public EventLoopEngineBuilder(EventCollector eventCollector, EventListener eventListener) {
            this.eventCollector = eventCollector;
            this.eventListener = eventListener;
        }

        public EventLoopEngine build() {
            return new EventLoopEngine(this.eventCollector, this.eventListener);
        }
    }

    @Override
    public void init() {
//        Runnable target = new Runnable() {
//            @Override
//            public void run() {
//                loop();
//                CountDownLatch threadStartWait;
//                threadStartWait.countDown();
//            }
//        };
//        Thread t = new Thread(target);
//        t.setDaemon(true);
//        t.setName("LoopEngine-" + t.getId());
//        t.start();
//        if (!Uninterruptibles.awaitUninterruptibly(threadStartWait,  , TimeUnit.MILLISECONDS)) {
//            throw new LoopEngineInitException();
//        }
    }

    @Override
    public void destroy() {

    }

    @Override
    public void loop() {

    }
}
