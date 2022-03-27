package binary_tree;

public class Node {
    private String value;
    private Node leftNode = null;
    private Node rightNode = null;

    public Node(String  value){
        this.value = value;
    }

    public int compare(String search, int counter) {
        int comp = value.compareTo(search);
        System.out.println("Key: "+ value + " Search: "+search+" counter: " +counter);
        if(comp == 0)
        {
            return counter;
        } else if(comp <= -1){
            if(leftNode == null){
                return counter;
            }
            return rightNode.compare(search, counter+1);
        } else {
            if(rightNode == null){
                return counter;
            }
            return leftNode.compare(search, counter+1);
        }
    }

    public String  getValue() {
        return value;
    }

    public void setValue(String  value) {
        this.value = value;
    }

    public Node getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }

    public Node getRightNode() {
        return rightNode;
    }

    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }
}
