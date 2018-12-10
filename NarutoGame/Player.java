
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Naruto here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Player extends Actor
{
    Integer step = 6;
    double dy = 0;
    int maxDy = 320;
    double g = 8;
    String caminhoImg;
    /**
     * Act - do whatever the Naruto wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        
        if((getY() + dy) > maxDy)
            setLocation(getX(),maxDy);
        else
        {
            setLocation(getX(), (int)(getY() + dy));
            dy += g;
            jump();
        }
        
        // If user presses SPACE, Naruto jumps
        if(Greenfoot.isKeyDown("space") == true && getY() == maxDy)
        {
            dy = -35;
            setLocation(getX(), (int)(getY() + dy));
            dy += g;
            jump();
        }
        if(getY() < maxDy)
        {
            jump();
        }
        else
        {
            run();
        }
    }
    
    public void run()
    {
        if(step < 6)
        {
            step += 1;
            setImage("naruto/running/n" + step.toString() + ".png");
        }
        else
        {
            step = 1;
            setImage("naruto/running/n" + step.toString() + ".png");
        }
        
    }
    
    public void jump()
    {
        if(dy < 0)
        {
            if(dy < -17)
                setImage("naruto/jumping/n1.png");
            else
                setImage("naruto/jumping/n2.png");
        }
        else
        {
            if(dy < 17)
                setImage("naruto/jumping/n3.png");
            else
                setImage("naruto/jumping/n4.png");
        }
    }
    
    public abstract void changeImg();
}
