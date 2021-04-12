package com.flexi.elephant.common.util;

import java.util.Collection;

/**
 * @author Lien6o
 * @description some desc
 * @email lienbo@meituan.com
 * @date 2021/4/12 10:35 上午
 */
public class CollectionUtil {

    public static <T> boolean isEmpty(Collection<T> collection) {
        return collection == null || collection.isEmpty();
    }

    public static <T> boolean isNotEmpty(Collection<T> collection) {
        return !isEmpty(collection);
    }
}
