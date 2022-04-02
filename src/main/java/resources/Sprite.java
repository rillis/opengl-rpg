package resources;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class Sprite {

    //List
    public static ArrayList<Sprite> sprites = new ArrayList<>();

    public static void init(){
        String[] list = new String[]{"F_01.png", "F_02.png","F_03.png","F_04.png","F_05.png","F_06.png","F_07.png","F_08.png","F_09.png","F_10.png","F_11.png","F_12.png", "M_01.png", "M_02.png","M_03.png","M_04.png","M_05.png","M_06.png","M_07.png","M_08.png","M_09.png","M_10.png","M_11.png","M_12.png"};
        for (String item : list){
            sprites.add(new Sprite(item));
        }
    }

    //Object
    public String name;
    private BufferedImage main = null;
    private final BufferedImage[] bufferedImages = new BufferedImage[12];

    public Sprite(String img){
        load(img);
        name = img;
    }

    private void load(String img){
        try {
            main = ImageIO.read(new File("src/main/resources/" + img));
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int y = 0; y < 3; y++){
            for (int x = 0; x < 4; x++){
                int xi = (x*16);
                int yi = (y*17+1);

                bufferedImages[x+y] = main.getSubimage(xi, yi, 16, 16);
            }
        }
    }

    public BufferedImage getImage(int i){
        return bufferedImages[i];
    }

    public ImageResource getImageResource(int i){ return new ImageResource(bufferedImages[i]); }
}
