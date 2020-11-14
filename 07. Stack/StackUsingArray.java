import java.io.*;

class StackUsingArray
{
	static int stack[];
	static int size, top = 0;

	static void push(int data){
		if(top<size)
			stack[top++] = data;
		else
			System.out.println("Stack overflow");
	}

	static void pop(){
		if(top>0)
			System.out.println("Deleted: "+stack[--top]);
		else
			System.out.println("Stack underflow");
		printTop();
	}

	static void printStack(){
		for (int i=0; i<top; i++) {
			System.out.print(stack[i]+" ");
		}
		System.out.println();
	}

	static void printTop(){
		System.out.println("top: "+top);
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// size = Integer.parseInt(br.readLine());
		size = 5;
		stack = new int[size];
		pop();
		push(3);
		pop();
		push(1);
		push(4);
		printStack();
		push(2);
		printStack();
		push(5);
		push(8);
		printStack();
	}
}