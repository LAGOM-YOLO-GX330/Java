public class SearchSet {
    class TreeNode{
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int val){
            this.val=val;
        }
    }
    public TreeNode root;
    public boolean Search(int val){
        if(root==null){
            return false;
        }
        TreeNode cur=root;
        while(cur!=null){
            if(cur.val<val){
                cur=cur.right;
            }else if(cur.val>val){
                cur=cur.left;
            }else{
                return true;
            }
        }
        return false;
    }
    public boolean Insert(int val){
        if(root==null){
            root=new TreeNode(val);
            return true;
        }
        TreeNode cur=root;
        TreeNode parent=cur;
        while(cur!=null){
            if(cur.val<val){
                parent=cur;
                cur=cur.right;
            }else if(cur.val>val){
                parent=cur;
                cur=cur.left;
            }else{
                return false;
            }
        }
        TreeNode tmp=new TreeNode(val);
        if(parent.val>val){
            parent.left=tmp;
        } else if (parent.val<val) {
            parent.right=tmp;
        }
        return true;
    }
    public boolean Delete(int val){
        if(root==null){
            return false;
        }
        TreeNode cur=root;
        TreeNode parent=cur;
        while(cur!=null){
            if(cur.val<val){
                parent=cur;
                cur=cur.right;
            }else if(cur.val>val){
                parent=cur;
                cur=cur.left;
            }else{
                if(cur.left==null){
                    if(cur==root){
                        root=cur.right;
                    }else if(parent.left==cur){
                        parent.left=cur.right;
                    }else if(parent.right==cur){
                        parent.right=cur.right;
                    }
                }else if(cur.right==null){
                    if(cur==root){
                        root=cur.left;
                    }else if(parent.left==cur){
                        parent.left=cur.left;
                    }else if(parent.right==cur){
                        parent.right=cur.left;
                    }
                }else {
                    TreeNode tmp=cur.right;
                    TreeNode tmpparent=cur;
                    while(tmp.left!=null){
                        tmpparent=tmp;
                        tmp=tmp.left;
                    }
                    cur.val=tmp.val;
                    if(tmpparent.left==tmp) {
                        tmpparent.left = tmp.right;
                    }else{
                        tmpparent.right=tmp.right;
                    }
                }
                return true;
            }
        }

        return false;
    }


}
