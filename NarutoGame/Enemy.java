import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Enemy extends Actor
{
    Integer step = 1;
    EnemyCategory category;
    String path;
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    } 
    
    public void run(String path, Integer maxStep)
    {
        if(step < maxStep)
        {
            step += 1;
            setImage(path + step.toString() + ".png");
        }
        else
        {
            step = 1;
            setImage(path + step.toString() + ".png");
        }
        
    }
    
    public void isOut()
    {
        if(this.isAtEdge())
        {
            getWorld().removeObject(this);
        }
    }
    //get
    public boolean collision(int pX, int pY, int xi, int xj)
    {
        if(pX >= xi && pX <= xj)
        {
            if(pY >= (getY() - halfHeight()) && pY <= (getY() + halfHeight()))
            {
                return true;
            }
        }
        return false;
    }
    
    public abstract boolean isTouching(int x, int y);
    
    public int halfHeight()
    {
        return getImage().getHeight()/2;
    }
    
    public int halfWidth()
    {
        return getImage().getWidth()/2;
    }
    
    public void setCategory(EnemyCategory category)
    {
        this.category = category;
    }
    
    public EnemyCategory getCategory()
    {
        return category;
    }
    
    public Integer getStep()
    {
        return this.step;
    }
}
