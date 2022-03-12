import GLOOP.GLQuader;
import GLOOP.GLTastatur;
import GLOOP.Sys;

public class PausenMenu {

    GLQuader hintergrund, karteScreen, karteTextOverlay;
    GLTastatur tastatur;

    public PausenMenu(){
        tastatur = new GLTastatur();
        hintergrund = new GLQuader( 0, 0, 32, 1050, 600, 0, "1x1.png");
        karteScreen = new GLQuader(0, 0, 35, 400, 250, 0);
        karteScreen.setzeFarbe(0.15, 0.15, 0.15);
        karteTextOverlay = new GLQuader(0, 0, 36, 400, 250, 0, "pause.png");
    }

    public boolean warte(){
        while (tastatur.esc()){
            Sys.warte();
        }
        boolean wait = true;
        boolean reset = false;
        while (wait){
            if (tastatur.esc()){
                wait = false;
                while (tastatur.esc()){
                    Sys.warte();
                }
            }
            if (tastatur.backspace()){
                wait = false;
                reset = true;
                while (tastatur.backspace()){
                    Sys.warte();
                }
            }
            Sys.warte();
        }
        return reset;
    }

    public void loesche(){
        hintergrund.loesche();
        karteScreen.loesche();
        karteTextOverlay.loesche();
    }
}
