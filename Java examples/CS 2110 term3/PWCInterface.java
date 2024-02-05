/**
 * PasswordChanger Interface
 *
 * By implementing this interface, you should have implemented all the
 * required methods for Homework 8.  Do not rely on the comments alone
 * in this interface when completing your implementation!  Refer to the
 * homework document for full descriptions of each of the required
 * methods.
 * 
 * @author CS2110 Fall 2021 Team
 *
 */
public interface PWCInterface {

    /**
     * Whether the password contains a digit (0-9).
     * 
     * Must be recursive.
     * 
     * @param password Password to check
     * @return true if it contains a digit, false otherwise.
     */
    public boolean containsDigit(String password);
    
    /**
     * Whether the passwords are equal.
     * 
     * Must be recursive.
     * 
     * @param oldPassword Original password.
     * @param newPassword New password.
     * @return true if the passwords are equal, false otherwise.
     */
    public boolean equalsOld(String oldPassword, String newPassword);
    
    /**
     * Whether the passwords are reverses of each other.
     * 
     * Must be recursive.
     * 
     * @param oldPassword Original password.
     * @param newPassword New password.
     * @return true if the passwords are the reverse of each other, 
     *          false otherwise.
     */
    public boolean reverseOfOld(String oldPassword, String newPassword);
    
    /**
     * Number of character differences (by position) between the two passwords.
     * 
     * Must be recursive.
     * 
     * @param oldPassword Original password.
     * @param newPassword New password.
     * @return The number of character differences.
     */
    public int numberDifferences(String oldPassword, String newPassword);
    
    /**
     * Whether the two passwords are different enough from each other.
     * 
     * Not recursive.
     * 
     * @param oldPassword Original password.
     * @param newPassword New password.
     * @param quality The minimum number of character differences needed.
     * @return true if the number of differences between the passwords
     *          is equal to or above the quality threshold, false otherwise.
     */
    public boolean differentEnough(String oldPassword, String newPassword, int quality);
    
    /**
     * Whether the new password is a valid change from the old password.
     * 
     * @param oldPassword Original password.
     * @param newPassword New password.
     * @return true if the change is valid, false otherwise.
     */
    public boolean validPasswordChange(String oldPassword, String newPassword);
}
