
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Player extends Actor
{
    int dy = 0;
    int g = 8;
    int MAXDY = 320;
    int BOOST_SPEED = -35;
    int jumpRatio = 0;
    int jumpLimit = 12;
    Integer step = 6;
    String caminhoImg;
    /**
     * Act - do whatever the Naruto wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        
        if((getY() + dy) > MAXDY)
            setLocation(getX(),MAXDY);
        else
        {
            setLocation(getX(), (int)(getY() + dy));
            dy += g;
            jump();
        }
        
        // If user presses SPACE, Naruto jumps
        if(Greenfoot.isKeyDown("space") == true && getY() == MAXDY && jumpRatio == 0)
        {
            jumpRatio = 1;
            dy = BOOST_SPEED;
            setLocation(getX(), (int)(getY() + dy));
            dy += g;
            jump();
        }
        if(getY() < MAXDY)
        {
            jump();
        }
        else
        {
            run();
        }
        
        if (jumpRatio >= 1)
            jumpRatio++;
        
        if (jumpRatio == jumpLimit)
            jumpRatio = 0;
        
        NarutoWorld world = (NarutoWorld)getWorld();    
        world.pontua();
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
