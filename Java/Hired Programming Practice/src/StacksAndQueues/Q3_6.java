/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StacksAndQueues;
//import java.util.BaseStackImplementation;
/**
 *
 * @author marcsantiago
 */
//write a program to sort a stack in ascending order (with biggest items on top)
//you may use at most one additional stack to hold items, you may not copy elements
//into any other data structure (such as an array), the stack supports the following
//push, pop, peek, isEmpty
public class Q3_6 {
    
    BaseStackImplementation sortByAsc(BaseStackImplementation s){
        BaseStackImplementation r = new BaseStackImplementation();
        while(!s.isEmpty()){
            int tmp = (int) s.pop();
            while(!r.isEmpty() && (int) r.peek() > tmp){
                s.push(r.pop());
            }
            r.push(tmp);
        }
        return r;
    }

}
