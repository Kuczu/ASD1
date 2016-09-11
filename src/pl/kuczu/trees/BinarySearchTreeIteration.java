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

    public Node delete(int deleteValue){
        //TODO
        return null;
    }

    public Node parent(int val){
        Node node = root;

        if(node.info == val){
            return null;
        }

        Node parent = null;

        while(node.info != val){
            if(node.info > val){ // go left
                if(node.left != null){
                    parent = node;
                    node = node.left;
                }
                else{
                    return null;
                }
            }
            else{
                if(node.right != null){
                    parent = node;
                    node = node.right;
                }
                else{
                    return null;
                }
            }
        }

        return parent;
    }

    public Node successor(int val){
        Node node = search(val);

        if(node == null){ // there isn't searched node
            return node;
        }

        Node pred = null;

        if(node.right != null){ // node has right son
            node = node.right;

            while(node.left != null){
                node = node.left;
            }

            return node;
        }
        else{ // node hasn't right son
            while(true){
                pred = parent(node.info); // can return Node or null

                if(pred != null){
                    if(pred.left == node){
                        return pred;
                    }
                    else{
                        node = pred;
                    }
                }
                else{
                    return null;
                }
            }
        }
    }

    public Node predecessor(int val){
        Node node = search(val);

        if(node == null){ // there isn't searched node
            return node;
        }

        Node pred = null;

        if(node.left != null){ // node has right son
            node = node.left;

            while(node.right != null){
                node = node.right;
            }

            return node;
        }
        else{ // node hasn't right son
            while(true){
                pred = parent(node.info); // can return Node or null

                if(pred != null){
                    if(pred.right == node){
                        return pred;
                    }
                    else{
                        node = pred;
                    }
                }
                else{
                    return null;
                }
            }
        }
    }
}
