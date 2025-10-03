public class Solution {

    public int numberOfSequence(int n, int[] sick) {
        final int MOD = 1_000_000_007;

        // Step 1: mark sick children
        boolean[] isSick = new boolean[n];
        for (int i : sick) {
            isSick[i] = true;
        }

        // Step 2: find all consecutive healthy segments (gaps)
        List<Integer> gaps = new ArrayList<>();
        int cur = 0;
        for (int i = 0; i < n; i++) {
            if (!isSick[i]) {
                cur++;
            }
            // end of a healthy segment
            if (!isSick[i] && (i == n - 1 || isSick[i + 1])) {
                gaps.add(cur);
                cur = 0;
            }
        }

        // Step 3: handle leading and trailing gaps separately
        int leading = 0, trailing = 0;
        if (sick[0] != 0) {
            leading = gaps.get(0);
            gaps.remove(0);
        }
        if (sick[sick.length - 1] != n - 1) {
            trailing = gaps.get(gaps.size() - 1);
            gaps.remove(gaps.size() - 1);
        }

        // Step 4: total permutations of healthy children
        int totalHealthy = n - sick.length;
        int ans = factorial(totalHealthy, MOD);

        // Step 5: process interior gaps
        for (int gapSize : gaps) {
            ans = multiply(ans, inverseFactorial(gapSize, MOD), MOD);
            ans = multiply(ans, pow(2, gapSize - 1, MOD), MOD);
        }

        // Step 6: handle leading and trailing gaps
        ans = multiply(ans, inverseFactorial(leading, MOD), MOD);
        ans = multiply(ans, inverseFactorial(trailing, MOD), MOD);

        return ans;
    }

    // factorial modulo MOD
    private int factorial(int n, int MOD) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result = multiply(result, i, MOD);
        }
        return result;
    }

    // modular inverse factorial
    private int inverseFactorial(int n, int MOD) {
        return modExp(factorial(n, MOD), MOD - 2, MOD);
    }

    // modular exponentiation
    private int modExp(int base, int exp, int MOD) {
        int result = 1;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = multiply(result, base, MOD);
            }
            base = multiply(base, base, MOD);
            exp >>= 1;
        }
        return result;
    }

    // modular multiplication
    private int multiply(int a, int b, int MOD) {
        return (int) ((1L * a * b) % MOD);
    }

    // modular power (for 2^(gap-1))
    private int pow(int base, int exp, int MOD) {
        int result = 1;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = multiply(result, base, MOD);
            }
            base = multiply(base, base, MOD);
            exp >>= 1;
        }
        return result;
    }
}
