class Solution {
    //Map course to their prerequisites
    Map<Integer, List<Integer>> preMap = new HashMap<>();
    //tracking courses visited along dfs path
    Set<Integer> visited = new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //Initialize premap
        for(int i = 0; i < numCourses; i++){
            preMap.put(i, new ArrayList<>());
        }

        //populate preMap with their prerequisites
        for(int[] prerequisite : prerequisites){
            preMap.get(prerequisite[0]).add(prerequisite[1]);
        }

        //Check if a course's prerequisites are in a loop(if in loop, 
        //then it is not possible to complete courses).
        for(int i = 0; i < numCourses; i++){
            if(!dfs(i)){
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int course){
        //if a course is in visiting state in dfs path then a cycle is detected
        //which is the reason for not completing the course
        if(visited.contains(course)){
            return false;
        }

        //If a course has no prerequisites then return true, indicating the course can
        //be processed
        if(preMap.get(course).isEmpty()){
            return true;
        }

        //mark current course vivited if it's first time
        visited.add(course);
        //Iterate through it's prerequisites and check for cycle
        for(int pre : preMap.get(course)){
            if(!dfs(pre)){
                return false;
            }
        }

        //perform clean-up process after done with processing the courses and it's prerequisites
        visited.remove(course);
        preMap.put(course, new ArrayList<>());

        //We've processed the prequisites and the course, so return true
        return true;
    }
}

//Time Complexity: O(V + E)
//Space Complexity: O(V + E)