import GLOOP.*;

import java.util.concurrent.ThreadLocalRandom;

public class Spiel {
    
    // ###########################
    
    // Verfügbare Skins: "rainbow" und "default"
    public static String characterSkin = "rainbow";
    
    // ###########################

    static boolean[] optionOWW = {false};

    // Variablen, die erhalten bleiben
    public static boolean devCamOn = false;
    public static boolean gravityActive = true;
    public static int coinSession = 0;
    
    
    public static int benzinWorth = 5000;

    // Variablen, die nach dem Spiel zurückgesetzt werden
    public boolean benzinEin;
    public boolean muenzenEin;
    public boolean jetpackEin;
    public int benzinTimer;
    public int jetpackFuel;
    public int globalPowerUpAnim;
    public int timeSurvived;
    public double topplat;
    public double gravity;
    public boolean[] optionLast;
    public double bossProzent;
    public int springerKick;
    public int lowBenzAnim;
    public int movePoint;

    public static int coinSum = 0;
    public static int benzinSum = 0;
    public static int jetpackSum = 0;
    public static boolean bossActive = false;

    GLTastatur tastatur;
    GLEntwicklerkamera devCam;
    Menu menu;
    EndMenu endMenu;
    Anzeige anzeige;
    PausenMenu pausenMenu;
    HoehenAnzeige hoehenAnzeige;

    GLQuader wandLinks, wandRechts, tankAnzeige, tankRoehre1, tankRoehre2, tankHintergrund, trennStrich, lowBenzin;

    // Hintergründe

    GLQuader hg1, hg2, hg3, hg4, hg5, hg6;

    // Plattformen

    Plattform[] plattform;
    Muenze[] muenze;
    Benzin[] benzin;
    Jetpack[] jetpack;

    // Springer

    SpringerVerwaltung springer;
    Haaland haaland;


    public Spiel(boolean[] optionOw, boolean quickstart){
        tastatur = new GLTastatur();
        initiate(optionOw, quickstart);

        // Variablen
        benzinEin = true;
        muenzenEin = true;
        jetpackEin = true;
        benzinTimer = 20000;
        jetpackFuel = 0;
        globalPowerUpAnim = -500;
        timeSurvived = 0;
        topplat = 750;
        optionLast = new boolean[] {true, true, true, true};
        springerKick = 0;
        lowBenzAnim = 0;
        movePoint = 100;

        // Szenerie erstellen
        wandLinks = new GLQuader(-400, 0, 0, 185, 1000, 0);
        wandRechts = new GLQuader(400, 0, 0, 205, 1000, 0);
        wandLinks.setzeFarbe(0.1, 0.1, 0.1);
        wandRechts.setzeFarbe(0.1, 0.1, 0.1);
        anzeige = new Anzeige(-350,230,1,80,80);
        hoehenAnzeige = new HoehenAnzeige(-350, -80, 1, 80, 342.2);
        trennStrich = new GLQuader(-355, 140, 1, 70, 5, 0);
        trennStrich.setzeFarbe(0.2,0.2,0.2);
        hg1 = new GLQuader(-200, -200, -20, 405, 411, 0, "background3.png");
        hg2 = new GLQuader(-200, 211, -20, 405, 411, 0, "background3.png");
        hg3 = new GLQuader(-200, 622, -20, 405, 411, 0, "background3.png");
        hg4 = new GLQuader(200, -200, -20, 405, 411, 0, "background3.png");
        hg5 = new GLQuader(200, 211, -20, 405, 411, 0, "background3.png");
        hg6 = new GLQuader(200, 622, -20, 405, 411, 0, "background3.png");
        lowBenzin = new GLQuader(0, 500, 0, 200, 50, 0, "lowBenzinWarning.png");

        // Objekte erstellen
        springer = new SpringerVerwaltung();
        springer.verschiebe(0, -50, 0, 2);

        if (benzinEin){
            tankRoehre1 = new GLQuader(338.5, -240, 3, 60, 60, 0, "pipe.png");
            tankRoehre2 = new GLQuader(338.5, 260, 3, 60, 60, 0, "pipe.png");
            tankRoehre2.setzeDrehung(180,0,0);
            tankHintergrund = new GLQuader(339,10,1,45,440,0);
            tankHintergrund.setzeFarbe(0.4,0.4,0.4);
            tankAnzeige = new GLQuader(338.5,10,2,35,440,0);
            tankAnzeige.setzeFarbe(0.3,1,0.3);
            benzin = new Benzin[15];
            for (int i = 0; i < benzin.length; i++){
                benzin[i] = new Benzin(0,500,1);
                benzin[i].setzeDrehung(0,0,50);
                Sys.warte();
            }
        }
        if (muenzenEin){
            muenze = new Muenze[15];
            for (int i = 0; i < muenze.length; i++){
                muenze[i] = new Muenze(0,500,1);
                muenze[i].setzeDrehung(0,0,50);
                Sys.warte();
            }
        }
        if (jetpackEin){
            jetpack = new Jetpack[15];
            for (int i = 0; i < jetpack.length; i++){
                jetpack[i] = new Jetpack(0,500,1);
                jetpack[i].setzeDrehung(0,0,50);
                Sys.warte();
            }
        }
        plattform = new Plattform[15];
        plattform[0] = new Plattform(0,0);
        for (int i = 1; i < plattform.length; i++){
            plattform[i] = new Plattform(ThreadLocalRandom.current().nextInt(-250, 251),i*50);
            int plattformGen = ThreadLocalRandom.current().nextInt(0,11);
            if (plattformGen == 1){
                plattform[i].plattformTyp = 1;
                plattform[i].setzeFarbe(0,1,0.2);
            }
            // Es wird zufällig entschieden, ob die Plattform eine Powerup enthält
            int powerUpGen = ThreadLocalRandom.current().nextInt(0,11);
            if (powerUpGen == 1 && muenzenEin){
                muenze[i].active = true;
            } else if (powerUpGen == 2 && benzinEin){
                benzin[i].active = true;
            }
            Sys.warte();
        }
        topplat = 50 * plattform.length;
        gravity = -2;
        for (int i = 0; i < 400; i++) {
            springer.verschiebe(0,gravity,0,2);
            gravity += 0.005;
        }
        if (quickstart) {
            endMenu.fadeOut();
        }
    }






