import java.util.*;
class GetMaxMinUsingDQ
{
	Deque<Integer> dq = new LinkedList<Integer>();
	
	void insert(int x){
		if(dq.isEmpty())
			dq.add(x);
		else if(x > dq.getFirst() && x < dq.getLast())
			System.out.println("Insert failed");
		else if(x <= dq.getFirst())
			dq.addFirst(x);
		else
			dq.addLast(x);
	}

	void getMin(){
		if(dq.isEmpty())
			System.out.println("No data inserted");
		else
			System.out.println(dq.getFirst());
	}

	void getMax(){
		if(dq.isEmpty())
			System.out.println("No data inserted");
		else
			System.out.println(dq.getLast());
	}

	void extractMin(){
		if(dq.isEmpty())
			System.out.println("No data inserted");
		else
			System.out.println("Removed: "+dq.pollFirst());
	}

	void extractMax(){
		if(dq.isEmpty())
			System.out.println("No data inserted");
		else
			System.out.println("Removed:"+dq.pollLast());
	}

	public static void main(String[] args) {
		GetMaxMinUsingDQ obj = new GetMaxMinUsingDQ();
		Scanner sc = new Scanner(System.in);
		int ch = Integer.MAX_VALUE;
		while(ch != -1){
			ch = sc.nextInt();
			switch (ch) {
				case 1:
					int n = sc.nextInt();
					obj.insert(n);
					break;
				case 2:
					obj.extractMax();
					break;
				case 3:
					obj.extractMin();
					break;
				case 4:
					obj.getMin();
					break;
				case 5:
					obj.getMax();
					break;
				case 6:
					System.out.println(obj.dq);
			}
		}
	}
}