/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ObjectOrientedDesign;
/**
 *
 * @author marcsantiago
 */
public class Tester {
    public static void main(String[] args){
//        BlackJack bj = new BlackJack();
//        System.out.println("");
        
        CallCenter cc = new CallCenter(3, 2, 1);
        cc.dispatchCall();
        System.out.println("");
    }
}
