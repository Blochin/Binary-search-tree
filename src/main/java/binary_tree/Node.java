package binary_tree;

public class Node {
    private String value;
    private Node leftNode = null;
    private Node rightNode = null;

    public Node(String  value){
        this.value = value;
    }

    private int compare(String search, int idx) {

        int comp = value.compareTo(search);
        System.out.println("Key: "+ value + " Search: "+search+" idx: " +idx+ " comp: "+comp);
        if(comp == 0)
        {
            return idx;
        } else if(comp <= -1){
            if(leftNode == null){
                return idx;
            }
            return rightNode.compare(search, idx+1);
        } else {
            if(rightNode == null){
                return idx;
            }
            return leftNode.compare(search, idx+1);
        }
    }

    public int compare(String search){
        return compare(search,1);
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
