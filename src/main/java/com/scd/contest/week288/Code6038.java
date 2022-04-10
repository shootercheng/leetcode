package com.scd.contest.week288;

/**
 * @author James
 */
public class Code6038 {

    public String minimizeResult(String expression) {
        String[] expArr = expression.split("\\+");
        int min = Integer.MAX_VALUE;
        StringBuilder result = new StringBuilder();
        int lens1 = expArr[0].length();
        int lens2 = expArr[1].length();
        for (int i = 0; i < lens1; i++) {
            for (int j = 1; j <= lens2; j++) {
                StringBuilder stringBuilder = new StringBuilder();
                int num1 = 1;
                int num2 = 1;
                int num3 = 1;
                int num4 = 1;
                if (i == 0) {
                    stringBuilder.append("(").append(expArr[0]);
                    num1 = Integer.parseInt(expArr[0]);
                } else {
                    String nStrLeft = expArr[0].substring(0, i);
                    num1 = Integer.parseInt(nStrLeft);
                    String nStrRight = expArr[0].substring(i);
                    num2 = Integer.parseInt(nStrRight);
                    stringBuilder.append(nStrLeft)
                            .append("(").append(nStrRight);
                }
                stringBuilder.append("+");
                if (j == lens2) {
                    stringBuilder.append(expArr[1]).append(")");
                    num3 = Integer.parseInt(expArr[1]);
                } else {
                    String nStrLeft = expArr[1].substring(0, j);
                    num3 = Integer.parseInt(nStrLeft);
                    String nStrRight = expArr[1].substring(j);
                    num4 = Integer.parseInt(nStrRight);
                    stringBuilder.append(nStrLeft)
                            .append(")")
                            .append(nStrRight);
                }
                int curSum = 0;
                if (i == 0 && j == lens2) {
                    curSum = num1 + num3;
                } else if (i == 0) {
                    curSum = (num1 + num3) * num4;
                } else if (j == lens2) {
                    curSum = num1 * (num2 + num3);
                } else {
                    curSum = num1 * (num2 + num3) * num4;
                }
                System.out.println(stringBuilder + "=" + curSum);
                if (curSum < min) {
                    min = curSum;
                    result = stringBuilder;
                }
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Code6038 code6038 = new Code6038();
        code6038.minimizeResult("12+34");
//        String str = "247";
//        for (int i = 0; i <= str.length(); i++) {
//            String left = str.substring(0, i);
//            String right = str.substring(i);
//            System.out.println(left + "_" + right);
//        }
    }
}
