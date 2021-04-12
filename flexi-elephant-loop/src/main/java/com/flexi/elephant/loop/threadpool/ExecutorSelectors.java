package com.flexi.elephant.loop.threadpool;

import com.flexi.elephant.event.DirectExecutor;

import java.util.concurrent.Executor;

/**
 * @author Lien6o
 * @date 2021/4/10 3:53 下午
 */
public class ExecutorSelectors {


    public static class External implements ExecutorSelector {

        @Override
        public Executor getExecutor() {
            return null;
        }
    }

    public static class Serialization implements ExecutorSelector {

        @Override
        public Executor getExecutor() {
            return DirectExecutor.INSTANCE;
        }
    }

    public static class Customize implements ExecutorSelector {
        private final Executor executor;

        Customize(Executor executor) {
            this.executor = executor;
        }

        @Override
        public Executor getExecutor() {
            return this.executor;
        }
    }


}