    // Schleife

    public void game(){
        gravity = 2;
        for (int i = 0; i < 400; i++) {
            springer.verschiebe(0,gravity,0,2);
            gravity -= 0.005;
            Sys.warte();
        }

        System.out.println("\n### Spiel gestartet! ###\n");
        boolean run = true;

        while (run){
            double[] springerKoordinatenLowest = springer.gibKoordinaten(true);
            double[] springerKoordinaten = springer.gibKoordinaten(false);
            for (int i = 0; i < plattform.length; i++) {
                // Plattform Hitboxen
                double[] plattformKoordinaten = plattform[i].gibKoordinaten();
                // Die ersten beiden Zahlen sind die Koordinaten für die Kanten rechts und links (auf der x Achse) und die dritte und vierte Zahl die Koordinaten für die Kanten oben und unten (auf der y Achse)
                double[] plattformKanten = {plattformKoordinaten[0] - 42.5, plattformKoordinaten[0] + 42.5, plattformKoordinaten[1], plattformKoordinaten[1] + 15};
                if (springerKoordinatenLowest[0] >= plattformKanten[0] && springerKoordinatenLowest[0] <= plattformKanten[1]){
                    if (springerKoordinatenLowest[1] >= plattformKanten[2] && springerKoordinatenLowest[1] <= plattformKanten[3]){
                        if (gravity <= 0){
                            if (plattform[i].plattformTyp == 0){
                                gravity = 1.2;
                            } else if (plattform[i].plattformTyp == 1){
                                gravity = 2.5;
                            } else if (plattform[i].plattformTyp == 2){
                                if (plattform[i].active) {
                                    gravity = 1.2;
                                    plattform[i].animation = true;
                                    plattform[i].active = false;
                                    if (muenzenEin) {
                                        muenze[i].active = false;
                                        muenze[i].setzePosition(0, 500, 1);
                                    }
                                    if (benzinEin) {
                                        benzin[i].active = false;
                                        benzin[i].setzePosition(0, 500, 1);
                                    }
                                    if (jetpackEin) {
                                        jetpack[i].active = false;
                                        jetpack[i].setzePosition(0, 500, 1);
                                    }
                                }
                            }
                        }
                    }
                }
                // Zerbrechende Plattformen
                if (plattform[i].animation){
                    plattform[i].animiere();
                }
                // Muenzen Hitboxen
                if (muenzenEin) {
                    if (muenze[i].active) {
                        double[] muenzenKoordinaten = muenze[i].gibKoordinaten();
                        // Selbes Prinzip, wie bei den Plattformen
                        double[] muenzenKanten = {muenzenKoordinaten[0] - 23.5, muenzenKoordinaten[0] + 23.5, muenzenKoordinaten[1] - 10, muenzenKoordinaten[1] + 25};
                        if (springerKoordinatenLowest[0] >= muenzenKanten[0] && springerKoordinatenLowest[0] <= muenzenKanten[1]) {
                            if (springerKoordinatenLowest[1] >= muenzenKanten[2] && springerKoordinatenLowest[1] <= muenzenKanten[3]) {
                                muenze[i].active = false;
                                muenze[i].collected();
                                muenze[i].setzePosition(0, 500, 1);
                                coinSum++;
                                anzeige.updateCounter(2);
                            }
                        }
                    }
                }
                // Benzin Hitboxen
                if (benzinEin) {
                    if (benzin[i].active) {
                        double[] benzinKoordinaten = benzin[i].gibKoordinaten();
                        // Selbes Prinzip, wie bei den Plattformen
                        double[] benzinKanten = {benzinKoordinaten[0] - 23.5, benzinKoordinaten[0] + 23.5, benzinKoordinaten[1] - 10, benzinKoordinaten[1] + 25};
                        if (springerKoordinatenLowest[0] >= benzinKanten[0] && springerKoordinatenLowest[0] <= benzinKanten[1]) {
                            if (springerKoordinatenLowest[1] >= benzinKanten[2] && springerKoordinatenLowest[1] <= benzinKanten[3]) {
                                benzin[i].active = false;
                                benzin[i].collected();
                                benzin[i].setzePosition(0, 500, 1);
                                benzinSum++;
                                benzinTimer += benzinWorth;
                                anzeige.updateCounter(1);
                            }
                        }
                    }
                }
                // Jetpack Hitboxen
                if (jetpackEin) {
                    if (jetpack[i].active) {
                        double[] jetpackKoordinaten = jetpack[i].gibKoordinaten();
                        // Selbes Prinzip, wie bei den Plattformen
                        double[] jetpackKanten = {jetpackKoordinaten[0] - 23.5, jetpackKoordinaten[0] + 23.5, jetpackKoordinaten[1] - 10, jetpackKoordinaten[1] + 25};
                        if (springerKoordinatenLowest[0] >= jetpackKanten[0] && springerKoordinatenLowest[0] <= jetpackKanten[1]) {
                            if (springerKoordinatenLowest[1] >= jetpackKanten[2] && springerKoordinatenLowest[1] <= jetpackKanten[3]) {
                                jetpack[i].active = false;
                                jetpack[i].collected();
                                jetpack[i].setzePosition(0, 500, 1);
                                jetpackFuel = 5000;
                                jetpackSum++;
                            }
                        }
                    }
                }
                // Überprüfen, ob die Plattform unter -280 kommt (und zurückgesetzt wird)
                if (plattformKoordinaten[1] <= -280) {
                    // Die Plattform wird zurückgesetzt
                    plattform[i].setzePosition(ThreadLocalRandom.current().nextInt(-250, 251), topplat, 1);
                    topplat += 50;
                    plattform[i].plattformTyp = 0;
                    plattform[i].active = true;
                    plattform[i].animation = false;
                    plattform[i].setzeSichtbarkeit(true);
                    plattform[i].setzeFarbe(0,0.5,1);
                    if (muenzenEin) {
                        muenze[i].active = false;
                        muenze[i].setzePosition(0, 500, 1);
                    }
                    if (benzinEin) {
                        benzin[i].active = false;
                        benzin[i].setzePosition(0, 500, 1);
                    }
                    if (jetpackEin) {
                        jetpack[i].active = false;
                        jetpack[i].setzePosition(0, 500, 1);
                    }
                    // Es wird zufällig entschieden, ob die Plattform eine Fähigkeit enthält
                    int plattformGen = ThreadLocalRandom.current().nextInt(0,11);
                    if (plattformGen == 1){
                        plattform[i].plattformTyp = 1;
                        plattform[i].setzeFarbe(0,1,0.2);
                    } else if (plattformGen == 2){
                        plattform[i].plattformTyp = 2;
                        plattform[i].setzeFarbe(1.1,0.3, 0.15);
                    }
                    // Es wird zufällig entschieden, ob die Plattform ein Powerup enthält
                    int powerUpGen = ThreadLocalRandom.current().nextInt(0, 11);
                    if (powerUpGen == 1 && muenzenEin) {
                        muenze[i].active = true;
                    } else if (powerUpGen == 2 && benzinEin) {
                        benzin[i].active = true;
                    } else if (jetpackEin) {
                        int jetpackGen = ThreadLocalRandom.current().nextInt(0,100);
                        if (jetpackGen == 1) {
                            jetpack[i].active = true;
                        }
                    }
                    // Die Höhen Anzeige wird erhöht, welche die Wahrscheinlichkeit erhöht, dass der einzig wahre Erling Haaland spawnt
                    hoehenAnzeige.verschiebePointer(0.5);
                    bossProzent = hoehenAnzeige.gibProzent();
                    int wahrscheinlichkeit = (int) bossProzent + 10;
                    wahrscheinlichkeit = ThreadLocalRandom.current().nextInt(0, wahrscheinlichkeit * 3);
                    if (wahrscheinlichkeit == 1 && !bossActive && jetpackFuel == 0){
                        System.out.println("HAALAND IST ERSCHIENEN!");
                        bossActive = true;
                        haaland = new Haaland();
                        haaland.bossAnimation = 1000;
                        hoehenAnzeige.verschiebePointer(-500);
                        hoehenAnzeige.gibProzent();
                    }
                    if (jetpackFuel > 0) {
                        hoehenAnzeige.verschiebePointer(-0.5);
                    }
                }
                // Setze die Powerups an die Position der dementsprechenden Plattformen
                if (muenzenEin) {
                    if (muenze[i].active) {
                        muenze[i].setzePosition(plattformKoordinaten[0], plattformKoordinaten[1] + 25, 1);
                    }
                    // Animation für alle Powerups
                    if (globalPowerUpAnim > 0) {
                        muenze[i].drehe(0.72, 0, 0.2);
                    } else if (globalPowerUpAnim < 0){
                        muenze[i].drehe(0, 0, -0.2);
                    }
                }
                if (benzinEin) {
                    if (benzin[i].active) {
                        benzin[i].setzePosition(plattformKoordinaten[0], plattformKoordinaten[1] + 25, 1);
                    }
                    // Animation für alle Powerups
                    if (globalPowerUpAnim > 0) {
                        benzin[i].drehe(0, 0, 0.2);
                    } else if (globalPowerUpAnim < 0){
                        benzin[i].drehe(0, 0, -0.2);
                    }
                }
                if (jetpackEin) {
                    if (jetpack[i].active) {
                        jetpack[i].setzePosition(plattformKoordinaten[0], plattformKoordinaten[1] + 35 + jetpack[i].relCoords, 1);
                    }
                    // Animation für alle Powerups
                    if (globalPowerUpAnim > 0) {
                        jetpack[i].relCoords += 0.04;
                    } else if (globalPowerUpAnim < 0){
                        jetpack[i].relCoords -= 0.04;
                    }
                }


            }



            // Pausen Menu
            if (tastatur.esc()){
                System.out.println(" - Spiel pausiert!");
                pausenMenu = new PausenMenu();
                boolean reset = pausenMenu.warte();
                pausenMenu.loesche();
                System.out.println(" - Pause aufgehoben!\n");
                if (reset){
                    System.out.println("### Spiel aufgegeben! ### \n\nDu hast aufgegeben!\");");
                    run = false;
                }
            }




            // Berechnungen

            timeSurvived++;

            // Jetpack Timer
            if (jetpackEin) {
                if (jetpackFuel > 400) {
                    jetpackFuel--;
                    gravity += 0.015;
                    if (gravity > 0.6) {
                        gravity = 0.6;
                    }
                    movePoint = -100;
                    springer.animate(true);
                }
                if (jetpackFuel <= 400 && jetpackFuel > 0) {
                    movePoint = 100;
                    jetpackFuel--;
                    gravity += 0.01;
                    if (gravity > 0.4) {
                        gravity = 0.4;
                    }
                    springer.animate(false);
                }
                if (jetpackFuel == 1) {
                    springer.resetAnim();
                }
            }
            // Benzin Timer und Tank Anzeige
            if (benzinEin) {
                benzinTimer--;
                if (benzinTimer > 20000){
                    benzinTimer = 20000;
                }
                if (benzinTimer <= 0){
                    System.out.println("### Spiel verloren! ### \n\nDu hast kein Benzin mehr!");
                    run = false;
                }
                tankAnzeige.setzePosition(tankAnzeige.gibX(),((float) benzinTimer / 44) - 440, tankAnzeige.gibZ());
            }
            // Benzin Warnung
            if (benzinEin) {
                if (benzinTimer < 7000){
                    lowBenzin.setzePosition(165,260,5);
                    if (lowBenzAnim <= 500){
                        lowBenzAnim++;
                        lowBenzin.setzeFarbe(1,0,0);
                    } else if (lowBenzAnim <= 1000){
                        lowBenzAnim++;
                        lowBenzin.setzeFarbe(1,1,0);
                    } else {
                        lowBenzAnim = 0;
                    }
                } else {
                    lowBenzAnim = 0;
                    lowBenzin.setzeFarbe(1,1,1);
                    lowBenzin.setzePosition(0,500,0);
                }
            }


            // Verschiebung des Springers und Festlegung der Schwerkraft
            springer.verschiebe(0,gravity,0,2);
            gravity -= 0.003;
            if (gravity <= -1){
                gravity = -1;
            }
            // Überprüfen, ob der Springer aus dem Bild fällt
            if (springerKoordinaten[1] <= -300){
                System.out.println("### Spiel verloren! ### \nDu bist aus der Welt gefallen!\n");
                run = false;
            }

            double hintergrundBewegung = this.springerBewegung(springerKoordinaten);
            // PowerUp Animation Redirect
            this.powerUpAnim(hintergrundBewegung);
            // Boss Redirect
            this.bossEvent(springerKoordinaten);
            // Dev Option Redirect
            this.devOption();

            // Warten
            Sys.warte(1);
        }
        reset(optionLast);
    }

