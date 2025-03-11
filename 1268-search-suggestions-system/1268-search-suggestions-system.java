class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> res = new ArrayList<>();
        Arrays.sort(products); // Sort products lexicographically
        
        int left = 0, right = products.length - 1;
        for (int i = 1; i <= searchWord.length(); i++) {
            String prefix = searchWord.substring(0, i);
            while (left <= right && !products[left].startsWith(prefix)) left++;
            while (left <= right && !products[right].startsWith(prefix)) right--;
            
            // Add up to 3 suggestions
            List<String> suggestions = new ArrayList<>();
            for (int j = left; j < Math.min(left + 3, right + 1); j++) {
                suggestions.add(products[j]);
            }
            res.add(suggestions);
        }
        return res;
    }
}
