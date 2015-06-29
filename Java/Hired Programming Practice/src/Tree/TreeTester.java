/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree;

/**
 *
 * @author marcsantiago
 */
public class TreeTester {
    public static void main(String[] args){
        BinarySearchTree tree = new BinarySearchTree();
//        int [] t = {1, 2, 3, 4, 5, 6, 7,8, 9, 80};
//        
//        tree.arrayToTree(t);
//        tree.inorder();
//        System.out.println("");
        
        for (int i = 0; i < 21; i++) {
            tree.add(i);
        }
        
        System.out.println(tree.getDepth());
        System.out.println(tree.getMinimumDepthDifference());
        
        
    }
}