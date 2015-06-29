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

//How would you design a stack which, in addition to push and pop, also has a
//function called min which returns the minimum element? Push, pop and min
//should all operate in O(1) time.
public class Q3_2{
    Node2 top;
    Node2 minNode;
    long min = 9223372036854775807L;
    int pop(){
        if(top != null){
            int item = top.data;
            top = top.next;
            minNode = minNode.next;
            return item;
        }
        return -1;
    }
    
    void push(int item){
        Node2 t = new Node2(item);
        t.next = top;
        top = t;
        
        if(top.data < min){
            min = item;
        }
        Node2 m = new Node2(min);
        m.next = minNode;
        minNode = m;
        
    }

    int peek(){
        return top.data;
    }
    
    long getMin(){
        return minNode.data2;
    }
    
}

class Node2 {
    int data;
    long data2;
    Node2 next = null;
    public Node2(int d){
        data = d;
    }

    public Node2(long d2) {
        data2 = d2;
    }
}
