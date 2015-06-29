package ArraysAndStrings;
/**
 *
 * @author marcsantiago
 */

//Implement a function void reverse(char* str) in c or c++ which
//reverses a null terminated string
//Java example
public class Q2 {
    
    public String reverse(String str){
        StringBuilder revString = new StringBuilder();
        char [] ch = str.toCharArray();
        int strLength = ch.length / 2;
        int endIndex = ch.length - 1;
        for(int i=0; i<strLength; i++){
            char temp = ch[i];
            ch[i] = ch[endIndex];
            ch[endIndex] = temp;
            endIndex--;
        }
        
        for(char c: ch){
            revString.append(c);
        }
        return revString.toString();
    }
    
    public String reverse(char [] str){
        StringBuilder revString = new StringBuilder();
        int strLength = str.length / 2;
        int endIndex = str.length - 1;
        for(int i=0; i<strLength; i++){
            char temp = str[i];
            str[i] = str[endIndex];
            str[endIndex] = temp;
            endIndex--;
        }
        for(char c: str){
            revString.append(c);
        }
        return revString.toString();
    }   
}
