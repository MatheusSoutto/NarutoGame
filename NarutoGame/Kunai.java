import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Kunai here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Kunai extends Mover
{
    /**
     * Act - do whatever the KunaiT wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        move(30.0);
    
        if (atWorldEdge())
        {
            getWorld().removeObject(this);
        }
        else
        {
            Actor wolf = getOneIntersectingObject(Wolf.class);
            
            if (wolf != null)
            {
                NarutoWorld world = (NarutoWorld)getWorld();
                
                
                
                world.removeObject(wolf);
                world.removeObject(this);
            }
        }        
    }    
}
