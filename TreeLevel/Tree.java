import java.io.*;
import java.util.*;

class Node
{
	public int item;
	public Node leftChild;
	public Node rightChild;
	public void displayNode()
	{
		System.out.print("[");
		System.out.print(item);
		System.out.print("]");
	}
}
class StackNode
{
	public Node item;
	public StackNode next;
	public StackNode(Node val)
	{
		item = val;
	}

}
class LinkedListStack
{
	private StackNode first;
	public LinkedListStack()
	{
		first = null;
	}
	public boolean isEmpty()
	{
		return (first==null);
	}
	public void insert(Node key)//inserts at beginning of list
	{
		StackNode newLLNode = new StackNode(key);
		newLLNode.next = first;
		first = newLLNode;
	}
	public Node delete()//deletes at beginning of list
	{
		StackNode temp = first;
		first = first.next;
		return temp.item;
	}
}
class Stack
{
	private LinkedListStack listObj;
	public Stack()
	{
		listObj = new LinkedListStack();
	}
	public void push(Node num)
	{
		listObj.insert(num);
	}
	public Node pop()
	{
		return listObj.delete();
	}
	public boolean isEmpty()
	{
		return listObj.isEmpty();
	}
}

class Tree
{
	public Node root;
	public Tree()
	{ root = null; }
	public Node returnRoot()
	{
		return root;
	}
	public void insert(int id)
	{
		Node newNode = new Node();
		newNode.item = id;
		if(root==null)
			root = newNode;
		else
		{
			Node current = root;
			Node parent;
			while(true)
			{
				parent = current;
				if(id < current.item)
				{
					current = current.leftChild;
					if(current == null)
					{
						parent.leftChild = newNode;
						return;
					}
				} 
				else
				{
					current = current.rightChild;
					if(current == null) 
					{
						parent.rightChild = newNode;
						return;
					}
				} 
			} 
		} 
	}


	public void bstArray(){
		Stack globalStack2 = new Stack();
		globalStack2.push(root);	
		int emptyLeaf = 64;
		boolean isRowEmpty = false;
		// System.out.println("****......................................................****");
		while(isRowEmpty==false)
		{

			Stack localStack2 = new Stack();
			isRowEmpty = true;
			while(globalStack2.isEmpty()==false)
			{
				Node temp = globalStack2.pop();
				if(temp != null)
				{
					System.out.print(temp.item + " ");
					localStack2.push(temp.leftChild);
					localStack2.push(temp.rightChild);
					if(temp.leftChild != null ||temp.rightChild != null)
						isRowEmpty = false;
				}
				else
				{
					localStack2.push(null);
					localStack2.push(null);
					System.out.print("NULL ");
				}
			}
			emptyLeaf /= 2;
			while(localStack2.isEmpty()==false)
				globalStack2.push( localStack2.pop() );
		}
	}
	
	public void displayTree()
	{
		Stack globalStack = new Stack();
		globalStack.push(root);	
		int emptyLeaf = 64;
		boolean isRowEmpty = false;
		// System.out.println("****......................................................****");
		while(isRowEmpty==false)
		{

			Stack localStack = new Stack();
			isRowEmpty = true;
			for(int j=0; j<emptyLeaf; j++)
				System.out.print(' ');
			while(globalStack.isEmpty()==false)
			{
				Node temp = globalStack.pop();
				if(temp != null)
				{
					System.out.print("-" + temp.item + "-");
					localStack.push(temp.leftChild);
					localStack.push(temp.rightChild);
					if(temp.leftChild != null ||temp.rightChild != null)
						isRowEmpty = false;
				}
				else
				{
					localStack.push(null);
					localStack.push(null);
					System.out.print("N ");
				}
				for(int j=0; j<emptyLeaf*2-2; j++)
					System.out.print(' ');
			}
			System.out.println();
			emptyLeaf /= 2;
			while(localStack.isEmpty()==false)
				globalStack.push( localStack.pop() );
		}
	// System.out.println("****......................................................****");
	}
	private static Scanner in = new Scanner(System.in);

	
	public static void main(String[] args) throws IOException
	{
		Tree bst = new Tree();
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
            System.out.println("\n");
            bst.displayTree();
            System.out.print("\n\n");

            System.out.println("Array Representation: ");
            bst.bstArray();
            System.out.print("\n\n");
        } while(choice != 3);
	} 
} 


	