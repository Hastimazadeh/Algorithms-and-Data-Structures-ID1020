//Hasti Mohebali Zadeh
// 5 - September - 2020 

/* Implementing a generic iterable queue based on a double linked circular list 
This program adds and removes nodes to/from the front and back end of the queue by the methods that are called in main 
as for output : It is going to print the whole data structure (the whole content of the list) every time something is changed */
//Input: Written from the test method (main) using each method

package task4;

interface Iterable<Type>{ //an interface that tells Assignment4 class what it needs
	
	Type remove_firstadded();
	Type remove_lastadded();
	String print();
	void add_lastadded(Type nim);
	void add_firstadded(Type nim);
}

public class Assignment4<Type> implements Iterable<Type> {
	
	int j;
	Node<Type>current;
	Node<Type>head_lastadded;
	Node<Type>last_firstadded;
	
	public Assignment4() { //a constructor for the class to initialise the object of a class
		head_lastadded= null; //the most recently added node
		last_firstadded= null; //the first added node
		j=0;	//for counting the number of items in the queue
	}
	
	private class Node<Type>{ //make an obj called node that has previous , next and item
		 Node<Type> next;
		 Node<Type> prev;
		 Type item;
	}
	//this add method is the same as for assignment 3
	public void add_lastadded(Type nim) //an add method that gets in a value Type and add to the side of most recently added nodes
	{
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
		else //if it is not empty 
		{
			current= head_lastadded; //we set the most recently added node to current
			head_lastadded=new_node; //and now our new node is head (most recently added)
			head_lastadded.next=current; //the newest node's next is our previous most recently added
			head_lastadded.prev=last_firstadded; //the newest node's prev is our first added node
			current.prev=head_lastadded; //our old most recently added node's prev is our new node
			last_firstadded.next=head_lastadded; //our first added node's next is the new node which is our most recently added node
		}
		j++; //we do this because we added one node
		System.out.println(print());
	}
	
	public void add_firstadded(Type nim) //an add method that gets in a value Type and add to the side of first added nodes
	{
		Node<Type> new_node = new Node<Type>();
		new_node.item= nim;
		if(head_lastadded == null) //for empty its the same code as the upper adding method
		{
			head_lastadded = new_node;
	        last_firstadded = head_lastadded;
	        head_lastadded.next = head_lastadded;
	        head_lastadded.prev = head_lastadded;
		}
		else // if its not empty
			//this part of the code is kind of the opposite of the other add method
		{
			current= last_firstadded; //we set the first added node to current
			last_firstadded=new_node; //and now our new node is the first added node
			last_firstadded.prev=current; //the node that we just added's prev is our old first added node
			last_firstadded.next=head_lastadded; //the node that we just added's next is our last added node
			current.next=last_firstadded; //our old first added node's next is our new node
			head_lastadded.prev=last_firstadded; //our last added node's prev is the new node(the one we just added)
		}
		j++; //w edo this because we just added one node
		System.out.println(print());
	}
	//this method is the same as the one in task3
	public Type remove_firstadded() {// a removing method that removes our first added node
		if(head_lastadded == null)	{ //if the queue is already empty
			throw new IllegalArgumentException("there is no node to remove");
		}
		Type trash = last_firstadded.item; //we keep the item of our first added node (the one that we wanna remove)
		last_firstadded = last_firstadded.prev; //our first added node becomes the node that was added after that one (so its previous node)
		last_firstadded.next= head_lastadded; //and now we connect its next to our most recently added node
		j--; // we do this because we removed one node
		System.out.println( print());
		System.out.println(trash); //printing out the item of the node we removed

		return trash;
		}
	
	public Type remove_lastadded() {
		if(head_lastadded == null)	{ //if the queue is already empty
			throw new IllegalArgumentException("there is no node to remove");
		}
		Type trash = head_lastadded.item; //we keep the item of our most recently added node (the one that we wanna remove)
		head_lastadded = head_lastadded.next; //we set the most recently added node to the one after it
		head_lastadded.prev= last_firstadded; //and then we set its prev to our first added node
		j--; //we do this because we just removed one node
		System.out.println( print());
		System.out.println(trash);

		return trash;
		}
	//this part of the code is exactly the same as task3
	 public String print () {
		 String output = "list: ";
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
	
