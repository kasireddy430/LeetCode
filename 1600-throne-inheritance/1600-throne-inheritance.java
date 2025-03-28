class ThroneInheritance {
    String king;
    TreeNode root;
    Map<String, TreeNode > graph = new HashMap<>();
    List<String> ans = new ArrayList<>();

    public ThroneInheritance(String kingName) {
        king = kingName;
        root = new TreeNode(kingName);
        graph.put(kingName, root);  
    }

    public void birth(String parentName, String childName) {
     
        TreeNode child = new TreeNode(childName);
        graph.put(childName, child);
        graph.get(parentName).children.add(child);               
    }

    public void death(String name) {
        TreeNode node = graph.get(name);
        if (node != null) 
            node.isDead = true;
    }

    public List<String> getInheritanceOrder() {
        ans.clear();
        dfs(root);
        return ans;
    }

    private void dfs(TreeNode u) {
        if (!u.isDead) 
            ans.add(u.name);
    
        for (TreeNode v : u.children) 
            dfs(v);
    }

    class TreeNode {
        String name;
        List<TreeNode> children;
        boolean isDead;
        
        TreeNode(String name) {
            this.name = name;
            this.children = new ArrayList<>();
            this.isDead = false;
        }
    }

}

/**
 * Your ThroneInheritance object will be instantiated and called as such:
 * ThroneInheritance obj = new ThroneInheritance(kingName);
 * obj.birth(parentName,childName);
 * obj.death(name);
 * List<String> param_3 = obj.getInheritanceOrder();
 */