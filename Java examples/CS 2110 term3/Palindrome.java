/** 
 * In-Class activity - Recursion
 * 
 * Palindrome - a word, phrase, number, or other sequence of characters
 * which reads the same backward as forward, such as madam or racecar.
 * 
 * @author cfr5spw
 *
 */
public class Palindrome {


	/**
     * palindrome method
     * @param s (a String)
     * @return boolean - returning true or false depending on if the input s is a Palindrome (true) or not (false) 
     * 
     * A method that determines if a string of characters (or words) is a Palindrome
     */
    public static boolean palindrome (String s) { 
    	if (s.charAt(0) != s.charAt(s.length()-1))
	        return false;
	    if (s.length() > 1){
	    	return palindrome(s.substring(1,s.length()-1));
	    }
	   
        //TODO: write the body of this method
        return true;
    }    

    public static void main(String[] args) {
        // Testing the palindrome() method
        String word1 = "racecar";       // true
        String word2 = "rotor";         // true
        String word3 = "motor";         // false
        String word4 = "axpghpxa";      // false
        String word5 = "xrtiiyrx";      // false
        String word6 = "wollem mellow"; // true
        // call to isPal() method:  
        // using the word examples above )
        System.out.println("Is " + word1 + " a palindrome? " + palindrome(word1));
        System.out.println("Is " + word2 + " a palindrome? " + palindrome(word2)); 
        System.out.println("Is " + word3 + " a palindrome? " + palindrome(word3)); 
        System.out.println("Is " + word4 + " a palindrome? " + palindrome(word4)); 
        System.out.println("Is " + word5 + " a palindrome? " + palindrome(word5)); 
        System.out.println("Is " + word6 + " a palindrome? " + palindrome(word6)); 
    }        


}
