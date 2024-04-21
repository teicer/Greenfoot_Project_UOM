import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Fire2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fire2 extends Fire
{
    public Fire2() {
        super("foot", 50,15);
    }
    
     public Fire2(double damage, double fireRate) { 
    super("default", damage, fireRate);
}

    @Override
    public Fire createCopy() {
        return new Fire2(this.damage, this.fireRate);
    }
    
   @Override
    public void act() {
        super.act(); // Καλεί την act() της Players, αν χρειάζεται
        //checkKeysPress();
        
    }
}
