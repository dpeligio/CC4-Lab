import java.util.Scanner;
public class StackCustom {
	int size;
	int arr[];
	int top;
 
	StackCustom(int size) {
		this.size = size;
		this.arr = new int[size];
		this.top = -1;
	}

	private static Scanner in = new Scanner(System.in);
 
	public void push(int pushedElement) {
		if (!isFull()) {
			top++;
			arr[top] = pushedElement;
			System.out.print("STACK: [");
			for(int i = 0;i<arr.length;i++){
				if(i <= top){
					System.out.print(arr[i]);
					if(i < top){
						System.out.print(", ");
					}
				}
			}
			System.out.print("]\n");
			System.out.print("TOP: " + top + "\n\n");

		} else {
			System.out.println("Stack is full !");
		}
	}
 
	public int pop() {
		if (!isEmpty()) {
			int returnedTop = top;
			top--;
			
			System.out.print("STACK: [");
			for(int i = 0;i<arr.length;i++){
				if(i <= top){
					System.out.print(arr[i]);
					if(i < top){
						System.out.print(", ");
					}
				}
			}
			System.out.print("]\n");
			System.out.print("TOP: " + top + "\n\n");

			return arr[returnedTop];
 
		} else {
			System.out.println("Stack is empty !");
			return -1;
		}
	}
 
	public int peek() {
		return arr[top];
	}
 
	public boolean isEmpty() {
		return (top == -1);
	}
 
	public boolean isFull() {
		return (size - 1 == top);
	}

	public static void main(String[] args) {
		StackCustom stack = new StackCustom(4);
		int choice = 0;
		int num,count=0;

		while(choice!=3){
			System.out.print("Options:\n[1] PUSH\n[2] POP\n[3] EXIT\n >> ");
			choice = in.nextInt();
			if(choice == 1){
				if(count < 4){
					System.out.print("Push >> ");
					num = in.nextInt();
					stack.push(num);
					count++;
				} else {
					System.out.println("Sorry, The Stack is Full!");
				}
			}
			else if(choice == 2){
				if(count <= 0){
					System.out.println("Sorry, The Stack is Empty!");
				} else {
					stack.pop();
					count--;
				}
			} else {
				System.out.println("Exit...");
			}

			System.out.println("COUNT: " + count);
		}

	}
}