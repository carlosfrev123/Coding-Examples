import java.util.ArrayList;
import java.util.List;

public class RecursiveTools {

	
	
	//   1 --------------------
	
	public  String reverseString(String input) { 
		if (input.isEmpty()) {
			return "";
		} else {
			return reverseString(input.substring(1)) + input.charAt(0);
		}
	}
	//   2 -------------------
	
	public int sizeOfList(List<String> l) { 
		if (l.isEmpty()){
			return 0;
			}
		l.remove(0);
		return 1 + sizeOfList(l);
	}
		
	
	//    3 -----------------
	public  boolean stringEqualityTest(String s1, String s2) { 
		if (s1 == null && s2 == null) {
			return true;
		}
		else if ((s1.length()==s2.length())) {
			return true;
		}
		else if(s1.charAt(0)==s2.charAt(0)){
	        return stringEqualityTest(s1.substring(1),s2.substring(1));
		}
		
		return false;
	}
	//    4 ----------------------
	
	
	public boolean listEqualityTest(ArrayList<String> l1, ArrayList<String> l2) {
		int n = 0;
		if (l1.size()==0 && l2.size() ==0) {
	        return true;
		}
	    else if (n>=l1.size() || n>=l2.size()) {
	        return false;
	    }
		if (n<l1.size() && l1.size() == l2.size()) {
		    if ((l1.get(n)==((l2.get(n))))) 
		        return false;
		}
		return listEqualityTest(l1, l2);
		
	}
	
	
	
	//    5 -----------------------
	public boolean listCustomComparison(ArrayList<String> l1, ArrayList<String> l2) { 
		if (l1.size()==0 && l2.size() ==0) {
	   
		for(int i = 0; i < l1.size(); i++) {
			if (i>=l1.size() || i>=l2.size()) {
				return false;
	    }
			else if (i<l1.size() && l1.size() == l2.size()) {
					if ((l1.get(i)==((l2.get(i))))) { 
							return l2.get(i) == reverseString(l1.get(i));
						}
							return false;
		}
		}
		return listCustomComparison(l1, l2);
		}
		return false;
	}
	
	
	
	
	

	


}
