package classFiles;
class TrieNode{
	TrieNode []child = new TrieNode[26];
	boolean isEnd;
	void insert(String word){
		TrieNode curr = this;
		for (char c : word.toCharArray()) {
			if(curr.child[c-'a']==null)
				curr.child[c-'a'] = new TrieNode();
			curr = curr.child[c-'a'];
		}
		curr.isEnd = true;
	}
	boolean search(String word){
		TrieNode curr = this;
		for(char c : word.toCharArray()){
			if(curr.child[c-'a']==null)
				return false;
			curr = curr.child[c-'a'];
		}
		return curr.isEnd;
	}
	TrieNode delete(String word, TrieNode root, int i){
		if(root == null)
			return null;
		if(i==word.length()){
			root.isEnd = false;
			if(isEmpty(root))
				root = null;
			return root;
		}
		int index = word.charAt(i)-'a';
		root.child[index] = delete(word, root.child[index], i+1);
		if(isEmpty(root) && root.isEnd==false)
			root = null;
		return root;
	}
	boolean isEmpty(TrieNode root){
		for (int i=0; i<root.child.length; i++) {
			if(root.child[i]!=null)
				return false;
		}
		return true;
	}
}
class TrieImplementation{
	public static void main(String[] args) {
		TrieNode root = new TrieNode();
		root.insert("geeks");
		root.insert("geek");
		root.insert("bat");
		root.insert("batting");
		System.out.println(root.search("gee"));
		System.out.println(root.search("geek"));
		System.out.println(root.search("bat"));
		System.out.println(root.search("batting"));
		root.delete("geek", root, 0);
		System.out.println(root.search("geek"));
	}
}