// count distinct element in binary matrix
package classFiles;
class TrieNode{
	TrieNode child[] = new TrieNode[2];
	boolean isEnd;
	void insert(boolean []row){
		TrieNode curr = this;
		for (int i=0; i<row.length; i++) {
			int index = row[i] ? 1 : 0;
			if(curr.child[index]==null)
				curr.child[index] = new TrieNode();
			curr = curr.child[index];
		}
		curr.isEnd = true;
	}
}
class DistinictRowInMatrix{
	public static void main(String[] args) {
		boolean [][]matrix = {	{true, false, false, true},
								{false, true, false},
								{false, true, false, false},
								{true, false, false}	};
		TrieNode root = new TrieNode();
		for(boolean [] i : matrix)
			root.insert(i);
		Solution obj = new Solution();
		obj.countDistinct(root);
		System.out.println(obj.count);
	}
}
class Solution{
	int count;
	void countDistinct(TrieNode root){
		if(root==null)
			return;
		if(root.isEnd)
			count++;
		for (int i=0; i<root.child.length; i++) {
			countDistinct(root.child[i]);
		}
	}
}
