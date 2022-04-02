package resources;

import com.jogamp.opengl.util.texture.*;
import com.jogamp.opengl.util.texture.awt.AWTTextureIO;
import graphics.Renderer;

import java.awt.image.*;

public class ImageResource {
    private Texture texture = null;
    private BufferedImage image = null;

    public ImageResource(BufferedImage image){
        this.image = image;
        if (image != null){
            image.flush();
        }
    }

    public Texture getTexture() {
        if (image == null){
            return null;
        }

        if (texture == null){
            texture = AWTTextureIO.newTexture(Renderer.getProfile(), image, true);
        }
        return texture;
    }
}
