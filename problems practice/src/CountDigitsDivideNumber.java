import java.util.Scanner;

public class CountDigitsDivideNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int origin = num;
        int count = 0;

        while (num > 0) {
            if (origin % (num % 10) == 0) {
                count++;
            }
            num /= 10;
        }

        System.out.println(count);
    }
}
