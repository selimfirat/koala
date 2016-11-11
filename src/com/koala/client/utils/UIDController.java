package com.koala.client.utils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Author: Selim Fırat Yılmaz - mrsfy
 * Version: 1.0.0
 * Creation Date: 10.11.2016.
 */
public class UIDController {


    private static Map<UIDTypes, Long> uidCounts = new HashMap<>();

    public static long createUID(UIDTypes t) {

        return uidCounts.putIfAbsent(t, uidCounts.getOrDefault(t, 0L)+1);

    }
}
