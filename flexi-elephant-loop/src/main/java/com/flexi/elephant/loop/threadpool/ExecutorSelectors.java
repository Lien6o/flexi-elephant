package com.flexi.elephant.loop.threadpool;

import com.flexi.elephant.event.DirectExecutor;

import java.util.concurrent.Executor;

/**
 * @author Lien6o
 * @date 2021/4/10 3:53 下午
 */
public class ExecutorSelectors {

    public static class SerializationPool implements ExecutorSelector {
        @Override
        public Executor getExecutor() {
            return DirectExecutor.INSTANCE;
        }
    }

    public static class CustomPool implements ExecutorSelector {
        private final Executor executor;

        CustomPool(Executor executor) {
            this.executor = executor;
        }

        @Override
        public Executor getExecutor() {
            return this.executor;
        }
    }


}
