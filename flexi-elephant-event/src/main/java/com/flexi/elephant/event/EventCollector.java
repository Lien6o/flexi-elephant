package com.flexi.elephant.event;

import java.util.Collection;

/**
 * @author Lien6o
 * @date 2021/4/12 11:09 上午
 */
public interface EventCollector {

    Collection<Event> collect();
}
