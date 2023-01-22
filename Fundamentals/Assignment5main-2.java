//Hasti Mohebali Zadeh
// 5 - September - 2020 

//Making a new class for main so that we can call our methods and test our code
//testing by adding nodes to the left side of the queue and removing the kth node 
//(assuming the most recently added element has index 1)
//also testing when such index doesn't exist it should throw excepting and give error
//also testing adding one node and removing that one

package task5;

public class Assignment5main {

	public static void main(String[] args) {
		Assignment5<Integer> list = new Assignment5<Integer>();//making a list of integers
		
		list.addd(9);
		list.addd(8);
		list.addd(7);
		list.addd(6);
		list.addd(5);
		list.addd(4);
		System.out.println("now we remove 4 (the last added index) ");
		list.remove_kth(1);
		System.out.println("now we remove 5 ");
		list.remove_kth(1);
		System.out.println("now we add 5 again");
		list.addd(5);
		System.out.println();
		System.out.println("removing the last index ");
		list.remove_kth(5);
		//list.remove_kth(5); //this should give error right here
		System.out.println();
		System.out.println("removing the 3rd index ");
		list.remove_kth(3);
		
		//list.remove_kth(25); //this should give error
		//list.remove_kth(0); //this should give error
		//list.remove_kth(-1); //this should give error 
		
		
		//we can even add only one index and then remove it
		//list.addd(9);
		//list.remove_kth(1);
		
	}

}
