package hackerRank;

public class HashTableArrayImplementation {

	private StoredEmployee[]	hashTable;
	
	public HashTableArrayImplementation() {
		hashTable = new StoredEmployee[10];
	}
	
	private int hashKey(String key) {
		return key.length() % hashTable.length;
	}
	
	private boolean Occupied(int index) {
//		returns false if element at index is null.
		return  hashTable[index] != null;
	}
	
	public void put(String key, Employee emp) {
//		generates the hashKey.
		int hashKey = hashKey(key);
//		Linear probing if the slot is occupied.
		if ( Occupied(hashKey) ) {
//			to wrap linear probing to search for empty spaces at the start of the array.
			int stopIndex = hashKey;
			//wrapping
			if ( hashKey == hashTable.length - 1) 
				hashKey =  0;
			else
				hashKey++;
			while ( Occupied(hashKey) && hashKey != stopIndex) {
				//Sets the next probe position and take care of wrapping.
				hashKey = ( hashKey + 1 ) % hashTable.length;
			}
		}
		
//	Added the same check to re-assert that the array is full and linear probing did not find any empty space.
		if ( Occupied(hashKey) ) {
			System.out.println("Sorry, this position is already occupied." + hashKey);
		} else {
			hashTable[hashKey] = new StoredEmployee(key, emp);
		}
	}
	
	public Employee get(String key) {
		int hashKey = FindKey(key);
		if ( hashKey == -1 )
			return null;
		return hashTable[hashKey].emp;
	}
	
	private int FindKey(String key) {
		int hashedKey = hashKey(key);
		if (hashTable[hashedKey] != null  && hashTable[hashedKey].key.equals(key)) {
			return hashedKey;
		}
		
//			to wrap linear probing to search for empty spaces at the start of the array.
			int stopIndex = hashedKey;
			//wrapping
			if ( hashedKey == hashTable.length - 1) 
				hashedKey =  0;
			else
				hashedKey++;
			while ( hashedKey != stopIndex && hashTable[hashedKey] != null &&
					!hashTable[hashedKey].key.equals(key)) {
				//Sets the next probe position and take care of wrapping.
				hashedKey = ( hashedKey + 1 ) % hashTable.length;
			}
			
//			Return hashkey after verifying it matches with the requested key else return -1.
			if ( hashTable[hashedKey] != null && hashTable[hashedKey].key.equals(key)) {
				return hashedKey;
			}  else {
				return -1;
			}
		
	}
	
	public void printHashTable() {
		for (int i = 0 ; i < hashTable.length ; i++ ) {
			if ( hashTable[i] == null ) {
				System.out.println("empty");
			} else {
				System.out.println(hashTable[i].emp);
			}
		}
	}
	
	public Employee remove(String key) {
		int hashedKey = FindKey(key);
		if ( hashedKey == -1 ) {
			return null;
		}
		
		Employee empl = hashTable[hashedKey].emp;
		hashTable[hashedKey] = null;
//		Rehashing after removing an element to rectify the bug wherein search was failing 
//		if the element to be searched for was after a removed element, because
//		we were nulling the element while removing.(as above)
		StoredEmployee[] oldHashTable = hashTable;
		hashTable = new StoredEmployee[oldHashTable.length];
		for (int i = 0 ; i < oldHashTable.length; i++) {
			if ( oldHashTable[i] != null ) {
				put(oldHashTable[i].key, oldHashTable[i].emp);
			}
		}
		
		return empl;
	}
	
	public static void main(String[] args) {
		Employee janeJones = new Employee("Jane", "Jones", 1);
		Employee johnDoe = new Employee("John", "Doe", 2);
		Employee marySmith = new Employee("Mary","Smith",3);
		Employee mikeWilson = new Employee("Mike","Wilson",4);
		Employee billEnd = new Employee("Bill","End",5);
		
		HashTableArrayImplementation ht = new HashTableArrayImplementation();
//		key length is the same
//		hence this will use linear probing to saye Smith, due to conflict arising because
//		of same length of last name.
		ht.put("Jones", janeJones);
		ht.put("Smith", marySmith);
		
		
//		System.out.println("Retrieve key Jones :" + ht.get("Jones"));
//		System.out.println("Retrieve key Jones :" + ht.get("Smith"));
		
//		ht.printHashTable();
		
		ht.remove("Smith");
//		
		ht.printHashTable();
	}

}

class Employee {
	
	private String firstName;
	private String lastName;
	private int id;
	
	public Employee(String first_name, String last_name, int id) {
		this.firstName = first_name;
		this.lastName = last_name;
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
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setFirstName(String first_name) {
		this.firstName = first_name;
	}
	
	public void setLastName(String last_name) {
		this.lastName = last_name;
	}
	
	@Override
	public String toString() {
		return this.firstName+","+this.lastName;
	}
}

class StoredEmployee {
//	raw key and not the hash value (for e.g, smith, jones)
	public String key;
	public Employee emp;
	
	public StoredEmployee(String key, Employee e) {
		this.key = key;
		this.emp = e;
	}
}
