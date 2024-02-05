package inClass18;

import java.util.TreeMap;

public class PhoneBook {
	public static TreeMap<Integer, String> reverseBook(TreeMap<String, Integer> phoneBook) {
	
		TreeMap<Integer, String> rBook = new TreeMap<>();
		for(String key: phoneBook.keySet()) {
			rBook.put(phoneBook.get(key), key);
		}
		return rBook;
	}
	
	// ---------- TESTING ----------------
	
	public static void main(String args[]) {
		TreeMap<String, Integer > treeMap = new TreeMap<String, Integer>();
		
		treeMap.put("twelve", 12);
		treeMap.put("eleven", 11);
		treeMap.put("ten", 10);
		treeMap.put("nine", 9);
		
		System.out.println(reverseBook(treeMap));
		
		
	}

}
