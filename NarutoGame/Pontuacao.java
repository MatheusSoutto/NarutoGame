import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Pontuacao here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pontuacao extends Actor
{
    private int points = 1;
    private int count = 0;
    private int inc = 1;
    
    public void Score()
    {               
        act();        
    }  
    
    public void act() 
    {            
        
        
            GreenfootImage image = new GreenfootImage("Pontos: "+points,          
                                    30,
                                   new Color(255,255,255,200),
                                   new Color(255,255,255,0)); 
                                            
            setImage(image);            
        
        
        // Redraws the score only at every 10 acts (saves CPU)
        
        count++;        
    }    
    
    public void addScore()
    {
        //System.out.println(count%50);
        if(count % 100 == 0){
            inc += 1;
        }        
        points += inc;
    }
    
    public int getScore()
    {
        return points;
    }    
}
