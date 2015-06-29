/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BitManipulation;

/**
 *
 * @author marcsantiago
 */
//given a positive integer, print the next smallest and the next largest number
//that have the same number of 1 bits in their binary representation
public class Q5_3 {
    
    public static void main(String[] args){
        nextEqualBitIntegers(4);
        System.out.println(Integer.toBinaryString(0));
    }
    
    public static void nextEqualBitIntegers(int num){
        if(num != 1){
            
            int prevNum = getPrev(num, num - 1);
            int nextNum = getNext(num, num + 1);

            int prevDistance = num - prevNum;
            int nextDistance = nextNum - num;

            if(prevDistance < nextDistance){
                System.out.println(prevNum + " " + num);
            }
            else{
                System.out.println(num + " " + nextNum);
            }
        }
        else{
            System.out.println(1 + " " + 2);
        }
        
    }
    
    
    private static int getNext(int num, int next){
         while(Integer.bitCount(num) != Integer.bitCount(next)){
             next++;
         }
         return next;
    }
    
    private static int getPrev(int num, int next){
        while(Integer.bitCount(num) != Integer.bitCount(next)){
             next--;
         }
         return next;
    }
    
}

