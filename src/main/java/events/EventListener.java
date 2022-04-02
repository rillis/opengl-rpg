package events;

import com.jogamp.opengl.*;
import graphics.*;
import resources.*;
import world.*;

import java.awt.*;

public class EventListener implements GLEventListener {
    public static GL2 gl = null;

    @Override
    public void init(GLAutoDrawable drawable) {
        gl = drawable.getGL().getGL2();

        gl.glClearColor(0, 0, 0, 1);


        gl.glEnable(GL2.GL_TEXTURE_2D);



        System.out.println("Game Initialized");
    }

    @Override
    public void display(GLAutoDrawable drawable) {
        //cleaning display
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT);

        World.render();
    }

    @Override
    public void dispose(GLAutoDrawable drawable) {
        System.out.println("Closing");
        System.exit(0);
    }

    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        gl.glViewport(0, 0, width, height);
        gl.glScissor(0, 0, width, height);
        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glLoadIdentity();

        float unitsTall = height / (width / Renderer.unitsWide);
        gl.glOrtho(-Renderer.unitsWide /2, Renderer.unitsWide /2, -unitsTall/2, unitsTall/2, 1, -1);
        gl.glMatrixMode(GL2.GL_MODELVIEW);
        gl.glLoadIdentity();

        System.out.println("UnitsWide:" + Renderer.unitsWide + ", UnitsTall:" + unitsTall);
    }
}
