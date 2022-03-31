package com.scd.exercise;

/**
 * @author James
 */
public class Code1160 {

    public int countCharacters(String[] words, String chars) {
        int count = 0;
        char[] eleArr = chars.toCharArray();
        for (String word : words) {
            char[] wordArr = word.toCharArray();
            boolean res = isWordInEleArr(wordArr, eleArr);
            if (res) {
                count = count + wordArr.length;
            }
        }
        return count;
    }

    private boolean isWordInEleArr(char[] wordArr, char[] eleArr) {
        int lenele = eleArr.length;
        boolean[] used = new boolean[lenele];
        for (char w : wordArr) {
            boolean isFind = false;
            for (int i = 0; i < lenele; i++) {
                if (w == eleArr[i] && !used[i]) {
                    isFind = true;
                    used[i] = true;
                    break;
                }
            }
            if (!isFind) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        String[] words = {"dyiclysmffuhibgfvapygkorkqllqlvokosagyelotobicwcmebnpznjbirzrzsrtzjxhsfpiwyfhzyonmuabtlwin","ndqeyhhcquplmznwslewjzuyfgklssvkqxmqjpwhrshycmvrb","ulrrbpspyudncdlbkxkrqpivfftrggemkpyjl","boygirdlggnh","xmqohbyqwagkjzpyawsydmdaattthmuvjbzwpyopyafphx","nulvimegcsiwvhwuiyednoxpugfeimnnyeoczuzxgxbqjvegcxeqnjbwnbvowastqhojepisusvsidhqmszbrnynkyop","hiefuovybkpgzygprmndrkyspoiyapdwkxebgsmodhzpx","juldqdzeskpffaoqcyyxiqqowsalqumddcufhouhrskozhlmobiwzxnhdkidr","lnnvsdcrvzfmrvurucrzlfyigcycffpiuoo","oxgaskztzroxuntiwlfyufddl","tfspedteabxatkaypitjfkhkkigdwdkctqbczcugripkgcyfezpuklfqfcsccboarbfbjfrkxp","qnagrpfzlyrouolqquytwnwnsqnmuzphne","eeilfdaookieawrrbvtnqfzcricvhpiv","sisvsjzyrbdsjcwwygdnxcjhzhsxhpceqz","yhouqhjevqxtecomahbwoptzlkyvjexhzcbccusbjjdgcfzlkoqwiwue","hwxxighzvceaplsycajkhynkhzkwkouszwaiuzqcleyflqrxgjsvlegvupzqijbornbfwpefhxekgpuvgiyeudhncv","cpwcjwgbcquirnsazumgjjcltitmeyfaudbnbqhflvecjsupjmgwfbjo","teyygdmmyadppuopvqdodaczob","qaeowuwqsqffvibrtxnjnzvzuuonrkwpysyxvkijemmpdmtnqxwekbpfzs","qqxpxpmemkldghbmbyxpkwgkaykaerhmwwjonrhcsubchs"};
//        String chars = "usdruypficfbpfbivlrhutcgvyjenlxzeovdyjtgvvfdjzcmikjraspdfp";
//        ["hello","world","leetcode"]
//        "welldonehoneyr"
        String[] words = {"hello","world","leetcode"};
        String chars = "welldonehoneyr";
        Code1160 code1160 = new Code1160();
        System.out.println(code1160.countCharacters(words, chars));
    }
}
