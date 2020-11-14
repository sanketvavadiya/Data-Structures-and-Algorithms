import java.util.*;
class Demo{
	int x, z;
	String y;
	Demo(int a, String b, int c){
		x = a; y = b; z = c;
	}
}
class SortUsingLambda{
	public static void main(String[] args) {
		ArrayList<Demo> arr = new ArrayList();
		arr.add(new Demo(2,"PQR",1));
		arr.add(new Demo(1,"PQR",2));
		arr.add(new Demo(3,"PQS",3));
		arr.add(new Demo(1,"PQR",1));
		arr.add(new Demo(3,"PQS",1));
		arr.add(new Demo(0,"QQR",2));
		arr.add(new Demo(-1,"PQR",2));
		arr.add(new Demo(1,"PQS",1));
		arr.add(new Demo(1,"QQR",2));
		
		Collections.sort(arr, (p1, p2) -> p1.x!=p2.x ? p1.x-p2.x : !p1.equals(p2) ? p2.y.compareTo(p1.y) : p2.z-p1.z);
		for(int i=0;i<arr.size();i++)
			System.out.println(arr.get(i).x+" "+arr.get(i).y+" "+arr.get(i).z);
	}
}