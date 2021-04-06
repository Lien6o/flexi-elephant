package com.flexi.elephant.loop;

import com.flexi.elephant.common.util.Uninterruptibles;
import com.flexi.elephant.loop.exception.LoopEngineInitException;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author Lien6o
 */
public class DefaultLoopEngine extends AbstractLoopEngine {

    /**
     * 监控线程和主线程直接的通信控制
     */
    private final CountDownLatch threadStartWait = new CountDownLatch(1);

    public DefaultLoopEngine(LoopConfig config) {
        super(config);
    }


    @Override
    public void init() throws Exception {
        Runnable target = new Runnable() {
            @Override
            public void run() {
                loop();
                threadStartWait.countDown();
            }
        };
        Thread t = new Thread(target);
        t.setDaemon(true);
        t.setName("LoopEngine-" + t.getId());
        t.start();
        if (!Uninterruptibles.awaitUninterruptibly(threadStartWait, super.config.getThreadStartTimeout(), TimeUnit.MILLISECONDS)) {
            throw new LoopEngineInitException();
        }
    }

    @Override
    public void destroy() throws Exception {

    }

    @Override
    public void loop() {

    }
}
