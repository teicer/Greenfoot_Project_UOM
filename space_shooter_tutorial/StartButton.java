import greenfoot.*;

public class StartButton extends Actor {
    public StartButton() {
        setImage(new GreenfootImage("Start", 24, Color.WHITE, new Color(0, 0, 0, 0)));
    }

    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            Greenfoot.setWorld(new MyWorld());
        }
    }
}
