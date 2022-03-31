package com.scd.contest.week251;

/**
 * @author James
 */
public class Code5824 {

    public String maximumNumber(String num, int[] change) {
        char[] charArray = num.toCharArray();
        int lenn = charArray.length;
        boolean flag = false;
        for (int i = 0; i < lenn; i++) {
           int index = Integer.parseInt(String.valueOf(charArray[i]));
           if (change[index] >= index) {
               charArray[i] = String.valueOf(change[index]).charAt(0);
               if (change[index] > index) {
                   flag = true;
               }
           } else if (flag) {
               break;
           }
        }
        return new String(charArray);
    }

    public static void main(String[] args) {
        Code5824 code5824 = new Code5824();
        String num = "334111";
        int[] ch = {0,9,2,3,3,2,5,5,5,5};
        System.out.println(code5824.maximumNumber(num, ch));
        String num1 = "214010";
        int[] ch1 = {6,7,9,7,4,0,3,4,4,7};
        // 974676
        System.out.println(code5824.maximumNumber(num1, ch1));
    }
}
