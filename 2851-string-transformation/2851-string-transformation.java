class Solution {
    public int numberOfWays(String s, String t, long k) {
        int n = s.length();  // Length of the string
        String ss = s + s;   // Concatenating s with itself to simulate cyclic shifts

        // Find the first occurrence of t in the concatenated string ss
        int first = ss.indexOf(t);
        
        // If t is not found in ss, return 0 since there are no valid shifts
        if (first == -1) {
            return 0;
        }

        // Count how many shifts lead to t being at position 0
        int zero_targets = (first == 0) ? 1 : 0;

        // Find the period of repetition (where s appears again in ss)
        int period = ss.indexOf(s, 1);
        if (period == -1) {
            period = n;  // If s is not found again, assume period = n
        }

        // Calculate how often s repeats in the cycle
        int frequency = n / period;
        int nonzero_targets = frequency - zero_targets; // Positions where t appears but not at index 0

        int MOD = 1_000_000_007; // Large prime number to prevent overflow

        // Determine the sign for the alternating series in binomial expansion
        int sign = (k % 2 == 0) ? 1 : -1;

        // Calculate the number of valid shift sequences using modular exponentiation
        long ways_0 = (modPow(n - 1, k, MOD) + (n - 1) * sign) % MOD;
        ways_0 = (ways_0 * modInverse(n, MOD)) % MOD;

        long ways_1 = (modPow(n - 1, k, MOD) - sign + MOD) % MOD;
        ways_1 = (ways_1 * modInverse(n, MOD)) % MOD;

        // Compute the final result based on zero and nonzero target occurrences
        return (int) ((zero_targets * ways_0 + nonzero_targets * ways_1) % MOD);
    }

    // Fast modular exponentiation (Exponentiation by Squaring)
    private long modPow(long base, long exp, long mod) {
        long res = 1;
        base %= mod;  // Ensure base is within mod

        while (exp > 0) {
            if ((exp & 1) == 1) {  // If exponent is odd, multiply result by base
                res = (res * base) % mod;
            }
            base = (base * base) % mod; // Square the base
            exp >>= 1; // Divide exponent by 2
        }
        return res;
    }

    // Compute modular inverse using Fermat’s Little Theorem: a^(mod-2) % mod
    private long modInverse(long a, long mod) {
        return modPow(a, mod - 2, mod);  
    }
}
