package com.example.url.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Collection;
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CollectionUtil {

    public static long[] toLongArray(Collection<Long> longs) {
        return longs.stream().mapToLong(l -> l).toArray();
    }
}

