import java.util.*;
class ChainingHashing{
	static void insert(int [][]htable, int key, int htableSize)
	{
		int i=key%htableSize;
		int j;
		for(j=0;j<5;j++)
			if(htable[i][j] == -1)
				break;
		
		if(j<5)
			htable[i][j] = key;
		else
			System.out.println("Can't insert");
	}

	static void showHash(int [][]htable, int htableSize)
	{
		for(int i=0;i<htableSize;i++){
			int j;
			for(j=0;j<5 && htable[i][j] != -1;j++){
				System.out.print(htable[i][j] + "->");
			}
			if(j!=0)
				System.out.println();
		}
	}

	static void delete(int [][] htable, int key, int htableSize)
	{
		boolean flag = false;
		int i, j=-1;
		for(i=0;i<htableSize;i++){
			for(j=0;j<5 && htable[i][j] != -1;j++){
				if(htable[i][j] == key)
				{
					flag = true;
					break;
				}
			}
			if(flag)
				break;
		}

		htable[i][j] = -2; //set as deleted
		while(j!=4){
			htable[i][j]=htable[i][j+1];
			j++;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int ch=-11111;

		System.out.print("Hash table size: ");
		int htableSize = sc.nextInt();
		int [][] htable = new int[htableSize][5];

		for(int i=0;i<htableSize;i++)
			for(int j=0;j<5;j++)
				htable[i][j] = -1;

		while(ch!=4){
			System.out.println("1. Insert\n2. Show \n3. Delete");
			System.out.print("Enter your choice: ");
			ch = sc.nextInt();

			if(ch == 1){
				System.out.print("Key: ");
				int key = sc.nextInt();
				insert(htable, key, htableSize);
			}
			else if(ch == 2){
				showHash(htable, htableSize);
			}
			else if(ch == 3){
				System.out.print("Key: ");
				int key = sc.nextInt();
				delete(htable, key, htableSize);
				System.out.println("Deleted");
			}
			else
				System.exit(0);
		}
	}
}