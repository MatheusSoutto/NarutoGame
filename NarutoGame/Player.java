import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

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
    int fireRatio = 0;
    int fireLimit = 35;
    int groundHeight = getImage().getHeight()/2;
    int sideWidth = getImage().getWidth()/2;
    Integer step = 6;
    String caminhoImg;
    /**
     * Act - do whatever the Naruto wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        isDead();
        
        if((getY() + dy) > MAXDY)
            setLocation(getX(),MAXDY);
        else
        {
            setLocation(getX(), (int)(getY() + dy));
            dy += g;
            jump();
        }
        if (Greenfoot.isKeyDown("enter") && fireRatio == 0)
        {
            fire();
            fireRatio++;
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
        
         if (fireRatio >= 1)
            fireRatio++;
        
        if (fireRatio == fireLimit)
            fireRatio = 0;
           
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
    
    public void isDead()
    {
        int limitX = (getX() + sideWidth);
        int limitY = (getY() + groundHeight);
        //int limitY = getY();
        List<Obstacle> list = getWorld().getObjects(Obstacle.class);
        for(Obstacle o : list)
        {
            int collisorXi = (o.getX() - o.getImage().getWidth()/2);
            int collisorXj = (o.getX() + o.getImage().getWidth()/2);
            int collisorYi = (o.getY() - o.getImage().getHeight()/2);
            int collisorYj = (o.getY() + o.getImage().getHeight()/2);
            if(limitX >= collisorXi && limitX <= collisorXj)
            {
                if(limitY >= collisorYi && limitY <= collisorYj)
                {
                    Greenfoot.stop();
                    GameOver gameOver = new GameOver();
                    getWorld().addObject(gameOver, (getWorld().getWidth()/2), (getWorld().getHeight()/2));
                }
                
            }
            
        }
        /*
        if(limitX == getWorld().getObjectsAt(_x_, _y_, _cls_))
        {
            this.getImage().getWidth()
            GameOver gameOver = new GameOver();
            getWorld().addObject(gameOver, (getWorld().getWidth()/2), (getWorld().getHeight()/2));
            Greenfoot.stop();
        }
        */
    }
    private void fire()
    {
        Kunai kunai = new Kunai();
        getWorld().addObject(kunai, getX(), getY());
        kunai.setRotation(getRotation());
        kunai.move(40.0);
    }
    public abstract void changeImg();
}
