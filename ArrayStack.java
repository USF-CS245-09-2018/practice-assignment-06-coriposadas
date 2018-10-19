import java.util.EmptyStackException;
/*
*@author Cori Posadas
*/

public class ArrayStack implements Stack {

	private Object [] arr;
	private int top;

	public ArrayStack() {
		top = -1;
		arr = new Object[10];
	}

	public void growArray(){
		Object [] newArr = new Object [arr.length * 2];
		for (int i = 0; i < arr.length; i++){
			newArr[i] = arr[i];
		}
		arr = newArr;
	}

	public void push(Object item) {
		if (top >= arr.length - 1){
			growArray();
		}
		top++;
		arr[top] = item;
	}

	public Object pop() {
		Object temp = arr[top];
		--top;
		return temp;
	}

	public Object peek() {
		return arr[top];
	}

	public boolean empty() {
		if (top == -1){
			return true;
		}
		return false;
	}
}