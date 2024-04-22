import greenfoot.*;  
import java.awt.Graphics;


public class TextActor extends Actor {
    
    private String text;
    private String color;
    private int fontSize;
    
   public TextActor(String text, int fontSize,Color textColor) {
       // Δημιουργία ενός GreenfootImage με το κείμενο
        GreenfootImage image = new GreenfootImage(text, fontSize, textColor, new Color(255, 180, 150,0)); 
        setImage(image);
    }
    
    public void act()
    {
      
    }
}
