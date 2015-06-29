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

/*Write a method to replace all spaces in a string with %20
You may assume that the string has sufficient space at the end
of the string to hold the additional characters, and that you given
the  "true" length of the string (note if implementing in Java, please
use a character array so that you can perform this operation in place)
*/
public class Q4 {
    
    public void replacer(char[] str, int stringLength){
        int spaceCount = 0;
        int newLength;
        for(int i=0; i<stringLength; i++){
            if(str[i] == ' '){
                spaceCount++;
            }
        }
        
        newLength = stringLength + spaceCount * 2;
        str[newLength] = '\0';
        for(int j= stringLength - 1; j >= 0; j--){
            if(str[j] == ' '){
                str[newLength - 1] = '0'; 
                str[newLength - 2] = '2'; 
                str[newLength - 3] = '%';
                newLength = newLength - 3;
            }
            else{
                str[newLength - 1] = str[j];
                newLength = newLength -1;
            }
        }     
    }
}
