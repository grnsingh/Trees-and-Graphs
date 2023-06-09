package BinaryTrees;
import java.util.*;

public class BinaryTrees {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree {
        static int index = -1;

        public Node buildTree(int[] nodes) {
            index++;
            if (nodes[index] == -1) {
                return null;
            }

            Node root = new Node(nodes[index]);
            root.left = buildTree(nodes);
            root.right = buildTree(nodes);

            return (root);
        }

        public void preOrderTraversal(Node root) {
            if (root == null) {
                System.out.print(-1 + " ");
                return;
            }
            System.out.print(root.data + " ");
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }

        public void inOrderTraversal(Node root) {
            if (root == null) {
                return;
            }

            inOrderTraversal(root.left);
            System.out.print(root.data + " ");
            inOrderTraversal(root.right);
        }

        public void postOrderTraversal(Node root) {
            if (root == null) {
                return;
            }

            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            System.out.print(root.data + " ");
        }

        public void levelOrderTraversal(Node root) {
            Queue<Node> queue = new LinkedList<>();
            queue.offer(root);
            queue.offer(null);

            while (!queue.isEmpty()) {
                Node curr = queue.poll();
                if (curr == null) {
                    System.out.println();
                    if (queue.isEmpty()) {
                        break;
                    } else {
                        queue.offer(null);
                    }
                } else {
                    System.out.print(curr.data + " ");
                    if (curr.left != null) {
                        queue.offer(curr.left);
                    }
                    if (curr.right != null) {
                        queue.offer(curr.right);
                    }
                }
            }
        }

        public static int counter(Node root) {
            if (root == null) {
                return (0);
            }
            int left = counter(root.left);
            int right = counter(root.right);
            return (left + right + 1);
        }

        public int getCount(Node root) {
            int count = counter(root);
            return (count);
        }

        public int minDepth(Node root) {
            Queue<Node> queue = new LinkedList<>();
            queue.offer(root);
            int depth = 1;
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    Node curr = queue.poll();
                    if (curr.left == null && curr.right == null) {
                        return (depth);
                    }
                    if (curr.left != null) {
                        queue.offer(curr.left);
                    }
                    if (curr.right != null) {
                        queue.offer(curr.right);
                    }
                }
                depth++;
            }
            return (-1);
        }

        public int maxDepth(Node root) {
            if (root == null) {
                return 0;
            }
            int leftDepth = maxDepth(root.left) + 1;
            int rightDepth = maxDepth(root.right) + 1;

            return (Math.max(leftDepth, rightDepth));
        }
        private int diameter = 0;
        public int diameterOfBinaryTree(Node root){
            if(root == null){
                return(0);
            }
            int leftPath = diameterOfBinaryTree(root.left);
            int rightPath = diameterOfBinaryTree(root.right);
            diameter = Math.max(diameter, leftPath+rightPath);
            return(Math.max(leftPath,rightPath)+1);
        }
        public int getDiameter(Node root){
            diameter = diameterOfBinaryTree(root);
            return(diameter);
        }
    }

    public static void main(String args[]) {
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        int nodes2[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, -1 };
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes2);
        tree.preOrderTraversal(root);
        System.out.println();
        tree.inOrderTraversal(root);
        System.out.println();
        tree.postOrderTraversal(root);
        System.out.println();
        tree.levelOrderTraversal(root);
        System.out.println();
        System.out.println(tree.getCount(root));
        System.out.println();
        System.out.println(tree.minDepth(root));
        System.out.println();
        System.out.println(tree.maxDepth(root));
        System.out.println();
        System.out.println(tree.getDiameter(root));
    }
}
