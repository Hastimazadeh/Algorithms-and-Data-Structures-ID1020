//Hasti Mohebali Zadeh
// 4 - September - 2020 

//Making a new class for main so that we can call our methods and test our code
//testing by both adding removing nodes from left and right side of the queue
//we can also test if there exist no node when we call remove it should give error

package task4;


public class Assignment4main {

	public static void main(String[] args) {
		Assignment4<Integer> list = new Assignment4<Integer>(); //making a list of integers
		System.out.println("adding integers to the left side of the queue");
		System.out.println();
		list.add_lastadded(1);
		list.add_lastadded(2);
		list.add_lastadded(3);
		list.add_lastadded(4);
		System.out.println();
		System.out.println("removing integers from right side of the queue");
		System.out.println();
		list.remove_firstadded();
		System.out.println("adding integers to the right side of the queue");
		System.out.println();
		list.add_firstadded(5); 
		list.add_firstadded(6);
		System.out.println();
		System.out.println("removing integers from left side of the queue");
		System.out.println();
		list.remove_lastadded();

		//list.remove_firstadded(); // this line alone without the upper part of the code should give error
		//list.remove_lastadded(); // this line alone without the upper part of the code should give error
	}

}
