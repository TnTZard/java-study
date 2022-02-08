package LeetCode1;

/**
 * @author xiezq1
 * @version 1.0.0
 * @date 2022/2/2 17:28
 */
public class 反转单词前缀 {

    public static void main(String[] args) {
        System.out.println(reversePrefix("abcdefd", 'd'));
    }

    public static String reversePrefix(String word, char ch) {
        char[] arr = word.toCharArray();
        int k = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ch) {
                k = i;
                break;
            }
        }
        String ans = "";
        for (int i = k; i >= 0; i--) {
            ans += arr[i];
        }

        for (int i = k + 1; i < word.length(); i++) {
            ans += arr[i];
        }
        return ans;
    }


}
