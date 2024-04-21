import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

public class BtnFire2 extends BuyBtn
{
   
    public BtnFire2(){
        super(1,true);
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
                player1.setTypeOfFire(new Fire2());         
                cash.setSpentMoney(price);   
                oneTimeBought=false;
            }
        }
    }
    }
}
