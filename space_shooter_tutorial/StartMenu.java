import greenfoot.*;

public class StartMenu extends World {

    public StartMenu() {    
         super(850, 600, 1); 
        prepare();
    }
    
    private void prepare() {
        GameStartMenu gameStartMenu = new GameStartMenu();
        addObject(gameStartMenu, getWidth() / 2, getHeight() / 2);

        StartButton startButton = new StartButton(); 
        addObject(startButton, getWidth() / 2, getHeight() - 100);
    }
}
