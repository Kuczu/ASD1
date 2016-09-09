package pl.kuczu.trees;

public class BinarySearchTreeRecursion {
    private Node root;
    private int postIdx;
    private int preIdx;

    public BinarySearchTreeRecursion() {
        this.root = null;
    }

    public Node getRoot(){
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public Node insert(Node node, int val){
        if(node == null){
            node = new Node(val);

            if(root == null){
                root = node;
            }
        }
        else{
            if(node.info > val){
                node.left = insert(node.left, val);
            }
            else{
                node.right = insert(node.right, val);
            }
        }

        return node;
    }

    public Node search(Node node, int searchVal){
        if(node.info == searchVal){
            return node;
        }

        if(node.info < searchVal){
            if(node.right != null){
                return search(node.right, searchVal);
            }
            else{
                return null;
            }
        }
        else{
            if(node.left != null){
                return search(node.left, searchVal);
            }
            else{
                return null;
            }
        }
    }

    public Node parent(int val, Node currentNode, Node prevNode){
        if(currentNode.info == val){
            if(!(currentNode == root)){
                return prevNode;
            }
            else{
                return null;
            }
        }

        if(currentNode.info < val){
            if(currentNode.right != null){
                return parent(val, currentNode.right, currentNode);
            }
            else{
                return null;
            }
        }
        else{
            if(currentNode.left != null){
                return parent(val, currentNode.left, currentNode);
            }
            else{
                return null;
            }
        }
    }

}
