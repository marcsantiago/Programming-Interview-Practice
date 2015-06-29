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
//write a function to determine the number of bits you would need to flip
//to convert integer A to integer B.
//Example
//input: 29 (or: 11101), 15 (or: 01111)
//output: 2
public class Q5_5 {
    public static void main(String[] args){
        //System.out.println(bitDifference(29, 15));
        bitSwapReq(29, 15);
        
    }

    //XOR
    //XOR bits represents the difference between A and B
    //Count how long it takes for c to equal zero
    public static int bitSwapReq(int a, int b){
        int count = 0;  
        for (int c = a ^ b; c!=0; c = c & (c - 1)){
            count++;
        }
        return count;
    }
    
    
    public static int bitDifference(int num1, int num2){
        
        String bString1 = Integer.toBinaryString(num1);
        String bString2 = Integer.toBinaryString(num2);
        StringBuffer sb = new StringBuffer();
        int diff = 0;
        
        int lenDif = Math.abs(bString1.length() - bString2.length());
        
        if(bString1.length() < bString2.length()){
            for (int i = 0; i < lenDif; i++) {
                sb.append("0");
            }
           bString1 = sb.toString() + bString1;
        }
        
        else if(bString1.length() > bString2.length()){
            for (int i = 0; i < lenDif; i++) {
                sb.append("0");
            }
           bString2 = sb.toString() + bString2;
        }
             
        for (int i = 0; i < bString1.length(); i++) {
            if(bString1.charAt(i) != bString2.charAt(i)){
                diff++;
            }
        }
        
        return diff;
    }
}
