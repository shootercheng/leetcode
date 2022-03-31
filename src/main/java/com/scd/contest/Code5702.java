package com.scd.contest;

/**
 * @author James
 */
public class Code5702 {

    public int findCenter(int[][] edges) {
        int[] edgeA = edges[0];
        int[] edgeB = edges[1];
        int source = edgeA[0];
        int target = edgeA[1];
        if (edgeB[0] == source || edgeB[1] == source) {
            return source;
        }
        if (edgeB[0] == target || edgeB[1] == target) {
            return target;
        }
        return -1;
    }
}
