class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> indexes = new ArrayList<>();
        if(s.length()<p.length()){
            return indexes;
        }
		Map<Character, Integer> sMap = new HashMap<>();
		Map<Character, Integer> pMap = new HashMap<>();

		for (int i = 0; i < p.length(); i++) {
			sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) + 1);
			pMap.put(p.charAt(i), pMap.getOrDefault(p.charAt(i), 0) + 1);
		}

		for (int i = 0; i < s.length() - p.length(); i++) {
			if (sMap.equals(pMap)) {
				indexes.add(i);
			}
			sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) - 1);
			if (sMap.get(s.charAt(i)) == 0) {
				sMap.remove(s.charAt(i));
			}
			sMap.put(s.charAt(i + p.length()), sMap.getOrDefault(s.charAt(i + p.length()), 0) + 1);
		}
        if (sMap.equals(pMap)) {
			indexes.add(s.length() - p.length());
		}
		return indexes;
    }
}