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

//you are given two 32 bit integers, N and M, and bit positons j and i.
//write a method to insert m into n such that m starts at j and ends at bit i.
//you can assume that bits j through i have enough space to fit all of M.
//Example
//N = 10000000000
//M = 10011
//i = 2
//j = 6
//output = 10001001100
public class Q5_1 {
    public static void main(String[] args){
        System.out.println(insertBits(1024, 19, 2, 6));
        System.out.println(Integer.toBinaryString(insertBits(1024, 19, 2, 6)));

    }
    
    
    public static int insertBits(int number, int chunk, int start, int end){
        //create a buffer of all ones
        //111111111
        int allOnes = ~0;
        
        //shift ones the ones to the left creating zeros on the right
        //111111111000
        int left = allOnes << (end + 1);
        //pad the right side with ones 
        int right = ((1 << start) - 1);
        //System.out.println(Integer.toBinaryString(right) + " r");
        //combine the left and right side
        //11111111100011
        //That zeros is the empty spaced needed to clear the area in the number
        int mask = left | right;
        
        //clear the numer
        //11111111111111 (num) & 11111111100011 (mask)
        //11111111100011 (num)
        int numberCleared = number & mask;
        
        //shift the chunk to pad the left with zeros
        int chunkShifted = chunk << start;
        
        //combine them together
        return numberCleared | chunkShifted;
    }
}