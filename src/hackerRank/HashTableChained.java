package hackerRank;
import java.util.LinkedList;
import java.util.ListIterator;
import hackerRank.HashTableArrayImplementation;

public class HashTableChained {

	private LinkedList<StoredEmployee>[] hashTable;
	
	public HashTableChained() {
		hashTable = new LinkedList[10];
		for ( int i = 0 ; i < hashTable.length ; i++) {
			hashTable[i] = new LinkedList<StoredEmployee>();
		}
	}
	
	public static void main(String[] args ) {
		Employee janeJones = new Employee("Jane", "Jones", 1);
		Employee johnDoe = new Employee("John", "Doe", 2);
		Employee marySmith = new Employee("Mary","Smith",3);
		Employee mikeWilson = new Employee("Mike","Wilson",4);
		Employee billEnd = new Employee("Bill","End",5);
		
		HashTableChained cht = new HashTableChained();
		cht.put("Jones", janeJones);
		cht.put("Doe", johnDoe);
		cht.put("Wilson", mikeWilson);
		cht.put("Smith", marySmith);
		
//		System.out.println("Retrieve key Smith : " + cht.get("Smith"));
		
		cht.remove("Doe");
		cht.remove("Jones");
		
		cht.printHashTable();
		
		System.out.println("Retrieve key Smith : " + cht.get("Smith"));
	}
	
	private int hashKey(String key) {
		return key.length() % hashTable.length;
	}

	public void put(String key, Employee e) {
		int hashedKey = hashKey(key);
//		Array of linked list means each element within the array is a linked list.
		hashTable[hashedKey].add(new StoredEmployee(key, e));
	}
	
	public Employee get(String key) {
		int hashedKey = hashKey(key);
//		Array of linked list means each element within the array is a linked list.
		ListIterator<StoredEmployee> iterator = hashTable[hashedKey].listIterator();
		StoredEmployee e = null;
		while (iterator.hasNext()) {
			e = iterator.next();
			if ( e.key.equals(key)) {
				return e.emp;
			}
		}
		return null;
	}
	
	public Employee remove(String key) {
		int hashedKey = hashKey(key);
		ListIterator<StoredEmployee> iterator = hashTable[hashedKey].listIterator();
		StoredEmployee e = null;
		int index = -1;
		while (iterator.hasNext()) {
			e = iterator.next();
			index++;
			if ( e.key.equals(key)) {
				break;
			}
		}
		
		if ( e == null ) {
			return null;
		} else {
			hashTable[hashedKey].remove(index);
			return e.emp;
		}
	}
	
	public void printHashTable() {
		for (int i = 0 ; i < hashTable.length; i++) {
			if ( hashTable[i].isEmpty()) {
				System.out.println("Position i :" + i + " is empty.");
			} else {
				ListIterator<StoredEmployee> iterator = hashTable[i].listIterator();
				while (iterator.hasNext()) {
					System.out.print(iterator.next().emp);
					System.out.print("->");
				}
				System.out.println("null");
			}
		}
	}
}