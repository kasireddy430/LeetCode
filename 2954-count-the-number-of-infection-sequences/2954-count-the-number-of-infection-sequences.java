class Solution {
    static final int MOD = 1_000_000_007;

    public int numberOfSequence(int n, int[] sick) {
        int m = n - sick.length; // total healthy

        // factorials, inverse factorials, and powers of 2
        long[] fact = new long[n + 1];
        long[] invFact = new long[n + 1];
        long[] pow2 = new long[n + 1];

        fact[0] = pow2[0] = 1;
        for (int i = 1; i <= n; i++) {
            fact[i] = fact[i - 1] * i % MOD;
            pow2[i] = pow2[i - 1] * 2 % MOD;
        }
        invFact[n] = modPow(fact[n], MOD - 2);
        for (int i = n; i > 0; i--) {
            invFact[i - 1] = invFact[i] * i % MOD;
        }

        long ans = fact[m];

        // gap before first sick child
        ans = ans * invFact[sick[0]] % MOD;

        // gaps between sick children
        for (int i = 1; i < sick.length; i++) {
            int gap = sick[i] - sick[i - 1] - 1;
            ans = ans * invFact[gap] % MOD;
            if (gap > 0) {
                ans = ans * pow2[gap - 1] % MOD; // interior gap factor
            }
        }

        // gap after last sick child
        ans = ans * invFact[n - 1 - sick[sick.length - 1]] % MOD;

        return (int) ans;
    }

    private long modPow(long base, long exp) {
        long res = 1;
        while (exp > 0) {
            if ((exp & 1) == 1) res = res * base % MOD;
            base = base * base % MOD;
            exp >>= 1;
        }
        return res;
    }
}
