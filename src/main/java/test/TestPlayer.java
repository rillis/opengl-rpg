package test;

import graphics.Graphics;
import world.GameObject;

public class TestPlayer extends GameObject {
    public TestPlayer(){
        width = 10;
        height = 10;
    }

    @Override
    public void update() {
        x += 0.3f;
        //y += 0.1f;
    }

    @Override
    public void render() {
        Graphics.fillRect(x, y, width, height);
    }
}
