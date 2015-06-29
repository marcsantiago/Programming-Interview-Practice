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
//Given a real number  between 0 and 1 that is passed in as a double, print the
//binary representation accurately in binary with at most 32 characters, else print
//ERROR
public class Q5_2 {
    public static void main(String[] args){
        doubleToBinary(.8125);
    }
    
    public static void doubleToBinary(double number){
        if(number >= 1.0 || number <= 0.0){
            System.out.println("Error");
            return;
        }
           
        StringBuilder sb = new StringBuilder();

        while(number > 0.0){
           number = number * 2;
           if(number >= 1.0){
               number = number - 1.0;
               sb.append(1);
           }
           else{
               sb.append(0);
           }
           
           if(sb.length() > 32){
               System.out.println("Error");
               return;
           }         
        }
        System.out.println(sb.toString());
    }
    
//    public static void intToBinary(int number){
//        StringBuilder sb = new StringBuilder();
//        while(number > 0){
//            int temp = number % 2;
//            number = number / 2;
//            sb.append(temp);
//        }
//        sb.reverse();
//        System.out.println(sb.toString());
//    }
}
