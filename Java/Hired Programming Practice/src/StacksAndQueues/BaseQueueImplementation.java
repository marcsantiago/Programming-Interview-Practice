/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StacksAndQueues;

/**
 *
 * @author marcsantiago
 */

public class BaseQueueImplementation {
    IntNode first, last;
    
    void enqueue(int item){
        if(first == null){
            last = new IntNode(item);
            first = last;
        }
        else{
            last.next = new IntNode(item);
            last = last.next;
        }
    }
    
    int dequeue(){
        if(first != null){
            int item = first.data;
            first = first.next;
            if(first == null){
                last = null;
            }
            return item;
        }
        return -1; //Instead of null
    }
}

