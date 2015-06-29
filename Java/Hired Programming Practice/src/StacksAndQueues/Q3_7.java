/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StacksAndQueues;
import java.util.LinkedList;
/**
 *
 * @author marcsantiago
 */
//Create a data structure to maintain the Animal Shelter system and implement operations
//such as enqueue, dequeueAny, dequeueCat, deQueueDog. You may use the built-in
//LinkList data structure
public class Q3_7 {
    LinkedList dog = new LinkedList();
    LinkedList cat = new LinkedList();
    LinkedList both = new LinkedList();
    int DOGID = 0;
    int CATID = 0;
    
    void enqueue(String type){
        String animal = type.toUpperCase();
        if("CAT".equals(animal)){
            cat.push("Cat " + Integer.toString(CATID));
            both.push("Cat " + Integer.toString(CATID));
            CATID++;
        }
        else if("DOG".equals(animal)){
            dog.push("Dog " + Integer.toString(DOGID));
            both.push("Dog " + Integer.toString(DOGID));
            DOGID++;
        }
        else{
            System.out.println("We only accept animals of type dog or cat, please "
                    + "try again");
        }
    }
    
    Object dequeueCat(){
        Object data = cat.removeLast();
        both.remove(data);
        return data;
    }
    
    Object dequeueDog(){
        Object data = dog.removeLast();
        both.remove(data);
        return data;
    }
    
    Object dequeueAny(){
        Object data = both.removeLast();
        String type = data.toString();
        if(type.contains("Cat")){
            cat.remove(data);
        }
        else{
            dog.remove(data);
        }
        return data;
    }
}
