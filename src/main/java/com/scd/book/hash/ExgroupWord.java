package com.scd.book.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author James
 */
public class ExgroupWord {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groupMap = Arrays.stream(strs)
                .collect(Collectors.groupingBy(this::sortStr));
        return new ArrayList<>(groupMap.values());
    }

    private String sortStr(String str) {
        char[] scharArr = str.toCharArray();
        Arrays.sort(scharArr);
        return new String(scharArr);
    }
}
