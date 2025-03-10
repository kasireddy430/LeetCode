public class Solution {
    public int nextGreaterElement(int n) {
        //Convert integer to character array
        char[] arr = ("" + n).toCharArray();
        int i = arr.length - 2;

        //Find first decreasing element from right side of the array
        while(i >= 0 && arr[i] >= arr[i + 1]){
            i--;
        }

        //If no decreasing element found return -1
        if(i < 0){
            return -1;
        }

        //Find smallest element just greater than first decresing element found
        int j = arr.length - 1;
        while(j >= 0 && arr[j] <= arr[i]){
            j--;
        }

        //swap both the elements to have next permutation greater than current input
        swap(arr, i, j);
        //reverse remaining right part to get smallest lexicographical order
        reverse(arr, i + 1);

        try{
            return Integer.parseInt(new String(arr));
        } catch(Exception e){
            return -1;//for handling Integer Overflow
        }
    }

    private void swap(char[] arr, int i, int j){
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private void reverse(char[] arr, int i){
        int j = arr.length - 1;

        while(i < j){
            swap(arr, i, j);
            i++;
            j--;
        }
    }
}

//Time Complexity: O(n)
//Space Complexity: O(n)