//Hasti Mohebali Zadeh
//22 September 2020

//this code implements Ordered Array ST

//input: a text file
//output: the word that appears most frequent and the number of appearances and the runtime

package task2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Task2_OrderedArrayST <Key extends Comparable<Key>, Value> { // Search Tree with array
	//a pair of parallel arrays, one for the keys and one for the values. 
	public Key[] keys; 
	private Value[] values; 
	private int N;

	public Task2_OrderedArrayST(int capacity){ //Constructor
		this.keys = (Key[]) new Comparable[capacity];
		this.values = (Value[]) new Object[capacity];
		//N=0;
	}

	public int size()
	{ 
		return N; 
	}

	//States if the table is empty or not.
	//return is true if empty, false if not.
	public boolean isEmpty() {
		return size() == 0;
	}

	//If key is in the table, search() returns its index in the table, which is the same as
	//the number of keys in the table that are smaller than key.
	//If key is not in the table, search() also returns the number of keys in the table that are smaller than key.
	//returns the number of keys smaller than a given key. to be used later in put()

	public int search(Key key) //Binary Searches the array for the element key.
	{
		int low = 0;
		int high = N-1;
		while (low <= high)
		{
			int mid = low + (high - low) / 2;
			int cmp = key.compareTo(keys[mid]);
			if(cmp < 0) //if key is in the left side of the array
				high = mid - 1;
			else if (cmp > 0) //if key is in the right side of the array
				low = mid + 1;
			else return mid; //if key is the middle
		}
		//low=high	
		return low;//returns the number of keys in the table that are smaller than key
	}

	//For get(), search() tells us precisely where the key is to be found if it is in the table
	//(and, if it is not there, that it is not in the table). 
	//*returns either null or a value*
	public Value get(Key key){
		if(isEmpty()) //if the array is empty
			return null;
		int i = search(key); // returned key from search
		//to check if it is the same with the one asked for and returns the value located at that key.
		if( i < N && keys[i].compareTo(key) == 0) 
			return values[i];
		else 
			return null;//then that key is not in the table
	}

	//For put(), the search() tells us precisely where to update the value when the key is in the table, 
	//and precisely where to put the key when the key is not in the table.
	//because we know the number of keys smaller than a given key from search()
	//We move all larger keys over one position to make room (working from back to front) 
	//and insert the given key and value into the proper positions in their respective arrays.

	//Search for key. Update value if found; grow table if new.
	public void put(Key key, Value val) // Places a new element in the array
	{ 
		int i = search(key); // returned key from search
		//to check if it is the same with the one asked for and returns the value located at that key.
		if (i < N && keys[i].compareTo(key) == 0)
		{
			values[i] = val;//if that key is in the table then we set its value to new value
			return; 
		}
		//if the key not already in the table then we insert it in the right position
		//starts from the end to where we put the new element
		//everything (both keys and values) from end to the newly added element moves one forward
		for (int j = N; j > i; j--)
		{ 
			keys[j] = keys[j-1]; 
			values[j] = values[j-1]; 
		}
		//i is exactly where we should put our new key so WHEN ITS NOT IN THE TABLE:
		keys[i] = key; //we set its key the newly added key
		values[i] = val;//we set its value the newly added key's value
		N++;// we increment N because we added a new key
	}
	//checks if that key is there
	// checks if the key has a value
	public boolean contains(Key key) {
		return get(key) != null;
	}

	//Returns the smallest key in the table. 
	public Key min() {
		if (isEmpty()) {
			throw new NoSuchElementException("Empty symbol table");
		}
		return keys[0];
	}

	//Returns the largest key in the table. 
	public Key max() {
		if (isEmpty()) {
			throw new NoSuchElementException("Empty symbol table");
		}
		return keys[N - 1];
	}


	// Returns all the keys in the table in a queue
	public Iterable<Key> keys() {
		return keys(min(), max());
	}

	//Keys of the table from low to high in sorted order.
	//return is the total number of keys in the given set of keys.
	public Iterable<Key> keys(Key lo, Key hi) {
		Queue<Key> queue = new Queue<Key>();
		for (int i = search(lo); i < search(hi); i++) 
			queue.enqueue(keys[i]);

		if (contains(hi))
			queue.enqueue(keys[search(hi)]);
		return queue; //the queue with all the keys
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

		Task2_OrderedArrayST<String, Integer> st = new Task2_OrderedArrayST<String, Integer>(10000000);//making a new st 

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

