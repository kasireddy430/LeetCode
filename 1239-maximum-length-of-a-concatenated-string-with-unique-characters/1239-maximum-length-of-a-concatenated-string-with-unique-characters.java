class Solution {
    private static boolean isUnique(String s) {
        boolean[] seen = new boolean[26];
        for (char c : s.toCharArray()) {
            int idx = c - 'a';
            if (seen[idx])
                return false;
            seen[idx] = true;
        }
        return true;
    }

    public static int findMaxLength(List<String> arr, String s, int index) {
        if (!isUnique(s)) {
            return 0;
        }
        int max = s.length();
        for (int i = index; i < arr.size(); i++) {
            max = Math.max(max, findMaxLength(arr, s + arr.get(i), i + 1));
        }
        return max;
    }

    public int maxLength(List<String> arr) {
        return findMaxLength(arr, "", 0);
    }
}