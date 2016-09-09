package pl.kuczu.trees;

public class BinarySearchTreeIteration {
    private Node root;
    private int postIdx;
    private int preIdx;

    public BinarySearchTreeIteration() {
        this.root = null;
    }

    public Node getRoot(){
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public void insert(int val){
        Node newNode = new Node(val);

        if(root == null){
            root = newNode;
        }
        else{
            Node node = root;
            Node prev = null;

            while(node != null){
                prev = node;

                if(val < node.info){
                    node = node.left;
                }
                else{
                    node = node.right;
                }
            }

            if(val < prev.info){
                prev.left = newNode;
            }
            else{
                prev.right = newNode;
            }
        }
    }

    public Node search(int searchValue){
        Node node = root;

        while(node != null && searchValue != node.info){
            if(searchValue < node.info){
                node = node.left;
            }
            else{
                node = node.right;
            }
        }
        return node;
    }
}
