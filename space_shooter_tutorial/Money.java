import greenfoot.*;  

public class Money extends Actor
{
     private static final Color textColor = new Color(255, 180, 150);
    
    int spentMoney = 0;
    int availableMoney = 0;
    private int level = 1;
    public void act()
    {
        updateMoney();

    }

    public int getSpentMoney(){
        return spentMoney;
    }
    
    public void setSpentMoney(int cost){
        this.spentMoney += cost;
        updateMoney();
    }
    
      public int getAvailableMoney(){
        return availableMoney;
    }
    
    public void setAvailableMoney(int availableMoney){
        this.availableMoney = availableMoney;   
    }
    
    public void updateMoney(){
            
         
        MyWorld myWorld = (MyWorld) getWorld();
        Counter counter = ((MyWorld) myWorld).getCounter();
        int levelEnemy = myWorld.currentLevel();
       
        int score = counter.geTarget();
        int levelP = levelEnemy*5;
        availableMoney = ( score*levelP) - spentMoney;
        if(availableMoney <=0 ){
            availableMoney = 0;
        }
        GreenfootImage image = new GreenfootImage(String.valueOf(availableMoney), 16, textColor, new Color(255, 180, 150,0));
        setImage(image);
        
    }

}
