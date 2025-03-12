class FileSystem {
    Map<String,Integer> map;
    public FileSystem() {
        map = new HashMap<>();
        map.put("", -1);
    }
    
    public boolean createPath(String path, int value) {
        if (map.containsKey(path)) {
            return false; // Path already exists
        }

        int lastSlash = path.lastIndexOf("/");
        String parent = path.substring(0, lastSlash);

        if (!map.containsKey(parent)) {
            return false; // Parent path must exist
        }

        map.put(path, value);
        return true;
        
    }
    
    public int get(String path) {
        return map.getOrDefault(path, -1);
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * boolean param_1 = obj.createPath(path,value);
 * int param_2 = obj.get(path);
 */