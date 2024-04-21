import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Fire1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fire1 extends Fire
{
    
   public Fire1() {
        super("default", 15,25);
    }
    
    public Fire1(double damage, double fireRate) { 
    super("default", damage, fireRate);
}

    @Override
    public Fire createCopy() {
        return new Fire1(this.damage, this.fireRate);
    }
    @Override
    public void act() {
        super.act(); 
 
        
    }}
