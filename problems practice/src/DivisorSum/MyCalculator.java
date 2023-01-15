package DivisorSum;

class MyCalculator implements AdvancedArithmetic {

    @Override
    public int divisorSum(int n) {
        int count = 1;

        for (int i = 2; i <= n; i++) {
            if (n % i == 0) count += i;
        }

        return count;
    }
}
