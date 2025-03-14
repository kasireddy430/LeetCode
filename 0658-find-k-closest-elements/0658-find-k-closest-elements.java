class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        //Initialize pointers at start and end of input array
        int left = 0, right = arr.length - 1;

        //Shrink window until k elements remain
        while (right - left >= k) {
            //Check for fathest element from x and move the pointer
            if(Math.abs(arr[left] - x) > Math.abs(arr[right] - x)){
                left++;//Element at left pointer is farthest
            } else {
                right--;
            }
        }

        //Add k closest element to result list
        List<Integer> result = new ArrayList<>();

        for (int i = left; i <= right; i++) {
            result.add(arr[i]);
        }

        return result;//list of k closest elements
    }
}

//Time Complexity: O(n)
//Space Complexity: O(n)