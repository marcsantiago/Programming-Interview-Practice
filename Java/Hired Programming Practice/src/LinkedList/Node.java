/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinkedList;
import java.util.HashSet;
import java.util.ArrayList;
import java.lang.Math;
import java.util.Arrays;

/**
 *
 * @author marcsantiago
 */
public class Node {
    
    Node next = null;
    int data;
    
    public Node(int d){
        data = d;
    }
    
    void appendToTail(int d){
        
        Node end = new Node(d); //Item to append to the end
        Node n = this; //To access Class object next
        
        while(n.next != null){
            n = n.next;
        }
        n.next = end;
    }
    
    Node deleteNode(Node head, int d){
        Node n = head;
        if(n.data == d){
            return head.next;
        }
        
        while(n.next != null){
            if(n.next.data == d){
                n.next = n.next.next;
                return head;
            }
            n = n.next;
        }
        return head;
    }
    
    void deleteNode(int d){
        Node n = this;
        if(n.data == d){
            data = next.data;
            next = next.next;
            return;
        }

        while(n.next != null){
            if(n.next.data == d){
                n.next = n.next.next;
                return;
            }
            n = n.next;
        }
    }
    
    void printNodes(){ 
        Node n = this;
        while(n.next != null){
            System.out.println(n.data);
            n = n.next;     
        }
        System.out.println(n.data); //print out the last node
    }
    
    //For fun, to simulate how python print's a list
    // printed example [1, 2, 3]
    void pythonListPrint(){
        Node n = this;
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while(n.next != null){
            sb.append(n.data).append(", ");
            n = n.next;
        }
        sb.append(n.data);
        sb.append("]");
        System.out.println(sb.toString());
    }
    
    
    //answer to question 2_1
    //Write code to remove duplicates from an unsorted linked list
    void removeDup(Node n){
        HashSet<Integer> set =  new HashSet<>();
        Node previous = null; 
        while(n != null){
            if(set.contains(n.data)){
                previous.next = n.next;
            }
            else{
                set.add(n.data);
                previous = n;
            }   
            n = n.next;
            
        }       
    }
    
    
    //answer to question 2_2
    //Implement an algorithm to find the kth to last element in a singly linked list
    
    //Method 1 find length of list and search for length - k
    //This method works, but i want to return the size
//    void size(){
//        Node n = this;
//        int count = 0;
//        while(n != null){
//            n = n.next;
//            count++;
//        }
//        System.out.println(count);
//    }
    
//    //METHOD 1 
    int size(){
        Node n = this;
        int count = 0;
        while(n != null){
            n = n.next;
            count++;
        }
        return count;
    }
//    
//    int searchKFromEnd(int k){
//        if(size() <= 0 || k > size()){
//            return 0;
//        }
//        Node n = this;
//        for(int i=0; i<size() - k; i++){
//            n = n.next;
//        }
//        
//        return n.data;
//    }
    
    
    // METHOD 2 use to pointers
    int searchKFromEnd(int k){
        if(k <= 0){
            return 0;
        }
        
        Node p1 = this;
        Node p2 = this;
        
        for(int i = 0; i < k - 1; i++){
            if(p2 == null){ //checks
                return 0;
            }
            p2 = p2.next;
        }
        if(p2 == null){
                return 0;
            }
        
        while(p2.next != null){
            p2 = p2.next;
            p1 = p1.next;
        }
        
        return p1.data;   
    }
    
    
    
    //answer to question 2_3 Implement an algorithm to delete a node in 
    //the middle of a singly linked list
    //given only access to that node
    //Implement an algorithm to find the kth to last element in a singly linked list
    
    //Method 1 find the size of the list using a the size method created above,
    //The size of the list / 2, floored, minus 1 gives us two nodes before the actually middle
    //Iterate to that node, set node.next == node.next.next (skipping middle node)
    
    void deleteMiddleNode(){
        int middle = (int) Math.floor(size() / 2) - 1; // cast to int
        Node n = this;
        for (int i = 0; i < middle; i++) {
            n = n.next;
        }
        n.next = n.next.next;  
    }
    
    //answer to question 2_4 write code to partition a linked list around a value x
    //such that all nodes lower than x are on the left and all nodes equal to or greater
    //than x are on the right
    //Method 1, create two arraylist
    //Add numbers lower than x to left else right
    //Combine those list and remove them to release mem
    //create a new Node
    //add values to new node
    
    Node sortByX(int x){
        ArrayList<Integer> leftArr = new ArrayList<>();
        ArrayList<Integer> rightArr = new ArrayList<>();
        ArrayList<Integer> combinedArr = new ArrayList<>();
        Node n = this;
        while(n.next != null){
            if(n.data >= x){
                rightArr.add(n.data);
            }
            else{
                leftArr.add(n.data);
            }
            n = n.next;
        }
        if(n.data >= x){
            rightArr.add(n.data);
        }
        else{
            leftArr.add(n.data);
        }
        
        combinedArr.addAll(leftArr);
        leftArr = null; //release memory
        
        combinedArr.addAll(rightArr);
        rightArr = null; //release memory
        
        Node newNodes = new Node(combinedArr.get(0)); //assign the new head
        
        for (int i = 1; i < combinedArr.size(); i++) {
            newNodes.appendToTail(combinedArr.get(i));
        }
          return newNodes;  
    }
    
    //2_5 you have to numbers representation by a linked list, where each node
    //contains a single digit.  The digits are stored in reverse order, such that
    //the 1st digit is at the head of the list. Write a function that adds the numbers
    //and returns the sum(reversed) as a linkedlist
    //e.g (7->1->6) + (5->9->2) = 617 + 295
    //    (2->1->9)            == 912
    //Method 1
    //Build two linkedlist
    
    Node reverseAdd(Node list1, Node list2){
        StringBuilder l1 = new StringBuilder();
        StringBuilder l2 = new StringBuilder();
        Node finalList;
        
        while(list1 != null){
            l1.append(list1.data);
            list1 = list1.next;
        }
       
        
        while(list2 != null){
            l2.append(list2.data);
            list2 = list2.next;
        }
        //reverse the data before you add it
        l1.reverse();
        l2.reverse();
        
        int result = Integer.parseInt(l1.toString()) + Integer.parseInt(l2.toString());
        
        //store head
        finalList = new Node(result % 10);
        result = result / 10;
        //Store the data reversed like the problem says
        do{
            finalList.appendToTail(result % 10);
            result /= 10;
        } while (result > 0);
          
        return finalList;
    }
     
    //2_7 implement an function to check if a linked list is a palindrome
    //Method 1 (See Method 2 in book)
    boolean isPalidrome(){
        ArrayList<Integer> fh = new ArrayList<>();
        ArrayList<Integer> sh = new ArrayList<>();
        
        int count = 0;
        Node n = this;
        boolean skip = true;
        
        while(n != null){
            if(size() % 2 == 0){
                if(count < size() / 2){
                    fh.add(n.data);
                }
                else{
                    sh.add(n.data);
                }
            }
            //what to do if the number is od
            else{
                if(count < size() / 2){
                    fh.add(n.data);
                }
                else{
                    if(skip){
                        n = n.next;
                    }
                    skip = false;
                    sh.add(n.data);
                }
            }
            count++;
            n = n.next;
        }
        
        Arrays.sort(sh.toArray());
        
        for (int i = 0; i < fh.size(); i++) {
            if(fh.get(i) != sh.get(i)){
                return false;
            }
        }
        
        
        return true;
    }
}

   