    public double springerBewegung(double[] springerKoordinaten) {
        // Springer Bewegung
        double hintergrundBewegung = 0;
        if (tastatur.istGedrueckt('a') || tastatur.links()){
            springer.verschiebe(-0.65,0,0,0);
        }
        if (tastatur.istGedrueckt('d') || tastatur.rechts()){
            springer.verschiebe(0.65,0,0,1);
        }
        // Springer teleportation (von rechts nach links und umgekehrt)
        if (springerKoordinaten[0] >= 280){
            springer.setzePosition(-289,springerKoordinaten[1] + 15,0,2);
        }
        if (springerKoordinaten[0] <= -290){
            springer.setzePosition(279,springerKoordinaten[1] + 15,0,2);
        }
        // Verschiebung der Plattformen
        if (springerKoordinaten[1] >= movePoint && gravity >= 0){
            for (Plattform value : plattform) {
                value.verschiebe(0, -gravity - ((springerKoordinaten[1] - movePoint) / 400));
            }
            springer.verschiebe(0, -gravity - ((springerKoordinaten[1] - movePoint) / 400), 0, 2);
            topplat -= gravity - ((springerKoordinaten[1] - movePoint) / 400);
            hintergrundBewegung -= gravity - ((springerKoordinaten[1] - movePoint) / 400);
        }
        // Verschiebung der Hintergründe
        if (springerKoordinaten[1] >= movePoint && gravity >= 0) {
            hg1.verschiebe(0, -gravity * 0.5, 0);
            hg2.verschiebe(0, -gravity * 0.5, 0);
            hg3.verschiebe(0, -gravity * 0.5, 0);
            hg4.verschiebe(0, -gravity * 0.5, 0);
            hg5.verschiebe(0, -gravity * 0.5, 0);
            hg6.verschiebe(0, -gravity * 0.5, 0);
        }
        if (hg1.gibY() <= -500) {
            hg1.setzePosition(hg1.gibX(), hg3.gibY() + 411, -20);
            hg4.setzePosition(hg4.gibX(), hg3.gibY() + 411, -20);
        }
        if (hg2.gibY() <= -500) {
            hg2.setzePosition(hg2.gibX(), hg1.gibY() + 411, -20);
            hg5.setzePosition(hg5.gibX(), hg1.gibY() + 411, -20);
        }
        if (hg3.gibY() <= -500) {
            hg3.setzePosition(hg3.gibX(), hg2.gibY() + 411, -20);
            hg6.setzePosition(hg6.gibX(), hg2.gibY() + 411, -20);
        }
        return hintergrundBewegung;
    }
    // PowerUp Animation
    public void powerUpAnim(double hintergrundBewegung) {
        // Powerup Animationen
        globalPowerUpAnim++;
        if (globalPowerUpAnim > 500){
            globalPowerUpAnim = -500;
        }
        if (benzinEin) {
            for (int i = 0; i < 15; i++) {
                if (benzin[i].isAnimation()) {
                    benzin[i].animate(hintergrundBewegung);
                }
            }
        }
        if (muenzenEin) {
            for (int i = 0; i < 15; i++) {
                if (muenze[i].isAnimation()) {
                    muenze[i].animate(hintergrundBewegung);
                }
            }
        }
        if (jetpackEin) {
            for (int i = 0; i < 15; i++) {
                if (jetpack[i].isAnimation()) {
                    jetpack[i].animate(hintergrundBewegung);
                }
            }
        }
    }
    // Boss Event
    public void bossEvent(double[] springerKoordinaten) {
        if (bossActive){
            if (haaland.bossAnimation > 0 && haaland.state == 1){
                haaland.verschiebe(0,0.2,0);
                haaland.bossAnimation--;
            } else if (haaland.bossAnimation > 0 && haaland.state == 2){
                int sk;
                if (haaland.bossAnimation > 2800){
                    sk = 250;
                    haaland.verschiebe(0.25,0,0);
                } else {
                    sk = -250;
                    haaland.verschiebe(-0.25,0,0);
                }
                if (haaland.bossAnimation == 2800){
                    haaland.setzeTextur("haaland_running_left.png");
                }
                haaland.bossAnimation--;
                double[] haalandKoordinaten = haaland.gibKoordinaten();
                if (haalandKoordinaten[1] >= springerKoordinaten[1]){
                    haaland.verschiebe(0,-0.1,0);
                } else {
                    haaland.verschiebe(0,0.1,0);
                }
                if (springerKoordinaten[0] > haalandKoordinaten[0] - 30 && springerKoordinaten[0] < haalandKoordinaten[0] + 30){
                    if (springerKoordinaten[1] > haalandKoordinaten[1] - 100 && springerKoordinaten[1] < haalandKoordinaten[1] + 100){
                        springerKick = sk;
                    }
                }
                // System.out.println("Debug: -> haaland.running, bossAnimation: " + haaland.bossAnimation);
            } else if (haaland.bossAnimation > 0 && haaland.state == 3){
                haaland.verschiebe(0,-0.2,0);
                haaland.bossAnimation--;
            }
            if (haaland.bossAnimation == 0 && haaland.state == 1){
                int start = ThreadLocalRandom.current().nextInt(0,2000);
                if (start == 1){
                    //System.out.println("Debug: -> haaland.state = 2");
                    haaland.changeState(2);
                    haaland.state = 2;
                    haaland.setzePosition(-300,springerKoordinaten[1],4);
                    haaland.bossAnimation = 5600;
                }
            }
            if (haaland.bossAnimation == 0 && haaland.state == 2){
                //System.out.println("Debug: -> haaland.state = 3");
                haaland.changeState(3);
                haaland.state = 3;
                haaland.setzePosition(300,300,4);
                haaland.bossAnimation = 3000;
            }
            if (haaland.bossAnimation == 0 && haaland.state == 3){
                haaland.loesche();
                bossActive = false;
            }
            hoehenAnzeige.verschiebePointer(-10);
        }
        if (springerKick > 0){
            springer.verschiebe((float) springerKick / 70,0,0,2);
            springerKick--;
        }
        if (springerKick < 0){
            springer.verschiebe((float) springerKick / 70,0,0,2);
            springerKick++;
        }
    }
    // Dev Option
    public void devOption() {
        if (tastatur.istGedrueckt('o') && !devCamOn){
            // Entwicklerkamera aktivieren
            System.out.println("Entwicklerkamera aktiviert!");
            devCam = new GLEntwicklerkamera(1400, 1000);
            devCamOn = true;
            gravityActive = false;
        }
        if (devCamOn) {
            if (!gravityActive) {
                benzinTimer = 10000;
                if (tastatur.istGedrueckt('w')) {
                    gravity = 1;
                } else if (tastatur.istGedrueckt('s')) {
                    gravity = -1;
                } else {
                    gravity = 0;
                }
            }
            if (tastatur.istGedrueckt('o')) {
                gravityActive = false;
            }
            if (tastatur.istGedrueckt('i')) {
                gravityActive = true;
            }
        }

    }
    // Reset Funktion
    private void reset(boolean[] optionOw){
        System.out.println("Aufruf des Endmenus...");
        endMenu = new EndMenu(false);
        boolean quickStart = endMenu.endScreen();
        // Zurücksetzen des Spiels (Löschen aller Objekte, Zurücksetzen der Variablen)
        anzeige.loesche();
        springer.loesche();
        wandLinks.loesche();
        wandRechts.loesche();
        trennStrich.loesche();
        if (benzinEin){
            tankAnzeige.loesche();
            tankRoehre2.loesche();
            tankRoehre1.loesche();
            tankHintergrund.loesche();
            lowBenzin.loesche();
            for (Benzin value : benzin) {
                value.loesche();
            }
        }
        if (muenzenEin){
            for (Muenze value : muenze) {
                value.loesche();
            }
        }
        if (jetpackEin){
            for (Jetpack value : jetpack) {
                value.loesche();
            }
        }
        for (Plattform value : plattform) {
            value.loesche();
        }
        hg1.loesche();
        hg2.loesche();
        hg3.loesche();
        hg4.loesche();
        hg5.loesche();
        hg6.loesche();
        hoehenAnzeige.loesche();
        coinSession += coinSum;
        coinSum = 0;
        benzinSum = 0;
        jetpackSum = 0;
        if (bossActive){
            bossActive = false;
            haaland.loesche();
        }
        System.out.println("Das Spiel wurde vollständig zurückgesetzt! Der Neustart wird ausgeführt...\n\n------------------------");
        // Neustart
        if (quickStart) {
            optionOWW = optionOw;
        } else {
            optionOWW = new boolean[] {false};
        }
        //Sys.beenden();
    }
    // Start
    private void initiate(boolean[] optionOw, boolean quickstart){
        if(quickstart) {
            System.out.println("\nEs wird kein Menu aufgerufen...");
            endMenu = new EndMenu(true);
        }
        optionLast = optionOw;
        benzinEin = optionOw[3];
        muenzenEin = optionOw[2];
        jetpackEin = optionOw[1];

        System.out.println("Das Spiel wird nun mit folgenden Optionen gestartet:");

        if (benzinEin){
            System.out.println(" - Benzin ist aktiviert!");
        } else {
            System.out.println(" - Benzin ist nicht aktiviert!");
        }
        if (muenzenEin){
            System.out.println(" - Muenzen sind aktiviert!");
        } else {
            System.out.println(" - Muenzen sind nicht aktiviert!");
        }
        if (jetpackEin){
            System.out.println(" - Jetpacks sind aktiviert!");
        } else {
            System.out.println(" - Jetpacks sind nicht aktiviert!");
        }

        System.out.println("Erstellen des Spiels...");
    }
}
