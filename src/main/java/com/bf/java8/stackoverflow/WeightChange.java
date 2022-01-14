package com.bf.java8.stackoverflow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @description:
 * @author: bofei
 * @date: 2020-05-21 19:48
 **/
public class WeightChange {

    private float value;

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public static void main(String[] args) {
        List<WeightChange> weightChanges = new ArrayList(Collections.singletonList(new WeightChange()));

        weightChanges.stream()
                .mapToDouble(WeightChange::getValue)
                .average()
                .orElse(Double.NaN);

    }

}