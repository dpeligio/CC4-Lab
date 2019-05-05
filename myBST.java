/**
 * Edomo Code
 * kx9bys
 * Due date: 3/20/19 @ 11:15pm
 */
import java.util.ArrayList;
import java.util.Scanner;
public class myBST {
	public static ArrayList<Integer> bst = new ArrayList<Integer>();
	private static Scanner in = new Scanner(System.in);

	public static int bstRoot(){
		return bst.get(0);
	}

    public static void addLevel() {
        int bstSize = bst.size();
        int node = 0;
        if(bstSize == 1){
            node = 2;
        }
        else if(bstSize == 3){
            node = 4;
        }
        else if(bstSize == 7){
            node = 8;
        }
        else if(bstSize == 15){
            node = 16;
        }
        for (int i = 0;i<node ;i++ ) {
            bst.add(null);
        }

    }

	public static void bstInsert(int insert, int current){
        int bstSize = bst.size();
        if(bstSize <= 0){
            bst.add(insert);
        }
		int i,j;
        
        int root = bst.get(0);
        // current = bst.get(current);
		if(bstSize != 0){
            // addLevel();
            if(insert <= bst.get(current) &&){
                bst.add(current+1, insert);
            }
            else{
                bst.set(current+2, insert);
            }
		}

	}

	public static void bstDelete(int delete){
		
		int index = bst.indexOf(delete);
		bst.remove(index);
	}

	public static void main(String[] args) {

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
                    bstInsert(insert, 0);
                    break;
                case 2:
                    System.out.print("Delete >> ");
                    delete = in.nextInt();
                    bstDelete(delete);
                    break;
                case 3:
                    System.out.println("Exit...");
                    break;
                default:
                    System.out.println("Invalid Choice");
            }
    		System.out.println("Tree Size: " + bst.size());
    		System.out.print(bst);
    		System.out.print("\n\n");
        } while(choice != 3);



	}

}