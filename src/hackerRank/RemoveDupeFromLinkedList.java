package hackerRank;
import java.util.LinkedList;
import java.util.List;

import hackerRank.HashTableArrayImplementation;
import java.util.HashMap;
import java.util.ListIterator;
import java.util.ArrayList;;

public class RemoveDupeFromLinkedList {

	public static void main(String[] args) {
		LinkedList<Employee> employee = new LinkedList();
		employee.add(new Employee("Jane","Jones",123));
		employee.add(new Employee("John","Doe",5678));
		employee.add(new Employee("Mike","Wilson",45));
		employee.add(new Employee("Mary","Smith",5555));
		employee.add(new Employee("John","Doe",5678));
		employee.add(new Employee("Bill","End",3948));
		employee.add(new Employee("Jane","Jones",123));
		
		for ( Employee e : employee) {
			System.out.println("before removing dupes : " + e);
		}
		
		
		HashMap<Integer, Employee> employeeTable = new HashMap();
		ListIterator<Employee> iterator = employee.listIterator();
		List<Employee> remove = new ArrayList<Employee>();
		
		while ( iterator.hasNext()) {
			Employee e = iterator.next();
			if ( employeeTable.containsKey(e.getId())) {
				remove.add(e);
//				employee.remove(e); concurrent modification exception.!!!!
				System.out.println("dupes : " + e);
			} else {
				employeeTable.put(e.getId(), e);
			}
		}
		
		for (Employee e : remove ) {
			employee.remove(e);
		}
		
		for ( Employee e : employee) {
			System.out.println("after removing dupes : " + e);
		}
		
		}
	
	

}
