package hackerRank;

import java.util.EmptyStackException;

public class StackImplementationArray {

	private StackImplementationArray.Employee[] stack;
	private int top;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackImplementationArray sia = new StackImplementationArray(10);
		sia.push(sia.new Employee("Jane", "Jones", 123));
		sia.push(sia.new Employee("Mary", "Smith", 456));
		sia.push(sia.new Employee("John", "Do", 789));
		sia.push(sia.new Employee("Mike", "Wilson", 987));
		sia.push(sia.new Employee("Bill", "Gates", 654));
		
		sia.printStack();
		
		System.out.println("Peek :" + sia.peek());
		sia.pop();
		
		sia.printStack();
		
	}
	
	public StackImplementationArray(int capacity) {
		stack = new StackImplementationArray.Employee[capacity];
	}
	
	public void push(Employee e) {
		if (top == stack.length) {
			//extend the size of the array before pushing new element
			//worst case O[N} operation
			Employee[] newStack = new Employee[2*stack.length];
			System.arraycopy(stack, 0, newStack, 0, stack.length);
			stack = newStack;
		}
		stack[top++] = e; //O[1] operation
	}
	
	public Employee pop() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		
		Employee e = stack[--top];
		stack[top] = null;
		return e;
	}
	
	public Employee peek() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		
		return stack[top-1];
	}
	
	public int size() {
		return top;
	}
	
	public boolean isEmpty() {
		return top == 0;
	}
	
	public void printStack() {
		for (Employee e : stack) {
			if (e != null) System.out.println(e);
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
