package hackerRank;

import java.util.NoSuchElementException;

public class QueueImplementationArray {

	private int[] queue;
	private int front, back;
	
	//define int array with initial capacity.
	//value of front stays at 0
	//Adding new elements increases value of back.
	public QueueImplementationArray(int capacity) {
		queue = new int[capacity];
	}
	
	public void add(int i) {
		//check whether max capacity is reached
		if ( back == queue.length) {
			int[] newArray = new int[2 * queue.length];
			System.arraycopy(queue, 0, newArray, 0, queue.length);
			queue = newArray;
		}
		
		queue[back] = i;
		back++;
	}
	
	public int remove() {
		if (size() == 0 ) {
			throw new NoSuchElementException();
		}
		
		int i = queue[front];
		queue[front] = -1;
		front++;
		
		if (size() == 0) {
			front = 0;
			back = 0;
		}
		
		return i;
	}
	
	
	public int peek() {
		if (size() == 0) {
			throw new NoSuchElementException();
		}
		
		return queue[front];
	}
	
	
	public int size() {
		return back-front;
	}
	
	public void printQueue() {
		for (int i = front; i < back ; i++) {
			System.out.println(queue[i]);
		}
	}
	
}
