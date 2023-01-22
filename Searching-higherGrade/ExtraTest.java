//Hasti Mohebali Zadeh
//26 September 2020

// this code implements BST to show  Which is the k:th most common word or Which are the k:th to the k+n:th most common words
//the input is a text file

package Extra2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
//the first par of this code is from Task2 BST


//using a proper Binary Tree with Nodes as the data structure. This method is faster for the input needed.
public class ExtraTest<Key extends Comparable<Key> , Value extends Comparable<Value>>{
	public Node root;
	//There is need for a subclass of type Node 
	//Each node contains a key, a value, a left link, a right link, and a node count(N)
	private class Node { 
		private Key key; //key
		private Value value; //associated value
		private Node left; // links to subtrees
		private Node right;// links to subtrees
		private int N; //number of nodes in subtree rooted here (including itself)
		//The instance variable N gives the node count in the subtree rooted at the node. 
		//N it is the height until that specific point.

		public Node (Key key, Value value, int N){
			this.key = key;
			this.value = value;
			this.N = N;
			left = null;
			right = null;
		}
	}
	//it takes a node as argument starting from root
	public int size(){
		return size(root);
	}

	private int size(Node x){
		if(x == null)
			return 0;
		else return x.N;//written later ,size(x) = size(x.left) + size(x.right) + 1 holds for every node x in the tree.
	}

	//from now on each client method calls a corresponding private method that takes an additional link (to a Node x) as argument
	//and returns null or a Node containing the desired Key via the recursive procedure described in the text depending on the situation.

	//"get" takes a node (root of a subtree = x) as first argument and a key as second argument, 
	//starting with the root of the tree and the search key
	//* it returns either null or a value (so we get how many times a word is appearing here which is the value)*

	public Value get(Key key){ //the key that we are looking for
		return get(root, key);//the root changes through out the tree
	}
	//A) if the tree is empty, we have a search miss 
	//B) if the search key is equal to the key at the root(x), we have a search hit.
	//C) Otherwise, we search (recursively) in the appropriate subtree, moving left if the search key is smaller, right if it is larger. 
	private Value get(Node x, Key key){
		if(x == null)//A
			return null;
		int cmp = key.compareTo(x.key);
		if(cmp < 0)//C)
			return get(x.left, key);//we do this (with calling get again) until the search key is equal to the key at the root(x) which is condition B and then return the value
		else if(cmp > 0)//C)
			return get(x.right, key);//we do this (with calling get again) until the search key is equal to the key at the root(x) which is condition B and then return the value
		else //B) key = x.key
			return x.value;    
	}
	// Search for key. Update value if found; grow table if new.

	//it takes the key that we wanna insert and its containing value * returns a node *
	public void put(Key key, Value value){
		//It takes a node (root of a subtree = x)as first argument and a key as second argument and also its containing value
		//starting with the root of the tree and the search key 
		root = put(root, key, value);//searching //the root changes through out the tree
	}
	//A) if the tree is empty, we return a new node containing the key and value; 
	//B) if the search key is less than the key at the root, we set the left link to the result
	//of inserting the key into the left subtree;
	//C) otherwise, we set the right link to the result of inserting the key into the right subtree.
	//D) if the search key is equal to the key at the root, we have a search hit and we set its value to the value of the inserting key 
	private Node put(Node x, Key key, Value val){ 
		if(x == null)//A
			return new Node(key, val, 1); //Node(Key,Value,N) N is 1 because it was empty so the height is 1
		int cmp = key.compareTo(x.key);
		if(cmp < 0)//B
			x.left = put(x.left, key, val);//we do this (with calling put again) until the search key is equal to the key at the root(x) which is condition D and we set its value to the value of the inserting key
		else if(cmp > 0)//C
			x.right = put(x.right, key,val);//we do this (with calling put again) until the search key is equal to the key at the root(x) which is condition D and we set its value to the value of the inserting key
		else //D
			x.value = val;

		//we need to update its node count
		x.N = size(x.left) + size(x.right) + 1;
		return x;
	} 
	//checks if that key is there
	// checks if the key has a value
	public boolean contains(Key key) {
		return get(key) != null;
	}

