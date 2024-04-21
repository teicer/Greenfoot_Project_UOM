import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;


public abstract class Fire extends Actor {
    protected String typeOfFire;
    protected double damage;
    protected double fireRate;
    protected double fireCounter = 0;
 
    
    
    public Fire(String typeOfFire, double damage,double fireRate) {
        this.typeOfFire = typeOfFire;
        this.damage = damage;
        this.fireRate = fireRate;
         Greenfoot.playSound("EnergyGun.wav");
    }
    
    public abstract Fire createCopy();
    
    public void act() {
      fireMove();
        removeFromWorld();
        

    }
    
    protected void fireMove(){
        setLocation(getX(), getY() - 5);
    }
    
    
     public String getTypeOfFire() {
        return typeOfFire;
    }

    public double getDamage() {
        return damage;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }

       public double getFireRate() {
        return fireRate;
    }

    public void setFireRate(double fireRate) {
        this.fireRate = fireRate;
    }
    
    //ελενχει εαν μπορει να Fire βασει του fireRate που εχει το οπλο
    public boolean canFire() {
        fireCounter--; 
            if (fireCounter <= 0) {
                fireCounter = fireRate; 
                return true; 
            }
        return false; 
    }
    
    //εδω διαγραφεται το Fire αμα βρει στο Enemy αντικειμενο η στο τελος του κοσμου
protected void removeFromWorld(){
    Actor actor = getOneIntersectingObject(Enemy.class);
    World myWorld = getWorld();
    Counter counter = ((MyWorld) myWorld).getCounter();

    if(actor != null){
        Enemy enemy = (Enemy) actor;
        double currentLife = enemy.getLife();
        enemy.setLife(currentLife - this.damage);

        if(enemy.getLife() <= 0){

            getWorld().removeObject(enemy);
            counter.add(1);
        }
        getWorld().removeObject(this);
    } else if (getY() == 0) {
        getWorld().removeObject(this);
    }
}



}
