class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //Map courses to their prerequisites
        Map<Integer, List<Integer>> preMap = new HashMap<>();

        //populate preMap with their prerequisites for courses
        for(int[] preRequisite : prerequisites){
            preMap.computeIfAbsent(preRequisite[0], k -> new ArrayList<>()).add(preRequisite[1]);
        }

        List<Integer> output = new ArrayList<>();//List to store courses in the order in which they were processed
        Set<Integer> cycle = new HashSet<>();//Tracks courses currently in dfs path
        Set<Integer> visit = new HashSet<>();//Tracks the courses processed and helps avaoiding re-processing courses

        //Iterate through courses and process their prerequisites
        //and if any course couldn't be processed(if cycle detected) return false
        for(int i = 0; i < numCourses; i++ ){
            if(!dfs(i, preMap, output, cycle, visit)){
                return new int[0];
            }
        }

        //Add the output list to result array in the order of processing
        int[] result = new int[numCourses];

        for(int i = 0; i< numCourses; i++){
            result[i] = output.get(i);
        }

        return result;
    }

    private boolean dfs(int course, Map<Integer, List<Integer>> preMap, 
                        List<Integer> output, Set<Integer> cycle, Set<Integer> visit){
        
        //Check if current course is in cycle(current dfs path)
        if(cycle.contains(course)){
            return false;
        }

        //Check if the course is already visited, if so avaoid revisiting
        if(visit.contains(course)){
            return true;
        }

        cycle.add(course);

        //Process all the prerequisites for current course
        //if a course is in current dfs path and we are trying to visit it again,
        //then a cycle is detected
        for(int pre : preMap.getOrDefault(course, Collections.emptyList())){
            if(!dfs(pre, preMap, output, cycle, visit)){
                return false;
            }
        }

        //add the course to output list and mark it visited
        cycle.remove(course);
        visit.add(course);
        output.add(course);

        return true;//processed course
    }
}

//Time Complexity: O(v + E)
//Space Complexity: O(V + E)