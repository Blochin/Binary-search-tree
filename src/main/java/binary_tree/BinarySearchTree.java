package binary_tree;


public class BinarySearchTree {
    private Node root;

    public BinarySearchTree(Node node){
        this.root = node;
    }

    public void traversePreOrder(StringBuilder sb, String padding, String pointer, Node node) {
        if (node != null) {
            sb.append(padding);
            sb.append(pointer);
            sb.append(node.getValue());
            sb.append("\n");

            String paddingForBoth = padding + "│  ";
            String pointerForLeft = "└──";
            String pointerForRight = (node.getLeftNode() != null) ? "├──" : "└──";

            traversePreOrder(sb, paddingForBoth, pointerForRight, node.getRightNode());
            traversePreOrder(sb, paddingForBoth, pointerForLeft, node.getLeftNode());
        }
    }

    public void print() {
        StringBuilder sb = new StringBuilder();
        traversePreOrder(sb," "," ", this.root);
        System.out.print(sb.toString());
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

}
