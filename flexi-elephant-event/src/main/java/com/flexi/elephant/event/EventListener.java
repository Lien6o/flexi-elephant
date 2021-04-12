package com.flexi.elephant.event;

/**
 * @author Lien6o
 * @date 2021/4/12 10:11 上午
 */
public interface EventListener {

    EventConsumerStatus onEvent(Event event);
}
