package Tree;

import java.util.ArrayList;
import java.util.Arrays;


class Node{
    protected int data;
    Node left;
    Node right;
    
    public Node(int data){
        this.data = data;
    }
}

public class BinarySearchTree {
    Node root;
    private int heightMinimum = 1;
    private int nodesAdded = 0;
    private int checkBalanceLimit = 20;
    private final ArrayList<Integer> tempList = new ArrayList<>();
        
    public void add(int data){
        Node newNode = new Node(data);
        if(root == null){
            root = new Node(data);
        }
        else{
            add(root, newNode);
        }
    }
    
    private void add(Node root, Node newNode){
        if(newNode.data < root.data){
            if(root.left == null){
                root.left = newNode;
                nodesAdded++;
            }
            else{
                add(root.left, newNode);
            }
        }
        else if(newNode.data > root.data){
            if(root.right == null){
                root.right = newNode;
                nodesAdded++;
            }
            else{
                add(root.right, newNode);
            }
        }
        
        if(nodesAdded == checkBalanceLimit){
            rebalance();
            nodesAdded = 0;
        }
    }
    
    public void preorder(){
        if(root != null){
            if(root.left == null && root.right == null){
                System.out.println(root.data);
            }
            else{
                preorder(root);
            }
        }
    }
    
    private void preorder(Node root){
        System.out.println(root.data);
        if(root.left != null){
            preorder(root.left);
        }
        if(root.right != null){
            preorder(root.right);
        }
    }
    
    public void inorder(){
        if(root != null){
            if(root.left == null && root.right == null){
                System.out.println(root.data);
            }
            else{
                inorder(root);
            }
        }
    }
    
    private void inorder(Node root){
        if(root.left != null){
            inorder(root.left);
        }
        System.out.println(root.data);
        if(root.right != null){
            inorder(root.right);
        }
    }
    
    public void postorder(){
        if(root != null){
            if(root.left == null && root.right == null){
                System.out.println(root.data);
            }
            else{
                postorder(root);
            }
        }
    }
    
    private void postorder(Node root){
        if(root.left != null){
            postorder(root.left);
        }
        
        if(root.right != null){
            postorder(root.right);
        }
        System.out.println(root.data);
    }
    
    public int getDepth(){
        return getDepth(root);
    }
    
    private int getDepth(Node root){
        if(root == null){
            return 0;
        }
        return Math.max(getDepth(root.left), getDepth(root.right)) + 1;
    }
    
    public boolean isBalanced(){
        if(root == null){
            return true;
        }
        
        int heightDiff = getDepth(root.left) - getDepth(root.right);
        if(Math.abs(heightDiff) > heightMinimum){
            return false;
        }
        
        return true;
    }
    
    
    public void rebalance(){
        if(!isBalanced()){
            toList(root);
            this.root = listToTree(tempList, 0, tempList.size() - 1);
            tempList.clear();
        }
    }
    
    private Node listToTree(ArrayList arr, int start, int end){
        if(start > end){
            return null;
        }
        int mid = (start + end) / 2;
        Node newRoot = new Node((int) arr.get(mid));
        newRoot.left = listToTree(arr, start, mid-1);
        newRoot.right = listToTree(arr, mid + 1, end);
        return newRoot;
    }
       
    private void toList(Node root){
        if(root.left != null){
            toList(root.left);
        }
        tempList.add(root.data);
        if(root.right != null){
            toList(root.right);
        }
    }
    
    public void arrayToTree(int [] arr){
        Arrays.sort(arr);// order the list to be added so that it's added balanced
        this.root = arrToTree(arr, 0, arr.length - 1);
    }
    
     private Node arrToTree(int [] array, int start, int end){
        if(start > end){
            return null;
        }
        int mid = (start + end) / 2;
        Node newRoot = new Node(array[mid]);
        newRoot.left = arrToTree(array, start, mid-1);
        newRoot.right = arrToTree(array, mid + 1, end);
        return newRoot;
    } 
     
    public void nodeToTree(Node node){
        this.root = node;
    }
     
    public boolean search(int data){
        if(root != null){
            if(findNode(root, new Node(data)) != null){
                return true;
            }
        }
        return false;
    }
    
    public Node getNode(int data){
        if(root != null){
            return findNode(root, new Node(data));
        }
        return null;
    }
    
    private Node findNode(Node search, Node node){
        if(search == null){
            return null;
        }
        if(search.data == node.data){
            return search;
        }
        else{
            Node returnNode = findNode(search.left, node);
            if(returnNode == null){
                returnNode = findNode(search.right, node);
            }
            return returnNode;
        }
    }
    
     
    public int getMinimumDepthDifference(){
        return heightMinimum;
    }
     
    public void setMinimumDepthDiffence(int depth){
        heightMinimum = depth;
    }
    
    public int getWhenToCheckBalace(){
        return checkBalanceLimit;
    }
    
    public void setWhenToCheckBalace(int number){
        checkBalanceLimit = number;
    }
       
}