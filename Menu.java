import GLOOP.GLMaus;
import GLOOP.GLQuader;
import GLOOP.GLTastatur;
import GLOOP.Sys;

import javax.swing.*;
import java.awt.*;

public class Menu {
    // Menu
    GLQuader karteScreen, karteScreenSchatten, hintergrund,
            karteOverlay, karteTextOverlay, karteTextOverlayMaus, karteLaden, karteLadenText;
    boolean ktomVisible = false;
    int ktomTexture = 1;
        // (ktomTexture: 1 = hoverStart.png, 2 = hoverHelp.png, 3 = hoverShop.png)
    // Coin Anzeige
    GLQuader coin, d1, d2, d3, d4, d5;
    // Eingabegeräte
    GLTastatur tastatur;
    GLMaus maus;
    Shop shop;

    private static boolean muenzenAktiv = true;
    private static boolean benzinAktiv = true;
    private static boolean jetpackAktiv = true;

    public Menu(){
        // Mittler Hintergrund (karteScreen)
        karteScreen = new GLQuader(0, 0, 35, 550, 450, 0);
        karteScreen.setzeFarbe(0.15, 0.15, 0.15);
        // Mittler Hintergrund Schatten (karteScreenSchatten)
        karteScreenSchatten = new GLQuader(10, -10, 33, 550, 450, 0);
        karteScreenSchatten.setzeFarbe(0.02, 0.02, 0.02);
        // Trenner zwischen Menu und Willkommens Text / Laden Text (karteOverlay)
        karteOverlay = new GLQuader(0, 0, 43, 540, 250, 0);
        karteOverlay.setzeFarbe(0.15, 0.15, 0.15);
        // Hintergrund, also Trenner zwischen Spiel und Menu, bzw. Mittlerer Hintergrund (hintergrund)
        hintergrund = new GLQuader(0, 0, 32, 1050, 600, 0);
        hintergrund.setzeFarbe(0.07, 0.07, 0.07);
        // Text, wie z.B. Willkommens Text (karteTextOverlay)
        karteTextOverlay = new GLQuader(0, 0, 44, 550, 450, 0, "cardWelcomeNew.png");
        // Maus Hover
        karteTextOverlayMaus = new GLQuader(0,0,45,550,450,0,"hoverStart.png");
        karteTextOverlayMaus.setzeSichtbarkeit(false);
        // Drei Punkte Lader
        karteLaden = new GLQuader(0, -500, 44, 100, 100, 0, "Laden.png");
        karteLaden.setzeSichtbarkeit(false);
        // Laden Text unter Ladezeichen
        karteLadenText = new GLQuader(0, -550, 44, 100, 33, 0, "cardLaden.png");
        karteLadenText.setzeSichtbarkeit(false);
        tastatur = new GLTastatur();
        maus = new GLMaus();

        // Coin Anzeige (Seesion)
        coin = new GLQuader(150,190,45,20,20,0,"coin.png");
        d5 = new GLQuader(175,190,45,15,27,0,"0.png");
        d4 = new GLQuader(190,190,45,15,27,0,"0.png");
        d3 = new GLQuader(205,190,45,15,27,0,"0.png");
        d2 = new GLQuader(220,190,45,15,27,0,"0.png");
        d1 = new GLQuader(235,190,45,15,27,0,"0.png");
        updateDigits();
    }



