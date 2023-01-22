//Hasti Mohebali Zadeh
//22 September 2020

//this code implements binary search tree

//input: a text file
//output: the word that appears most frequent and the number of appearances and the runtime

package task2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//using a proper Binary Tree with Nodes as the data structure. This method is faster for the input needed.
public class Task2_BST<Key extends Comparable<Key> , Value extends Comparable<Value>>{
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
		Queue<Key> queue = new Queue<Key>();
		keys(root, queue, lo, hi);//keys(Node x, Queue<Key> queue, Key lo, Key hi)
		return queue;//the queue with all the keys
	} 
	//To enqueue all the keys from the tree rooted at a given node that fall in a given range onto a queue,
	//A) we (recursively) enqueue all the keys from the left subtree (if any of them could fall in the range), 
	//B) then enqueue the node at the root (if it falls in the range), 
	//C) then (recursively) enqueue all the keys from the right subtree (if any of them could fall in the range).
	private void keys(Node x, Queue<Key> queue, Key lo, Key hi)
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
		File file = new File("C:\\Users\\hasti\\Desktop\\task1\\lab3test.txt");
		Scanner sc = new Scanner(file);
		Scanner in=new Scanner(System.in);
		int minlen = 1; // key-length cutoff each word has at least one letter
		//only check the first n hundred words
		int N;
		System.out.println("enter N in the order of hundred words:");
		N=in.nextInt();

		Task2_BST<String, Integer> st = new Task2_BST<String, Integer>();//making a new BST

		//starting to insert the word from text
		long startTimeInsert = System.nanoTime();
		while (sc.hasNext() && st.size()<N*100) { // Build symbol table and count frequencies.
			String word = sc.next(); // word is the next word that scanner takes
			if (word.length() < minlen)
				continue; // Ignore short keys.
			if (!st.contains(word))//if it doesn't have a value meaning its the first time its appearing
				st.put(word, 1);//we set the value to 1 
			else
				st.put(word, st.get(word) + 1);//but if its not the first time its appearing the get has the value for it then we increment it
		}
		//the insertion ends here and we starting to search 

		// Find a key with the highest frequency count.
		long startTimeSearch_endTimeInsert = System.nanoTime();
		String max = "";//set max to nothing
		st.put(max, 0);//public void put(Key key, Value value) gives it the value zero for now means that its not in the text yet

		//st.keys has all the unique words and st.get has all the keys values
		
		for (String word : st.keys())//you check every word in the table
			//if value of a word is more than the value of max then that one is max
			if (st.get(word) > st.get(max))//comparing the values cause it returns values and its the number of times its in the text
				max = word;
		//searching ends here
		long endTimeSearch = System.nanoTime();

		long elapsedTimeSearch = endTimeSearch - startTimeSearch_endTimeInsert;
		long elapsedTimeInsert = startTimeSearch_endTimeInsert -startTimeInsert ;

		double secondsSearch = (double) elapsedTimeSearch / 1000000000.0;
		double secondsInsert = (double) elapsedTimeInsert / 1000000000.0;

		System.out.println("Word: '" + max + "', Frequency: " + st.get(max));
		System.out.println("Time for searching: " + secondsSearch + " seconds.");
		System.out.println("Time for inserting: " + secondsInsert + " seconds.");
	}

}
