class Solution {
    public List<Integer> partitionLabels(String s) {
        //Create a map to store last occurences of each character from input string
        Map<Character, Integer> count = new HashMap<>();

        //populate map with last occurence of each character from input string
        for(int i = 0; i < s.length(); i++){
            count.put(s.charAt(i), i);
        }

        List<Integer> res = new ArrayList<>();//to store partition sizes
        int size = 0;//tracks partition size
        int end = 0;//tarcks partition boundary

        //Iterate over each character from input string
        for(int i = 0; i < s.length(); i++){
            size++; //Increment partition size
            //Update partition boundary 
            end = Math.max(end, count.get(s.charAt(i)));

            //Check if current index is the farthest occurrence of any character in partition
            if(i == end){
                res.add(size);//add partion size to result list
                size = 0;//reset partition size for next partition
            }
        }

        //return list of partition sizes
        return res;
    }

}

//Time Complexity: O(n)
//Space Complexity: O(1). since heap can strore O(26) characters which is constant