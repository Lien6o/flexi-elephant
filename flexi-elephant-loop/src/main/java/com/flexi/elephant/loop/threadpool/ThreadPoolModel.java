package com.flexi.elephant.loop.threadpool;

import java.util.concurrent.Executor;

/**
 * @author Lien6o
 * @date 2021/4/10 3:53 下午
 */
public class ThreadPoolModel {

    public static class CommonPool implements ExecutorSelector {
        @Override
        public Executor getExecutor() {
            return null;
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
