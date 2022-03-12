import GLOOP.GLMaus;
import GLOOP.GLQuader;
import GLOOP.Sys;

public class SettingsMenu {
    GLQuader textAnzeige, abbruchAnzeige, overJet, overCoin, overBenz, overEnter, overAbbruch;
    GLMaus maus;
    GLQuader[] schalter;
    private boolean[] state;

    public SettingsMenu() {
        textAnzeige = new GLQuader(0, 0, 44, 550, 450, 0, "settingsMenu.png");
        abbruchAnzeige = new GLQuader(325, 225, 44, 30, 30, 0, "xGrey.png");
        schalter = new GLQuader[] {
            new GLQuader(120, 59, 45, 60, 60, 0, "schalterEin.png"),
            new GLQuader(120, -25, 45, 60, 60, 0, "schalterEin.png"),
            new GLQuader(120, -105, 45, 60, 60, 0, "schalterEin.png"),
            new GLQuader(120, 59, 45, 60, 60, 0, "schalterAus.png"),
            new GLQuader(120, -25, 45, 60, 60, 0, "schalterAus.png"),
            new GLQuader(120, -105, 45, 60, 60, 0, "schalterAus.png"),
        };
        maus = new GLMaus();
        textAnzeige.setzeSichtbarkeit(false);
        abbruchAnzeige.setzeSichtbarkeit(false);
        for (int i = 0; i < schalter.length; i++) {
            schalter[i].setzeSichtbarkeit(false);
        }

        overJet = new GLQuader(0, 0, 45, 550, 450, 0, "setJet.png");
        overCoin = new GLQuader(0, 0, 45, 550, 450, 0, "setCoin.png");
        overBenz = new GLQuader(0, 0, 45, 550, 450, 0, "setBenz.png");
        overEnter = new GLQuader(0, 0, 45, 550, 450, 0, "setEnter.png");
        overAbbruch = new GLQuader(324.8, 224.8, 45, 29.7, 29.7, 0, "xRed.png");
        overJet.setzeSichtbarkeit(false);
        overCoin.setzeSichtbarkeit(false);
        overBenz.setzeSichtbarkeit(false);
        overEnter.setzeSichtbarkeit(false);
        overAbbruch.setzeSichtbarkeit(false);

        state = new boolean[] {true, true, true};
    }

    public void activate() {
        textAnzeige.setzeSichtbarkeit(true);
        abbruchAnzeige.setzeSichtbarkeit(true);
        schalter[0].setzeSichtbarkeit(true);
        schalter[1].setzeSichtbarkeit(true);
        schalter[2].setzeSichtbarkeit(true);

    }

    public void entfernen() {
        textAnzeige.loesche();
        abbruchAnzeige.loesche();
        for (int i = 0; i < schalter.length; i++) {
            schalter[i].loesche();
        }
        overAbbruch.loesche();
        overCoin.loesche();
        overJet.loesche();
        overBenz.loesche();
        overEnter.loesche();
    }

    public boolean[] getOption() {
        int bereich = 0;
        while (true) {
            // Mausabmessungen
            // 1 Jetpack:
            // X: 406 Y: 345 - X: 990 Y: 435
            // 2 Coin:
            // X: 406 Y: 500 - X: 990 Y: 590
            // 3 Benzin:
            // X: 406 Y: 655 - X: 990 Y: 745
            // 4 Bestätigen:
            // X: 570 Y: 798 - X: 829 Y: 855
            // 5 X:
            // X: 1291 Y: 45 - X: 1343 Y: 98
            //System.out.println(maus.gibX() + " , " + maus.gibY());
            int mausX = maus.gibX();
            int mausY = maus.gibY();

            if (mausX > 406 && mausX < 989 && mausY > 344 && mausY < 434) {
                if (bereich != 1) {
                    bereich = 1;
                    overJet.setzeSichtbarkeit(true);
                    overAbbruch.setzeSichtbarkeit(false);
                    overEnter.setzeSichtbarkeit(false);
                    overBenz.setzeSichtbarkeit(false);
                    overCoin.setzeSichtbarkeit(false);
                }
            } else if (mausX > 406 && mausX < 989 && mausY > 499 && mausY < 589) {
                if (bereich != 2) {
                    bereich = 2;
                    overCoin.setzeSichtbarkeit(true);
                    overAbbruch.setzeSichtbarkeit(false);
                    overEnter.setzeSichtbarkeit(false);
                    overBenz.setzeSichtbarkeit(false);
                    overJet.setzeSichtbarkeit(false);
                }
            } else if (mausX > 406 && mausX < 989 && mausY > 654 && mausY < 744) {
                if (bereich != 3) {
                    bereich = 3;
                    overBenz.setzeSichtbarkeit(true);
                    overJet.setzeSichtbarkeit(false);
                    overCoin.setzeSichtbarkeit(false);
                    overAbbruch.setzeSichtbarkeit(false);
                    overEnter.setzeSichtbarkeit(false);
                }
            } else if (mausX > 570 && mausX < 798 && mausY > 797 && mausY < 854) {
                if (bereich != 4) {
                    bereich = 4;
                    overEnter.setzeSichtbarkeit(true);
                    overBenz.setzeSichtbarkeit(false);
                    overJet.setzeSichtbarkeit(false);
                    overCoin.setzeSichtbarkeit(false);
                    overAbbruch.setzeSichtbarkeit(false);
                }
            } else if (mausX > 1291 && mausX < 1343 && mausY > 45 && mausY < 98) {
                if (bereich != 5) {
                    bereich = 5;
                    overAbbruch.setzeSichtbarkeit(true);
                    overEnter.setzeSichtbarkeit(false);
                    overBenz.setzeSichtbarkeit(false);
                    overJet.setzeSichtbarkeit(false);
                    overCoin.setzeSichtbarkeit(false);
                }
            } else {
                if (bereich != 0) {
                    bereich = 0;
                    overAbbruch.setzeSichtbarkeit(false);
                    overEnter.setzeSichtbarkeit(false);
                    overBenz.setzeSichtbarkeit(false);
                    overJet.setzeSichtbarkeit(false);
                    overCoin.setzeSichtbarkeit(false);
                }
            }

            if (maus.gedruecktLinks()) {
                switch (bereich) {
                    case 1:
                    case 2:
                    case 3:
                        if (state[bereich-1]) {
                            schalter[bereich-1].setzeSichtbarkeit(false);
                            schalter[bereich+2].setzeSichtbarkeit(true);
                            state[bereich-1] = false;
                        } else {
                            schalter[bereich-1].setzeSichtbarkeit(true);
                            schalter[bereich+2].setzeSichtbarkeit(false);
                            state[bereich-1] = true;
                        }
                        break;
                    case 4:
                        while (maus.gedruecktLinks()) {
                            Sys.warte();
                        }
                        entfernen();
                        return new boolean[]{true, state[0], state[1], state[2]};
                    case 5:
                        while (maus.gedruecktLinks()) {
                            Sys.warte();
                        }
                        entfernen();
                        return new boolean[] {false};
                    default:
                }
                while (maus.gedruecktLinks()) {
                    Sys.warte();
                }
            }
            Sys.warte();
        }
    }
}
