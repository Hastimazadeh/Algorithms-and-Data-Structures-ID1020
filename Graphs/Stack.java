//README
//Hasti Mohebali Zadeh
//2 October 2020

//we use this class in DFS class and BFS class and also Directed DFS
//so its used for task 1_2_3
//we remember a path from each vertex to the start
//LIFO

//I got help from books implementation of stack

package task1;//and task2

import java.util.Iterator;

//Simple stack implementation based on algorithms 4th edition.
public class Stack<Item> implements Iterable<Item>
{
	private Node first; // top of stack (most recently added node)
	private int N; // number of items

	// helper linked list class
	private class Node
	{ // nested class to define nodes
		Item item;
		Node next;
	}

	public boolean isEmpty() { 
		return first == null; 
	} // Or: N == 0.

	//public int size() { 
	//	return N;
	//}

	// Adds the item to this stack.
	public void push(Item item)
	{ // Add item to top of stack.
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
		N++;
	}

	public Item pop()
	{ // Remove item from top of stack.
		Item item = first.item;
		first = first.next;
		N--;
		return item;
	}

	// Returns an iterator to this stack that iterates through the items in LIFO order.

	public Iterator<Item> iterator()
	{ 
		return new ListIterator();
	}

	private class ListIterator implements Iterator<Item>
	{
		private Node current = first;

		public boolean hasNext()
		{ 
			return current != null; 
		}


		public Item next()
		{
			Item item = current.item;
			current = current.next;
			return item;
		}
	} 
	
}
