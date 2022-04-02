package input;

import com.jogamp.newt.event.MouseEvent;
import com.jogamp.newt.event.MouseListener;
import events.EventListener;
import graphics.Renderer;
import world.GameObject;
import world.World;

public class MouseInput implements MouseListener {

    private static int x = 0;
    private static int y = 0;

    public static int getX() {
        return x;
    }

    public static int getY() {
        return y;
    }

    public static float getWorldX(){
        return ((Renderer.unitsWide / EventListener.getWindowWidth() * x) - Renderer.unitsWide/2)+Renderer.cameraX;
    }

    public static float getWorldY(){
        return ((EventListener.getUnitsTall() / EventListener.getWindowHeight() * y) - EventListener.getUnitsTall()/2)-Renderer.cameraY ;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        x = e.getX();
        y = e.getY();

        for(GameObject go : World.gameObjects){
            if(go.isClicked(getWorldX(), getWorldY())){
                go.click();
                break;
            }
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        x = e.getX();
        y = e.getY();
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseWheelMoved(MouseEvent e) {

    }
}
