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
        BlackJack c = new BlackJack();
        System.out.println(c.draw());
        System.out.println(c.draw());
        System.out.println(c.draw());
        System.out.println(c.draw());
        System.out.println(c.draw());
        c.play();
    }
}
