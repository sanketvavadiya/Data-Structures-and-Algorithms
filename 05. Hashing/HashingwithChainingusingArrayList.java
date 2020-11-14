import java.util.*;
import java.io.*;

class HashingwithChainingusingArrayList
{
	public static void insert(ArrayList<ArrayList <Integer>> hashTable, int key, int htableSize)
	{
		int i = key%htableSize;
		int j=0;
		hashTable.get(i).add(j, key);
	}

	public  static void showHash(ArrayList<ArrayList <Integer>>hashTable, int htableSize)
	{
		System.out.println(hashTable);
	}

	public static void delete(ArrayList<ArrayList <Integer>>hashTable, int key, int htableSize)
	{
		int index = key%htableSize;
		int n = hashTable.get(index).size();
		int i;
		System.out.println("Size: " + n);
		for(i=0;i<n;i++){
			System.out.print(hashTable.get(index).get(i)+" ");
			if(hashTable.get(index).get(i) == key)
				break;
		}
		hashTable.get(index).remove(i);
	}

	public static void main (String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int ch=-11111;

		System.out.print("Hash table size: ");
		int htableSize = sc.nextInt();

		ArrayList <ArrayList <Integer>> hashTable = new ArrayList<ArrayList <Integer>>(htableSize);
		for (int i=0;i<htableSize;i++) {
			hashTable.add(new ArrayList<Integer>());
		}

		while(ch!=4){
			System.out.println("1. Insert\n2. Show \n3. Delete");
			System.out.print("Enter your choice: ");
			ch = sc.nextInt();

			if(ch == 1){
				System.out.print("Key: ");
				int key = sc.nextInt();
				insert(hashTable, key, htableSize);
			}

			else if(ch == 2){
				showHash(hashTable, htableSize);
			}

			else if(ch == 3){
				System.out.print("Key: ");
				int key = sc.nextInt();
				delete(hashTable, key, htableSize);
				System.out.println("Deleted");
			}

			else
				System.exit(0);
		}
	}
}