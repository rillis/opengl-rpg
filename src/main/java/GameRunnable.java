import engine.GameLoop;
import graphics.Renderer;
import resources.Sprite;
import test.TestPlayer;
import world.World;

import java.io.File;

public class GameRunnable {
    public static void main(String[] args) {
        System.setProperty("newt.window.icons", new File("src/main/resources/logo16.png").getPath()+" "+new File("src/main/resources/logo32.png").getPath());

        Sprite.init();
        Renderer.init();
        GameLoop.start();

        //TESTS
        World.addObject(new TestPlayer());

    }
}
