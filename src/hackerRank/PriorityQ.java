package hackerRank;

import java.util.PriorityQueue;

public class PriorityQ {

	public PriorityQ() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		PriorityQueue pq = new PriorityQueue<Integer>();
		pq.add(25);
		pq.add(-22);
		pq.add(1343);
		pq.add(54);		
		pq.add(0);
		pq.add(-3492);
		pq.add(429);
		
		System.out.println(pq.peek());
		System.out.println(pq.remove());
		System.out.println(pq.peek());
		
		System.out.println(pq.poll()); //Poll and Remove are the same.
		System.out.println(pq.peek());
		
		System.out.println(pq.remove(54));
		System.out.println(pq.peek());
		
		pq.add(-1);
		System.out.println(pq.peek());
		
		Object[] ints = pq.toArray();
		for (Object num : ints) {
			System.out.println(num);
		}
	}

}
