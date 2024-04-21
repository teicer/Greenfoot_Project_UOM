import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

public abstract class Players extends Actor
{
    protected Fire currentFire;
    protected GreenfootImage image1;
    protected GreenfootImage image2;
    protected int life;
    private boolean gotHit;
    protected int hitCounter = 0;
    private int currentLevel = 0;
    
    public Players(){
    }
    
    public Players(String imageFileName1, String imageFileName2,int life,Fire fire) {
        
        image1 = new GreenfootImage(imageFileName1);
        image2 = new GreenfootImage(imageFileName2);
        this.life = life;
        this.currentFire = fire;
        setImage(image1);

    }
    
    public int getLife(){
        return life;
    }
    
    public void setLife(int life){
        this.life = life; 
    }

    public void act() {
        checkKeysPress();
        isHitted();
    }
    //Χειρισμος του Player 
    protected void checkKeysPress() {
        // Βασική λογική για κίνηση προς τα δεξιά και αριστερά
       if(Greenfoot.isKeyDown("right")){
            if (getX() + 3 <= 560) {
                setLocation(getX() + 3, getY());
            } else {
                setLocation(560, getY());  
            }
        }
        if(Greenfoot.isKeyDown("left")){
            setLocation(getX() - 3, getY());
        }
         if (Greenfoot.isKeyDown("space") && currentFire.canFire()) {
            fire();
        }
    
        if(Greenfoot.isKeyDown("up") || Greenfoot.isKeyDown("down")){
            ignite(true);
        } else {
            ignite(false);
        }
    }
    //Δημιουργει ενα εφε ωστε να μπορει να βγαζει φωτια
    protected void ignite(boolean boosterOn) {
        if (boosterOn) {
            setImage(image2);
            image2.scale(image1.getWidth(), image1.getHeight());
            
            if(Greenfoot.isKeyDown("up")){
                if (getY() > (getWorld().getHeight()) * 0.1) {
                    setLocation(getX(), getY() - 3);
                }
            }
            if(Greenfoot.isKeyDown("down")){
                if (getY() < (getWorld().getHeight() * 0.9)) {
                    setLocation(getX(), getY() + 3);
                }
            }
        } else {
            setImage(image1);
        }
    }
    
    //Θετω ενα αντικειμενο Fire στον Player
     public void setTypeOfFire(Fire fire) {
        this.currentFire = fire;
    }
    public Fire getFire(){
        return currentFire;
    }
    
    //κλαση fire οπου καλει ενα αντικειμενο Fire(current) ωστε να πυροβολησει
 private void fire() {
        try{
            Fire fireShot = currentFire.createCopy(); 
            getWorld().addObject(fireShot, getX(), getY() - 30);
            //System.out.println(fireShot.getDamage());
          
              
            //Διπλη βολη
            if(currentLevel ==1){
                getWorld().addObject(this.currentFire.getClass().newInstance(), getX(), getY() - 60); 
            }
            // Διαγωνια προς τα δεξια/αριστερα
            if(currentLevel ==2){
                getWorld().addObject(this.currentFire.getClass().newInstance(), getX() - 60, getY() - 30);  
                getWorld().addObject(this.currentFire.getClass().newInstance(), getX() + 60, getY() - 30); 
            }
            // Διπλη βολη και διαγωνια
            if(currentLevel ==3){
                getWorld().addObject(this.currentFire.getClass().newInstance(), getX(), getY() - 60); 
                
                getWorld().addObject(this.currentFire.getClass().newInstance(), getX() - 60, getY() - 30);  
                getWorld().addObject(this.currentFire.getClass().newInstance(), getX() - 60, getY() - 60);
                
                getWorld().addObject(this.currentFire.getClass().newInstance(), getX() + 60, getY() - 30); 
                 getWorld().addObject(this.currentFire.getClass().newInstance(), getX() + 60, getY() - 60); 
            }
           
            
            
        }catch(Exception e){
             e.printStackTrace();
        }
    }

    public void setLevel (int level){
        currentLevel = level;
    }
    
  
    
    //η κλαση που ελενχει αν ενας Actor εχει χτυπησει το σκαφος
    private void isHitted(){
        Actor actor = getOneIntersectingObject(Enemy.class);   
        if(actor != null && hitCounter>120){
            Enemy enemy = (Enemy) actor;
            setLife(life - 1);
            hitCounter = 0;
            if(life <= 0) {
                getWorld().removeObject(this);
                
            }
        }
        hitCounter++;
    }
    
    
}
