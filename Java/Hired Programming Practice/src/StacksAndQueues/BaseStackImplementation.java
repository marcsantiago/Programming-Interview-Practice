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

public class BaseStackImplementation{
    ObjectNode top;
    Object pop(){
        if(top != null){
            Object item = top.data;
            top = top.next;
            return item;
        }
        return null;
    }
    
    void push(Object item){
        ObjectNode t = new ObjectNode(item);
        t.next = top;
        top = t;
    }
    
    Object peek(){
        return top.data;
    }
    
    boolean isEmpty(){
        return top == null;
    }
}

