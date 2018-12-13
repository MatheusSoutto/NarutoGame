/**
 * Write a description of class EnemyCategory here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public enum EnemyCategory  
{
    // instance variables - replace the example below with your own
    WOLF(1), OROCHIMARU(2);
    
    private final int value;

    /**
     * Constructor for objects of class EnemyCategory
     */
    EnemyCategory(int value)
    {
        this.value = value;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public int getValue()
    {
        // put your code here
        return value;
    }
}
