//Hasti Mohebali Zadeh
// 5 - September - 2020 

/* Implementing a generic iterable queue based on a double linked circular list
  This program adds nodes and removes the k-th node (assuming the most recently added element has index 1) by the methods that are called in main 
 as for output: It is going to print the whole data structure (the whole content of the list) every time something is changed*/
 //Input: Written from the test method (main) using each method
 
package task5;



interface Iterable<Type>{ //an interface that tells Assignment5 class what it needs
	String print();
	void addd(Type nim);
	Type remove_kth(int kth);
}
	
public class Assignment5<Type> implements Iterable<Type> {

	int j;
	Node<Type>current;
	Node<Type>head_lastadded;
	Node<Type>last_firstadded;
	
	public Assignment5() { //a constructor for the class to initialise the object of a class
		head_lastadded= null; //the most recently added node
		last_firstadded= null; //the first added node
		j=0; //for counting the number of items in the queue
	}
	
	private class Node<Type>{ //make an obj called node that has previous , next and item
		 Node<Type> next;
		 Node<Type> prev;
		 Type item;
	}
	
	//this method is exactly the same as the one in task 3
	public void addd(Type nim) {
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

	public Type remove_kth(int kth) { // a remove method that removes the kth node
		if ((kth>j) ||(kth<=0) ) //if k is more than the number of nodes or if its negative it throws exception
			throw new IllegalArgumentException("no such index");
		//
		current = head_lastadded; //setting current to the most recently added node
		int h=1; //assuming that h is the most recently added node which starts with 1
		while(h<kth) {//going through the queue until we reach kth
			h++;
			current=current.next;
		}
// when we find the kth node
		Type trash = current.item; //saving its item 
		(current.prev).next = current.next;//the kth's prve's next is the kth's next
		(current.next).prev= current.prev; //the kth's next's prev is the kth's prev
		if ( kth ==1) {
			head_lastadded= current.next; //because head was still there and in print current=head
		}
		j--; // we do this because we are removing one node
		System.out.println(print());
		System.out.println(trash);
		return trash;
	}
	//this part is exactly the same as the one is task 3
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
