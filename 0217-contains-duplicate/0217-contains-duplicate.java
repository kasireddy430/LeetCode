class Solution {
    public boolean containsDuplicate(int[] nums) {
        //Create a hash set to store the unique values from the input array
        Set<Integer> unique = new HashSet<>();

        //Iterate over input array
        for(int num:nums){
            //Check if the value is present in the hash set
            if(unique.contains(num)){
                return true;
            }
            unique.add(num);
        }

        return false;
    }
}