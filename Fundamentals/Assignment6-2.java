//Hasti Mohebali Zadeh
// 5 - September - 2020 

//Implementing a generic iterable ordered queue based on a double linked circular list based on task3
//The elements are ordered at insertion so that all elements are stored in ascending order 
//starting from when you insert the first element and in all following insertions.
//the remove method removes the first (smallest integer) from the queue
//This program adds and removes nodes by the methods that are called in main 
//Input: Written from the test method (main) using each method
//The elements stored in the queue are integer values.
//as for output:It is going to print the whole data structure (the whole content of the list) every time something is changed.

package task6;


interface Iterable<Type>{//an interface that tells Assignment6 class what it needs
	
	String print();
	void add_order(Type nim);
	Type remove();
	}

public class Assignment6<Type> implements Iterable<Type>{
	
	int j;
	Node<Type>current;
	Node<Type>head_lastadded;
	Node<Type>last_firstadded;
	
	public Assignment6() { //a constructor for the class to initialise the object of a class
		head_lastadded= null; //the most recently added node
		last_firstadded= null; //the first added node
		j=0;	//for counting the number of items in the queue
	}
	
	private class Node<Type>{ //make an obj called node that has previous , next and item
		 Node<Type> next;
		 Node<Type> prev;
		 Type item;
	}
	
	public void add_order(Type nim){
		
		Node<Type> new_node = new Node<Type>(); //making a new node
		new_node.item= nim; //setting its item to the value we got 
		if(head_lastadded == null) //if the queue is empty
		{
			//there is gonna be one node that it is first and last and its previous and next node is itself
			head_lastadded = new_node; 
	        last_firstadded = head_lastadded;
	        head_lastadded.next = head_lastadded;
	        head_lastadded.prev = head_lastadded;
		}
		current = head_lastadded;
		int k = 0;
		while((j > k) && ((int) nim < (int) current.item)){
			k++;
			current = current.next;
		}
		//current right now is the first smaller node after new
		//when we find the place its supposed to be added we exit the while loop
		new_node.prev = current.prev;
		new_node.next = current;
		(current.prev).next = new_node;
		current.prev = new_node;
		if(k == 0) //the largest number which is supposed to be in head
			head_lastadded = new_node;
		if(j == k) //the smallest number which is supposed to be in the end
			last_firstadded = new_node;
		j++;
		System.out.println(print());
	}
	//this remove method is exactly the same as the one in task 3
	public Type remove() { // a removing method that removes the first node
		if(head_lastadded == null)	{ //if the queue is already empty
			throw new IllegalArgumentException("there is no node to remove");
		}
		Type trash = last_firstadded.item; //we keep the item of our first node (the one that we wanna remove)
		last_firstadded = last_firstadded.prev; //our first node becomes the node that was after that one (so its previous node)
		last_firstadded.next= head_lastadded; //and now we connect its next to our last node
		j--; // we do this because we removed one node
		System.out.println( print());
		System.out.println(trash); //printing out the item of the node we removed

		return trash;
		}
	//this part is exactly like the one in task 3
	public String print () {
		String output = "sorted list: ";
		 current = head_lastadded; //we put our current to our most recently added node
		 int k=0;
		 while(j > k) { //so we don't go out of bounce and it doesn't go in the circular queue forever
			 output = output + "[" + current.item + "]"; // for having brackets and also writing down the whole list
			 if(k+1 != j) // so there is no "," at the end
				 output = output + ",";
			 current = current.next; 
			 k++; // this is required because of the while condition and also we do current++
		 }
		 
		return output;	  //so that print has an output that its gonna print when its called by sysout
	 }

}