	//Returns the smallest key in the tree. *returns a node*
	public Key min()
	{
		return min(root).key;
	}
	//A) If the left link of the root is null, the smallest key in a BST is the key at the root; 
	//B) if the left link is not null, the smallest key in the BST is the smallest key in the subtree rooted at the node referenced by the left link. with calling min again
	private Node min(Node x)
	{
		if (x.left == null) //A
			return x;
		return min(x.left);//B
	}
	//Returns the largest key in the tree. *returns a node*
	public Key max()
	{
		return max(root).key;
	}
	//A) If the right link of the root is null, the biggest key in a BST is the key at the root; 
	//B) if the right link is not null, the biggest key in the BST is the biggest key in the subtree rooted at the node referenced by the right link.with calling max again
	private Node max(Node x)
	{
		if (x.right == null) 
			return x;//A
		return max(x.right);//B
	}

	//To implement the two-argument keys() method that returns to a client all the keys in a specified range, 
	//we modify this code to add each key that is in the range to a Queue,
	//and to skip the recursive calls for subtrees that can't contain keys in the range. 
	public Iterable<Key> keys() {
		return keys(min(), max());
	}

	public Iterable<Key> keys(Key lo, Key hi) {
		Queue_Extra<Key> queue = new Queue_Extra<Key>();
		keys(root, queue, lo, hi);//keys(Node x, Queue<Key> queue, Key lo, Key hi)
		return queue;//the queue with all the keys
	} 
	//To enqueue all the keys from the tree rooted at a given node that fall in a given range onto a queue,
	//A) we (recursively) enqueue all the keys from the left subtree (if any of them could fall in the range), 
	//B) then enqueue the node at the root (if it falls in the range), 
	//C) then (recursively) enqueue all the keys from the right subtree (if any of them could fall in the range).
	private void keys(Node x, Queue_Extra<Key> queue, Key lo, Key hi)
	{
		if (x == null)
			return;
		int cmplo = lo.compareTo(x.key);
		int cmphi = hi.compareTo(x.key);
		if (cmplo < 0) //A //left subtree
			keys(x.left, queue, lo, hi);
		if (cmplo <= 0 && cmphi >= 0) //B //root 
			queue.enqueue(x.key);
		if (cmphi > 0) //C //right subtree
			keys(x.right, queue, lo, hi);
	}

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("C:\\Users\\hasti\\Desktop\\task1\\leipzig1m.txt");
		Scanner sc = new Scanner(file);
		Scanner in=new Scanner(System.in);
		int minlen = 1; // key-length cutoff each word has at least one letter
		int uniqueWords = 0;

		ExtraTest<String, Integer> st = new ExtraTest<String, Integer>();//making a new BST



		while (sc.hasNext()) { // Build symbol table and count frequencies.
			String word = sc.next(); // word is the next word that scanner takes
			if (word.length() < minlen)
				continue; // Ignore short keys.
			if (!st.contains(word)) {//if it doesn't have a value meaning its the first time its appearing
				st.put(word, 1);//we set the value to 1 
				uniqueWords++;//counting all the unique words in text
			}
			else
				//st.get has all the values :))
				st.put(word, st.get(word) + 1);//but if its not the first time its appearing the get has the value for it then we increment it
		}


		//creates a string array with all the size of unique word with all the words
		String[] intervalArray = new String[uniqueWords];
		int k = 0;
		for(String word : st.keys()) {//st.keys has all the unique words
			intervalArray[k] = word;
			k++;
		}
		//sorts them in ascending order
		Extra_Quick.sort(intervalArray, st);// we need to call st in partition is quick to sort the intervalArray

		while(true) {           
			System.out.println();
			System.out.println("Press 1 for interval, press 2 for a single rank: ");
			int n =in.nextInt();

			if(n==1){
				System.out.println();
				System.out.println("Set the interval of the most frequent words between a and b");
				System.out.println("k:th word:");
				int a = in.nextInt();
				System.out.println("k+n:th word:");
				int b = in.nextInt();

				//prints out the given interval
				a = (intervalArray.length) - a; 
				b = (intervalArray.length) - b;
				System.out.println();                
				while (a >= b) {                    
					System.out.println('\n');
					System.out.print("'"+intervalArray[a]+"'");
					System.out.print(" with the frequency of:  " + st.get(intervalArray[a]));
					a--;
				}        
			}

			else
			{
				System.out.println();
				System.out.println("Set the rank you want: ");
				int c = in.nextInt();
				c = (intervalArray.length) - c;
				System.out.println('\n');
				System.out.print("'"+intervalArray[c]+"'");
				System.out.print(" with the frequency of:  " + st.get(intervalArray[c]));
			}
		}
	}
}