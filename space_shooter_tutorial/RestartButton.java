import greenfoot.*; 

public class RestartButton extends Actor {
    public RestartButton() {
        setImage(new GreenfootImage("Restart", 24, Color.WHITE, new Color(0, 0, 0, 0)));
    }

    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            Greenfoot.setWorld(new MyWorld());         
        }
            
    }
}