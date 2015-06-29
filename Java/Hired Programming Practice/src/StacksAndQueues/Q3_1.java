/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StacksAndQueues;

import java.util.Arrays;

/**
 *
 * @author marcsantiago
 */
//Write a method that converts an array into three stacks
public class Q3_1 {
   
    public BaseStackImplementation [] arrayToThreeStacks(Object [] list){
        
        int max = list.length;
        //create stacks
        BaseStackImplementation firstStack = new BaseStackImplementation();
        BaseStackImplementation secondStack = new BaseStackImplementation();
        BaseStackImplementation thirdStack = new BaseStackImplementation();
        //create three list
        Object [] first = Arrays.copyOfRange(list, 0, max / 3);
        Object [] second = Arrays.copyOfRange(list, max / 3, (2 * max) / 3);
        Object [] third  = Arrays.copyOfRange(list,(2 * max) / 3, max);
        
        
        for(Object o: first){
            firstStack.push(o);
        }
        for(Object o: second){
            secondStack.push(o);
        }
        for(Object o: third){
            thirdStack.push(o);
        }
        
        BaseStackImplementation [] all = {firstStack, secondStack, thirdStack};
        
        return all;
    }     
}

