package world;

import graphics.Animation;
import graphics.Graphics;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class GameObject {
    //position
    public float x = 0;
    public float y = 0;

    //size
    public float width = 1;
    public float height = 1;

    //rotation ºDEG
    public float rotation = 180;

    //Animations
    public Animation[] animations;
    public int currentAnimation = 0;

    public void update(){
        //
    }

    public void render(){
        animations[currentAnimation].play();
        Graphics.setRotation(rotation);
        Graphics.drawImage(animations[currentAnimation].getImage(), x, y, width, height);
        Graphics.setRotation(0);
    }

    public void click(){
        //
    }

    public boolean isClicked(float mouse_x, float mouse_y){
        //System.out.println(x + "|" + y + "|"+width+"|"+height+ "   "+mouse_x+"|"+mouse_y);
        return new Rectangle2D.Float(x-width/2, y-height/2, width, height).contains(new Rectangle2D.Float(mouse_x, mouse_y, 1f, 1f));
    }
}
