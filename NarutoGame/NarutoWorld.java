import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
import java.util.Random;

/**
 * Write a description of class NarutoWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NarutoWorld extends World
{
    int time = 0;
    int nivel = 1;
    int max = 35;
    int min = 20;
    int soltaLobos = 30;
    private int imageCount = 0;
    private Pontuacao pontos;
    private GreenfootImage bgImage = new GreenfootImage("images/world/background1.jpg");
    int ground = 320;
    
    
    /**
     * 
     * 
     * 
     * 
     * Constructor for objects of class NarutoWorld.
     * 
     */
    public NarutoWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        
        Greenfoot.setSpeed(37);
        
        //Create Naruto
        Naruto naruto = new Naruto();
        
        //Add Naruto to the world
        addObject(naruto, 100, getHeight()/2);
        
        ground += naruto.groundHeight;
        
        pontos = new Pontuacao();
        addObject(pontos,getWidth()/2,15);
    }
    
    
    
    public void pontua()
    {
        pontos.addScore();
        pontos.getScore();
    }
    
    public void act() {
        imageCount -= 20; //(or any other value; small -> slow moving, big -> fast movement)
        drawBackgroundImage(); 
        
        if(time > soltaLobos)
        {
            Wolf wolf = new Wolf();
            int wolfHeight = wolf.getImage().getHeight()/2;
            addObject(wolf, getWidth(), ground - wolfHeight);
            time = 0;
            Random aleatorio = new Random();
            soltaLobos = aleatorio.nextInt((max - min) + 1) + min;
            
        }
        if(nivel > 200){
            if(nivel % 100 == 0){
                if(max > 25)
                    max-=1;
                if(min > 15)
                    min-=1;                
            }
        }                
        
        if(time > 80)
        {
            Orochimaru orochimaru = new Orochimaru();
            int orochimaruHeight = orochimaru.getImage().getHeight()/2;
            addObject(orochimaru, getWidth(), ground - orochimaruHeight);
            time = 0;
        }
        nivel ++;
        time++;        
    }
     
    public void drawBackgroundImage() {
        if (imageCount < -bgImage.getWidth()) {
            imageCount += bgImage.getWidth();
        }
        int temp = imageCount;
        getBackground().drawImage(bgImage, temp, 0);
        getBackground().drawImage(bgImage, temp + bgImage.getWidth(), 0);
    }
}
