import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public abstract class BuyBtn extends Actor
{
    private static final Color textColor = new Color(29, 48, 105);
    private static final Color buttonColor = new Color(232,237,237);
    protected int price;
    protected boolean oneTimeBought;
    private static final int PADDING = 5;
    
    
    public BuyBtn(int price, boolean oneTimeBought){
        this.price = price;
        this.oneTimeBought = oneTimeBought;
        String text = "Buy";
        int fontSize = 16;
        // Χρησιμοποιείται για να υπολογίσουμε το μέγεθος του κειμένου
        GreenfootImage tempImage = new GreenfootImage(text, fontSize, textColor, new Color(0, 0, 0, 0)); 
        int imageWidth = tempImage.getWidth() + PADDING*2; 
        int imageHeight = tempImage.getHeight() + PADDING*2;
        GreenfootImage image = new GreenfootImage(imageWidth, imageHeight);
        image.setColor(buttonColor);
        image.fill(); 
        image.drawImage(tempImage, PADDING, PADDING);
        setImage(image);
        
    }
    
    public void act()
    {
       
    }
}
