package pl.kuczu.trees;

public class BinaryTreeRecursion {
    private Node root;
    private int postIdx;
    private int preIdx;

    public BinaryTreeRecursion() {
        this.root = null;
    }

    public Node getRoot(){
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public Node makeBTFromPOST(int postOrder[], int inOrder[], int first, int second) {
        postIdx = postOrder.length - 1;

        return makeBTFromPOSTMethod(postOrder, inOrder, first, second);
    }

    private Node makeBTFromPOSTMethod(int postOrder[], int inOrder[], int first, int second){
        if(first > second){
            return null;
        }

        Node node;

        if(first == second){ // can be short -> return new Node(postOrder[postIdx--]);
            node = new Node(postOrder[postIdx]);
            postIdx--;
            return node;
        }
        else{
            int val = postOrder[postIdx];
            postIdx--;
            int idx = findCenter(inOrder, val, first, second);

            node = new Node(val,
                    makeBTFromPOSTMethod(postOrder, inOrder, first, idx - 1), // left
                    makeBTFromPOSTMethod(postOrder, inOrder, idx + 1, second) // right
                    );

            return node;
        }
    }

    public Node makeBTFromPRE(int preOrder[], int inOrder[], int first, int second) {
        postIdx = preOrder.length - 1;

        return makeBTFromPREMethod(preOrder, inOrder, first, second);
    }

    private Node makeBTFromPREMethod(int preOrder[], int inOrder[], int first, int second){
        if(first > second){
            return null;
        }

        Node node;

        if(first == second){
            node = new Node(preOrder[preIdx]);
            preIdx++;
            return node;
        }
        else{
            int val = preOrder[preIdx++];
            int idx = findCenter(inOrder, val, first, second);

            node = new Node(val,
                    makeBTFromPREMethod(preOrder, inOrder, first, idx - 1), // left
                    makeBTFromPREMethod(preOrder, inOrder, idx + 1, second)
                    ); // right

            return node;
        }
    }

    private int findCenter(int arr[], int value, int first, int second){
        int i;
        for(i = first; i <= second; i++){
            if(arr[i] == value){
                return i;
            }
        }

        return i;
    }

    public int height(Node node){
        if (node == null){
            return 0;
        }
        else{
            int leftHeight = height(node.left);
            int rightHeight = height(node.right);

            if(leftHeight > rightHeight){
                return (leftHeight + 1);
            }
            else{
                return (rightHeight + 1);
            }
        }
    }

    private void printLevel(Node node, int height){
        for(int i = 1; i <= height; i++){
            printGivenLevel(node, i);
        }
    }

    public void printGivenLevel(Node node, int level){
        if(node == null){
            return;
        }
        if(level == 1){
            System.out.print(node.info + " ");
        }
        else if (level > 1){
            printGivenLevel(node.left, level-1);
            printGivenLevel(node.right, level-1);
        }
    }

    public void printPRE(Node node){
        if(node != null){
            System.out.print(node.info + " ");
            printPRE(node.left);
            printPRE(node.right);
        }
    }

    public void printPOST(Node node){
        if(node != null){
            printPOST(node.left);
            printPOST(node.right);
            System.out.print(node.info + " ");
        }
    }

    public void printIN(Node node){
        if(node != null){
            printPOST(node.left);
            System.out.print(node.info + " ");
            printPOST(node.right);
        }
    }

    public Node parent(int val, Node currentNode, Node prevNode){
        if(currentNode.info == val){
            if(currentNode != root){
                return prevNode;
            }
            else{
                return null;
            }
        }

        Node find = null;

        if(currentNode.left != null){
            find = parent(val, currentNode.left, currentNode);
        }
        if(currentNode.right != null && find == null){
            find = parent(val, currentNode.right, currentNode);
        }

        return find;
    }

    public int depth(Node node, int val){
        if(node == null){
            return -1;
        }

        int depthLevel;

        if(node.info == val){
            return 0;
        }
        else{
            depthLevel = depth(node.left, val);

            if(depthLevel != -1){
                return depthLevel + 1;
            }
            else{
                depthLevel = depth(node.right, val);

                if(depthLevel != -1){
                    return depthLevel + 1;
                }
                else{
                    return -1;
                }
            }
        }
    }

    static public void main(String args[]){
        BinaryTreeRecursion bs = new BinaryTreeRecursion();
        int inorder[] = {8, 4, 2, 5, 9, 1, 6, 3, 10, 7, 11};
        int preorder[] = {1, 2, 4, 8, 5, 9, 3, 6, 7, 10, 11};

        bs.setRoot( bs.makeBTFromPRE(preorder, inorder, 0, preorder.length - 1) );
        bs.printIN(bs.getRoot());
        System.out.println();
        bs.printPOST(bs.getRoot());
        System.out.println();
        bs.printLevel(bs.getRoot(), bs.height(bs.getRoot()));
        System.out.println();

        for(int i = 2; i <= 11; i++){
            System.out.println(bs.parent(i, bs.getRoot(), null).info + " -> " + i);
        }

        for(int i = 1; i <= 11; i++){
            System.out.println(i + " is on " + bs.depth(bs.getRoot(), i));
        }
    }
}
