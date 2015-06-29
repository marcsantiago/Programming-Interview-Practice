/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BitManipulation;

import java.util.Arrays;

/**
 *
 * @author marcsantiago
 */
public class Q5_6 {
    public static void main(String[] args){
        swapBits(29);
        System.out.println(Integer.toBinaryString(123));
        swapBits(123);

    }
    
    public static void swapBits(int a){
        char [] bitArr = Integer.toBinaryString(a).toCharArray();
        for (int i = 0; i < bitArr.length; i = i + 2) {
            if(i < bitArr.length -1){
                char temp = bitArr[i];
                bitArr[i] = bitArr[i + 1];
                bitArr[i + 1] = temp;
            }
        }
        System.out.println(Arrays.toString(bitArr));
    }
    

}
