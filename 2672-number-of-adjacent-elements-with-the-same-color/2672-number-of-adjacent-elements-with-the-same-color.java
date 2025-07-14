class Solution {
    public int[] colorTheArray(int n, int[][] queries) {
        int[] colors = new int[n];
        int[] result = new int[queries.length];
        int adjacentcount = 0;
        for(int i=0;i<queries.length;i++){
            int index = queries[i][0];
            int newcolor = queries[i][1];
            int oldcolor = colors[index];
            if(oldcolor==newcolor){
                result[i] = adjacentcount;
                continue;
            }
            if(oldcolor!=0){
                if(index>0 && colors[index-1] == oldcolor) adjacentcount--;
                if(index<n-1 && colors[index+1] == oldcolor) adjacentcount--;

            }
            colors[index] = newcolor;
            if(index>0 && colors[index-1] == newcolor) adjacentcount++;
            if(index<n-1 && colors[index+1] == newcolor) adjacentcount++;
            result[i] = adjacentcount;




        }
        return result;
       
       
    }
}