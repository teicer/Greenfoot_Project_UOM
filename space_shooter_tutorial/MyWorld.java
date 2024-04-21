import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
public class MyWorld extends World
{
    private static final Color alienColor = new Color(61, 255, 71);
    private static final Color buttonColor = new Color(232,237,237);
    
    int timer = 0;
    int levelTimer = 0;
    int currentLevel = 1;
    private Counter counter;
    Player1 player = new Player1();
    Menu menu = new Menu();

    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(850, 600, 1); 
    
            prepare();
       
        
    }
    public void act(){
            timer++;
            levelTimer++;
            if(levelTimer >= 1800){
                currentLevel++;
                levelTimer = 0;
            }
            if(timer >= 40) {
                addEnemy1(); 
                timer = 0; 
            }
            updateLives();
        
    }
    public void addEnemy1(){
        addObject(new Enemy1(currentLevel), Greenfoot.getRandomNumber(560),0);
    }
    
     public int currentLevel(){
        return this.currentLevel;
    }
    private void prepare()
    {
        addObject(player,283,477);
        Enemy1 enemy1 = new Enemy1(currentLevel);
        addObject(enemy1,182,54);
        counter  = new Counter("Score: ");
        addObject(counter, 60, 580);
        addObject(menu,730,300);
        addObject(new TextActor("Menu", 24,alienColor),728,30);
        addObject(new TextActor("Cash: ", 20,alienColor),700,60);
        addObject(new Money(),750,60);
        addObject(new TextActor("Upgrade Your Wapon", 16,alienColor),725,90);
        
        addObject(new TextActor("Level 1", 12,alienColor),640,110);
         addObject(new TextActor("Cost 500", 10,alienColor),640,125);
        addObject(new BtnLevel1(),640,150);
        
        addObject(new TextActor("Level 2", 12,alienColor),725,110);
        addObject(new TextActor("Cost 1000", 10,alienColor),725,125);
        addObject(new BtnLevel2(),725,150);
        
        addObject(new TextActor("Level 3", 12,alienColor),805,110);
        addObject(new TextActor("Cost 3000", 10,alienColor),805,125);
        addObject(new BtnLevel3(),805,150);
        
        addObject(new TextActor("+1 Damage", 12,alienColor),670,200);
        addObject(new TextActor("Cost 40", 10,alienColor),670,215);
        addObject(new BtnDamage(), 680, 240);
        
        addObject(new TextActor("+1 Fire Rate", 12,alienColor),770,200);
        addObject(new BtnFireRate(), 770, 240);
        addObject(new TextActor("Cost 40", 10,alienColor),770,215);
        
        addObject(new TextActor("Buy New Wapon", 16,alienColor),725,300);
        MenuImage fireImage1 = new MenuImage("greenfoot.png");
        addObject(fireImage1,625,340);
        addObject(new TextActor("Beeper", 12,alienColor),660,340);
        addObject(new TextActor("Damage 50", 10,alienColor),665,360);
        addObject(new TextActor("Fire Rate 15", 10,alienColor),665,380);
        addObject(new TextActor("Cost 500", 10,alienColor),665,400);
        addObject(new BtnFire2(),665, 425);
       
    }

     public Counter getCounter() {
        return counter;
    }
    
    private void updateLives() {
        List<Life> lives = getObjects(Life.class);
        int lifes = player.getLife();
        if(lifes == 0){
            showGameOver();
        }
        for(int i = 0; i < lifes; i++) {
            addObject(new Life(), 120 + i * 40, 580);
        }
        for (Life life : lives) {
            removeObject(life);
        }
    }
    
    public void showGameOver(){
            Counter counter = getCounter();
            int score = counter.geTarget();
            addObject(new GameOverMenu(score), getWidth()/2, getHeight()/2);
            addObject(new RestartButton(),getWidth()/2, getHeight()/2+ 100);
    }
    
  
    
}
