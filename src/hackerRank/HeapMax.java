package hackerRank;

public class HeapMax {

	private int[] heap;
	private int size;
	
	public HeapMax(int capacity) {
		heap = new int[capacity];
	}
//	check the size of the heap
	public boolean isFull() {
		return size == heap.length;
	}
	
//	formula to return the parent of any element in a heap : current element index - 1 / 2 
//	we don't have to explicitly call floor
	public int getParent(int index) {
		return (index-1)/2;
	}
	
	public void insert(int value) {
		if (isFull()) {
			throw new IndexOutOfBoundsException("Heap is Full");
		}
//		Insert the value in the next available array index
		heap[size++] = value;
//		Heapify the array to ensure the element is greater than it's parent for a MaxHeap.
//		We pass the size/index position of the array to heapify.
		fixHeapAbove(size);
	}
	
	public int delete(int index) {
		
		if (isEmpty())
			throw new IndexOutOfBoundsException("Heap is Empty!!");
		
//		fetch the parent value
		int parent = getParent(index);
//		saved the value to be deleted.
		int deletedValue = heap[index];
//		replace the value to be deleted with the right most value from the heap.
//		this is the replacement step.
		heap[index] = heap[size-1];
//		index == 0 means root.
		if ( index == 0 || heap[index] < heap[parent] ) {
//			if the replacement value has gone to the the root then the heap below needs to be fixed.
//			or if the replacement value is less than it's parent.
			fixHeapBelow(index,size-1);
		} else {
			fixHeapAbove(index);
		}
		
		size--;
		return deletedValue;
	}
	
//	To ensure all elements above the current element is either min/max of their child 
//	for a min Heap or a Max Heap.
	private void fixHeapAbove(int index) {
		int newValue = heap[index];
//		Replace value with its parent if the current element is not the root
//		and it's parent is > than the current element value.
		while ( index > 0 && newValue > heap[getParent(index)]) {
//			We are shifting the parents down till the correct location is found for the new value.
//			Bubbling the new value up till the correct location is found.
			heap[index] = heap[getParent(index)];
			index = getParent(index);
		}
		heap[index] = newValue;
	}
	
//	Index is the index of the item that we deleted.
	private void fixHeapBelow(int index, int lastHeapIndex) {
		int childToSwap;
		
//		to navigate the heap below the current index value.
		while (index <= lastHeapIndex) {
//			Get the two children indices.
			int leftChild = getChild(index, true);
			int rightChild = getChild(index, false);
//			this means there is a heap at the left child.
//			the heap has to be a complete tree
//			hence the only possibility is 
//			heap has both the childs or only left child
			if ( leftChild <= lastHeapIndex) {
//				this means there is no heap at right child.
//				if this condition fails, it does not have a right child.
				if (rightChild > lastHeapIndex) {
					childToSwap = leftChild;
				} else {
//					if left child is > than right child, than, swap with left child.
//					swap with larger of the two childs. 
					childToSwap = (heap[leftChild] > heap[rightChild] ? leftChild : rightChild);
				}
				
				if ( heap[index] < heap[childToSwap] ) {
//					Swapping the replacement value with it's largest child.
					int tmp = heap[index];
					heap[index] = heap[childToSwap];
					heap[childToSwap] = tmp;
				} else {
//					Break out of the loop if the replacement value, i.e. heap[index} > heap[childToSwap]
					break;
				}
//				Re-assigning the indexes after swapping.
					index = childToSwap;
			}
			else {
//				Break if the element in that position does not have any children.
				break;
			}
		}
	}
	
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public int getChild(int index, boolean left) {
//		As per the formula, 1 returns left child and 2 returns right child.
		return 2 * index + (left ? 1 : 2) ;
	}

}
