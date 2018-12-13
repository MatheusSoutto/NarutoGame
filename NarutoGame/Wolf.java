import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Wolf here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Wolf extends Enemy
{
    String path = "wolf/running/w";
    Integer maxStep = 6;
    //setCategory(EnemyCategory.WOLF);
    /**
     * Act - do whatever the Wolf wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        setLocation(getX() - 20, getY());
        run(path, maxStep);
        isOut();
    }
    
    public boolean isTouching(int x, int y)
    {
        int limitXi = getX() - halfWidth();
        int limitXj = getX() + halfWidth();
        /*if(!getImage().equals(new GreenfootImage(path + "1.png")))
        {
            limitXi = getX() - halfWidth()/2;
            limitXj = getX() + halfWidth()/2;
        }*/
        return collision(x, y, limitXi, limitXj);
    }
}
