package resources;

import com.jogamp.opengl.util.texture.*;
import com.jogamp.opengl.util.texture.awt.AWTTextureIO;
import graphics.Renderer;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;

public class ImageResource {
    private Texture texture = null;
    private BufferedImage image = null;

    public ImageResource(BufferedImage image){
        this.image = image;
        if (image != null){
            image.flush();
        }
    }

    public ImageResource(String path){
        try {
            this.image = ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
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
