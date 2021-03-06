package inf112.skeleton.app;

import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;


public class Main {
    public static void main(String[] args) {
        LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();


        // Min requirement res: 1366x768
        // Other: 1400x1050, 1600×900, 2560×1440, 3840×2160
        // Default res: 1920x1080

        cfg.title = "RoboRally";
        cfg.width = 1920;
        cfg.height = 1080;
        cfg.useHDPI = true;
        cfg.fullscreen = false;

        GameClass game = new GameClass();
        game.play(cfg);
        
    }
}
