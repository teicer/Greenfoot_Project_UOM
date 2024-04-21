import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Enemy1 extends Enemy
{
  
    public Enemy1(int level){
        super(10*level+(1/level),3);
        setRotation(-270);
    }
    
    @Override
    public void act() {
        super.act(); 
        
    }


}
