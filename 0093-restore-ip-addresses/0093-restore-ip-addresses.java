class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s.length() > 12 || s.length() < 4) return res;

        backtrack(s, 0, 0, "", res);
        return res;
    }

    private void backtrack(String s, int i, int dots, String currIp, List<String> res) {
        if (dots == 4 && i == s.length()) {
            res.add(currIp.substring(0, currIp.length() - 1)); // Remove trailing dot
            return;
        }
        if (dots >= 4) return;

        for (int j = i; j < i + 3 && j < s.length(); j++) {
            String segment = s.substring(i, j + 1);
            if (isValid(segment)) {
                backtrack(s, j + 1, dots + 1, currIp + segment + ".", res);
            }
        }
    }

    private boolean isValid(String segment) {
        if (segment.length() > 1 && segment.startsWith("0")) return false;
        int val = Integer.parseInt(segment);
        return val >= 0 && val <= 255;
    }
}
