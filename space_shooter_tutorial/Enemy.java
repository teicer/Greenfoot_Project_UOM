import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

public abstract class Enemy extends Actor
{
    protected double life;
    protected int speed;
    
    public Enemy(double life, int speed){
        this.life = life;
        this.speed = speed;
    }
    
     public double getLife() {
        return life;
    }

    public void setLife(double life) {
        this.life = life;
    }
    
    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
    
    public void act()
    {
        moveEnemy();
        removeFromWorld();
        //System.out.println(getY());
    }
    
     private void removeFromWorld(){
         MyWorld myWorld = (MyWorld) getWorld();
         Money money = (Money) getWorld().getObjects(Money.class).get(0); 
         int level = myWorld.currentLevel();
        if(getY() > 590){
            getWorld().removeObject(this);
            money.setSpentMoney(1 * level);
        }
    }
    
     private void moveEnemy(){
        setLocation(getX(), getY()+speed);
    }
}
