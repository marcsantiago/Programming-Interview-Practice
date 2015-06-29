package ArraysAndStrings;
import java.util.Arrays;
/**
 *
 * @author marcsantiago
 */
//Given two strings, write a method to decide if one is a permutation of the other
public class Q3 {
    
    private char [] sortString(String str){
        char [] lowerCase = str.toLowerCase().replace(" ","").toCharArray();
        Arrays.sort(lowerCase); //performs an inplace sort
        return lowerCase;
    }
    
    public boolean isPermutation(String str1, String str2){
      char [] string1 = sortString(str1);
      char [] string2 = sortString(str2);
      
      if(string1.length != string2.length){
          return false;
      }
      
      for(int i=0; i<string1.length; i++){
          if(string1[i] != string2[i]){
              return false;
          }
      }
      return true;
    }
    
}
