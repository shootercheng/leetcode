package com.scd.exercise.y2022.m3;

/**
 * @author James
 */
public class Code1700 {

    public int countStudents(int[] students, int[] sandwiches) {
        int[] count = new int[2];
        for (int student : students) {
            count[student]++;
        }
        for (int sand : sandwiches) {
            if (count[sand] == 0) {
                break;
            } else {
                count[sand]--;
            }
        }
        return count[0] + count[1];
    }

    public static void main(String[] args) {
        int[] students = {1,1,0,0};
        int[] sandwiches = {0,1,0,1};
        Code1700 code1700 = new Code1700();
        code1700.countStudents(students, sandwiches);
    }
}
