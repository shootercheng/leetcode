package com.scd.exercise.m12;

import java.util.HashSet;
import java.util.Set;

/**
 * @author James
 */
public class Code207 {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Set<String> dependencySet = new HashSet<>(numCourses);
        for (int[]  prerequisite : prerequisites) {
            int start = prerequisite[0];
            int end = prerequisite[1];
            String data = start > end ? start + "_" + end : end + "_" + start;
            if (dependencySet.contains(data)) {
                return false;
            }
            dependencySet.add(data);
        }
        return true;
    }
}
