package world;

import test.TestPlayer;

import java.util.ArrayList;

public class World {

    private static ArrayList<GameObject> gameObjects = new ArrayList<>();

    public static void update(){
        for(GameObject gameObject : gameObjects){
            gameObject.update();
        }
    }

    public static void render(){
        for(GameObject gameObject : gameObjects){
            gameObject.render();
        }
    }

    public static void addObject(GameObject go) {
        gameObjects.add(go);
    }
}
