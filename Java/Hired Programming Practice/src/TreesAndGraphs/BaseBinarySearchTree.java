/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TreesAndGraphs;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author marcsantiago
 */

public class BaseBinarySearchTree {
    
    Node root;
    
    //****************************//
    public void add(int d){
        Node nodeToAdd = new Node(d);
        if(root == null){
            root = new Node(d);
        }
        traverseAndAddNode(root, nodeToAdd);
    }

    private void traverseAndAddNode(Node node, Node nodeToAdd){
        if(nodeToAdd.data < node.data){
            if(node.leftPointer == null){
                nodeToAdd.parent = node;
                node.leftPointer = nodeToAdd;
            }
            else{
                traverseAndAddNode(node.leftPointer, nodeToAdd);
            }
        }
        else if(nodeToAdd.data > node.data){
            if(node.rightPointer == null){
                nodeToAdd.parent = node;
                node.rightPointer = nodeToAdd;
            }
            else{
                traverseAndAddNode(node.rightPointer, nodeToAdd);
            }
        }    
    }
    //****************************//
    //****************************//
    
    public void traverse(){
        if(root != null){
            Node nodeToTraverse = root;
            if(nodeToTraverse.leftPointer == null && nodeToTraverse.rightPointer == null){
                System.out.println(nodeToTraverse.data); //check to see if tree only as a root and no children
               
            }
            else{
                inOrderTrasversal(nodeToTraverse);
            }
        }
    }
    
    private void inOrderTrasversal(Node node){
        //place sout here for preorder
        //System.out.println(node.data);
        if(node.leftPointer != null){
            inOrderTrasversal(node.leftPointer);
        }
        //place sout here for inorder
        System.out.println(node.data);
        
        if(node.rightPointer != null){
            inOrderTrasversal(node.rightPointer);
        }
        //place sout here for postorder
        //System.out.println(node.data);
    }
    //****************************//
    //****************************//
    
//    public Node find(int d){
//        if(root != null){
//            return findNode(root, new Node(d));
//        }
//        return null;
//    }
//    
    //Breadth first search
    public void bfs(){
        if(root != null){
            Queue<Node> q= new LinkedList<>();
            q.add(root);
            while(!q.isEmpty()){
                Node node = q.remove();
                System.out.println(node.data);
                if(node.leftPointer != null){
                    q.add(node.leftPointer);
                }
                if(node.rightPointer != null){
                    q.add(node.rightPointer);
                }
            }
        }
        
    }
    
    public boolean find(int d){
        if(root != null){
            if(findNode(root, new Node(d)) != null){
                return true;
            }
        }
        return false;
    }
    
    private Node findNode(Node search, Node node){
        if(search == null){
            return null;
        }
        if(search.data == node.data){
            return search;
        }
        else{
            Node returnNode = findNode(search.leftPointer, node);
            if(returnNode == null){
                returnNode = findNode(search.rightPointer, node);
            }
            return returnNode;
        }
    }
    
    public int getDepth(){
        return depth(root);
    }
    
    //****************************//
    //****************************//    
    //Q1
    //Implement a function to check if a binary tree is balanced. For the purposes
    //of this question, a balance tree is defined to be a tree such that the height
    //of the two subtrees of any node never differ by more than one./
    
    private int depth(Node root){
        if(root == null){
            return 0;
        }
        return Math.max(depth(root.leftPointer), depth(root.rightPointer)) + 1;
    }
    
    public boolean isBalanced(){
        if(root == null){
            return true;
        }

        int heightDifference = depth(root.leftPointer) - depth(root.rightPointer) ;      
        if(Math.abs(heightDifference) > 1){
            return false;
        }       
        return true;
    }
    
    
    //Q2 given a directed graph, design an algorithm to find out whether there
    //is a route between to nodes.
    public boolean isPath(int first, int second){
        
        if(root != null){
            //There is always a path from the root of the tree
            if(first == root.data){
                return true;
            }
            //If one node is on the left of the root and the other is on
            //the right then there is never going to be root
            if(first < root.data && second > root.data){
                return false;
            }
            
            if(first > root.data && second < root.data){
                return false;
            }

            Node firstNode = findNode(root, new Node(first));
            Node secondNode = findNode(root, new Node(second));
            
            int firstNodeDepth = nodeDepth(root, firstNode);
            int secondNodeDepth = nodeDepth(root, secondNode);
           
            if(firstNodeDepth != secondNodeDepth){
                if(firstNodeDepth > secondNodeDepth){
                   return false;
                }
                return modifiedInorderTraversal(firstNode, secondNode);
            }          
        }
        return false;
    }
    
    private int nodeDepth(Node root, Node target){        
        if(root == null || root.data == target.data) {
            return 0;
        }
        if (target.data < root.data){
            return 1 + nodeDepth(root.leftPointer, target);
        }
        return 1 + nodeDepth(root.rightPointer, target);
    }   
    
    private boolean modifiedInorderTraversal(Node newRoot, Node target){     
        boolean foundIt = false;
 
        if(newRoot.leftPointer != null){
            foundIt = modifiedInorderTraversal(newRoot.leftPointer, target);
            if(foundIt){
                return true;
            } //the target was in the left subtree
        }

        if(newRoot == target){
            return true; //the target is this node!
        } 

        if(newRoot.rightPointer != null){
            foundIt = modifiedInorderTraversal(newRoot.rightPointer, target);
            if(foundIt){
                return true;
            } //the target was in the right subtree
        }
        
        return false; //the target is in neither subtree, and is not the root :-(
    }
    

  
   
}

class Node {
    int data;
    
    
    Node leftPointer = null;
    Node rightPointer = null;
    Node parent = null;

    public Node(int d){
        data = d;
    }       
}
