import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)
import java.awt.Graphics;
public class Counter extends Actor
{
    private static final Color textColor = new Color(255, 180, 150);
    
    private int value = 0;
    private int target = 0;
    private String text;
    private int stringLength;

    public Counter()
    {
        this("");
    }

    public Counter(String prefix)
    {
        text = prefix;
        stringLength = (text.length() + 2) * 10;
        setImage(new GreenfootImage(stringLength, 16));
        GreenfootImage image = getImage();
        image.setColor(textColor);

        updateImage();
    }
     
    public void act() {
        
        if(value < target) {
            value++;
            updateImage();
        }
        else if(value > target) {
            value--;
            updateImage();
        }
    }

    public void add(int score)
    {
       
        target += score;
    }

        
    public int geTarget(){
        return target;
    }

    public int getValue()
    {
        return value;
    }

    /**
     * Make the image
     */
    private void updateImage()
    {
        GreenfootImage image = getImage();
        image.clear();
        image.drawString(text + value, 1, 12);
    }
}
