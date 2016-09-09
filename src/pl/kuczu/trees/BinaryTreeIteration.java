package pl.kuczu.trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeIteration {
    private Node root;
    private int postIdx;
    private int preIdx;

    public BinaryTreeIteration() {
        this.root = null;
    }

    public Node getRoot(){
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public void printIN(){
        Stack<Node> stack = new Stack<Node>();
        Node node = root;

        while(node != null || !stack.empty()){
            if(node != null){
                stack.push(node);
                node = node.left;
            }
            else{
                node = stack.pop();
                System.out.print(node.info + " ");
                node = node.right;
            }
        }
    }

    public void printPRE(){ //TODO TEST
        Stack<Node> stack = new Stack<Node>();
        stack.push(root);

        while(stack.peek() != null && !stack.empty()){
            Node node = stack.pop();
            System.out.print(node.info + " ");

            if(node.right != null){
                stack.push(node.right);
            }

            if(node.left != null){
                stack.push(node.left);
            }
        }
    }

    public void printPOST(){
        Stack<Node> stack = new Stack<Node>();
        stack.push(root);

        while(!stack.isEmpty()) {
            Node temp = stack.peek();

            if(temp.left==null && temp.right==null) {
                Node pop = stack.pop();
                System.out.print(pop + " ");
            }
            else {
                if(temp.right!=null) {
                    stack.push(temp.right);
                    temp.right = null;
                }

                if(temp.left!=null) {
                    stack.push(temp.left);
                    temp.left = null;
                }
            }
        }
    }

    public void printLEVEL(){
        Node node = root;
        Queue<Node> nodeQueue=new LinkedList<Node>();

        nodeQueue.add(node);

        while(!nodeQueue.isEmpty())
        {
            Node akt=nodeQueue.poll();
            System.out.print(akt.info + " ");

            if(akt.left != null)
                nodeQueue.add(akt.left);
            if(akt.right != null)
                nodeQueue.add(akt.right);
        }
    }
}
