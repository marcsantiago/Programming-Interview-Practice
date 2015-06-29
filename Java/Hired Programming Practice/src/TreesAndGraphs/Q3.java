/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TreesAndGraphs;

import java.util.ArrayList;

/**
 *
 * @author marcsantiago
 */
//Given a sorted (increasing order) array with unique integer elements,
//write an algorithm to create a binary search tree with minimal height.
public class Q3 {
    private ArrayList<Integer> arrl = new ArrayList<>();
    public BaseBinarySearchTree arrToTree(int arr [], int start, int end){
        BaseBinarySearchTree t = new BaseBinarySearchTree();
        Node structure = convertArrayToTree(arr, start, end);
        preOrderTraversal(structure);
        for(Integer i: arrl){
            t.add(i);
        }
        return t;
    }
 
    private Node convertArrayToTree(int arr [], int start, int end){
        if(start > end){
            return null;
        }

        int mid = (start + end) / 2;
        
        Node r = new Node(arr[mid]);
        r.leftPointer = convertArrayToTree(arr, start, mid-1);
        r.rightPointer = convertArrayToTree(arr, mid+1, end);
        
        return r;
    }
    
    private void preOrderTraversal(Node n){
        arrl.add(n.data);
        if(n.leftPointer != null){
            preOrderTraversal(n.leftPointer);
        }
        if(n.rightPointer != null){
            preOrderTraversal(n.rightPointer);
        }
    }
}
