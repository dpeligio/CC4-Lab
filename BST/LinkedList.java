import java.io.*; 
import java.util.Scanner;

// Java program to implement 
// a Singly Linked List 
public class LinkedList { 
  
    Node root; // root of list 
  
    // Linked list Node. 
    // This inner class is made static 
    // so that main() can access it 
    static class Node { 
  
        int data; 
        Node next; 
  
        // Constructor 
        Node(int d) 
        { 
            data = d; 
            next = null; 
        } 
    } 
  
    // **************INSERTION************** 
  
    // Method to insert a new node 
    public static LinkedList insert(LinkedList list, int data) 
    { 
        // Create a new node with given data 
        Node new_node = new Node(data); 
        new_node.next = null; 
  
        // If the Linked List is empty, 
        // then make the new node as root 
        if (list.root == null) { 
            list.root = new_node; 
        } 
        else { 
            // Else traverse till the last node 
            // and insert the new_node there 
            Node last = list.root; 
            while (last.next != null) { 
                last = last.next; 
            } 
  
            // Insert the new_node at last node 
            last.next = new_node; 
        } 
  
        // Return the list by root 
        return list; 
    } 
  
    // **************TRAVERSAL************** 
  
    // Method to print the LinkedList. 
    public static void printList(LinkedList list) 
    { 
        Node currNode = list.root; 
  
        System.out.print("\nLinkedList: "); 
  
        // Traverse through the LinkedList 
        while (currNode != null) { 
            // Print the data at current node 
            System.out.print(currNode.data + " "); 
  
            // Go to next node 
            currNode = currNode.next; 
        } 
        System.out.println("\n"); 
    } 
  
    // **************DELETION BY KEY************** 
  
    // Method to delete a node in the LinkedList by KEY 
    public static LinkedList deleteByKey(LinkedList list, int key) 
    { 
        // Store root node 
        Node currNode = list.root, prev = null; 
  
        // 
        // CASE 1: 
        // If root node itself holds the key to be deleted 
  
        if (currNode != null && currNode.data == key) { 
            list.root = currNode.next; // Changed root 
  
            // Display the message 
            System.out.println(key + " found and deleted"); 
  
            // Return the updated List 
            return list; 
        } 
  
        // 
        // CASE 2: 
        // If the key is somewhere other than at root 
        // 
  
        // Search for the key to be deleted, 
        // keep track of the previous node 
        // as it is needed to change currNode.next 
        while (currNode != null && currNode.data != key) { 
            // If currNode does not hold key 
            // continue to next node 
            prev = currNode; 
            currNode = currNode.next; 
        } 
  
        // If the key was present, it should be at currNode 
        // Therefore the currNode shall not be null 
        if (currNode != null) { 
            // Since the key is at currNode 
            // Unlink currNode from linked list 
            prev.next = currNode.next; 
  
            // Display the message 
            System.out.println(key + " found and deleted"); 
        } 
  
        // 
        // CASE 3: The key is not present 
        // 
  
        // If key was not present in linked list 
        // currNode should be null 
        if (currNode == null) { 
            // Display the message 
            System.out.println(key + " not found"); 
        } 
  
        // return the List 
        return list; 
    } 
  
    // **************DELETION AT A POSITION************** 
  
    // Method to delete a node in the LinkedList by POSITION 
    public static LinkedList deleteAtPosition(LinkedList list, int index) 
    { 
        // Store root node 
        Node currNode = list.root, prev = null; 
  
        // 
        // CASE 1: 
        // If index is 0, then root node itself is to be deleted 
  
        if (index == 0 && currNode != null) { 
            list.root = currNode.next; // Changed root 
  
            // Display the message 
            System.out.println(index + " position element deleted"); 
  
            // Return the updated List 
            return list; 
        } 
  
        // 
        // CASE 2: 
        // If the index is greater than 0 but less than the size of LinkedList 
        // 
        // The counter 
        int counter = 0; 
  
        // Count for the index to be deleted, 
        // keep track of the previous node 
        // as it is needed to change currNode.next 
        while (currNode != null) { 
  
            if (counter == index) { 
                // Since the currNode is the required position 
                // Unlink currNode from linked list 
                prev.next = currNode.next; 
  
                // Display the message 
                System.out.println(index + " position element deleted"); 
                break; 
            } 
            else { 
                // If current position is not the index 
                // continue to next node 
                prev = currNode; 
                currNode = currNode.next; 
                counter++; 
            } 
        } 
  
        // If the position element was found, it should be at currNode 
        // Therefore the currNode shall not be null 
        // 
        // CASE 3: The index is greater than the size of the LinkedList 
        // 
        // In this case, the currNode should be null 
        if (currNode == null) { 
            // Display the message 
            System.out.println(index + " position element not found"); 
        } 
  
        // return the List 
        return list; 
    }

    private static Scanner in = new Scanner(System.in);
  
    // **************MAIN METHOD************** 
  
    // method to create a Singly linked list with n nodes 
    public static void main(String[] args) 
    { 
        /* Start with the empty list. */
        LinkedList list = new LinkedList(); 
    
        int choice = 0;

        while(choice != 3){
            System.out.print(
                "[1] Insert" + 
                "\n[2] Delete" + 
                "\n[2] Exit" +
                "\n >> " 
            );
            choice = in.nextInt();


            int insertNum, deleteNum;

            switch(choice) {
                // Insert
                case 1:
                    System.out.print("Insert >> ");
                    insertNum = in.nextInt();
                    list = insert(list, insertNum);
                    list = insert(list, insertNum);
                    break;
                case 2:
                    System.out.print("Delete >> ");
                    deleteNum = in.nextInt();
                    deleteByKey(list, deleteNum);
                    break;
                case 3:
                    System.out.print("Exit...");
                    break;
                default:
                    System.out.println("Invalid Choice");
                    break;
            }
            printList(list);
            System.out.println("\n\n");
        }
        /*// 
        // ******INSERTION****** 
        // 
  
        // Insert the values 
        list = insert(list, 1); 
        list = insert(list, 2); 
        list = insert(list, 3); 
        list = insert(list, 4); 
        list = insert(list, 5); 
        list = insert(list, 6); 
        list = insert(list, 7); 
        list = insert(list, 8); 
  
        // Print the LinkedList 
        printList(list); 
  
        // 
        // ******DELETION BY KEY****** 
        // 
  
        // Delete node with value 1 
        // In this case the key is ***at root*** 
        deleteByKey(list, 1); 
  
        // Print the LinkedList 
        printList(list); 
  
        // Delete node with value 4 
        // In this case the key is present ***in the middle*** 
        deleteByKey(list, 4); 
  
        // Print the LinkedList 
        printList(list); 
  
        // Delete node with value 10 
        // In this case the key is ***not present*** 
        deleteByKey(list, 10); 
  
        // Print the LinkedList 
        printList(list); 
  
        // 
        // ******DELETION AT POSITION****** 
        // 
  
        // Delete node at position 0 
        // In this case the key is ***at root*** 
        deleteAtPosition(list, 0); 
  
        // Print the LinkedList 
        printList(list); 
  
        // Delete node at position 2 
        // In this case the key is present ***in the middle*** 
        deleteAtPosition(list, 2); 
  
        // Print the LinkedList 
        printList(list); 
  
        // Delete node at position 10 
        // In this case the key is ***not present*** 
        deleteAtPosition(list, 10); 
  
        // Print the LinkedList 
        printList(list); */
    } 
} 