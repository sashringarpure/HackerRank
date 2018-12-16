package hackerRank;

public class LinkedList {
	
	private EmployeeNode head;
	private int size;
	
	public static void main(String args[]) {
		
		LinkedList ll = new LinkedList();
		LinkedList.Employee janeJones = ll.new Employee("Jane","Jones",123);
		LinkedList.Employee johnDoe = ll.new Employee("John","Doe",456);
		LinkedList.Employee marySmith = ll.new Employee("Mary","Smith",789);
		LinkedList.Employee mikeWilson = ll.new Employee("Mike","Wilson",102);
		
		ll.addToFront(janeJones);
		ll.addToFront(johnDoe);
		ll.addToFront(marySmith);
		ll.addToFront(mikeWilson);
		
		ll.printList();
		
		ll.removeFromFront();
		
		ll.printList();
		
	}
	
	public void addToFront(Employee e) {
//		To add John in front of Jane,we should set John to point to Jane (line 2)
//		and since John is added to front, we should set head to John(line 3)
		EmployeeNode node = new EmployeeNode(e);
		node.setNext(head); //should point to Jane
		head = node; //assigning head to John
		size++;
	}
	
	public int getSize() {
		return size;
	}
	
	public EmployeeNode removeFromFront() {
		
		EmployeeNode removedNode = head;
		head = removedNode.getNext();
		size--;
		removedNode.setNext(null);
		return removedNode;
	}
	
	public void printList() {
		LinkedList.EmployeeNode current = head;
		System.out.print("Head =>");
		while (current != null) {
			System.out.print(current );
			System.out.print(" => " );
			current = current.getNext();
		}
		System.out.print("NULL");
	}
	
	private class EmployeeNode {
		Employee employee;
		EmployeeNode next;
		
		private EmployeeNode(Employee e) {
			this.employee = e;
		}
		
		public void setEmployee(Employee e) {
			this.employee = e;
		}
		
		public void setNext(EmployeeNode en) {
			this.next = en;
		}
		
		public Employee getEmployee() {
			return this.employee;
		}
		
		public EmployeeNode getNext() {
			return this.next;
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
