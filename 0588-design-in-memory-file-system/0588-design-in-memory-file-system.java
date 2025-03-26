class TrieNode{
    Map<String, TrieNode> children = new TreeMap<>();
    boolean isFile = false;
    String content = "";
}

public class FileSystem {
    TrieNode root;

    public FileSystem() {
        root = new TrieNode();
    }

    public List<String> ls(String path) {
        TrieNode node = root;
        List<String> res = new ArrayList<>();
        String[] file = path.split("/");

        for(int i = 1; i < file.length; i++){
            String cur = file[i];
            node = node.children.get(cur);
        }

        if(node.isFile){
            res.add(file[file.length - 1]);
        } else {
           for(Map.Entry<String, TrieNode> entry: node.children.entrySet()){
                res.add(entry.getKey());
           }
        }
        return res;
    }

    public void mkdir(String path) {
        TrieNode node = root;
        String[] file = path.split("/");

        for(int i = 1; i < file.length; i++){
            String cur = file[i];
            node.children.putIfAbsent(cur, new TrieNode());
            node = node.children.get(cur);
        }
    }

    public void addContentToFile(String filePath, String content) {
        TrieNode node = root;
        String[] file = filePath.split("/");

        for(int i = 1; i < file.length; i++){
            String cur = file[i];
            node.children.putIfAbsent(cur, new TrieNode());
            node = node.children.get(cur);
        }

        node.isFile = true;
        node.content += content;
    }

    public String readContentFromFile(String filePath) {
        TrieNode node = root;
        String[] file = filePath.split("/");

        for(int i = 1; i < file.length; i++){
            String cur = file[i];
            node.children.putIfAbsent(cur, new TrieNode());
            node = node.children.get(cur);
        }

        return node.content;
    }
}

//Time Complexity: O(n)
//Space Complexity: O(n)
//where n is depth of the path

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */