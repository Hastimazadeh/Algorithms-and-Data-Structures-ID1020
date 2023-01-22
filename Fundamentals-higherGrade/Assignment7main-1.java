//Hasti Mohebali Zadeh
// 6 - September - 2020 

//in main we are calling the balance method to check if parentheses are balanced or not
//testing by giving several series of  parentheses
package taskExtra;

public class Assignment7main {

	public static void main(String[] args) {
		char[] list1 = { '(', '{' , ']'};
		char[] list2 = { '[',   ']'};
		char[] list3 = { '(', ')' , ']' , '['};
		char[] list4 = { '(', '[' , '}' , ']'};
		char[] list5 = { '(', '[' , ')' , ']' , '{'};
		

		System.out.println(list1);
		Assinment7.balance(list1); //not balanced
		System.out.println();
		System.out.println(list2);
		Assinment7.balance(list2); //balanced
		System.out.println();
		System.out.println(list3);
		Assinment7.balance(list3); //not balanced
		System.out.println();
		System.out.println(list4);
		Assinment7.balance(list4); //not balanced
		System.out.println();
		System.out.println(list5);
		Assinment7.balance(list5); //not balanced
	}

}

//time complexity for the worst case is O(n) 
//because in the worst case it is going to go through all the chars in the array and in the end it realizes its not balanced 
//like (  (  {  [  {  (  )
//time complexity of the best case is O(1)
//like if we have an array of parentheses that starts with a closing bracket it is gonna know right away with checking only one char that its not balanced

//for space complexity 
//I have an array of chars assuming that I have n chars in it so it would be n.2bytes
//and I have 4 int so that would be 4.4bytes
//so overall I have 2n+16 bytes
//so space complexity would be O(n)