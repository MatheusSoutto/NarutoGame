import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class Orochimaru here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Orochimaru extends Enemy
{
    String base = "C:/Users/MatheusdeAbreuGoncal/Documents/MATHEUS/BCC/8/JOGOS/Jogo/NarutoGreenfoot/NarutoGame/images/";
    String path = "orochimaru/attack/o";
    Integer maxStep = 10;
    int speed = 20;
    int width = getImage().getWidth()/2;
    /**
     * Act - do whatever the Orochimaru wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        move();
        setLocation(getX() - speed, getY());
        isOut();
    } 
    
    public void move()
    {
        int limitX = getX() - width;
        List<Player> list = getWorld().getObjects(Player.class);
        if(!list.isEmpty())
        {
            Player player = list.get(0);
            int distance = (player.getX() + player.getImage().getWidth()/2) - limitX;
            if(distance <= 20)
            {
                speed = 30;
                setLocation(getX() - speed, getY());
                run(path, maxStep);
            }
        }
        speed = 20;
    }
    @Override
    public int halfHeight()
    {
        GreenfootImage image = new GreenfootImage(path + getStep().toString() + ".png");
        return image.getHeight()/2;
    }
    @Override
    public int halfWidth()
    {
        GreenfootImage image = new GreenfootImage(path + getStep().toString() + ".png");
        return image.getWidth()/2;
    }
    
    public boolean isTouching(int x, int y)
    {
        int limitXi = getX() - halfWidth();
        int limitXj = getX() + halfWidth();
        if(!getImage().equals(new GreenfootImage(path + "1.png")))
        {
            limitXi = getX() - halfWidth()/2;
            limitXj = getX() + halfWidth()/2;
        }
        return collision(x, y, limitXi, limitXj);
    }
}
