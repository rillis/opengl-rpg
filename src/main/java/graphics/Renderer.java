package graphics;

import com.jogamp.nativewindow.WindowClosingProtocol;
import com.jogamp.newt.opengl.GLWindow;
import com.jogamp.opengl.*;
import com.jogamp.opengl.util.FPSAnimator;
import events.*;
import input.MouseInput;

import javax.swing.*;

public class Renderer {
    private static GLWindow window = null;

    public static int screenWidth = 1280;
    public static int screenHeight = 720;

    public static float unitsWide = 200;

    public static float cameraX = 0;
    public static float cameraY = 0;

    private static GLProfile profile = null;

    public static void init(){
        GLProfile.initSingleton();
        profile = GLProfile.get(GLProfile.GL2);
        GLCapabilities caps = new GLCapabilities(profile);

        window = GLWindow.create(caps);
        window.setTitle("IdleRPG");
        window.setSize(screenWidth, screenHeight);
        window.setResizable(false);

        window.addGLEventListener(new EventListener());
        window.addMouseListener(new MouseInput());

        //FPSAnimator animator = new FPSAnimator(window, 60);
        //animator.start();

        window.setVisible(true);
        window.requestFocus();
    }

    public static GLProfile getProfile(){
        return profile;
    }

    public static void render(){
        if(window==null){
            return;
        }
        window.display();
    }
}
