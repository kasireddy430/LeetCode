class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, HashMap<String, Double>> gr = createGraph(equations, values);

        int n = queries.size();
        double[] cur = new double[n];

        for(int i = 0; i < n; i++){
            String src = queries.get(i).get(0);
            String dst = queries.get(i).get(1);

            if(!gr.containsKey(src) || !gr.containsKey(dst)){
                cur[i] = -1.0;
            } else {
                HashSet<String> cycle = new HashSet<>();
                double[] res = {-1.0};
                double tmp = 1.0;
                dfs(gr, src, dst, cycle, res, tmp);
                cur[i] = res[0];
            }
        }
        return cur;
    }

    private void dfs(HashMap<String, HashMap<String, Double>> gr, String src, String dst, HashSet<String> cycle, 
                            double[] res, double tmp){
        if(cycle.contains(src)) return;
        cycle.add(src);

        if(src.equals(dst)){
            res[0] = tmp;
            return;
        }

        for(Map.Entry<String, Double> entry : gr.get(src).entrySet()){
            String curVal = entry.getKey();
            double edge = entry.getValue();

            dfs(gr, curVal, dst, cycle, res, tmp * edge);
        }
    }

    private HashMap<String, HashMap<String, Double>> createGraph(List<List<String>> equations, double[] values){
        int n = equations.size();
        HashMap<String, HashMap<String, Double>> gr = new HashMap<>();

        for(int i = 0; i < n; i++){
            String cur = equations.get(i).get(0);
            String dst = equations.get(i).get(1);
            double val = values[i];

            gr.putIfAbsent(cur, new HashMap<>());
            gr.putIfAbsent(dst, new HashMap<>());

            gr.get(cur).put(dst, val);
            gr.get(dst).put(cur, 1.0/val);
        }

        return gr;
    }
}


//Time Complexity: O(Q * (V + E))
//Space Complexity: O(V + E)