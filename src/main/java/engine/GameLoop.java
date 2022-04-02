package engine;

import events.EventListener;
import graphics.Renderer;
import world.World;

public class GameLoop {

    private static boolean running = false;

    private static int updates = 0;
    private static final int maxUpdates = 5;
    private static long lastUpdateTime = 0;
    private static final int targetFPS = 60;
    private static final int targetTime = 1000000000 / targetFPS;


    public static void start(){
        Thread thread = new Thread(() -> {
            running = true;
            lastUpdateTime = System.nanoTime();

            int fps = 0;
            long lastFPSCheck = System.nanoTime();


            while(running){
                long currentTime = System.nanoTime();

                updates = 0;
                while(currentTime - lastUpdateTime >= targetTime){
                    World.update();
                    lastUpdateTime += targetTime;
                    updates++;

                    if (updates > maxUpdates){
                        break;
                    }
                }

                Renderer.render();

                fps++;
                if(System.nanoTime() >= lastFPSCheck + 1000000000){
                    System.out.println(fps);
                    fps = 0;
                    lastFPSCheck = System.nanoTime();
                }

                long timeTaken = System.nanoTime() - currentTime;
                if(timeTaken < targetTime){
                    try {
                        Thread.sleep((targetTime-timeTaken)/1000000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.setName("gameloop");
        thread.start();
    }
}
