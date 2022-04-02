package test;

import events.EventListener;
import graphics.Graphics;
import graphics.Renderer;
import resources.ImageResource;
import world.GameObject;

public class TestBackground extends GameObject {
    public TestBackground(){
        x = 0;
        y = 0;
        height = EventListener.getUnitsTall();
        width = Renderer.unitsWide;
    }

    @Override
    public void render() {
        Graphics.setRotation(rotation);
        Graphics.drawImage(new ImageResource("src/main/resources/back.jpg"), x, y, width, height);
        Graphics.setRotation(0);
    }
}
