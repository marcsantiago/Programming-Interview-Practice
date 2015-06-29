package ArraysAndStrings;
import java.util.Arrays;
/**
 *
 * @author marcsantiago
 */

//Implement an algorithm to determine if a string has unique characters.
//What if you cannot use additional data structures?
public class Q1 {
    
    private char[] sortString(String str){
        char[] chars = str.toLowerCase().replace(" ", "").toCharArray();
        Arrays.sort(chars);
        return chars;
    }   
    public boolean isStringUnique(String str){
        char [] sortedString = sortString(str);
        for(int i=0; i<sortedString.length; i++){
            int j = i + 1;
            if(j < sortedString.length){
                if(sortedString[i] == sortedString[j]){
                    return false;
                }
            }
        }    
        return true;
    }
}

