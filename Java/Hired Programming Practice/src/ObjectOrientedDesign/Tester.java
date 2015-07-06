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
        
//        CallCenter cc = new CallCenter(3, 2, 1);
//        cc.dispatchCall();
//        System.out.println("");
        
//        CDPlayer cp = new CDPlayer();
//        String [] songs = {"burn burn burn", "train", "grey hat"};
//        String [] songs2 = {"falling asleep", "tip toe", "walking to town"};
//        cp.addCD("Kenny Bloom", songs);
//        cp.addCD("Dust", songs2);
//        cp.removeCD("Dust");
        
       JukeBox jb = new JukeBox("Marc", "123");
       String [] songs = {"burn burn burn", "train", "grey hat"};
       String [] songs2 = {"falling asleep", "tip toe", "walking to town"};
       jb.addCD("Kenny Bloom", songs);
       jb.addCD("Dust", songs2);
       jb.saveUserMusic();
       jb.displayCurrentUserInformation();
       
       jb.addUser("Jonny", "111");
       jb.changeDefaultUser("Jonny", "111");
       jb.addCD("Kenny Bloom", songs);
       jb.addCD("Dust", songs2);
       jb.saveUserMusic();
       jb.displayCurrentUserInformation();

        
        System.out.println("");
    }
}
