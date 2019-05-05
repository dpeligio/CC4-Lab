
 
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
 
public class BinarySearchTreeImpl {
 
    private BstNode root;
    private static Scanner in = new Scanner(System.in);
    public boolean isEmpty() {
 
        return (this.root == null);
    }
 
    public void insert(Integer data) {
 
        System.out.print("[input: "+data+"]");
        if(root == null) {
            this.root = new BstNode(data);
            System.out.println(" -> inserted: "+data);
            return;
        }
 
        insertNode(this.root, data);
        System.out.print(" -> inserted: "+data);
        System.out.println();
    }
 
    private BstNode insertNode(BstNode root, Integer data) {
 
        BstNode tmpNode = null;
        System.out.print(" ->"+root.getData());
        if(root.getData() >= data) {
            System.out.print(" [L]");
            if(root.getLeft() == null) {
                root.setLeft(new BstNode(data));
                return root.getLeft();
            } else {
                tmpNode = root.getLeft();
            }
        } else {
            System.out.print(" [R]");
            if(root.getRight() == null) {
                root.setRight(new BstNode(data));
                return root.getRight();
            } else {
                tmpNode = root.getRight();
            }
        }
 
        return insertNode(tmpNode, data);
    }
 
    public void levelOrderTraversal() {
 
        Queue<BstNode> discovedNodeQueue = new LinkedList<>();
        if(this.root == null) {
            System.out.println("The tree is empty.");
            return;
        }
        discovedNodeQueue.add(this.root);
        while (!discovedNodeQueue.isEmpty()) {
 
            BstNode tmpNode = discovedNodeQueue.remove();
            if(tmpNode.getLeft() != null) {
                discovedNodeQueue.add(tmpNode.getLeft());
            }
            if(tmpNode.getRight() != null) {
                discovedNodeQueue.add(tmpNode.getRight());
            }
            else{
                System.out.print("null ");
            }
            System.out.print(tmpNode.getData()+" ");
        }
    }
 
    public static void main(String a[]) {
 
        BinarySearchTreeImpl bst = new BinarySearchTreeImpl();
        int count, insert, delete, choice;

        do {
            System.out.print(
                "[1] Insert" + 
                "\n[2] Delete" + 
                "\n[3] Exit" + 
                "\n >> "
            );
            choice = in.nextInt();
            switch(choice) {
                case 1:
                    System.out.print("Insert >> ");
                    insert = in.nextInt();
                    bst.insert(insert);
                    break;
                case 2:
                    System.out.print("Delete >> ");
                    delete = in.nextInt();
                    // bstDelete(delete);
                    break;
                case 3:
                    System.out.println("Exit...");
                    break;
                default:
                    System.out.println("Invalid Choice");
            }
            System.out.println("-------------------");
            bst.levelOrderTraversal();
            System.out.print("\n\n");
        } while(choice != 3);
        
        
    }
}