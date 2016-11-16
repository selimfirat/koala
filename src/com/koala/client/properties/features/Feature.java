package com.koala.client.properties.features;

import javafx.beans.NamedArg;
import javafx.util.Pair;
/**
 * Author: Selim Fırat Yılmaz - mrsfy
 * Version: 1.0.0
 * Creation Date: 16.11.2016.
 */
public class Feature<T> extends Pair<HouseFeatures, T> {

    /**
     * Creates a new pair
     *
     * @param key   The key for this pair
     * @param value The value to use for this pair
     */
    public Feature(@NamedArg("key") HouseFeatures key, @NamedArg("value") T value) {
        super(key, value);
    }
}
