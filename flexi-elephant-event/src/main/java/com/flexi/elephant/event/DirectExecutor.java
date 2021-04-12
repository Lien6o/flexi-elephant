package com.flexi.elephant.event;

import java.util.concurrent.Executor;

/**
 * @author Lien6o
 * @date 2021/4/10 4:43 下午
 */
public enum DirectExecutor implements Executor {
    INSTANCE;

    DirectExecutor() {
    }

    public void execute(Runnable command) {
        command.run();
    }

    public String toString() {
        return "directExecutor()";
    }

}
