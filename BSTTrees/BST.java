package BSTTrees;
public class BST {
    static class Node {
        private int data;
        private Node left = null;
        private Node right = null;

        Node(int data) {
            this.data = data;
        }
    }

    public static Node insert(Node root, int data) {
        // Assumption there is no common root
        if (root == null) {
            root = new Node(data);
            return root;
        }

        if (data < root.data) {
            root.left = insert(root.left, data);
        }

        else {
            root.right = insert(root.right, data);
        }
        return root;
    }

    public static void inorder(Node root){
        if(root == null ) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static boolean search(Node root, int target){
        if(root == null){
            return false;
        }

        if(root.data == target){
            return true;
        }
        
        if(target > root.data){
            return search(root.right, target);
        }
        else{
            return search(root.left, target);
        }
    }

    public static void main(String args[]){
        int values[] = {5,1,3,4,2,7, -2,6};
        Node root = null;
        for(int i=0; i<values.length; i++){
            root = insert(root, values[i]);
        }
        inorder(root);
        System.out.println(search(root, -55));
        System.out.println(search(root, 6));
        System.out.println(search(root, -2));
        System.out.println(search(root, 8));
    }

    

}
