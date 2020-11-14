import java.util.*;
class Demo{
	int x, z;
	String y;
	Demo(int a, String b, int c){
		x = a; y = b; z = c;
	}
}
class HeapUsingLambda{
	public static void main(String[] args) {
		PriorityQueue<Demo> arr = new PriorityQueue<Demo>((p1, p2) -> p1.x!=p2.x ? p1.x-p2.x : !p1.equals(p2) ? p2.y.compareTo(p1.y) : p2.z-p1.z);
		arr.add(new Demo(2,"PQR",1));
		arr.add(new Demo(1,"PQR",2));
		arr.add(new Demo(3,"PQS",3));
		arr.add(new Demo(1,"PQR",1));
		arr.add(new Demo(3,"PQS",1));
		arr.add(new Demo(0,"QQR",2));
		arr.add(new Demo(-1,"PQR",2));
		arr.add(new Demo(1,"PQS",1));
		arr.add(new Demo(1,"QQR",2));
		
		while(!arr.isEmpty()){
			Demo curr = arr.poll();
			System.out.println(curr.x+" "+curr.y+" "+curr.z);
		}
	}
}