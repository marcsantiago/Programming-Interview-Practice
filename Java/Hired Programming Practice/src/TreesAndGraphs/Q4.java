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
//Given a binary tree, design an algorithm which creates a linked list 
//of all the nodes at each depth.
public class Q4 {
    //can be modified and added as a method within the BinaryTree defination
    public LinkedList treeToLinkedList(Node tree){
        if(tree != null){
            LinkedList<Integer> ll = new LinkedList<>();
            Queue<Node> q = new LinkedList<>();
            q.add(tree);
            while(!q.isEmpty()){
                Node node = q.remove();
                ll.add(node.data);
                if(node.leftPointer != null){
                    q.add(node.leftPointer);
                }
                if(node.rightPointer != null){
                    q.add(node.rightPointer);
                }
            }
            return ll;
        }
        return null;
    }
    
}



