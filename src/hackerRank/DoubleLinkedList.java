package hackerRank;

public class DoubleLinkedList {
	
	private EmployeeNode head;
	private EmployeeNode tail;
	private int size;
	
	public static void main(String args[]) {
		
		DoubleLinkedList dll = new DoubleLinkedList();
		DoubleLinkedList.Employee janeJones = dll.new Employee("Jane","Jones",123);
		DoubleLinkedList.Employee johnDoe = dll.new Employee("John","Doe",456);
		DoubleLinkedList.Employee marySmith = dll.new Employee("Mary","Smith",789);
		DoubleLinkedList.Employee mikeWilson = dll.new Employee("Mike","Wilson",102);
		DoubleLinkedList.Employee billGates = dll.new Employee("Bill","Gates",987);
		DoubleLinkedList.Employee addBefore = dll.new Employee("Added","Before",999);
		
		dll.addToFront(janeJones);
		dll.addToFront(johnDoe);
		dll.addToFront(marySmith);
		dll.addToFront(mikeWilson);
		
		dll.printList();
		
		dll.addToEnd(billGates);
				
		dll.printList();
		
		dll.removeFromFront();
		
		dll.printList();
		
		dll.removeFromEnd();
		
		dll.printList();
		
		dll.addBefore(addBefore, johnDoe);
		
		dll.printList();
	}
	
	public void addToFront(Employee e) {
//		To add John in front of Jane,we should set John to point to Jane (line 2)
//		and since John is added to front, we should set head to John(line 3)
		EmployeeNode node = new EmployeeNode(e);
		node.setNext(head); //if list is not empty, than, head is pointing to Jane, and we need to
		//set the next field of the new node to point to Jane.
		if (head == null) {
			tail = node; //if we are adding an element to an empty list than 
		} else {
			head.setPrevious(node); //set the current head's previous field to the new node being added.
		}
		head = node; //assigning head to John
		size++;
	}
	
	public void addToEnd(Employee e) {
		EmployeeNode node = new EmployeeNode(e);
		if (tail == null) { // checks the condition if we are adding the first node.
			head = node;
		} else {
			tail.setNext(node); //point the tail of the current last element to the node being added at the end
			node.setPrevious(tail);//point the previous of the node being added to the current tail.
		}
		tail = node;
		size++;
	}
	
	public int getSize() {
		return size;
	}
	
	public EmployeeNode removeFromFront() {
		EmployeeNode removedNode = head;
		if (head.getNext() == null) {
			tail = null; //handles scenario if there is only one element.
		} else {
			head = removedNode.getNext();
			head.setPrevious(null);			
		}

		removedNode.setNext(null);
		size--;
		return removedNode;
	}
	
	public EmployeeNode removeFromEnd() {
		
		EmployeeNode removedNode = tail;
		if (tail.getPrev() == null) {
			head = null; //handles scenario if there is only one element.
		} else {
			tail.getPrev().setNext(null);
			tail = tail.getPrev();
		}
		size--;
		removedNode.setPrevious(null);
		return removedNode;
	}
	
	public boolean addBefore(Employee newEmployee, Employee existingEmployee) {
		//if list is empty
		if (head == null) {
			return false;
		}
		//iterate through the list to find the existing employee
		EmployeeNode current = head;
		while (current != null && !current.getEmployee().equals(existingEmployee)) {
			current = current.getNext();
		}
		
		//if employee does not exist, return false
		if (current == null) {
			return false;
		}
		
		EmployeeNode en = new EmployeeNode(newEmployee); //create employee node instance
		//sequencing is important
		en.setPrevious(current.getPrev()); //set's the previous of "en" to point to current's previous 
		en.setNext(current); //sets the next of "en" to point to current.
		current.setPrevious(en); //sets the previous of current to point to "en"
		
		if (head == current) { //if new node is to be added before head node then make "en" head node
			head = en;
		} else {
			en.getPrev().setNext(en); //set's "en" previous to point to "en"
		}
		size++;
		return true;
		
	}
	
	public void printList() {
		
		DoubleLinkedList.EmployeeNode current = head;
		System.out.print("Head =>");
		while (current != null) {
			System.out.print(current );
			System.out.print(" <=> " );
			current = current.getNext();
		}
		System.out.print("NULL");
		System.out.println("");
	}
	
	private class EmployeeNode {
		Employee employee;
		EmployeeNode next;
		EmployeeNode prev;
		
		private EmployeeNode(Employee e) {
			this.employee = e;
		}
		
		public void setEmployee(Employee e) {
			this.employee = e;
		}
		
		public void setNext(EmployeeNode en) {
			this.next = en;
		}
		
		public void setPrevious(EmployeeNode en) {
			this.prev = en;
		}
		
		public Employee getEmployee() {
			return this.employee;
		}
		
		public EmployeeNode getNext() {
			return this.next;
		}
		
		public EmployeeNode getPrev() {
			return this.prev;
		}
		
		public String toString() {
			return employee.toString();
		}
	}
	
	private class Employee {
		private String firstName;
		private String lastName;
		private int id;
		
		private Employee(String fname,String lname, int id) {
			this.firstName = fname;
			this.lastName = lname;
			this.id = id;
		}
		
		public void setFirstName(String fname) {
			this.firstName = fname;
		}
		
		public void setLastName(String lname) {
			this.lastName = lname;
		}
		
		public void setId(int id) {
			this.id = id;
		}
		
		public String getFirstName() {
			return this.firstName;
		}
		
		public String getLastName() {
			return this.lastName;
		}
		
		public int getId() {
			return this.id;
		}
		
		@Override
		public String toString() {
			return "Employee{" + 
					"firstName='" + firstName + '\'' + 
					", lastName='" + lastName + '\'' +
					",id=" + id + '}';
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			
			Employee e = (Employee) o;
			
			if(id != e.id) return false;
			if(!firstName.equals(e.firstName)) return false;
			return lastName.equals(e.lastName);
		}
		
		@Override
		public int hashCode() {
			int result = firstName.hashCode();
			result = 31 * result + lastName.hashCode();
			result = 31 * result + id;
			return result;
		}
	}

}
