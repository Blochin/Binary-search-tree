package binary_tree;

import java.io.PrintStream;

public class BinarySearchTree {
    private Node root;


    public void traversePreOrder(StringBuilder sb, String padding, String pointer, Node node) {
        if (node != null) {
            sb.append(padding);
            sb.append(pointer);
            sb.append(node.getValue());
            sb.append("\n");

            String paddingForBoth = padding + "│  ";
            String pointerForRight = "└──";
            String pointerForLeft = (node.getRightNode() != null) ? "├──" : "└──";

            traversePreOrder(sb, paddingForBoth, pointerForLeft, node.getLeftNode());
            traversePreOrder(sb, paddingForBoth, pointerForRight, node.getRightNode());
        }
    }

    public void print() {
        StringBuilder sb = new StringBuilder();
        traversePreOrder(sb," "," ", this.root);
        System.out.print(sb.toString());
    }

    public BinarySearchTree(Node node){
        this.root = node;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

}
