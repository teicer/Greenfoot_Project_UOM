import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player1 extends Players
{

    
      public Player1() {
        super("rocket.png", "rocketWithThrust.png",5,new Fire1());
        setRotation(270);
    }
     
    @Override
    public void act() {
        super.act(); // Καλεί την act() της Players, αν χρειάζεται
        //checkKeysPress();
        
    }
    
     @Override
    protected void checkKeysPress() {
        super.checkKeysPress(); // Καλεί την checkKeysPress() της Players, εάν έχει κοινό κώδικα
        // Ειδικός κώδικας για Player1
    }
    
    @Override
    protected void ignite(boolean boosterOn) {
        super.ignite(boosterOn); 
    }
}
