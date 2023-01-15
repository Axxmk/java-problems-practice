import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        boolean check = true;
        String num = Integer.toString(x);

        for (int i = 0; i < num.length()/2; i++) {
            if (num.charAt(i) != num.charAt(num.length() - i - 1)) {
                check = false;
                break;
            }
        }

        System.out.println(check);

//        if(x < 0) return false;
//
//        int rev = 0;
//        int tmp = x;
//
//        while(tmp > 0) {
//            rev = (rev * 10) + (tmp % 10);
//            tmp /= 10;
//        }
//
//        return rev == x;
    }
}