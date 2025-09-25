class Solution {
    public String arrangeWords(String text) {
        String[] strs = text.split(" ");
        strs[0] = strs[0].toLowerCase();

        int maxLen = 0;
        for(String str : strs){
            maxLen = Math.max(maxLen, str.length());
        }

        List<String>[] bucket = new List[maxLen + 1];
        for(int i = 0; i <= maxLen; i++){
            bucket[i] = new ArrayList<>();
        }

        for(String str : strs){
            bucket[str.length()].add(str);
        }

        List<String> res = new ArrayList<>();
        for(int i = 0; i <= maxLen; i++){
            res.addAll(bucket[i]);
        }

        res.set(0, res.get(0).substring(0, 1).toUpperCase() + res.get(0).substring(1));

        return String.join(" ", res);
    }
}