import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)
import java.awt.Graphics;


public class TextActor extends Actor {
    
    private String text;
    private String color;
    private int fontSize;
    
   public TextActor(String text, int fontSize,Color textColor) {
        GreenfootImage image = new GreenfootImage(text, fontSize, textColor, new Color(255, 180, 150,0)); // Δημιουργία ενός GreenfootImage με το κείμενο
        setImage(image);
    }
    
    public void act()
    {
      
    }
}
