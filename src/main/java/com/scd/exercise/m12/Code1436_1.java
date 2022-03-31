package com.scd.exercise.m12;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author James
 */
public class Code1436_1 {

    public String destCity(List<List<String>> paths) {
        Set<String> startPoint = new HashSet<>();
        Set<String> endPoint = new HashSet<>();
        for (List<String> line : paths) {
            startPoint.add(line.get(0));
            endPoint.add(line.get(1));
        }
        endPoint.removeAll(startPoint);
        return endPoint.iterator().next();
    }
}
