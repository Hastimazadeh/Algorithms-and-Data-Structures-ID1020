//Hasti Mohebali Zadeh
//23 September 2020

//a program that shows how evenly the built-in hash function for strings in Java distributes the hashes for the words found in the text.
//that takes a file as input

package Task3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Task3<Key, Value> {

	private int n;       // number of key-value pairs //number of total words
	private int m;       // hash table size //size of the array of nodes 
	private Node[] st;   // array of linked-list symbol tables //the array of nodes

	// a helper linked list data type
	private static class Node {
		private Object key;
		private Object val;
		private Node next;

		//each node has key , value and next
		public Node(Object key, Object val, Node next)  {
			this.key  = key;
			this.val  = val;
			this.next = next;
		}
	}

	//create separate chaining hash table with m lists
	public Task3(int m) {

		this.m = m;         //size of this hash table
		st = new Node[m]; //creating an array of nodes with size m
	}

	//m
	//create separate chaining hash table
	public Task3() {
		this(997);
	}

	//hash value between 0 and m-1
	private int hash(Key key) {
		return (key.hashCode() & 0x7fffffff) % m;   // masks off sign bit and returns remainder when dividing by hash table size (m)
	}

	//return number of key-value pairs in symbol table
	public int size() { //total number of words 
		return n;
	}

	//return value associated with key, null if no such key
	public Value get(Key key) {

		int i = hash(key); //the associated number we got from hash()

		for (Node x = st[i]; x != null; x = x.next) {//we use the node x to iterate through the linked list where position i is

			if (key.equals(x.key)) //if they match (x. key and the key we wanna get)

				return (Value) x.val;//then we found it and we get the value of it
		}
		return null;
	}

	//insert key-value pair into the table
	public void put(Key key, Value val) {

		int i = hash(key);//the associated number we got from hash() its also the position that the new key is going to be at in the array
		for (Node x = st[i]; x != null; x = x.next) {//we use the node x to iterate through the linked list where position i is

			if (key.equals(x.key)) {//if they match (x. key and the key we wanna get) if there is already a key
				x.val = val;// we set x.value to the new value we are putting (updating its value)
				return;
			}
		}
		//but if there isn't already a key we put the new key at where it supposed to be
		st[i] = new Node(key, val, st[i]); //public Node(Object key, Object val, Node next)
		n++;//one more key
	}

	// return all keys as an Iterable inside a queue
	public Iterable<Key> keys()  {

		Queue<Key> queue = new Queue<Key>(); // we make  anew queue for all the keys

		for (int i = 0; i < m; i++) {// for each position i (each node) in the array we go through all the nodes 
			for (Node x = st[i]; x != null; x = x.next) {

				queue.enqueue((Key) x.key);// and we put all of them in the new queue
			}
		}
		return queue;//Returning that queue with all the keys
	}

	public void printh () {

		for (int i = 0; i < st.length ; i++) { //for each position in the array of node it counts how many nodes are there
			int size = 0;
			Node linkedlist = st[i];//for each position i

			while( linkedlist != null){
				linkedlist = linkedlist.next;
				size++;//gives us the number of nodes in each position
			}
			System.out.println(size); //printing out the number of nodes in each position i
		}
	}

	public static void main(String[] args) throws FileNotFoundException {

		File file = new File("C:\\Users\\hasti\\Desktop\\task1\\lab3test.txt");
		Scanner sc = new Scanner(file);

		long startTime = System.nanoTime();

		//we create a hash table here actually 
		Task3<String, Integer> st = new Task3<String, Integer>(97); //m the size of the hash table

		for (int i = 0; sc.hasNext(); i++) {//putting the words from the text inside the hash table
			String key = sc.next();// key is the next word that scanner takes
			st.put(key, i);//we put the key at position i in hash table
		}

		st.printh();//gives us the number of nodes in each position

		long endTime = System.nanoTime();
		long elapsedTime = endTime - startTime;
		double seconds = (double) elapsedTime / 1000000000.0;
		System.out.println("Distributes the hashcodes time: " + seconds);

	}
}
