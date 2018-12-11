import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Wolf here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Wolf extends Obstacle
{
    Integer step = 6;
    /**
     * Act - do whatever the Wolf wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    @Override
    public void act() 
    {
        // Add your action code here.
        setLocation(getX() - 20, getY());
        run();
        if(this.isAtEdge())
        {
            getWorld().removeObject(this);
        }
    }  
    
    public void run()
    {
        if(step < 6)
        {
            step += 1;
            setImage("wolf/running/w" + step.toString() + ".png");
        }
        else
        {
            step = 1;
            setImage("wolf/running/w" + step.toString() + ".png");
        }
        
    }
}
