/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArraysAndStrings;

/**
 *
 * @author marcsantiago
 */
public class Q5 {
    
    public String stringCompression(String str){
        if(stringLength(str) > str.length()){
            return str;
        }
        
        StringBuilder sb = new StringBuilder();
        char last = str.charAt(0);
        int count = 1;
        
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == last){
                count++;
            }
            else{
                sb.append(last);
                sb.append(count);
                last = str.charAt(i);
                count = 1;
            }
        }
        //This allows us the grab the last section since it wasn't appended
        sb.append(last);
        sb.append(count);
        
        return sb.toString();
    }
    
    private int stringLength(String str){
        if(str == null || str.isEmpty()){
            return 0;
        }
        int size = 0;
        int count = 1;
        char last = str.charAt(0);
        
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) ==  last){
                count++;
            }
            else{
                last = str.charAt(i);
                size += 1 + String.valueOf(count).length();// isn't this the same as size += 2 I should test that out
                count = 1;
            }
            
        }
        //Grab the last stored values
        size += 1 + String.valueOf(count).length(); 
        return size;
    }
   
}
