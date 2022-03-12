import GLOOP.GLMaus;
import GLOOP.GLQuader;
import GLOOP.GLTastatur;
import GLOOP.Sys;
import com.jogamp.opengl.GL;

public class EndMenu {
    GLQuader karteScreen, karteScreenSchatten, hintergrund, karteOverlay, karteTextOverlay, karteTextOverlayMaus;
    GLTastatur tastatur;
    GLMaus maus;
    Anzeige anzeige;
    boolean ktomVisible = false;
    int ktomTexture = 1;

    public EndMenu(boolean quickStart){
        // Prüft, ob ein Schnellstart vorliegt, um die Fadeout Animation abzuspielen
        if (quickStart){
            karteScreen = new GLQuader(0, 0, 35, 550, 450, 0);
            karteScreen.setzeFarbe(0.15, 0.15, 0.15);
            karteOverlay = new GLQuader(0, -0, 43, 540, 250, 0);
            karteOverlay.setzeFarbe(0.15, 0.15, 0.15);
            karteScreenSchatten = new GLQuader(10, -10, 33, 550, 450, 0);
            karteScreenSchatten.setzeFarbe(0.02, 0.02, 0.02);
            hintergrund = new GLQuader(0, -0, 32, 1050, 600, 0);
            hintergrund.setzeFarbe(0.07, 0.07, 0.07);
            karteTextOverlay = new GLQuader(0, -0, 44, 550, 450, 0, "gameovermenu.png");
            anzeige = new Anzeige(145,-95,45,90,90);
        } else {
            karteScreen = new GLQuader(0, -540, 35, 550, 450, 0);
            karteScreen.setzeFarbe(0.15, 0.15, 0.15);
            karteOverlay = new GLQuader(0, -540, 43, 540, 250, 0);
            karteOverlay.setzeFarbe(0.15, 0.15, 0.15);
            karteScreenSchatten = new GLQuader(10, -550, 33, 550, 450, 0);
            karteScreenSchatten.setzeFarbe(0.02, 0.02, 0.02);
            hintergrund = new GLQuader(0, -700, 32, 1050, 600, 0);
            hintergrund.setzeFarbe(0.07, 0.07, 0.07);
            karteTextOverlay = new GLQuader(0, -540, 44, 550, 450, 0, "gameovermenu.png");
            karteTextOverlayMaus = new GLQuader(0,0,45,550,450,0,"overHoverMenu.png");
            karteTextOverlayMaus.setzeSichtbarkeit(false);
            anzeige = new Anzeige(145,-635,45,90,90);
            anzeige.updateCounter(1);
            anzeige.updateCounter(2);
            tastatur = new GLTastatur();
            maus = new GLMaus();
            this.fadeIn();
        }
    }

    public boolean endScreen(){
        // Mausabmessungen
        // Menu:
            // X: 308 Y: 590 - X: 499 Y: 780
        // Quick Start:
            // X: 576 Y: 590 - X: 766 Y: 780
        boolean endMenu = false;
        boolean quickRestart = true;
        while (!endMenu){
            // Überprüfen auf normalen oder schnellen Neustart
            //System.out.println(maus.gibX()+ ", " + maus.gibY());
            int mausX = maus.gibX();
            int mausY = maus.gibY();
            if (mausX >= 308 && mausX <= 499 && mausY >= 590 && mausY <= 780){
                if (!ktomVisible){
                    karteTextOverlayMaus.setzeSichtbarkeit(true);
                }
                if (ktomTexture != 1){
                    karteTextOverlayMaus.setzeTextur("overHoverMenu.png");
                    ktomTexture = 1;
                }
                if (maus.gedruecktLinks()){
                    endMenu = true;
                    quickRestart = false;
                    System.out.println("Kein schneller Neustart. Das Menu wird geöffnet.");
                }
            } else if (mausX >= 576 && mausX <= 766 && mausY >= 590 && mausY <= 780){
                if (!ktomVisible){
                    karteTextOverlayMaus.setzeSichtbarkeit(true);
                }
                if (ktomTexture != 2){
                    karteTextOverlayMaus.setzeTextur("overHoverQStart.png");
                    ktomTexture = 2;
                }
                if (maus.gedruecktLinks()){
                    endMenu = true;
                    quickRestart = true;
                    System.out.println("Kein schneller Neustart. Das Menu wird geöffnet.");
                }
            } else {
                ktomVisible = false;
                karteTextOverlayMaus.setzeSichtbarkeit(false);
            }
            if (tastatur.enter()){
                endMenu = true;
                quickRestart = true;
                System.out.println("Der schnelle Neustart wird ausgeführt.");
            }
            if (tastatur.esc()){
                endMenu = true;
                quickRestart = false;
                System.out.println("Kein schneller Neustart. Das Menu wird geöffnet.");
            }
            Sys.warte();
        }
        // Löschen des End Menus, um für das nächste Menu Platz zu machen
        karteScreen.loesche();
        karteScreenSchatten.loesche();
        hintergrund.loesche();
        karteTextOverlay.loesche();
        karteOverlay.loesche();
        karteTextOverlayMaus.loesche();
        anzeige.loesche();
        return quickRestart;
    }

    public void fadeIn(){
        // Fade In Animation
        for (int i = 0; i < 900; i++){
            karteScreenSchatten.verschiebe(0,0.6,0);
            karteScreen.verschiebe(0,0.6,0);
            karteOverlay.verschiebe(0,0.6,0);
            karteTextOverlay.verschiebe(0,0.6,0);
            anzeige.verschiebe(0,0.6,0);
            if (i >= 200){
                hintergrund.verschiebe(0,1,0);
            }
            Sys.warte(1);
        }
    }

    public void fadeOut(){
        // Fade Out Animation
        for (int i = 0; i <= 900; i++){
            karteScreenSchatten.verschiebe(0,-0.6,0);
            karteScreen.verschiebe(0,-0.6,0);
            karteOverlay.verschiebe(0,-0.6,0);
            karteTextOverlay.verschiebe(0,-0.6,0);
            anzeige.verschiebe(0,-0.6,0);
            if (i >= 200){
                hintergrund.verschiebe(0,-1,0);
            }
            Sys.warte(1);
        }
        karteScreen.loesche();
        karteScreenSchatten.loesche();
        hintergrund.loesche();
        karteTextOverlay.loesche();
        karteOverlay.loesche();
        anzeige.loesche();
    }
}
