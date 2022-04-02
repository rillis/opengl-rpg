package graphics;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.util.texture.Texture;
import events.EventListener;
import resources.ImageResource;

import java.awt.*;

public class Graphics {

    private static float r = 1;
    private static float g = 1;
    private static float b = 1;
    private static float a = 1;

    private static float rotation = 0;

    public static void drawImage(ImageResource image, float x, float y, float w, float h){
        GL2 gl = EventListener.gl;



        Texture tex = image.getTexture();
        if (tex!=null){
            gl.glBindTexture(GL2.GL_TEXTURE_2D, tex.getTextureObject());
            gl.glTexParameteri(GL2.GL_TEXTURE_2D, GL2.GL_TEXTURE_MAG_FILTER, GL2.GL_NEAREST);
        }

        gl.glTranslatef(x, y, 0);
        gl.glRotatef(rotation, 0, 0, 1);

        gl.glColor4f(r, g, b, a);
        gl.glBegin(GL2.GL_QUADS);
            gl.glTexCoord2f(0, 0);
            gl.glVertex2f(-w/2, -h/2);

            gl.glTexCoord2f(1, 0);
            gl.glVertex2f(w/2, -h/2);

            gl.glTexCoord2f(1, 1);
            gl.glVertex2f(w/2, h/2);

            gl.glTexCoord2f(0, 1);
            gl.glVertex2f(-w/2, h/2);
        gl.glEnd();
        gl.glFlush();

        gl.glBindTexture(GL2.GL_TEXTURE_2D, 0);
        gl.glRotatef(-rotation, 0, 0, 1);
        gl.glTranslatef(-x, -y, 0);
    }

    public static void fillRect(float x, float y, float w, float h){
        GL2 gl = EventListener.gl;

        gl.glTranslatef(x, y, 0);
        gl.glRotatef(rotation, 0, 0, 1);

        gl.glColor4f(r, g, b, a);
        gl.glBegin(GL2.GL_QUADS);
            gl.glVertex2f(-w/2, -h/2);
            gl.glVertex2f(w/2, -h/2);
            gl.glVertex2f(w/2, h/2);
            gl.glVertex2f(-w/2, h/2);
        gl.glEnd();
        gl.glFlush();

        gl.glRotatef(-rotation, 0, 0, 1);
        gl.glTranslatef(-x, -y, 0);
    }

    public static void reset(){
        r = 1;
        g = 1;
        b = 1;
        a = 1;

        rotation = 0;
    }

    public static void setColor(float red, float green, float blue, float alpha){
        r = red;
        g = green;
        b = blue;
        a = alpha;
    }

    public static void setColor(Color c, float alpha){
        setColor(c.getRed()/255f, c.getGreen()/255f, c.getBlue()/255f, alpha);
    }

    public static void setColor(Color c){
        setColor(c, 1f);
    }

    public static void setRotation(float r){
        rotation = -r;
    }

}
