class FileSystem {
    private Map<String, Integer> map;
    public FileSystem() {
        map = new HashMap<>();
    }
    
    public boolean createPath(String path, int value) {
        if (map.get(path) != null) {
            return false;
        }
        String parent = path.substring(0, path.lastIndexOf('/'));
        if (!parent.isEmpty() && map.get(parent) == null) {
            return false;
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