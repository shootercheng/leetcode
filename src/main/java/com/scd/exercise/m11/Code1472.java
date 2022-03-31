package com.scd.exercise.m11;

import java.util.ArrayList;
import java.util.List;

/**
 * @author James
 */
public class Code1472 {

    static class BrowserHistory {
        private List<String> historyList = new ArrayList<>();

        private int maxIndex;

        private int pointIndex;

        public BrowserHistory(String homepage) {
            historyList.add(homepage);
            pointIndex = 0;
            maxIndex = pointIndex;
        }

        public void visit(String url) {
            historyList.add(++pointIndex, url);
            maxIndex = pointIndex;
        }

        public String back(int steps) {
            pointIndex = pointIndex - steps;
            if (pointIndex < 0) {
                pointIndex = 0;
            }
            return historyList.get(pointIndex);
        }

        public String forward(int steps) {
            pointIndex = pointIndex + steps;
            if (pointIndex > maxIndex) {
                pointIndex = maxIndex;
            }
            return historyList.get(pointIndex);
        }
    }

    public static void main(String[] args) {
        BrowserHistory browserHistory = new BrowserHistory("leetcode.com");
        browserHistory.visit("google.com");       // 你原本在浏览 "leetcode.com" 。访问 "google.com"
        browserHistory.visit("facebook.com");     // 你原本在浏览 "google.com" 。访问 "facebook.com"
        browserHistory.visit("youtube.com");      // 你原本在浏览 "facebook.com" 。访问 "youtube.com"
        System.out.println(browserHistory.back(1));                   // 你原本在浏览 "youtube.com" ，后退到 "facebook.com" 并返回 "facebook.com"
        System.out.println(browserHistory.back(1));                   // 你原本在浏览 "facebook.com" ，后退到 "google.com" 并返回 "google.com"
        System.out.println(browserHistory.forward(1));                // 你原本在浏览 "google.com" ，前进到 "facebook.com" 并返回 "facebook.com"
        browserHistory.visit("linkedin.com");     // 你原本在浏览 "facebook.com" 。 访问 "linkedin.com"
        System.out.println(browserHistory.forward(2));                // 你原本在浏览 "linkedin.com" ，你无法前进任何步数。
        System.out.println(browserHistory.back(2));                 // 你原本在浏览 "linkedin.com" ，后退两步依次先到 "facebook.com" ，然后到 "google.com" ，并返回 "google.com"
        System.out.println(browserHistory.back(7));               // 你原本在浏览 "google.com"， 你只能后退一步到 "leetcode.com" ，并返回 "leetcode.com"
    }
}
