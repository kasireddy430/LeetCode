class Solution {
    public long minimumOperations(int[] nums, int[] target) {
        long prev =0;
        long opr = 0;

        for(int i =0;i<target.length;i++){
            int num = nums[i];
            int tar = target[i];
            long diff = target[i]-nums[i];

            if((prev < 0 && diff > 0 ) || (prev > 0 && diff < 0)){
                opr += Math.abs(diff);
            }else if(Math.abs(diff) > Math.abs(prev)){
                opr += Math.abs(diff-prev);
            }
            
            prev = diff;
            
        }

        return opr;
    }
}