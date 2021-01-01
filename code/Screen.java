import GLOOP.GLQuader;
import GLOOP.GLTastatur;
import GLOOP.Sys;

public class Screen {

    GLQuader screen, benzinSchild, muenzenSchild, startSchild, bestaetigungSchild, menu, auswahlEins, auswahlZwei,
            trenner, benzinaus;
    GLTastatur tastatur;

    public Screen() {
        screen = new GLQuader(0, 0, 40, 450, 300, 1);
        screen.setzeFarbe(0.1, 0.1, 0.1);

        menu = new GLQuader(11, 110, 42, 330, 55, 1, "einstellungen.png");
        trenner = new GLQuader(0, 75, 42, 400, 2, 1);
        benzinSchild = new GLQuader(19, 40, 42, 250, 41.6, 1, "benzinan.png");
        muenzenSchild = new GLQuader(15, -20, 42, 250, 41.6, 1, "muenzean.png");
        benzinSchild.setzeFarbe(0, 1, 0);
        muenzenSchild.setzeFarbe(0, 1, 0);
        startSchild = new GLQuader(0, -80, 42, 250, 41.6, 1, "startgame.png");

        bestaetigungSchild = new GLQuader(0, -130, 42, 150, 25, 1, "bestaetigen.png");
        auswahlEins = new GLQuader(-140, 40, 42, 10, 10, 1);
        auswahlEins.setzeFarbe(1, 1, 0);
        auswahlEins.setzeDrehung(0, 0, 45);
        auswahlZwei = new GLQuader(140, 40, 42, 10, 10, 1);
        auswahlZwei.setzeFarbe(1, 1, 0);
        auswahlZwei.setzeDrehung(0, 0, 45);

        tastatur = new GLTastatur();

    }

    public int menScreen() {
        screen.setzePosition(0, 0, 40);
        menu.setzePosition(11, 110, 42);
        trenner.setzePosition(0, 75, 42);
        benzinSchild.setzePosition(19, 40, 42);
        muenzenSchild.setzePosition(15, -20, 42);
        startSchild.setzePosition(0, -80, 42);
        bestaetigungSchild.setzePosition(0, -130, 42);
        auswahlEins.setzePosition(-140, 40, 42);
        auswahlZwei.setzePosition(140, 40, 42);

        int option = 1;
        int zaehler = 0;
        int animationAuswahl = 1;
        boolean start = false;
        int hoehe = 2;
        int gedrueckt = 0;
        int benzinaktiv = 1;
        int muenzeaktiv = 1;

        while (start == false) {
            if (zaehler >= 400) {
                zaehler = 0;

                if (animationAuswahl == 1) {
                    auswahlEins.setzePosition(auswahlEins.gibX(), auswahlEins.gibY(), -10);
                    auswahlZwei.setzePosition(auswahlZwei.gibX(), auswahlZwei.gibY(), -10);
                    animationAuswahl = 0;
                } else if (animationAuswahl == 0) {
                    auswahlEins.setzePosition(auswahlEins.gibX(), auswahlEins.gibY(), 42);
                    auswahlZwei.setzePosition(auswahlZwei.gibX(), auswahlZwei.gibY(), 42);
                    animationAuswahl = 1;
                }
            }
            if (tastatur.oben() || tastatur.istGedrueckt('w') || tastatur.unten() || tastatur.istGedrueckt('s')
                    || tastatur.enter()) {
                if (gedrueckt == 0) {
                    if (tastatur.oben() || tastatur.istGedrueckt('w')) {
                        hoehe = hoehe + 1;
                        if (hoehe >= 3) {
                            hoehe = 2;
                        }
                    } else if (tastatur.unten() || tastatur.istGedrueckt('s')) {
                        hoehe = hoehe - 1;
                        if (hoehe <= -1) {
                            hoehe = 0;
                        }
                    } else if (tastatur.enter()) {
                        switch (hoehe) {
                            case 2:
                                if (benzinaktiv == 1) {
                                    benzinaktiv = 0;
                                    benzinSchild.setzeFarbe(1, 0, 0);
                                } else {
                                    benzinaktiv = 1;
                                    benzinSchild.setzeFarbe(0, 1, 0);
                                }
                                break;
                            case 1:
                                if (muenzeaktiv == 1) {
                                    muenzeaktiv = 0;
                                    muenzenSchild.setzeFarbe(1, 0, 0);
                                } else {
                                    muenzeaktiv = 1;
                                    muenzenSchild.setzeFarbe(0, 1, 0);
                                }
                                break;
                            case 0:
                                start = true;
                                break;
                            default:
                                System.out.println("Error!");
                        }
                    }
                }
                gedrueckt = 1;
            } else {
                gedrueckt = 0;
            }

            if (gedrueckt == 1) {
                switch (hoehe) {
                    case 2:
                        auswahlEins.setzePosition(auswahlEins.gibX(), 40, auswahlEins.gibZ());
                        auswahlZwei.setzePosition(auswahlZwei.gibX(), 40, auswahlZwei.gibZ());
                        auswahlEins.setzePosition(auswahlEins.gibX(), auswahlEins.gibY(), 42);
                        auswahlZwei.setzePosition(auswahlZwei.gibX(), auswahlZwei.gibY(), 42);
                        animationAuswahl = 1;
                        zaehler = 0;
                        break;
                    case 1:
                        auswahlEins.setzePosition(auswahlEins.gibX(), -20, auswahlEins.gibZ());
                        auswahlZwei.setzePosition(auswahlZwei.gibX(), -20, auswahlZwei.gibZ());
                        auswahlEins.setzePosition(auswahlEins.gibX(), auswahlEins.gibY(), 42);
                        auswahlZwei.setzePosition(auswahlZwei.gibX(), auswahlZwei.gibY(), 42);
                        animationAuswahl = 1;
                        zaehler = 0;
                        break;
                    case 0:
                        auswahlEins.setzePosition(auswahlEins.gibX(), -80, auswahlEins.gibZ());
                        auswahlZwei.setzePosition(auswahlZwei.gibX(), -80, auswahlZwei.gibZ());
                        auswahlEins.setzePosition(auswahlEins.gibX(), auswahlEins.gibY(), 42);
                        auswahlZwei.setzePosition(auswahlZwei.gibX(), auswahlZwei.gibY(), 42);
                        animationAuswahl = 1;
                        zaehler = 0;
                        break;
                    default:
                        System.out.println("Error!");

                }
            }

            zaehler++;
            Sys.warte(1);
        }

        // Option & Ende

        if (benzinaktiv == 1) {
            if (muenzeaktiv == 1) {
                option = 1;
            } else if (muenzeaktiv == 0) {
                option = 2;
            }
        } else if (benzinaktiv == 0) {
            if (muenzeaktiv == 1) {
                option = 3;
            } else if (muenzeaktiv == 0) {
                option = 4;
            }
        }
        screen.setzePosition(0, -1000, 40);
        menu.setzePosition(11, -1000, 42);
        trenner.setzePosition(0, -1000, 42);
        benzinSchild.setzePosition(19, -1000, 42);
        muenzenSchild.setzePosition(15, -1000, 42);
        startSchild.setzePosition(0, -1000, 42);
        bestaetigungSchild.setzePosition(0, -1000, 42);
        auswahlEins.setzePosition(-140, -1000, 42);
        auswahlZwei.setzePosition(140, -1000, 42);

        return option;
    }
}
