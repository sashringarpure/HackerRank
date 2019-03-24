package hackerRank;

import java.util.NoSuchElementException;

public class CircularQueueImplementationArray {

	private int[] queue;
	private int front, back;
	
	//define int array with initial capacity.
	//value of front stays at 0
	//front is incremented while removing elements
	//back is incremented while adding elements	
	//Adding new elements increases value of back.
	//queue is not wrapped if front is < back	
	//queue is wrapped if front > back	
	public CircularQueueImplementationArray(int capacity) {
		queue = new int[capacity];
	}
	
	public void add(int i) {
		//	check whether max capacity is reached
		//	actual number of elements in an array (excluding nulls) minus the array length	
		if ( size() == queue.length - 1) {
			int numItems = size();
			int[] newArray = new int[2 * queue.length];
			//0 - Jane
			//1 - John
			//2 - back
			//3 - mike - front
			//4 - bill
			//in above example, back is before front because back
			//got wrapped as 0,1 and 2 became null due to element removal.			
			//need to re-arrange the circular array while resizing 
			//so that the mike and bill do not get over-written
			//because we increment back by one while adding elements			
			System.arraycopy(queue, front, newArray, 0, queue.length - front);
			System.arraycopy(queue, 0, newArray, queue.length - front, back);
			queue = newArray;
			front = 0;
			back = numItems;
		}
		
		queue[back] = i;
		//logic to determine whether back should be wrapped to first element to make it circular queue
		//or back should be incremented by 1
		if ( back < queue.length - 1)
			back++;
		else
			back = 0;
	}
	
	public int remove() {
		if (size() == 0 ) {
			throw new NoSuchElementException();
		}
		
		int i = queue[front];
		queue[front] = -1;
		front++;
		
		//if the queue is empty, initialize front and back to 0		
		if (size() == 0) {
			front = 0;
			back = 0;
		} else if ( front == queue.length)
			//in circular queue, wrap front back to 0 if it reaches the queue length			
			front = 0;
		
		return i;
	}
	
	
	public int peek() {
		if (size() == 0) {
			throw new NoSuchElementException();
		}
		
		return queue[front];
	}
	
	
	public int size() {
		if ( front <= back )
			//if the queue is not wrapped, back - front gives us the size of the queue			
			return back-front;
		else
			//by adding queue.length we adjust the negative number to get the actual number of elements			
			return back - front + queue.length;
		
	}
	
	public void printQueue() {
//		If Queue is not wrapped, then front will be less than back.
		if ( front <= back ) {
			for (int i = front; i < back ; i++) {
				System.out.println(queue[i]);
			}
		}
//		if Queue is wrapped, then front will be greater than back.
		else {
			for (int i = front ; i <= queue.length; i++ ) {
				System.out.println(queue[i]);
			}
			
			for (int i = 0 ; i <= back ; i++) {
				System.out.println(queue[i]);
			}
		}

	}

}
