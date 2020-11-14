import java.util.*;
class HashTable
{
	int hashSize;
	ArrayList <Integer> hashTable;

	HashTable(int hashSize)
	{
		this.hashSize=hashSize;
		hashTable=new ArrayList<Integer>(hashSize);
		for(int i=0;i<hashSize;i++)
			hashTable.add(i, -1);	//-1 as empty
	}

	int hash(int key)
	{
		return key%hashSize;
	}

	void insert(int key)
	{
		int index=hash(key);
		if(hashTable.contains(key))
			System.out.println("Value present");
		else{
			while(hashTable.get(index) != -1 && hashTable.get(index) != -2)
				index = (index+1)%hashSize;
			hashTable.set(index, key);
		}
	}

	int search(int key)
	{
		int index=hash(key);
		if(!hashTable.contains(key)){
			System.out.println("Value not present");
			return -1;
		}
		else{
			int j=index;
			while(hashTable.get(index)!=key)
				index = (index+1)%hashSize;
			return index;
		}
	}

	void delete(int key)
	{
		int index = search(key);
		hashTable.set(index, -2);
	}

	void show()
	{
		System.out.println(hashTable);
	}
}
class HashingOpenAddressing
{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);

		System.out.print("Hash size: ");
		int hashSize = sc.nextInt();

		HashTable ht=new HashTable(hashSize);		

		int ch=-111;
		do{
			System.out.println("1. Insert\n2. Show \n3. Delete\n4. Search");
			System.out.print("Enter your choice: ");
			ch = sc.nextInt();
			int key;
			switch(ch){
				case 1:
					key = sc.nextInt();
					ht.insert(key);
					break;

				case 2:
					ht.show();
					break;

				case 3:
					System.out.print("Key: ");
					key = sc.nextInt();
					ht.delete(key);
					break;

				case 4:
					System.out.print("Key: ");
					key = sc.nextInt();
					System.out.println(key + " key found at " + ht.search(key));
					break;

				case 5:
					System.exit(0);
					break;

				default:
					System.out.println("Invalid entry");
			}
		}while(ch!=0);
	}
}