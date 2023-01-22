//README
//Hasti Mohebali Zadeh
//2 October 2020

// we use this class in Graph class and also Digraph class for adjacency lists
//so this is used for TASK 1 _ 2 _3 and the higher grade task

//I got help from books implementation of bag

package task1;

import java.util.Iterator;

public class Bag<Item> implements Iterable<Item>
{
	private Node first; // first node in list
	private class Node
	{
		Item item;
		Node next;
	}
	public void add(Item item)
	{ // same as push() in Stack
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
	}

	//Returns an iterator that iterates over the items in this bag in arbitrary order.
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