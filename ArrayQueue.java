import java.util.NoSuchElementException;
/*
*@author Cori Posadas
*/

public class ArrayQueue implements Queue {

	private Object [] arr;
	private int head;
	private int tail;
	private int size;

	public ArrayQueue(){
		arr = new Object [10];
		head = tail = 0;
		size = 0;
	}

	public void growArray(){
		Object [] newArr = new Object [arr.length * 2];
		int a = head;
		for (int i = 0; i <= size; i++){
			newArr[i] = arr[a];
			a = (a+1)%size;
		}
		head = 0;
		tail = size;
		arr = newArr;
	}

	public Object dequeue() {
		Object obj = arr[head];
		++head;
		head = head%arr.length;
		size--;
		return obj;
	}

	public void enqueue(Object item){
		if (size == arr.length){
			growArray();
		}
		arr[tail++] = item;
		size++;
		if (tail >= arr.length){
			tail = 0;
		}
	}

	public boolean empty() {
		if (size == 0){
			return true;
		}
		return false;
	}
}