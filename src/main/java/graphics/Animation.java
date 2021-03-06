package graphics;

import resources.ImageResource;
import utils.Utils;

public class Animation {
    public ImageResource[] frames;

    private int currentFrame = 0;
    public int fps = 8;
    private long lastFrameTime = 0;

    public boolean loop = true;

    public void play(){
        long currentTime = System.nanoTime();
        if(currentTime > lastFrameTime + Utils.NANO / fps){
            currentFrame++;
            if(currentFrame >= frames.length){
                if (loop){
                    currentFrame = 0;
                }else{
                    currentFrame--;
                }
            }
            lastFrameTime = currentTime;
        }
    }

    public ImageResource getImage(){
        return frames[currentFrame];
    }
}
