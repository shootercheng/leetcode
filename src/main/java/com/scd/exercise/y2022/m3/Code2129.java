package com.scd.exercise.y2022.m3;

/**
 * 2129. 将标题首字母大写
 * @author James
 */
public class Code2129 {

    public String capitalizeTitle(String title) {
        String[] titArr = title.split("\\s+");
        StringBuilder stringBuilder = new StringBuilder("");
        for (String word : titArr) {
            if (word.length() <= 2) {
                String first = word.substring(0, 1);
                String other = word.substring(1);
                stringBuilder.append(first.toUpperCase().concat(other.toLowerCase())).append(" ");
            } else {
                stringBuilder.append(word.toLowerCase()).append(" ");
            }
        }
        return stringBuilder.toString().trim();
    }
}