    public boolean[] getOption(){;
        boolean startGame = false;
        boolean[] options = {false};

        // Menu wird eingeschaltet



        // Willkommensbildschirm (mit Hilfen)
        while (!startGame) {

            karteTextOverlay.setzeTextur("cardWelcomeNew.png");
            karteOverlay.setzeSichtbarkeit(true);
            karteTextOverlay.setzeSichtbarkeit(true);
            coin.setzeSichtbarkeit(true);
            d1.setzeSichtbarkeit(true);
            d2.setzeSichtbarkeit(true);
            d3.setzeSichtbarkeit(true);
            d4.setzeSichtbarkeit(true);
            d5.setzeSichtbarkeit(true);

            // Warten auf die Eingabe des Nutzers

            while (!startGame) {
                // Mausabmessungen
                // Starten:
                // X: 315 Y: 595 - X: 490 Y: 770
                // Hilfe
                // X: 610 Y: 595 - X: 790 Y: 770
                // Shop
                // X: 910 Y: 595 - X: 1085 Y: 770

                int mausX = maus.gibX();
                int mausY = maus.gibY();

                if (mausX >= 305 && mausX <= 500 && mausY >= 585 && mausY <= 780) {
                    if (!ktomVisible) {
                        karteTextOverlayMaus.setzeSichtbarkeit(true);
                        ktomVisible = true;
                    }
                    if (ktomTexture != 1) {
                        karteTextOverlayMaus.setzeTextur("hoverStart.png");
                        ktomTexture = 1;
                    }
                    if (maus.gedruecktLinks()) {
                        // Startet die Abfrage der Optionen durch das beenden der Schleife

                        startGame = true;
                    }
                } else if (mausX >= 603 && mausX <= 797 && mausY >= 585 && mausY <= 780) {
                    if (!ktomVisible) {
                        karteTextOverlayMaus.setzeSichtbarkeit(true);
                        ktomVisible = true;
                    }
                    if (ktomTexture != 2) {
                        karteTextOverlayMaus.setzeTextur("hoverHelp.png");
                        ktomTexture = 2;
                    }
                    if (maus.gedruecktLinks()) {
                        ktomVisible = false;
                        karteTextOverlayMaus.setzeSichtbarkeit(false);

                        // Führt die Hilfe auf. Die weiteren Schleifen werden dafür benutzt, um die Tastaturklicks voneinander zu trennen

                        karteTextOverlay.setzeTextur("cardHelp1.png");
                        while (tastatur.istGedrueckt() || maus.gedruecktLinks() || maus.gedruecktRechts()) {
                            Sys.warte();
                        }
                        while (!tastatur.istGedrueckt() && !maus.gedruecktLinks() && !maus.gedruecktRechts()) {
                            Sys.warte();
                        }
                        karteTextOverlay.setzeTextur("cardHelp2.png");
                        while (tastatur.istGedrueckt() || maus.gedruecktLinks() || maus.gedruecktRechts()) {
                            Sys.warte();
                        }
                        while (!tastatur.istGedrueckt() && !maus.gedruecktLinks() && !maus.gedruecktRechts()) {
                            Sys.warte();
                        }
                        karteTextOverlay.setzeTextur("cardHelp3.png");
                        while (tastatur.istGedrueckt() || maus.gedruecktLinks() || maus.gedruecktRechts()) {
                            Sys.warte();
                        }
                        while (!tastatur.istGedrueckt() && !maus.gedruecktLinks() && !maus.gedruecktRechts()) {
                            Sys.warte();
                        }
                        karteTextOverlay.setzeTextur("cardHelp4.png");
                        while (tastatur.istGedrueckt() || maus.gedruecktLinks() || maus.gedruecktRechts()) {
                            Sys.warte();
                        }
                        while (!tastatur.istGedrueckt() && !maus.gedruecktLinks() && !maus.gedruecktRechts()) {
                            Sys.warte();
                        }
                        karteTextOverlay.setzeTextur("cardWelcomeNew.png");
                        while (tastatur.istGedrueckt() || maus.gedruecktLinks() || maus.gedruecktRechts()) {
                            Sys.warte();
                        }
                    }
                } else if (mausX >= 900 && mausX <= 1095 && mausY >= 585 && mausY <= 780) {
                    if (!ktomVisible) {
                        karteTextOverlayMaus.setzeSichtbarkeit(true);
                        ktomVisible = true;
                    }
                    if (ktomTexture != 3) {
                        karteTextOverlayMaus.setzeTextur("hoverShop.png");
                        ktomTexture = 3;
                    }
                    if (maus.gedruecktLinks()) {
                        shop = new Shop();
                    }
                } else if (ktomVisible) {
                    ktomVisible = false;
                    karteTextOverlayMaus.setzeSichtbarkeit(false);
                }
                if (tastatur.enter()) {

                    // Startet die Abfrage der Optionen durch das beenden der Schleife
                    ktomVisible = false;
                    karteTextOverlayMaus.setzeSichtbarkeit(false);
                    startGame = true;
                } else if (tastatur.istGedrueckt('h') || tastatur.istGedrueckt('H')) {

                    // Führt die Hilfe auf. Die weiteren Schleifen werden dafür benutzt, um die Tastaturklicks voneinander zu trennen
                    ktomVisible = false;
                    karteTextOverlayMaus.setzeSichtbarkeit(false);
                    karteTextOverlay.setzeTextur("cardHelp1.png");
                    while (tastatur.istGedrueckt() || maus.gedruecktLinks() || maus.gedruecktRechts()) {
                        Sys.warte();
                    }
                    while (!tastatur.istGedrueckt() && !maus.gedruecktLinks() && !maus.gedruecktRechts()) {
                        Sys.warte();
                    }
                    karteTextOverlay.setzeTextur("cardHelp2.png");
                    while (tastatur.istGedrueckt() || maus.gedruecktLinks() || maus.gedruecktRechts()) {
                        Sys.warte();
                    }
                    while (!tastatur.istGedrueckt() && !maus.gedruecktLinks() && !maus.gedruecktRechts()) {
                        Sys.warte();
                    }
                    karteTextOverlay.setzeTextur("cardHelp3.png");
                    while (tastatur.istGedrueckt() || maus.gedruecktLinks() || maus.gedruecktRechts()) {
                        Sys.warte();
                    }
                    while (!tastatur.istGedrueckt() && !maus.gedruecktLinks() && !maus.gedruecktRechts()) {
                        Sys.warte();
                    }
                    karteTextOverlay.setzeTextur("cardHelp4.png");
                    while (tastatur.istGedrueckt() || maus.gedruecktLinks() || maus.gedruecktRechts()) {
                        Sys.warte();
                    }
                    while (!tastatur.istGedrueckt() && !maus.gedruecktLinks() && !maus.gedruecktRechts()) {
                        Sys.warte();
                    }
                    karteTextOverlay.setzeTextur("cardWelcomeNew.png");
                    while (tastatur.istGedrueckt() || maus.gedruecktLinks() || maus.gedruecktRechts()) {
                        Sys.warte();
                    }
                } else if (tastatur.istGedrueckt('s')) {
                    shop = new Shop();
                } else if (tastatur.backspace()) {
                    Sys.beenden();
                }
                //System.out.println(maus.gibX()+ ", " + maus.gibY());
                Sys.warte();
            }

            // Abfrage der Optionen (Der Willkommensbildschirm wird deaktiviert)

            startGame = false;
            SettingsMenu settingsMenu = new SettingsMenu();
            settingsMenu.activate();
            Sys.warte(10);
            karteOverlay.setzeSichtbarkeit(false);
            karteTextOverlay.setzeSichtbarkeit(false);
            karteTextOverlayMaus.setzeSichtbarkeit(false);
            ktomVisible = false;
            coin.setzeSichtbarkeit(false);
            d1.setzeSichtbarkeit(false);
            d2.setzeSichtbarkeit(false);
            d3.setzeSichtbarkeit(false);
            d4.setzeSichtbarkeit(false);
            d5.setzeSichtbarkeit(false);
            options = settingsMenu.getOption();
            if (options[0]) {
                startGame = true;
            }
        }


            /*changeAnimation(1);

            // Verhindert das automatische auswählen, falls die Entertaste noch gedrückt war
            while (tastatur.istGedrueckt()){
                Sys.warte();
            }

            // Abfrage der Optionen + Animationen
            benzinAktiv = abfrage(1);
            changeAnimation(2);
            muenzenAktiv = abfrage(2);
            changeAnimation(3);

            // Falls das Spiel abgebrochen wird fängt die Schleife wieder von vorne an (Willkommensbildschirm, etc.)
            startGame = abfrage(3);
            Sys.warte();
        }

        System.out.println("Optionen ausgewählt! Bereite das Spiel vor...");

        // Ladeanimation, nachdem der Knopf "Starten" ausgewählt wurde*/

        karteOverlay.verschiebe(0,-500,0);
        karteOverlay.setzeSichtbarkeit(true);
        karteLaden.setzeSichtbarkeit(true);
        karteLaden.setzePosition(0,-500,44);
        karteLadenText.setzeSichtbarkeit(true);
        karteLadenText.setzePosition(0,-550,44);
        karteScreen.setzeSichtbarkeit(false);
        karteScreenSchatten.setzeSichtbarkeit(false);
        double j = 2;
        double k = 2;
        double l = 2;
        double m = 0;

        // Animation

        for (int i = 0; i <= 800; i++){
            //karteOverlay.verschiebe(0,j,0);
            j = j - 0.00401;
            if (i >= 250) {
                karteLaden.verschiebe(0,k,0);
                k = k - 0.00401;
            }
            if (i >= 300){
                coin.verschiebe(0,m,0);
                d1.verschiebe(0,m,0);
                d2.verschiebe(0,m,0);
                d3.verschiebe(0,m,0);
                d4.verschiebe(0,m,0);
                d5.verschiebe(0,m,0);
                karteLadenText.verschiebe(0,l,0);
                l = l - 0.004;
                m = m - 0.0007;
            }
            if (i >= 650){
                karteLaden.skaliere(1.001,1.001,0);
            }
            if (j < 0){
                j = 0;
            }
            if (k < 0){
                k = 0;
            }
            if (l < 0){
                l = 0;
            }
            Sys.warte();
        }

        return options;
    }

