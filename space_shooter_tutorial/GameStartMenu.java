import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class GameStartMenu extends Actor
{
    public static final float FONT_SIZE = 48.0f;
    public static final float INSTRUCTIONS_FONT_SIZE = 16.0f;
    public static final int WIDTH = 500;
    public static final int HEIGHT = 500;
    private String[] instructions = {  // Σωστή αρχικοποίηση του πίνακα συμβολοσειρών
        "You're on a space mission, the future of the ship,",
        "depends on your crew. All you have to",
        "do is kill as many malicious robots as you can.",
        "Remember, you have to upgrade your weapons ",
        "because your mission will become more difficult",
        "by the hour."
    };
    
    
    public GameStartMenu()
    {
        makeImage("Instructions",instructions);
    }
    
     private void makeImage(String title, String[] instructions)
    {
        GreenfootImage image = new GreenfootImage(WIDTH, HEIGHT);
        image.setColor(new Color(255,255,255, 128));
        image.fillRect(0, 0, WIDTH, HEIGHT);
        image.setColor(new Color(0, 0, 0, 128));
        image.fillRect(5, 5, WIDTH-10, HEIGHT-10);
        Font font = image.getFont();
        font = font.deriveFont(FONT_SIZE);
        image.setFont(font);
        image.setColor(Color.WHITE);
        image.drawString(title, 100, 100);
         Font instructionsFont = image.getFont().deriveFont(INSTRUCTIONS_FONT_SIZE);
        image.setFont(instructionsFont);
        int y = 150;
        for(int i=0; i<instructions.length; i++){
             image.drawString(instructions[i], 60, y);
             y += 28;
        }
        setImage(image);
    }
    
    public void act()
    {
        
    }
    
}
