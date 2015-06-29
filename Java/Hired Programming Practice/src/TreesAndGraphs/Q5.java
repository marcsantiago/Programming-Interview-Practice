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

//Implement a function to check if a binary tree is a binary search tree
public class Q5 {
       
    ArrayList<Integer> list = new ArrayList<>();
    public boolean isBinarySearchTree(Node root){
        inorder(root);
        for (int i = 0; i < list.size(); i++) {
            if(i + 1 < list.size()){
                if(list.get(i) > list.get(i + 1)){
                    return false;
                }
            }
        }
        return true;
    }
    
    public void inorder(Node root){
        if(root.leftPointer != null){
            inorder(root.leftPointer);
        }
        list.add(root.data);
        if(root.rightPointer != null){
            inorder(root.rightPointer);
        }
    }
    
    
}
