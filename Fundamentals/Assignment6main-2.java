//Hasti Mohebali Zadeh
// 5 - September - 2020 

//Making a new class for main so that we can call our methods and test our code
//testing with adding numbers that are not in order and the output should be in order
//and also testing to remove the first number in the list (which would be the smallest number)

package task6;


public class Assignment6main {

	public static void main(String[] args) {
		Assignment6<Integer> list = new Assignment6<Integer>();
		
		list.add_order(3);
		list.add_order(1);
		list.add_order(8);
		list.add_order(4);
		list.add_order(100);
		list.add_order(9);
		list.add_order(0);
		list.add_order(5);
		list.add_order(-1);
		list.add_order(5);
		list.remove();

	}

}
