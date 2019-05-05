/*
 *  Java Program to Implement a Binary Search Tree using Linked Lists
 */
 
 import java.util.Scanner;
 
 /* Class LinkedListBST */
 public class LinkedListBST
 {
     public static void main(String[] args)
     {                 
         Scanner scan = new Scanner(System.in);
         /* Creating object of BST */
         BST bst = new BST(); 
         System.out.println("Linked List Binary Search Tree Test\n");          
         char ch = 'Y';
         /*  Accept input  */
         do    
         {
             System.out.print("\nInsert >> ");
             bst.insert( scan.nextInt() );                     
 
             /*  Display tree  */ 
             System.out.print("\nPost order : ");
             bst.postorder();
             System.out.print("\nPre order : "); 
             bst.preorder();
             System.out.print("\nIn order : ");
             bst.inorder();
 
             // System.out.print("\nDo you want to continue (Type y or n)\n >> ");
             // ch = scan.next().charAt(0);                        
         } while (ch == 'Y'|| ch == 'y');                    
     }
 }