// A complete working Java program to demonstrate all insertion methods 
// on linked list 
import java.util.Scanner;
public class LinkedList 
{ 
    Node root;  // root of list 
  
    /* Linked list Node*/
    class Node 
    { 
        int data; 
        Node next; 
        Node(int d) {data = d; next = null; } 
    } 
  
    /* Inserts a new Node at front of the list. */
    public void push(int new_data) 
    { 
        /* 1 & 2: Allocate the Node & 
                  Put in the data*/
        Node new_node = new Node(new_data); 
  
        /* 3. Make next of new Node as root */
        new_node.next = root; 
  
        /* 4. Move the root to point to new Node */
        root = new_node; 
    } 
  
    /* Inserts a new node after the given prev_node. */
    public void insertAfter(Node prev_node, int new_data) 
    { 
        /* 1. Check if the given Node is null */
        if (prev_node == null) 
        { 
            System.out.println("The given previous node cannot be null"); 
            return; 
        } 
  
        /* 2 & 3: Allocate the Node & 
                  Put in the data*/
        Node new_node = new Node(new_data); 
  
        /* 4. Make next of new Node as next of prev_node */
        new_node.next = prev_node.next; 
  
        /* 5. make next of prev_node as new_node */
        prev_node.next = new_node; 
    } 
     
    /* Appends a new node at the end.  This method is  
       defined inside LinkedList class shown above */
    public void append(int new_data) 
    { 
        /* 1. Allocate the Node & 
           2. Put in the data 
           3. Set next as null */
        Node new_node = new Node(new_data); 

        /* 4. If the Linked List is empty, then make the 
              new node as root */
        if (root == null) 
        { 
            root = new Node(new_data); 
            return; 
        } 
  
        /* 4. This new node is going to be the last node, so 
              make next of it as null */
        new_node.next = null; 
  
        /* 5. Else traverse till the last node */
        Node last = root;  
        while (last.next != null) 
            last = last.next; 
  
        /* 6. Change the next of last node */
        last.next = new_node; 
        return; 
    } 
  
    /* This function prints contents of linked list starting from 
        the given node */
    public void printList() 
    { 
        Node tnode = root; 
        while (tnode != null) 
        { 
            System.out.print(tnode.data+" "); 
            tnode = tnode.next; 
        } 
    }

    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) 
    { 
        /* Start with the empty list */
        LinkedList bst = new LinkedList(); 
  
        // Insert 6.  So linked list becomes 6->NUllist 
        // bst.append(6); 
  
        // Insert 7 at the beginning. So linked list becomes 
        // 7->6->NUllist 
        // bst.push(7); 
  
        // Insert 1 at the beginning. So linked list becomes 
        // 1->7->6->NUllist 
        // bst.push(1); 
  
        // Insert 4 at the end. So linked list becomes 
        // 1->7->6->4->NUllist 
        // bst.append(4); 
  
        // Insert 8, after 7. So linked list becomes 
        // 1->7->8->6->4->NUllist 
        // bst.insertAfter(bst.root.next, 10);
        
        // bst.append(18); 
        // bst.append(11); 
        // bst.append(30); 
        // bst.append();
        
        int choice = 1;

        while(choice != 3){
            System.out.print(
                "[1] Insert" +
                "\n[2] Delete" +
                "\n[3] Exit" +
                "\n >> "
            );
            // choice = in.nextInt();
            switch(choice) {
                case 1:
                    System.out.print("Insert >> ");
                    int insertNum = in.nextInt();
                    bst.append(insertNum);
                    break;
                default:
                    System.out.println("Invalid");
            }
            System.out.println("\nBST: ");
            bst.printList(); 
            System.out.println("\n\n");
        }
  

    } 
} 