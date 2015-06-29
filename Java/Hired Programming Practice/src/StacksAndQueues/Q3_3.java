/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StacksAndQueues;

import java.util.ArrayList;

/**
 *
 * @author marcsantiago
 */
//Implement a data structure called setofstacks that mimics this.  SetOfStacks should
//be composed of several stacks and should create a new stack once the previous
//one exceeds capacity.  Push and pop should act as if there is just one stack
public class Q3_3 {
    
    ArrayList<Stack2> stacks = new ArrayList<>();    
    
    void push(int d){
        Stack2 last = getLastStack();
        if(last != null && !last.isFull()){
            last.push(d);
        }
        else{
            Stack2 stack = new Stack2();
            stack.push(d);
            stacks.add(stack);
        }
    }
        
    int pop(){
        Stack2 last = getLastStack();
        int v = last.pop();
        if(last.size == 0){
            stacks.remove(stacks.size() - 1);
        }
        return v;
        
    }
    
    int popAt(int index){
        if(index + 1 > numberOfStacks()){
            return -1;
        }
        Stack2 myStack = stacks.get(index);
        int v = myStack.pop();
        if(myStack.size == 0){
            stacks.remove(stacks.get(index));
        }
        return v;
    }
 
    int numberOfStacks(){
        return stacks.size();
    }
    
    int peek(){
        Stack2 last = getLastStack();
        return last.top.data;
    }
    
    Stack2 getLastStack(){
       if(stacks.isEmpty()){
           return null;
       }
       else{
          int last = stacks.size() - 1;
          return stacks.get(last); 
       } 
    }
    
}

class Node3 {
    int data;
    Node3 next = null;
    public Node3(int d){
        data = d;
    }
}

class Stack2{
    Node3 top;
    int capacity = 10;
    int count = 0;
    int size = 10;
    
    int pop(){
        if(top != null){
            int item = top.data;
            top = top.next;
            size--;
            return item;
        }
        return -1;
    }
    
    void push(int item){
        Node3 t = new Node3(item);
        t.next = top;
        top = t;
        count++;
    }
    
    boolean isFull(){
        return count == capacity;
    }
    
    boolean isEmpty(){
        return top == null;
    }
    
    int peek(){
        return top.data;
    }
}

