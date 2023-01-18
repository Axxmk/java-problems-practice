import java.util.Arrays;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};

//        if (strs.length == 0) {
//            System.out.println("");
//        }

        Arrays.sort(strs);

        String first = strs[0];
        String last = strs[strs.length - 1];

        int i = 0;
        while (i < first.length() && i < last.length() && first.charAt(i) == last.charAt(i)) {
            i++;
        }

        System.out.println(i == 0 ? "" : first.substring(0, i));

    }
}

//        String prefix = "";
//        boolean flag = true;
//
//        for (int i = 0; i < arr[0].length(); i++) {
//            for (int j = 0; j < arr.length; j++) {
//                if (arr[j].charAt(i) != arr[0].charAt(i)) {
//                    flag = false;
//                    break;
//                }
//            }
//
//            if (flag) {
//                prefix += arr[0].charAt(i);
//            } else {
//                break;
//            }
//        }
//
//        System.out.println(prefix);