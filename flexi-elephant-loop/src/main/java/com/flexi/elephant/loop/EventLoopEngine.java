package com.flexi.elephant.loop;

import com.flexi.elephant.loop.threadpool.ExecutorSelector;

import java.util.concurrent.CountDownLatch;

/**
 * @author Lien6o
 * @date 2021/4/6 3:49 下午
 */
public class EventLoopEngine implements LifeCycle, EventLoop {
    private LoopConfig config;

    private CountDownLatch threadStartWait;

    private ExecutorSelector executorSelector;


    private EventLoopEngine(ExecutorSelector executorSelector) {
        this.executorSelector = executorSelector;
    }

    public EventLoopEngine() {
        /* no-op */
    }

    private static void start() {
        // FIXME: 2021/4/10
    }


    public static EventLoopEngineBuilder builder() {
        return new EventLoopEngineBuilder();
    }


    private static class EventLoopEngineBuilder {
        private EventLoopEngineBuilder() {
            /* no-op */
        }

        private ExecutorSelector executorSelector;

        private EventLoopEngineBuilder executorSelector(ExecutorSelector executorSelector) {
            this.executorSelector = executorSelector;
            return this;
        }

        public EventLoopEngine build() {
            return new EventLoopEngine(this.executorSelector);
        }
    }

    @Override
    public void init() throws Exception {
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
    public void destroy() throws Exception {

    }

    @Override
    public void loop() {

    }
}
