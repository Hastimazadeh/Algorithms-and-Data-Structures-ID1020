//Hasti Mohebali Zadeh
// 4 - September - 2020 

//Making a new class for main so that we can call our methods and test our code
//testing by adding nodes to the left side of the queue and removing the first added one
//we can also test if there exist no node when we call remove it should give error

package task3;

public class Assignment3main {

	public static void main(String[] args) {
		Assignment3<Integer> listInt = new Assignment3<>(); //making a list of integers
		Assignment3<String> listString = new Assignment3<>(); //making a list of strings
		String s1 = "meow";
		String s2 = "kth";
		String s3 = "arbiter";
		String s4 = "mathilda";

		listInt.addd(8);
		listInt.addd(6);
		listInt.addd(9);
		listInt.addd(3);
		listInt.remove(); //should remove 8 and also print it out
		listInt.addd(4);
		listInt.remove(); //should remove 6 and also print it out
		System.out.println();
		System.out.println("now we make a string list");
		System.out.println();
		listString.addd(s1);
		listString.addd(s2);
		listString.addd(s3);
		listString.remove(); // should remove meow and also print it out
		listString.addd(s4); 

		//listInt.remove(); // this line alone without the upper part of the code should give error

	}

}
