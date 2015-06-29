/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StacksAndQueues;
import java.util.EmptyStackException;
import java.util.Stack;
/**
 *
 * @author marcsantiago
 */
//Implement a MyQueue class which implements a queue using two stacks
public class Q3_5 { //MyQueue Class
    Stack<Integer> newestStack = new Stack<>();
    Stack<Integer> oldestStack = new Stack<>();
    
    void enqueue(int item){
        newestStack.push(item);
    }
    
    void pushToOldStack(){
        while(newestStack != null){
            try{
               oldestStack.push(newestStack.pop()); 
            }
            catch(EmptyStackException e){
                return;
            }
            
        }
    }
    
    int dequeue(){
        pushToOldStack();
        return oldestStack.pop();
    }
}
