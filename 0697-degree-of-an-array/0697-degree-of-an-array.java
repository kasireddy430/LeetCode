class Solution {
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer,Integer> first=new HashMap<>();
        HashMap<Integer,Integer> last=new HashMap<>();
        HashMap<Integer,Integer> count=new HashMap<>();

        int degree=0;
        int minL=nums.length;

        for(int i=0;i<nums.length;i++){
            int num=nums[i];
            first.putIfAbsent(num,i);
            last.put(num,i);
            count.put(num,count.getOrDefault(num,0)+1);

            degree=Math.max(degree,count.get(num));
        }

        for(int key : count.keySet()){
            if(count.get(key)==degree){
                int length=last.get(key)-first.get(key)+1;
                minL=Math.min(minL,length);
            }
        }
        return minL;
        
    }
}