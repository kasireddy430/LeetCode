class FileSystem {
    //Create a map to store paths and associated values
    private Map<String, Integer> map;

    public FileSystem() {
        map = new HashMap<>();
    }
    
    public boolean createPath(String path, int value) {
        //If path is already present, it is impossible to create path with different value
        if(map.get(path) != null){
            return false;
        }
        //Extract the parent path
        String parent = path.substring(0, path.lastIndexOf("/"));
        //If parent path is non empty and it is not present in map, then it
        //is not possible to create path
        if(!parent.isEmpty() && map.get(parent) == null){
            return false;
        }

        //store new path with associated value
        map.put(path, value);
        return true;
    }
    
    public int get(String path) {
        //return -1, if path doesn't exist 
        return map.getOrDefault(path, -1);
    }
}

//Time Complexity: O(n) for createPath where n is parent length. O(1) for get
//Space Complexity: O(P) for create path where P is for stoarge in map represents number of paths.
//O(1)space for get operation

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * boolean param_1 = obj.createPath(path,value);
 * int param_2 = obj.get(path);
 */