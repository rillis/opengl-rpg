package test;

import engine.*;
import graphics.*;
import input.MouseInput;
import resources.*;
import world.*;

import java.awt.event.MouseEvent;

public class TestPlayer extends GameObject {
    public TestPlayer(){
        width = 10;
        height = 10;
        rotation = 180;


        animations = new Animation[1];
        Sprite sprite = Sprite.sprites.get(2);
        animations[0] = new Animation();
        animations[0].frames = new ImageResource[]{sprite.getImageResource(0), sprite.getImageResource(1), sprite.getImageResource(2)};
        animations[0].fps = 2;
    }

    @Override
    public void update() {
    }

    @Override
    public void click() {
        System.out.println("clicked");
    }
}
