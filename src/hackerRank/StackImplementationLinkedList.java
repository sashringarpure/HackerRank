package hackerRank;
import java.util.*;

public class StackImplementationLinkedList {

	public static void main(String[] args) {
		StackImplementationLinkedList sll = new StackImplementationLinkedList();
		StackImplementationLinkedList.Employee janeJones = sll.new Employee("Jane","Jones",123);
		StackImplementationLinkedList.Employee johnDoe = sll.new Employee("John","Doe",123);
		StackImplementationLinkedList.Employee marySmith = sll.new Employee("Mary","Smith",123);
		
		StackImplementationLinkedList.LinkedStack stack = sll.new LinkedStack();
		stack.push(janeJones);
		stack.push(johnDoe);
		stack.push(marySmith);
		
		stack.printStack();
		stack.peek();
		stack.printStack();
		stack.pop();
		stack.printStack();
	}

//	Create a private class of type Employee to create a stack of type Employee
//	Implementation borrowed from private class in LinkedList.java
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
	
//	Create a private class of type LinkedList to hold a stack instance.
	private class LinkedStack {
		private java.util.LinkedList stack;
		
//		constructor
		public LinkedStack() {
			stack = new java.util.LinkedList();
		}
		
//		Invoke push method to push an element into stack
		public void push(Employee e) {
			stack.push(e);
		}
		
//		Invoke pop method to remove an element from stack
		public StackImplementationLinkedList.Employee pop() {
			return (StackImplementationLinkedList.Employee) stack.pop();
		}
		
//		Invoke peek method to view the next LIFO element in stack.
		public StackImplementationLinkedList.Employee peek() {
			return (StackImplementationLinkedList.Employee) stack.peek();
		}
		
//		Check whether stack is empty.
		public boolean isEmpty() {
			return stack.isEmpty();
		}
		
//		Prints stack elements
		public void printStack() {
			ListIterator i = stack.listIterator();
			while (i.hasNext()) {
				System.out.println(i.next());
			}
		}
	}
	
}
