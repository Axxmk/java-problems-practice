import java.util.Scanner;

public class ClimbingStairs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int first = 1;
        int second = 1;

        for (int i = 1; i < n; i++) {
            int temp = second;
            second = first + second;
            first = temp;
        }

        System.out.println(second);
    }
}