    public void fadeOut(){
        karteLaden.setzeSichtbarkeit(true);
        karteLadenText.setzeSichtbarkeit(true);
        coin.loesche();
        d1.loesche();
        d2.loesche();
        d3.loesche();
        d4.loesche();
        d5.loesche();
        for (int i = 0; i <= 900; i++){
            karteScreenSchatten.verschiebe(0,-0.6,0);
            karteScreen.verschiebe(0,-0.6,0);
            if (i >= 150){
                hintergrund.verschiebe(0,-2,0);
            }
            karteLaden.verschiebe(0,-1,0);
            karteLadenText.verschiebe(0,-1,0);
            karteOverlay.verschiebe(0,-0.6,0);
            Sys.warte(1);
        }
        karteScreen.loesche();
        karteScreenSchatten.loesche();
        karteLadenText.loesche();
        karteLaden.loesche();
        hintergrund.loesche();
        karteOverlay.loesche();
    }



    private void updateDigits(){
        int coins = Spiel.coinSession;
        int cd1 = 0, cd2 = 0, cd3 = 0, cd4 = 0, cd5 = 0;
        for (int i = coins; i >= 1; i -= 1) {
            cd1 += 1;
            if (cd1 >= 10) {
                cd1 = 0;
                cd2 += 1;
                if (cd2 >= 10) {
                    cd2 = 0;
                    cd3 += 1;
                    if (cd3 >= 10) {
                        cd3 = 0;
                        cd4 += 1;
                        if (cd4 >= 10) {
                            cd4 = 0;
                            cd5 += 1;
                            if (cd5 >= 10) {
                                cd5 = 9;
                                cd4 = 9;
                                cd3 = 9;
                                cd2 = 9;
                                cd1 = 9;
                            }
                        }
                    }
                }
            }
        }

        switch (cd5){
            case 0:
                d5.setzeTextur("0.png");
                break;
            case 1:
                d5.setzeTextur("1.png");
                break;
            case 2:
                d5.setzeTextur("2.png");
                break;
            case 3:
                d5.setzeTextur("3.png");
                break;
            case 4:
                d5.setzeTextur("4.png");
                break;
            case 5:
                d5.setzeTextur("5.png");
                break;
            case 6:
                d5.setzeTextur("6.png");
                break;
            case 7:
                d5.setzeTextur("7.png");
                break;
            case 8:
                d5.setzeTextur("8.png");
                break;
            case 9:
                d5.setzeTextur("9.png");
                break;
            default:
                System.out.println("Debug: -> Error on d5 (Menu)");
        }
        switch (cd4){
            case 0:
                d4.setzeTextur("0.png");
                break;
            case 1:
                d4.setzeTextur("1.png");
                break;
            case 2:
                d4.setzeTextur("2.png");
                break;
            case 3:
                d4.setzeTextur("3.png");
                break;
            case 4:
                d4.setzeTextur("4.png");
                break;
            case 5:
                d4.setzeTextur("5.png");
                break;
            case 6:
                d4.setzeTextur("6.png");
                break;
            case 7:
                d4.setzeTextur("7.png");
                break;
            case 8:
                d4.setzeTextur("8.png");
                break;
            case 9:
                d4.setzeTextur("9.png");
                break;
            default:
                System.out.println("Debug: -> Error on d4 (Menu)");
        }
        switch (cd3){
            case 0:
                d3.setzeTextur("0.png");
                break;
            case 1:
                d3.setzeTextur("1.png");
                break;
            case 2:
                d3.setzeTextur("2.png");
                break;
            case 3:
                d3.setzeTextur("3.png");
                break;
            case 4:
                d3.setzeTextur("4.png");
                break;
            case 5:
                d3.setzeTextur("5.png");
                break;
            case 6:
                d3.setzeTextur("6.png");
                break;
            case 7:
                d3.setzeTextur("7.png");
                break;
            case 8:
                d3.setzeTextur("8.png");
                break;
            case 9:
                d3.setzeTextur("9.png");
                break;
            default:
                System.out.println("Debug: -> Error on d3 (Menu)");
        }
        switch (cd2){
            case 0:
                d2.setzeTextur("0.png");
                break;
            case 1:
                d2.setzeTextur("1.png");
                break;
            case 2:
                d2.setzeTextur("2.png");
                break;
            case 3:
                d2.setzeTextur("3.png");
                break;
            case 4:
                d2.setzeTextur("4.png");
                break;
            case 5:
                d2.setzeTextur("5.png");
                break;
            case 6:
                d2.setzeTextur("6.png");
                break;
            case 7:
                d2.setzeTextur("7.png");
                break;
            case 8:
                d2.setzeTextur("8.png");
                break;
            case 9:
                d2.setzeTextur("9.png");
                break;
            default:
                System.out.println("Debug: -> Error on d2 (Menu)");
        }
        switch (cd1){
            case 0:
                d1.setzeTextur("0.png");
                break;
            case 1:
                d1.setzeTextur("1.png");
                break;
            case 2:
                d1.setzeTextur("2.png");
                break;
            case 3:
                d1.setzeTextur("3.png");
                break;
            case 4:
                d1.setzeTextur("4.png");
                break;
            case 5:
                d1.setzeTextur("5.png");
                break;
            case 6:
                d1.setzeTextur("6.png");
                break;
            case 7:
                d1.setzeTextur("7.png");
                break;
            case 8:
                d1.setzeTextur("8.png");
                break;
            case 9:
                d1.setzeTextur("9.png");
                break;
            default:
                System.out.println("Debug: -> Error on d1 (Menu)");
        }
        System.out.println("Muenzenstand: " + coins);
    }
}
