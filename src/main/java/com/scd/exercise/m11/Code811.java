package com.scd.exercise.m11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author James
 */
public class Code811 {

    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> domainCountMap = new HashMap<>();
        for (String inputStr : cpdomains) {
            String[] inputArr = inputStr.split("\\s+");
            if (inputArr.length != 2) {
                continue;
            }
            Integer inputCount = Integer.parseInt(inputArr[0]);
            String inputDomain = inputArr[1];
            List<String> subDomainList = new ArrayList<>();
            getSubList(inputDomain, subDomainList);
            subDomainList.forEach(subdomain -> {
                Integer count = domainCountMap.computeIfAbsent(subdomain, k -> 0);
                Integer curCount = inputCount + count;
                domainCountMap.put(subdomain, curCount);
            });
        }
        List<String> resultList = new ArrayList<>();
        Set<Map.Entry<String, Integer>> entrySet = domainCountMap.entrySet();
        for (Map.Entry<String, Integer> entry : entrySet) {
            String curData = entry.getValue() + " " + entry.getKey();
            resultList.add(curData);
        }
        return resultList;
    }

    private void getSubList(String inputDomain, List<String> subDomainList) {
        subDomainList.add(inputDomain);
        int index = inputDomain.indexOf(".");
        if (index != -1) {
            inputDomain = inputDomain.substring(index + 1);
            getSubList(inputDomain, subDomainList);
        }
    }

    public static void main(String[] args) {
        String[] inputStr = new String[]{"9001 discuss.leetcode.com"};
        Code811 code811 = new Code811();
        System.out.println(code811.subdomainVisits(inputStr));
    }
}
