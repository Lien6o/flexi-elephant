package com.flexi.elephant.event;

import java.util.concurrent.Executor;

/**
 * @author Lien6o
 * @description some desc
 * @email lienbo@meituan.com
 * @date 2021/4/10 4:43 下午
 */
public enum DirectExecutor implements Executor {
    INSTANCE;

    private DirectExecutor() {
    }

    public void execute(Runnable command) {
        command.run();
    }

    public String toString() {
        return " directExecutor()";
    }

}
