import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class BtnLevel1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BtnLevel1 extends BuyBtn
{
    
    public BtnLevel1(){
        super(500,true);
    }
    
    public void act()
    {
        click();
    }
    
    
    public void click(){
        
      if (Greenfoot.mouseClicked(this)) {
        MyWorld myWorld = (MyWorld) getWorld();
        List<Player1> players = myWorld.getObjects(Player1.class);
        List<Money> money = myWorld.getObjects(Money.class);
        if (!players.isEmpty() && !money.isEmpty()) {
            Player1 player1 = players.get(0); 
            Money cash = money.get(0);
            int availableMoney = cash.getAvailableMoney();
            int spentMoney = cash.getSpentMoney();
            
            if(availableMoney >= price && oneTimeBought){
                player1.setLevel(1);       
                cash.setSpentMoney(price);   
                oneTimeBought=false;
            }
        }
    }
    }
}
