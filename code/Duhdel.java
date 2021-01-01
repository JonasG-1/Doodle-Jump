import GLOOP.*;

import java.util.concurrent.ThreadLocalRandom;

public class Duhdel {
    GLKamera Kamera;
    GLLicht Licht;

    GLQuader Springer, wandLinks, wandRechts, Hintergrund1, Hintergrund2, Hintergrund3, Hintergrund4, Hintergrund5,
            Hintergrund6, tBlock, greyScreen, Strich, Tank, Leer, CoinTafel1, CoinTafel2, CoinTafel3, Abschluss,
            Benzin1, Benzin2, Benzin3, Anzeige, pauseScreen, pauseTafel, enter_esc, frame, auswahlEins, auswahlZwei,
            resetMenu, TankUeberdeckung;
    GLZylinder Nase, AugeEins, AugeZwei;
    GLTastatur Tastatur;
    GLEntwicklerkamera devCam;

    // Konstruktor

    public Duhdel() {

        wandLinks = new GLQuader(-800, 0, 0, 1005, 3000, 1);
        wandRechts = new GLQuader(800, 0, 0, 1025, 3000, 1);
        Hintergrund1 = new GLQuader(-200, -200, -20, 405, 411, 0, "background3.png");
        Hintergrund2 = new GLQuader(-200, 211, -20, 405, 411, 0, "background3.png");
        Hintergrund3 = new GLQuader(-200, 622, -20, 405, 411, 0, "background3.png");
        Hintergrund4 = new GLQuader(200, -200, -20, 405, 411, 0, "background3.png");
        Hintergrund5 = new GLQuader(200, 211, -20, 405, 411, 0, "background3.png");
        Hintergrund6 = new GLQuader(200, 622, -20, 405, 411, 0, "background3.png");
        Tastatur = new GLTastatur();
        wandLinks.setzeFarbe(0.1, 0.1, 0.1);
        wandRechts.setzeFarbe(0.1, 0.1, 0.1);

        Springer = new GLQuader(0, 0, -0.3, 20, 25, 5);
        Nase = new GLZylinder(10, 5, -0.2, 5, 4.7);
        AugeEins = new GLZylinder(-5, 6, 0, 1.5, 6);
        AugeZwei = new GLZylinder(5, 6, 0, 1.5, 6);
        AugeEins.setzeFarbe(0, 0, 0);
        AugeZwei.setzeFarbe(0, 0, 0);
        Nase.setzeFarbe(0.1, 1, 0.2);
        tBlock = new GLQuader(0, -280, 0, 60, 10, 0);
        Springer.setzeFarbe(0.1, 1, 0.2);
        Tank = new GLQuader(330, -200, 8, 35, 250, 0);
        Leer = new GLQuader(328.5, -260, 8.5, 39, 15, 0);
        Leer.setzeFarbe(1, 0, 0);
        Tank.setzeFarbe(0, 1, 0);
        greyScreen = new GLQuader(0, 0, 10, 1200, 700, 10);
        greyScreen.setzeFarbe(0.1, 0.1, 0.1);

    }

    // Springer Reset

    public void springerReset() {
        System.out.println("     ðŸ¡¶  Der Springer wird zurÃ¼ckgesetzt!");
        Springer.loesche();
        AugeEins.loesche();
        AugeZwei.loesche();
        Nase.loesche();
        Springer = new GLQuader(0, 0, -0.3, 20, 25, 5);
        Nase = new GLZylinder(10, 5, -0.2, 5, 4.7);
        AugeEins = new GLZylinder(-5, 6, 0, 1.5, 6);
        AugeZwei = new GLZylinder(5, 6, 0, 1.5, 6);
        AugeEins.setzeFarbe(0, 0, 0);
        AugeZwei.setzeFarbe(0, 0, 0);
        Springer.setzeFarbe(0.1, 1, 0.2);
        Nase.setzeFarbe(0.1, 1, 0.2);
    }

    // Spiel

    public void PlatformEngine(int preOption) {
        System.out.println("\n\n--------------------\nâ˜† â˜†  Neues Spiel â˜† â˜†\n--------------------\n");

        boolean SpielLaeuft = true;

        // ------------------------------------------
        // Vorbereitung:
        // ------------------------------------------

        // Constructor (uses):

        Platform pfCon = new Platform();
        Schwerkraft skCon = new Schwerkraft();
        Events evCon = new Events();

        // Plattformen

        System.out.println("[âš  ] Plattformen setzen...");
        pfCon.szeneAufbauen();
    pfCon.kugelSetzen();

        // Menu (Falls keine Option forher gesetzt wurde)

        int benzinan = 1;
        int muenzean = 1;
        if (preOption < 1) {
            System.out.println("\n[âš  ] Das Menu wird aufgerufen!\n     Warte auf Auswahl der Einstellungen...");
            Screen scCon = new Screen();
            int option = scCon.menScreen();
            System.out.println("[â�Ÿ ] Option " + option + " wurde ausgewÃ¤hlt! Auswerten...");

            switch (option) {
                case 1:
                    benzinan = 1;
                    muenzean = 1;
                    break;
                case 2:
                    benzinan = 1;
                    muenzean = 0;
                    break;
                case 3:
                    benzinan = 0;
                    muenzean = 1;
                    break;
                case 4:
                    benzinan = 0;
                    muenzean = 0;
                    break;
                default:
                    System.out.println("[â˜¢ ] Ein Fehler ist aufgetreten!");
                    Sys.beenden();
            }
        } else {
            switch (preOption) {
                case 1:
                    benzinan = 1;
                    muenzean = 1;
                    break;
                case 2:
                    benzinan = 1;
                    muenzean = 0;
                    break;
                case 3:
                    benzinan = 0;
                    muenzean = 1;
                    break;
                case 4:
                    benzinan = 0;
                    muenzean = 0;
                    break;
                default:
                    System.out.println("[â˜¢ ] Ein Fehler ist aufgetreten!");
                    Sys.beenden();

            }
            System.out.println("\n[â�Ÿ ] Option " + preOption + " wurde ausgewÃ¤hlt! Auswerten...");
        }
        if (benzinan == 1) {
            System.out.println("     Die Option 'Benzin' ist eingeschaltet!");
        } else {
            System.out.println("     Die Option 'Benzin' ist ausgeschaltet!");
            TankUeberdeckung = new GLQuader(800, 0, 10, 1025, 3000, 1);
            TankUeberdeckung.setzeFarbe(0.1, 0.1, 0.1);
        }
        if (muenzean == 1) {
            System.out.println("     Die Option 'MÃ¼nzen' ist eingeschaltet!");
        } else {
            System.out.println("     Die Option 'MÃ¼nzen' ist ausgeschaltet!");
        }

        int mCount = 0;
        while (mCount <= 520) {
            greyScreen.verschiebe(0, -1, 0);
            mCount++;
            Sys.warte();
        }
        while (mCount <= 800) {
            greyScreen.verschiebe(0, -0.4, 0);
            mCount++;
            Sys.warte();
        }
        mCount = 0;

        greyScreen.loesche();

        System.out.println("\n[âš  ] Das Spiel wird vorbereitet...");

        // Schwerkraft/Coins/Benzin

        double topplat = 750;
        double gravity = -0.5;
        int grCount = 0;
        int rsCount = 0;
        int noseSide = 10;
        int coinSum = 0;
        int timeSurvived = 0;
        int coinDrei = 0;
        int coinZwei = 0;
        int coinEins = 0;
        int benzDrei = 0;
        int benzZwei = 0;
        int benzEins = 0;
        int benzSum = 0;
        int benzTimer = 17000;
        int benzPlus = 4000;
        int anzeigean = 0;
        int devcam = 0;

        // Events & Loot

        int event1 = 0;
        int event2 = 0;
        int event3 = 0;
        int event4 = 0;
        int event5 = 0;
        int event6 = 0;
        int event7 = 0;
        int event8 = 0;
        int event9 = 0;
        int event10 = 0;
        int event11 = 0;
        int event12 = 0;
        int event13 = 0;
        int event14 = 0;
        int event15 = 0;
        int loot1 = 0;
        int loot2 = 0;
        int loot3 = 0;
        int loot4 = 0;
        int loot5 = 0;
        int loot6 = 0;
        int loot7 = 0;
        int loot8 = 0;
        int loot9 = 0;
        int loot10 = 0;
        int loot11 = 0;
        int loot12 = 0;
        int loot13 = 0;
        int loot14 = 0;
        int loot15 = 0;

        // Timer - warten (200 millis)

        System.out.println("[âš  ] VerzÃ¶gern des Start des Programmes um 200ms...");
        try {
            Thread.sleep(200);
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }
        System.out.println("[âš  ] Vorbereitungen abgeschlossen!");

        // ------------------------------------------
        // Spielstart:
        // ------------------------------------------

        System.out.println("\n[âš  ] --- Das Spiel wird gestartet! ---\n");
        while (SpielLaeuft) {

            if (Tastatur.istGedrueckt('o') && devcam == 0) {
                System.out.println("[âš  ] Entwicklerkamera wird aktiviert...");
                try {
                    devCam.loesche();
                } catch (Exception ex) {
                    System.out
                            .println("[â˜¢ ] Ein Fehler ist aufgetreten, Entwicklerkamera konnte nicht entfernt werden!");
                }
                System.out.println("[âš  ] Entwicklerkamera aktiviert!");
                devCam = new GLEntwicklerkamera(1400, 1000);
                devcam = 1;
            }

            // --------------
            // Timer (Lebenszeit)
            // --------------

            if (benzinan == 1) {
                if (timeSurvived == 20000) {
                    benzPlus = 3500;
                    Anzeige = new GLQuader(0, 250, 20, 500, 30, 0, "warnung.png");
                    anzeigean = 1;
                }
                if (timeSurvived == 24000) {
                    Anzeige.loesche();
                    anzeigean = 0;
                }
                if (timeSurvived == 40000) {
                    benzPlus = 3000;
                    Anzeige = new GLQuader(0, 250, 20, 500, 30, 0, "warnung.png");
                    anzeigean = 1;
                }
                if (timeSurvived == 44000) {
                    Anzeige.loesche();
                    anzeigean = 0;
                }
                if (timeSurvived == 70000) {
                    benzPlus = 2500;
                    Anzeige = new GLQuader(0, 250, 20, 500, 30, 0, "warnung.png");
                    anzeigean = 1;
                }
                if (timeSurvived == 74000) {
                    Anzeige.loesche();
                    anzeigean = 0;
                }
                if (timeSurvived == 90000) {
                    benzPlus = 2000;
                    Anzeige = new GLQuader(0, 250, 20, 500, 30, 0, "warnung.png");
                    anzeigean = 1;
                }
                if (timeSurvived == 94000) {
                    Anzeige.loesche();
                    anzeigean = 0;
                }
                if (timeSurvived == 110000) {
                    benzPlus = 1500;
                    Anzeige = new GLQuader(0, 250, 20, 500, 30, 0, "warnung.png");
                    anzeigean = 1;
                }
                if (timeSurvived == 114000) {
                    Anzeige.loesche();
                    anzeigean = 0;
                }
            }

            // --------------
            // Hitboxen
            // --------------

            // Springer Hitbox (& Skin)

            double lSpringer = Springer.gibX();
            double hSpringer = Springer.gibY();
            Nase.setzePosition(lSpringer + noseSide, hSpringer + 4, 0);
            AugeEins.setzePosition(lSpringer - 5, hSpringer + 6, 0);
            AugeZwei.setzePosition(lSpringer + 5, hSpringer + 6, 0);

            // Loot Hibtox

            if (muenzean == 1) {
                int lootHit = evCon.springerHit(0, lSpringer, hSpringer, 0);
                switch (lootHit) {
                    case 1:
                        loot1 = 0;
                        coinSum = coinSum + 1;
                        break;
                    case 2:
                        loot2 = 0;
                        coinSum = coinSum + 1;
                        break;
                    case 3:
                        loot3 = 0;
                        coinSum = coinSum + 1;
                        break;
                    case 4:
                        loot4 = 0;
                        coinSum = coinSum + 1;
                        break;
                    case 5:
                        loot5 = 0;
                        coinSum = coinSum + 1;
                        break;
                    case 6:
                        loot6 = 0;
                        coinSum = coinSum + 1;
                        break;
                    case 7:
                        loot7 = 0;
                        coinSum = coinSum + 1;
                        break;
                    case 8:
                        loot8 = 0;
                        coinSum = coinSum + 1;
                        break;
                    case 9:
                        loot9 = 0;
                        coinSum = coinSum + 1;
                        break;
                    case 10:
                        loot10 = 0;
                        coinSum = coinSum + 1;
                        break;
                    case 11:
                        loot11 = 0;
                        coinSum = coinSum + 1;
                        break;
                    case 12:
                        loot12 = 0;
                        coinSum = coinSum + 1;
                        break;
                    case 13:
                        loot13 = 0;
                        coinSum = coinSum + 1;
                        break;
                    case 14:
                        loot14 = 0;
                        coinSum = coinSum + 1;
                        break;
                    case 15:
                        loot15 = 0;
                        coinSum = coinSum + 1;
                        break;
                }
            }

            if (benzinan == 1) {
                int benzHit = evCon.springerHitBenzin(0, lSpringer, hSpringer, 0);
                switch (benzHit) {
                    case 1:
                        loot1 = 0;
                        benzHit = 0;
                        benzSum = benzSum + 1;
                        benzTimer = benzTimer + benzPlus;
                        break;
                    case 2:
                        loot2 = 0;
                        benzHit = 0;
                        benzSum = benzSum + 1;
                        benzTimer = benzTimer + benzPlus;
                        break;
                    case 3:
                        loot3 = 0;
                        benzHit = 0;
                        benzSum = benzSum + 1;
                        benzTimer = benzTimer + benzPlus;
                        break;
                    case 4:
                        loot4 = 0;
                        benzHit = 0;
                        benzSum = benzSum + 1;
                        benzTimer = benzTimer + benzPlus;
                        break;
                    case 5:
                        loot5 = 0;
                        benzHit = 0;
                        benzSum = benzSum + 1;
                        benzTimer = benzTimer + benzPlus;
                        break;
                    case 6:
                        loot6 = 0;
                        benzHit = 0;
                        benzSum = benzSum + 1;
                        benzTimer = benzTimer + benzPlus;
                        break;
                    case 7:
                        loot7 = 0;
                        benzHit = 0;
                        benzSum = benzSum + 1;
                        benzTimer = benzTimer + benzPlus;
                        break;
                    case 8:
                        loot8 = 0;
                        benzHit = 0;
                        benzSum = benzSum + 1;
                        benzTimer = benzTimer + benzPlus;
                        break;
                    case 9:
                        loot9 = 0;
                        benzHit = 0;
                        benzSum = benzSum + 1;
                        benzTimer = benzTimer + benzPlus;
                        break;
                    case 10:
                        loot10 = 0;
                        benzHit = 0;
                        benzSum = benzSum + 1;
                        benzTimer = benzTimer + benzPlus;
                        break;
                    case 11:
                        loot11 = 0;
                        benzHit = 0;
                        benzSum = benzSum + 1;
                        benzTimer = benzTimer + benzPlus;
                        break;
                    case 12:
                        loot12 = 0;
                        benzHit = 0;
                        benzSum = benzSum + 1;
                        benzTimer = benzTimer + benzPlus;
                        break;
                    case 13:
                        loot13 = 0;
                        benzHit = 0;
                        benzSum = benzSum + 1;
                        benzTimer = benzTimer + benzPlus;
                        break;
                    case 14:
                        loot14 = 0;
                        benzHit = 0;
                        benzSum = benzSum + 1;
                        benzTimer = benzTimer + benzPlus;
                        break;
                    case 15:
                        loot15 = 0;
                        benzHit = 0;
                        benzSum = benzSum + 1;
                        benzTimer = benzTimer + benzPlus;
                        break;

                }
            } else {
                benzTimer = 20000;
            }

            // Fehler Verhinderung - Benzin Timer
            if (benzTimer >= 20000) {
                benzTimer = 20000;
            }

            // Plattform Hitboxen

            double hp1 = pfCon.gibposY(1);
            double hp2 = pfCon.gibposY(2);
            double hp3 = pfCon.gibposY(3);
            double hp4 = pfCon.gibposY(4);
            double hp5 = pfCon.gibposY(5);
            double hp6 = pfCon.gibposY(6);
            double hp7 = pfCon.gibposY(7);
            double hp8 = pfCon.gibposY(8);
            double hp9 = pfCon.gibposY(9);
            double hp10 = pfCon.gibposY(10);
            double hp11 = pfCon.gibposY(11);
            double hp12 = pfCon.gibposY(12);
            double hp13 = pfCon.gibposY(13);
            double hp14 = pfCon.gibposY(14);
            double hp15 = pfCon.gibposY(15);
            double lp1 = pfCon.gibposX(1);
            double lp2 = pfCon.gibposX(2);
            double lp3 = pfCon.gibposX(3);
            double lp4 = pfCon.gibposX(4);
            double lp5 = pfCon.gibposX(5);
            double lp6 = pfCon.gibposX(6);
            double lp7 = pfCon.gibposX(7);
            double lp8 = pfCon.gibposX(8);
            double lp9 = pfCon.gibposX(9);
            double lp10 = pfCon.gibposX(10);
            double lp11 = pfCon.gibposX(11);
            double lp12 = pfCon.gibposX(12);
            double lp13 = pfCon.gibposX(13);
            double lp14 = pfCon.gibposX(14);
            double lp15 = pfCon.gibposX(15);

            double p1hitr = lp1 + 45;
            double p1hitl = lp1 - 45;
            double p2hitr = lp2 + 45;
            double p2hitl = lp2 - 45;
            double p3hitr = lp3 + 45;
            double p3hitl = lp3 - 45;
            double p4hitr = lp4 + 45;
            double p4hitl = lp4 - 45;
            double p5hitr = lp5 + 45;
            double p5hitl = lp5 - 45;
            double p6hitr = lp6 + 45;
            double p6hitl = lp6 - 45;
            double p7hitr = lp7 + 45;
            double p7hitl = lp7 - 45;
            double p8hitr = lp8 + 45;
            double p8hitl = lp8 - 45;
            double p9hitr = lp9 + 45;
            double p9hitl = lp9 - 45;
            double p10hitr = lp10 + 45;
            double p10hitl = lp10 - 45;
            double p11hitr = lp11 + 45;
            double p11hitl = lp11 - 45;
            double p12hitr = lp12 + 45;
            double p12hitl = lp12 - 45;
            double p13hitr = lp13 + 45;
            double p13hitl = lp13 - 45;
            double p14hitr = lp14 + 45;
            double p14hitl = lp14 - 45;
            double p15hitr = lp15 + 45;
            double p15hitl = lp15 - 45;
            double p1hith = hp1 + 10;
            double p2hith = hp2 + 10;
            double p3hith = hp3 + 10;
            double p4hith = hp4 + 10;
            double p5hith = hp5 + 10;
            double p6hith = hp6 + 10;
            double p7hith = hp7 + 10;
            double p8hith = hp8 + 10;
            double p9hith = hp9 + 10;
            double p10hith = hp10 + 10;
            double p11hith = hp11 + 10;
            double p12hith = hp12 + 10;
            double p13hith = hp13 + 10;
            double p14hith = hp14 + 10;
            double p15hith = hp15 + 10;

            // Benzin Anzeige

            if (benzinan == 1) {
                int benzMinus = benzTimer / 75;
                Tank.setzePosition(330, -400 + benzMinus, 10);
            }

            // --------------
            // Kollision mit Springer
            // --------------

            if (gravity <= 0 && hSpringer >= hp1 && hSpringer <= p1hith) {
                if (lSpringer <= p1hitr && lSpringer >= p1hitl) {
                    switch (event1) {
                        case 1:
                            break;
                        case 2:
                            gravity = 1;
                            break;
                        default:
                            gravity = 0.5;
                    }
                }
            }
            if (gravity <= 0 && hSpringer >= hp2 && hSpringer <= p2hith) {
                if (lSpringer <= p2hitr && lSpringer >= p2hitl) {
                    switch (event2) {
                        case 1:
                            break;
                        case 2:
                            gravity = 1;
                            break;
                        default:
                            gravity = 0.5;
                    }
                }
            }
            if (gravity <= 0 && hSpringer >= hp3 && hSpringer <= p3hith) {
                if (lSpringer <= p3hitr && lSpringer >= p3hitl) {
                    switch (event3) {
                        case 1:
                            break;
                        case 2:
                            gravity = 1;
                            break;
                        default:
                            gravity = 0.5;
                    }
                }
            }
            if (gravity <= 0 && hSpringer >= hp4 && hSpringer <= p4hith) {
                if (lSpringer <= p4hitr && lSpringer >= p4hitl) {
                    switch (event4) {
                        case 1:
                            break;
                        case 2:
                            gravity = 1;
                            break;
                        default:
                            gravity = 0.5;
                    }
                }
            }
            if (gravity <= 0 && hSpringer >= hp5 && hSpringer <= p5hith) {
                if (lSpringer <= p5hitr && lSpringer >= p5hitl) {
                    switch (event5) {
                        case 1:
                            break;
                        case 2:
                            gravity = 1;
                            break;
                        default:
                            gravity = 0.5;
                    }
                }
            }
            if (gravity <= 0 && hSpringer >= hp6 && hSpringer <= p6hith) {
                if (lSpringer <= p6hitr && lSpringer >= p6hitl) {
                    switch (event6) {
                        case 1:
                            break;
                        case 2:
                            gravity = 1;
                            break;
                        default:
                            gravity = 0.5;
                    }
                }
            }
            if (gravity <= 0 && hSpringer >= hp7 && hSpringer <= p7hith) {
                if (lSpringer <= p7hitr && lSpringer >= p7hitl) {
                    switch (event7) {
                        case 1:
                            break;
                        case 2:
                            gravity = 1;
                            break;
                        default:
                            gravity = 0.5;
                    }
                }
            }
            if (gravity <= 0 && hSpringer >= hp8 && hSpringer <= p8hith) {
                if (lSpringer <= p8hitr && lSpringer >= p8hitl) {
                    switch (event8) {
                        case 1:
                            break;
                        case 2:
                            gravity = 1;
                            break;
                        default:
                            gravity = 0.5;
                    }
                }
            }
            if (gravity <= 0 && hSpringer >= hp9 && hSpringer <= p9hith) {
                if (lSpringer <= p9hitr && lSpringer >= p9hitl) {
                    switch (event9) {
                        case 1:
                            break;
                        case 2:
                            gravity = 1;
                            break;
                        default:
                            gravity = 0.5;
                    }
                }
            }
            if (gravity <= 0 && hSpringer >= hp10 && hSpringer <= p10hith) {
                if (lSpringer <= p10hitr && lSpringer >= p10hitl) {
                    switch (event10) {
                        case 1:
                            break;
                        case 2:
                            gravity = 1;
                            break;
                        default:
                            gravity = 0.5;
                    }
                }
            }
            if (gravity <= 0 && hSpringer >= hp11 && hSpringer <= p11hith) {
                if (lSpringer <= p11hitr && lSpringer >= p11hitl) {
                    switch (event11) {
                        case 1:
                            break;
                        case 2:
                            gravity = 1;
                            break;
                        default:
                            gravity = 0.5;
                    }
                }
            }
            if (gravity <= 0 && hSpringer >= hp12 && hSpringer <= p12hith) {
                if (lSpringer <= p12hitr && lSpringer >= p12hitl) {
                    switch (event12) {
                        case 1:
                            break;
                        case 2:
                            gravity = 1;
                            break;
                        default:
                            gravity = 0.5;
                    }
                }
            }
            if (gravity <= 0 && hSpringer >= hp13 && hSpringer <= p13hith) {
                if (lSpringer <= p13hitr && lSpringer >= p13hitl) {
                    switch (event13) {
                        case 1:
                            break;
                        case 2:
                            gravity = 1;
                            break;
                        default:
                            gravity = 0.5;
                    }
                }
            }
            if (gravity <= 0 && hSpringer >= hp14 && hSpringer <= p14hith) {
                if (lSpringer <= p14hitr && lSpringer >= p14hitl) {
                    switch (event14) {
                        case 1:
                            break;
                        case 2:
                            gravity = 1;
                            break;
                        default:
                            gravity = 0.5;
                    }
                }
            }
            if (gravity <= 0 && hSpringer >= hp15 && hSpringer <= p15hith) {
                if (lSpringer <= p15hitr && lSpringer >= p15hitl) {
                    switch (event15) {
                        case 1:
                            break;
                        case 2:
                            gravity = 1;
                            break;
                        default:
                            gravity = 0.5;
                    }
                }
            }

            // --------------
            // Hitboxen Ende
            // --------------

            // --------------
            // Spieler Bewegungen/EinflÃ¼sse (Tastatur)
            // --------------

            if (Tastatur.rechts() || Tastatur.istGedrueckt('d')) {
                Springer.verschiebe(0.35, 0, 0);
                noseSide = 10;
            }
            if (Tastatur.links() || Tastatur.istGedrueckt('a')) {
                Springer.verschiebe(-0.35, 0, 0);
                noseSide = -10;
            }
            if (lSpringer >= 280) {
                Springer.setzePosition(-289, hSpringer, 0);
            }
            if (lSpringer <= -290) {
                Springer.setzePosition(279, hSpringer, 0);
            }
            if (hSpringer >= 100 && gravity >= 0) {
                pfCon.verschiebe(16, -gravity);
                Springer.verschiebe(0, -gravity, 0);
                topplat -= gravity;
            }
            if (Tastatur.esc()) {
                System.out.println("[â�¸ ] Das Spiel wurde pausiert!");
                pauseScreen = new GLQuader(0, 0, 40, 450, 300, 1);
                pauseScreen.setzeFarbe(0.1, 0.1, 0.1);
                pauseTafel = new GLQuader(0, 0, 42, 400, 100, 1, "pausiert.png");
                while (Tastatur.esc()) {
                }
                while (!Tastatur.esc() && !Tastatur.enter()) {
                }
                while (Tastatur.esc() || Tastatur.enter()) {
                }
                pauseScreen.loesche();
                pauseTafel.loesche();
                System.out.println("[â–¶ ] Das Spiel geht jetzt weiter!");
            }

            // --------------
            // Verloren ÃœberprÃ¼fen
            // --------------

            if (hSpringer <= -280 || benzTimer <= 0) {

                // Tafel = new GLTafel(0,0,100,400,200);
                SpielLaeuft = false;
                greyScreen = new GLQuader(0, -700, 10, 1200, 700, 10);
                greyScreen.setzeFarbe(0.1, 0.1, 0.1);
                if (anzeigean == 1) {
                    Anzeige.loesche();
                }

                // Animation (fade-in)

                while (rsCount <= 520) {
                    greyScreen.verschiebe(0, 1, 0);
                    rsCount++;
                    Sys.warte();
                }
                while (rsCount <= 800) {
                    greyScreen.verschiebe(0, 0.4, 0);
                    rsCount++;
                    Sys.warte();
                }
                rsCount = 0;

                // Ãœberleben Berechnen (Sekunden) -> Ausgabe in Konsole (vorerst)

                float secondsSurvived = (float) timeSurvived / 1000;
                System.out.println("\n[âžœ ] --- Spiel vorbei! ---");
                System.out.println("[âžœ ] âœ§  " + secondsSurvived + " (Spiel)Sekunden Ã¼berlebt! âœ§");
                System.out.println("[âžœ ] âœ§  " + coinSum + " MÃ¼nzen gesammelt! âœ§");
                System.out.println("[âžœ ] âœ§  " + benzSum + " Benzinkanister gesammelt! âœ§");

                // Anzeigen erstellen

                evCon.setzeCoin(1, -65, 2.5, 40);
                evCon.setzeCoinDrehung(1, 0, 0, 0);
                evCon.setzeBenzin(1, -65, -67.5, 40);
                evCon.setzeBenzinDrehung(1, 0, 0, 0);
                CoinTafel1 = new GLQuader(-30, 0, 40, 25, 50, 0);
                CoinTafel2 = new GLQuader(0, 0, 40, 25, 50, 0);
                CoinTafel3 = new GLQuader(30, 0, 40, 25, 50, 0);
                Benzin1 = new GLQuader(-30, -70, 40, 25, 50, 0);
                Benzin2 = new GLQuader(0, -70, 40, 25, 50, 0);
                Benzin3 = new GLQuader(30, -70, 40, 25, 50, 0);
                Abschluss = new GLQuader(0, 110, 40, 450, 100, 0, "schade.png");
                Strich = new GLQuader(0, 60, 40, 200, 2, 1);
                Strich.setzeFarbe(1, 1, 1);
                enter_esc = new GLQuader(0, -147.5, 40, 281.25, 31.25, 0, "esc_enter-druecken.png");
                frame = new GLQuader(0, 0, 38, 450, 480, 0, "end_frame.png");
                CoinTafel1.setzeTextur("0.png");
                CoinTafel2.setzeTextur("0.png");
                CoinTafel3.setzeTextur("0.png");
                Benzin1.setzeTextur("0.png");
                Benzin2.setzeTextur("0.png");
                Benzin3.setzeTextur("0.png");
                auswahlEins = new GLQuader(-150, 340, 42, 10, 10, 0);
                auswahlEins.setzeFarbe(1, 1, 0);
                auswahlEins.setzeDrehung(0, 0, 45);
                auswahlZwei = new GLQuader(150, 340, 42, 10, 10, 0);
                auswahlZwei.setzeFarbe(1, 1, 0);
                auswahlZwei.setzeDrehung(0, 0, 45);
                resetMenu = new GLQuader(0, 310, 40, 500, 100, 0, "resetMenu.png");
                if (benzinan == 0) {
                    try {
                        TankUeberdeckung.loesche();
                    } catch (Exception ex) {
                        System.out.println("[â˜¢ ] Ein Fehler ist aufgetreten!");
                    }

                }

                // Punkte berechnen

                while (coinSum >= 100) {
                    coinSum = coinSum - 100;
                    coinDrei = coinDrei + 1;
                    switch (coinDrei) {
                        case 1:
                            CoinTafel1.setzeTextur("1.png");
                            break;
                        case 2:
                            CoinTafel1.setzeTextur("2.png");
                            break;
                        case 3:
                            CoinTafel1.setzeTextur("3.png");
                            break;
                        case 4:
                            CoinTafel1.setzeTextur("4.png");
                            break;
                        case 5:
                            CoinTafel1.setzeTextur("5.png");
                            break;
                        case 6:
                            CoinTafel1.setzeTextur("6.png");
                            break;
                        case 7:
                            CoinTafel1.setzeTextur("7.png");
                            break;
                        case 8:
                            CoinTafel1.setzeTextur("8.png");
                            break;
                        default:
                            CoinTafel1.setzeTextur("9.png");
                            break;
                    }
                    Sys.warte(100);
                }
                while (coinSum >= 10) {
                    coinSum = coinSum - 10;
                    coinZwei = coinZwei + 1;
                    switch (coinZwei) {
                        case 1:
                            CoinTafel2.setzeTextur("1.png");
                            break;
                        case 2:
                            CoinTafel2.setzeTextur("2.png");
                            break;
                        case 3:
                            CoinTafel2.setzeTextur("3.png");
                            break;
                        case 4:
                            CoinTafel2.setzeTextur("4.png");
                            break;
                        case 5:
                            CoinTafel2.setzeTextur("5.png");
                            break;
                        case 6:
                            CoinTafel2.setzeTextur("6.png");
                            break;
                        case 7:
                            CoinTafel2.setzeTextur("7.png");
                            break;
                        case 8:
                            CoinTafel2.setzeTextur("8.png");
                            break;
                        default:
                            CoinTafel2.setzeTextur("9.png");
                            break;
                    }
                    Sys.warte(100);
                }
                while (coinSum >= 1) {
                    coinSum = coinSum - 1;
                    coinEins = coinEins + 1;
                    switch (coinEins) {
                        case 1:
                            CoinTafel3.setzeTextur("1.png");
                            break;
                        case 2:
                            CoinTafel3.setzeTextur("2.png");
                            break;
                        case 3:
                            CoinTafel3.setzeTextur("3.png");
                            break;
                        case 4:
                            CoinTafel3.setzeTextur("4.png");
                            break;
                        case 5:
                            CoinTafel3.setzeTextur("5.png");
                            break;
                        case 6:
                            CoinTafel3.setzeTextur("6.png");
                            break;
                        case 7:
                            CoinTafel3.setzeTextur("7.png");
                            break;
                        case 8:
                            CoinTafel3.setzeTextur("8.png");
                            break;
                        default:
                            CoinTafel3.setzeTextur("9.png");
                            break;
                    }
                    Sys.warte(100);
                }
                while (benzSum >= 100) {
                    benzSum = benzSum - 100;
                    benzDrei = benzDrei + 1;
                    switch (benzDrei) {
                        case 1:
                            Benzin1.setzeTextur("1.png");
                            break;
                        case 2:
                            Benzin1.setzeTextur("2.png");
                            break;
                        case 3:
                            Benzin1.setzeTextur("3.png");
                            break;
                        case 4:
                            Benzin1.setzeTextur("4.png");
                            break;
                        case 5:
                            Benzin1.setzeTextur("5.png");
                            break;
                        case 6:
                            Benzin1.setzeTextur("6.png");
                            break;
                        case 7:
                            Benzin1.setzeTextur("7.png");
                            break;
                        case 8:
                            Benzin1.setzeTextur("8.png");
                            break;
                        default:
                            Benzin1.setzeTextur("9.png");
                            break;
                    }
                    Sys.warte(100);
                }
                while (benzSum >= 10) {
                    benzSum = benzSum - 10;
                    benzZwei = benzZwei + 1;
                    switch (benzZwei) {
                        case 1:
                            Benzin2.setzeTextur("1.png");
                            break;
                        case 2:
                            Benzin2.setzeTextur("2.png");
                            break;
                        case 3:
                            Benzin2.setzeTextur("3.png");
                            break;
                        case 4:
                            Benzin2.setzeTextur("4.png");
                            break;
                        case 5:
                            Benzin2.setzeTextur("5.png");
                            break;
                        case 6:
                            Benzin2.setzeTextur("6.png");
                            break;
                        case 7:
                            Benzin2.setzeTextur("7.png");
                            break;
                        case 8:
                            Benzin2.setzeTextur("8.png");
                            break;
                        default:
                            Benzin2.setzeTextur("9.png");
                            break;
                    }
                    Sys.warte(100);
                }
                while (benzSum >= 1) {
                    benzSum = benzSum - 1;
                    benzEins = benzEins + 1;
                    switch (benzEins) {
                        case 1:
                            Benzin3.setzeTextur("1.png");
                            break;
                        case 2:
                            Benzin3.setzeTextur("2.png");
                            break;
                        case 3:
                            Benzin3.setzeTextur("3.png");
                            break;
                        case 4:
                            Benzin3.setzeTextur("4.png");
                            break;
                        case 5:
                            Benzin3.setzeTextur("5.png");
                            break;
                        case 6:
                            Benzin3.setzeTextur("6.png");
                            break;
                        case 7:
                            Benzin3.setzeTextur("7.png");
                            break;
                        case 8:
                            Benzin3.setzeTextur("8.png");
                            break;
                        default:
                            Benzin3.setzeTextur("9.png");
                            break;
                    }
                    Sys.warte(100);
                }

                // Warten auf Reset (esc/enter drÃ¼cken)

                int doReset = 0;
                int am1State = 0;
                int zaehler = 0;
                int animationAuswahl = 1;
                int gedrueckt = 0;
                int hoehe = 1;
                int waitForReset = 0;
                while (waitForReset == 0) {
                    if (Tastatur.esc() == true || Tastatur.enter() == true && am1State == 0) {
                        int am1Counter = 0;
                        if (am1State == 0) {
                            while (am1Counter <= 225) {
                                Strich.verschiebe(0, -0.5, 0);
                                CoinTafel3.verschiebe(0, -0.5, 0);
                                CoinTafel2.verschiebe(0, -0.5, 0);
                                CoinTafel1.verschiebe(0, -0.5, 0);
                                Benzin3.verschiebe(0, -0.5, 0);
                                Benzin2.verschiebe(0, -0.5, 0);
                                Benzin1.verschiebe(0, -0.5, 0);
                                Abschluss.verschiebe(0, -0.5, 0);
                                frame.verschiebe(0, -0.5, 0);
                                enter_esc.verschiebe(0, -0.5, 0);
                                evCon.verschiebeCoin(1, 0, -0.5, 0);
                                evCon.verschiebeBenzin(1, 0, -0.5, 0);
                                resetMenu.verschiebe(0, -0.5, 0);
                                auswahlEins.verschiebe(0, -0.5, 0);
                                auswahlZwei.verschiebe(0, -0.5, 0);
                                am1Counter++;
                                Sys.warte();
                            }
                            am1State = 1;
                        }

                        am1Counter = 0;
                        while (Tastatur.esc() == true || Tastatur.enter() == true) {
                        }
                        waitForReset = 1;
                    }
                }
                while (doReset == 0) {

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
                    if (Tastatur.oben() || Tastatur.istGedrueckt('w') || Tastatur.unten() || Tastatur.istGedrueckt('s')
                            || Tastatur.enter()) {
                        if (gedrueckt == 0) {
                            if (Tastatur.oben() || Tastatur.istGedrueckt('w')) {
                                hoehe = hoehe + 1;
                                if (hoehe >= 2) {
                                    hoehe = 1;
                                }
                            } else if (Tastatur.unten() || Tastatur.istGedrueckt('s')) {
                                hoehe = hoehe - 1;
                                if (hoehe <= -1) {
                                    hoehe = 0;
                                }
                            } else if (Tastatur.enter()) {
                                switch (hoehe) {
                                    case 1:
                                        doReset = 1;
                                        break;
                                    case 0:
                                        doReset = 1;
                                        benzinan = 2;
                                        break;
                                    default:
                                        System.out.println("[â˜¢ ] Ein Fehler ist aufgetreten!");
                                        Sys.beenden();
                                }
                            }
                        }
                        gedrueckt = 1;
                    } else {
                        gedrueckt = 0;
                    }

                    if (gedrueckt == 1) {
                        switch (hoehe) {
                            case 1:
                                auswahlEins.setzePosition(auswahlEins.gibX(), 340 - (225 * 0.5), 42);
                                auswahlZwei.setzePosition(auswahlZwei.gibX(), 340 - (225 * 0.5), 42);
                                animationAuswahl = 1;
                                zaehler = 0;
                                break;
                            case 0:
                                auswahlEins.setzePosition(auswahlEins.gibX(), 300 - (225 * 0.5), 42);
                                auswahlZwei.setzePosition(auswahlZwei.gibX(), 300 - (225 * 0.5), 42);
                                animationAuswahl = 1;
                                zaehler = 0;
                                break;
                            default:
                                System.out.println("[â˜¢ ] Ein Fehler ist aufgetreten!");
                                Sys.beenden();

                        }

                        zaehler++;
                        Sys.warte();
                    }
                }

                // Reset

                System.out.println("\n[âš  ] ZurÃ¼cksetzen:");
                evCon.szeneReset();
                pfCon.szeneReset();
                springerReset();
                Strich.loesche();
                CoinTafel3.loesche();
                CoinTafel2.loesche();
                CoinTafel1.loesche();
                Benzin3.loesche();
                Benzin2.loesche();
                Benzin1.loesche();
                Abschluss.loesche();
                frame.loesche();
                enter_esc.loesche();
                resetMenu.loesche();
                auswahlEins.loesche();
                auswahlZwei.loesche();

                // Animation (fade-out)

                // greyScreen.loesche();
                // Tafel.loesche();
                System.out.println("\n[âš  ] Neustart wird eingeleitet!\n");

                // Funktionsneustart

                /**
                 * Options: case 1 benzinan = 1; muenzean = 1; || case 2: benzinan = 1; muenzean
                 * = 0; || case 3: benzinan = 0; muenzean = 1; || case 4: benzinan = 0; muenzean
                 * = 0;
                 */

                int optionRestart = 0;
                switch (benzinan) {
                    case 1:
                        if (muenzean == 1) {
                            optionRestart = 1;
                        } else {
                            optionRestart = 2;
                        }
                        System.out.println("[â�Ÿ ] Das Spiel wird mit den letzten bekannten Einstellungen gestartet!");
                        break;
                    case 0:
                        if (muenzean == 1) {
                            optionRestart = 3;
                        } else {
                            optionRestart = 4;
                        }
                        System.out.println("[â�Ÿ ] Das Spiel wird mit den letzten bekannten Einstellungen gestartet!");
                        break;
                    default:
                        optionRestart = 0;
                        System.out.println("[â�Ÿ ] Das Spiel wird neugestartet und das Menu wird aufgerufen!");
                }
                System.out.println("[â�Ÿ ] Das Spiel wird mit der Option " + optionRestart + " neugestartet.");
                PlatformEngine(optionRestart);
            }

            // --------------
            // Spielerbewegungen Ende
            // --------------

            // --------------
            // Plattform Resets & Events
            // --------------

            if (hp1 <= -280) {
                int p1pv = ThreadLocalRandom.current().nextInt(-250, 250 + 1);
                double p1ph = topplat;
                // System.out.println("Platform (P1) verschoben: X: " + p1pv + ", Y: " + p1ph);
                pfCon.setzePosition(1, p1pv, p1ph);
                topplat += 50;
                pfCon.setzeFarbe(1, 0, 0.5, 1);
                pfCon.setzeKugelFarbe(1, 0, 0.5, 1);
                event1 = evCon.EventGen(1, event1);
                loot1 = evCon.LootGen(1, loot1, benzinan, muenzean);
            }
            if (event1 == 1) {
                pfCon.setzeFarbe(1, 1, 0, 0);
                pfCon.setzeKugelFarbe(1, 1, 0, 0);
            } else if (event1 == 2) {
                pfCon.setzeFarbe(1, 0, 1, 0);
                pfCon.setzeKugelFarbe(1, 0, 1, 0);
            }
            if (hp2 <= -280) {
                int p2pv = ThreadLocalRandom.current().nextInt(-250, 250 + 1);
                double p2ph = topplat;
                // System.out.println("Platform (P2) verschoben: X: " + p2pv + ", Y: " + p2ph);
                pfCon.setzePosition(2, p2pv, p2ph);
                topplat += 50;
                pfCon.setzeFarbe(2, 0, 0.5, 1);
                pfCon.setzeKugelFarbe(2, 0, 0.5, 1);
                event2 = evCon.EventGen(2, event2);
                loot2 = evCon.LootGen(2, loot2, benzinan, muenzean);
            }
            if (event2 == 1) {
                pfCon.setzeFarbe(2, 1, 0, 0);
                pfCon.setzeKugelFarbe(2, 1, 0, 0);
            } else if (event2 == 2) {
                pfCon.setzeFarbe(2, 0, 1, 0);
                pfCon.setzeKugelFarbe(2, 0, 1, 0);
            }
            if (hp3 <= -280) {
                int p3pv = ThreadLocalRandom.current().nextInt(-250, 250 + 1);
                double p3ph = topplat;
                // System.out.println("Platform (P3) verschoben: X: " + p3pv + ", Y: " + p3ph);
                pfCon.setzePosition(3, p3pv, p3ph);
                topplat += 50;
                pfCon.setzeFarbe(3, 0, 0.5, 1);
                pfCon.setzeKugelFarbe(3, 0, 0.5, 1);
                event3 = evCon.EventGen(3, event3);
                loot3 = evCon.LootGen(3, loot3, benzinan, muenzean);
            }
            if (event3 == 1) {
                pfCon.setzeFarbe(3, 1, 0, 0);
                pfCon.setzeKugelFarbe(3, 1, 0, 0);
            } else if (event3 == 2) {
                pfCon.setzeFarbe(3, 0, 1, 0);
                pfCon.setzeKugelFarbe(3, 0, 1, 0);
            }
            if (hp4 <= -280) {
                int p4pv = ThreadLocalRandom.current().nextInt(-250, 250 + 1);
                double p4ph = topplat;
                // System.out.println("Platform (P4) verschoben: X: " + p4pv + ", Y: " + p4ph);
                pfCon.setzePosition(4, p4pv, p4ph);
                topplat += 50;
                pfCon.setzeFarbe(4, 0, 0.5, 1);
                pfCon.setzeKugelFarbe(4, 0, 0.5, 1);
                event4 = evCon.EventGen(4, event4);
                loot4 = evCon.LootGen(4, loot4, benzinan, muenzean);
            }
            if (event4 == 1) {
                pfCon.setzeFarbe(4, 1, 0, 0);
                pfCon.setzeKugelFarbe(4, 1, 0, 0);
            } else if (event4 == 2) {
                pfCon.setzeFarbe(4, 0, 1, 0);
                pfCon.setzeKugelFarbe(4, 0, 1, 0);
            }
            if (hp5 <= -280) {
                int p5pv = ThreadLocalRandom.current().nextInt(-250, 250 + 1);
                double p5ph = topplat;
                // System.out.println("Platform (P5) verschoben: X: " + p5pv + ", Y: " + p5ph);
                pfCon.setzePosition(5, p5pv, p5ph);
                topplat += 50;
                pfCon.setzeFarbe(5, 0, 0.5, 1);
                pfCon.setzeKugelFarbe(5, 0, 0.5, 1);
                event5 = evCon.EventGen(5, event5);
                loot5 = evCon.LootGen(5, loot5, benzinan, muenzean);
            }
            if (event5 == 1) {
                pfCon.setzeFarbe(5, 1, 0, 0);
                pfCon.setzeKugelFarbe(5, 1, 0, 0);
            } else if (event5 == 2) {
                pfCon.setzeFarbe(5, 0, 1, 0);
                pfCon.setzeKugelFarbe(5, 0, 1, 0);
            }
            if (hp6 <= -280) {
                int p6pv = ThreadLocalRandom.current().nextInt(-250, 250 + 1);
                double p6ph = topplat;
                // System.out.println("Platform (P6) verschoben: X: " + p6pv + ", Y: " + p6ph);
                pfCon.setzePosition(6, p6pv, p6ph);
                topplat += 50;
                pfCon.setzeFarbe(6, 0, 0.5, 1);
                pfCon.setzeKugelFarbe(6, 0, 0.5, 1);
                event6 = evCon.EventGen(6, event6);
                loot6 = evCon.LootGen(6, loot6, benzinan, muenzean);
            }
            if (event6 == 1) {
                pfCon.setzeFarbe(6, 1, 0, 0);
                pfCon.setzeKugelFarbe(6, 1, 0, 0);
            } else if (event6 == 2) {
                pfCon.setzeFarbe(6, 0, 1, 0);
                pfCon.setzeKugelFarbe(6, 0, 1, 0);
            }
            if (hp7 <= -280) {
                int p7pv = ThreadLocalRandom.current().nextInt(-250, 250 + 1);
                double p7ph = topplat;
                // System.out.println("Platform (P7) verschoben: X: " + p7pv + ", Y: " + p7ph);
                pfCon.setzePosition(7, p7pv, p7ph);
                topplat += 50;
                pfCon.setzeFarbe(7, 0, 0.5, 1);
                pfCon.setzeKugelFarbe(7, 0, 0.5, 1);
                event7 = evCon.EventGen(7, event7);
                loot7 = evCon.LootGen(7, loot7, benzinan, muenzean);
            }
            if (event7 == 1) {
                pfCon.setzeFarbe(7, 1, 0, 0);
                pfCon.setzeKugelFarbe(7, 1, 0, 0);
            } else if (event7 == 2) {
                pfCon.setzeFarbe(7, 0, 1, 0);
                pfCon.setzeKugelFarbe(7, 0, 1, 0);
            }
            if (hp8 <= -280) {
                int p8pv = ThreadLocalRandom.current().nextInt(-250, 250 + 1);
                double p8ph = topplat;
                // System.out.println("Platform (P8) verschoben: X: " + p8pv + ", Y: " + p8ph);
                pfCon.setzePosition(8, p8pv, p8ph);
                topplat += 50;
                pfCon.setzeFarbe(8, 0, 0.5, 1);
                pfCon.setzeKugelFarbe(8, 0, 0.5, 1);
                event8 = evCon.EventGen(8, event8);
                loot8 = evCon.LootGen(8, loot8, benzinan, muenzean);
            }
            if (event8 == 1) {
                pfCon.setzeFarbe(8, 1, 0, 0);
                pfCon.setzeKugelFarbe(8, 1, 0, 0);
            } else if (event8 == 2) {
                pfCon.setzeFarbe(8, 0, 1, 0);
                pfCon.setzeKugelFarbe(8, 0, 1, 0);
            }
            if (hp9 <= -280) {
                int p9pv = ThreadLocalRandom.current().nextInt(-250, 250 + 1);
                double p9ph = topplat;
                // System.out.println("Platform (P9) verschoben: X: " + p9pv + ", Y: " + p9ph);
                pfCon.setzePosition(9, p9pv, p9ph);
                topplat += 50;
                pfCon.setzeFarbe(9, 0, 0.5, 1);
                pfCon.setzeKugelFarbe(9, 0, 0.5, 1);
                event9 = evCon.EventGen(9, event9);
                loot9 = evCon.LootGen(9, loot9, benzinan, muenzean);
            }
            if (event9 == 1) {
                pfCon.setzeFarbe(9, 1, 0, 0);
                pfCon.setzeKugelFarbe(9, 1, 0, 0);
            } else if (event9 == 2) {
                pfCon.setzeFarbe(9, 0, 1, 0);
                pfCon.setzeKugelFarbe(9, 0, 1, 0);
            }
            if (hp10 <= -280) {
                int p10pv = ThreadLocalRandom.current().nextInt(-250, 250 + 1);
                double p10ph = topplat;
                // System.out.println("Platform (P10) verschoben: X: " + p10pv + ", Y: " +
                // p10ph);
                pfCon.setzePosition(10, p10pv, p10ph);
                topplat += 50;
                pfCon.setzeFarbe(10, 0, 0.5, 1);
                pfCon.setzeKugelFarbe(10, 0, 0.5, 1);
                event10 = evCon.EventGen(10, event10);
                loot10 = evCon.LootGen(10, loot10, benzinan, muenzean);
            }
            if (event10 == 1) {
                pfCon.setzeFarbe(10, 1, 0, 0);
                pfCon.setzeKugelFarbe(10, 1, 0, 0);
            } else if (event10 == 2) {
                pfCon.setzeFarbe(10, 0, 1, 0);
                pfCon.setzeKugelFarbe(10, 0, 1, 0);
            }
            if (hp11 <= -280) {
                int p11pv = ThreadLocalRandom.current().nextInt(-250, 250 + 1);
                double p11ph = topplat;
                // System.out.println("Platform (P11) verschoben: X: " + p11pv + ", Y: " +
                // p11ph);
                pfCon.setzePosition(11, p11pv, p11ph);
                topplat += 50;
                pfCon.setzeFarbe(11, 0, 0.5, 1);
                pfCon.setzeKugelFarbe(11, 0, 0.5, 1);
                event11 = evCon.EventGen(11, event11);
                loot11 = evCon.LootGen(11, loot11, benzinan, muenzean);
            }
            if (event11 == 1) {
                pfCon.setzeFarbe(11, 1, 0, 0);
                pfCon.setzeKugelFarbe(11, 1, 0, 0);
            } else if (event11 == 2) {
                pfCon.setzeFarbe(11, 0, 1, 0);
                pfCon.setzeKugelFarbe(11, 0, 1, 0);
            }
            if (hp12 <= -280) {
                int p12pv = ThreadLocalRandom.current().nextInt(-250, 250 + 1);
                double p12ph = topplat;
                // System.out.println("Platform (P12) verschoben: X: " + p12pv + ", Y: " +
                // p12ph);
                pfCon.setzePosition(12, p12pv, p12ph);
                topplat += 50;
                pfCon.setzeFarbe(12, 0, 0.5, 1);
                pfCon.setzeKugelFarbe(12, 0, 0.5, 1);
                event12 = evCon.EventGen(12, event12);
                loot12 = evCon.LootGen(12, loot12, benzinan, muenzean);
            }
            if (event12 == 1) {
                pfCon.setzeFarbe(12, 1, 0, 0);
                pfCon.setzeKugelFarbe(12, 1, 0, 0);
            } else if (event12 == 2) {
                pfCon.setzeFarbe(12, 0, 1, 0);
                pfCon.setzeKugelFarbe(12, 0, 1, 0);
            }
            if (hp13 <= -280) {
                int p13pv = ThreadLocalRandom.current().nextInt(-250, 250 + 1);
                double p13ph = topplat;
                // System.out.println("Platform (P13) verschoben: X: " + p13pv + ", Y: " +
                // p13ph);
                pfCon.setzePosition(13, p13pv, p13ph);
                topplat += 50;
                pfCon.setzeFarbe(13, 0, 0.5, 1);
                pfCon.setzeKugelFarbe(13, 0, 0.5, 1);
                event13 = evCon.EventGen(13, event13);
                loot13 = evCon.LootGen(13, loot13, benzinan, muenzean);
            }
            if (event13 == 1) {
                pfCon.setzeFarbe(13, 1, 0, 0);
                pfCon.setzeKugelFarbe(13, 1, 0, 0);
            } else if (event13 == 2) {
                pfCon.setzeFarbe(13, 0, 1, 0);
                pfCon.setzeKugelFarbe(13, 0, 1, 0);
            }
            if (hp14 <= -280) {
                int p14pv = ThreadLocalRandom.current().nextInt(-250, 250 + 1);
                double p14ph = topplat;
                // System.out.println("Platform (P14) verschoben: X: " + p14pv + ", Y: " +
                // p14ph);
                pfCon.setzePosition(14, p14pv, p14ph);
                topplat += 50;
                pfCon.setzeFarbe(14, 0, 0.5, 1);
                pfCon.setzeKugelFarbe(14, 0, 0.5, 1);
                event14 = evCon.EventGen(14, event14);
                loot14 = evCon.LootGen(14, loot14, benzinan, muenzean);
            }
            if (event14 == 1) {
                pfCon.setzeFarbe(14, 1, 0, 0);
                pfCon.setzeKugelFarbe(14, 1, 0, 0);
            } else if (event14 == 2) {
                pfCon.setzeFarbe(14, 0, 1, 0);
                pfCon.setzeKugelFarbe(14, 0, 1, 0);
            }
            if (hp15 <= -280) {
                int p15pv = ThreadLocalRandom.current().nextInt(-250, 250 + 1);
                double p15ph = topplat;
                // System.out.println("Platform (P15) verschoben: X: " + p15pv + ", Y: " +
                // p15ph);
                pfCon.setzePosition(15, p15pv, p15ph);
                topplat += 50;
                pfCon.setzeFarbe(15, 0, 0.5, 1);
                pfCon.setzeKugelFarbe(15, 0, 0.5, 1);
                event15 = evCon.EventGen(15, event15);
                loot15 = evCon.LootGen(15, loot15, benzinan, muenzean);
            }
            if (event15 == 1) {
                pfCon.setzeFarbe(15, 1, 0, 0);
                pfCon.setzeKugelFarbe(15, 1, 0, 0);
            } else if (event15 == 2) {
                pfCon.setzeFarbe(15, 0, 1, 0);
                pfCon.setzeKugelFarbe(15, 0, 1, 0);
            }

            if (loot1 == 1) {
                evCon.setzeCoin(1, lp1, hp1 + 20, 0);
            }
            if (loot2 == 1) {
                evCon.setzeCoin(2, lp2, hp2 + 20, 0);
            }
            if (loot3 == 1) {
                evCon.setzeCoin(3, lp3, hp3 + 20, 0);
            }
            if (loot4 == 1) {
                evCon.setzeCoin(4, lp4, hp4 + 20, 0);
            }
            if (loot5 == 1) {
                evCon.setzeCoin(5, lp5, hp5 + 20, 0);
            }
            if (loot6 == 1) {
                evCon.setzeCoin(6, lp6, hp6 + 20, 0);
            }
            if (loot7 == 1) {
                evCon.setzeCoin(7, lp7, hp7 + 20, 0);
            }
            if (loot8 == 1) {
                evCon.setzeCoin(8, lp8, hp8 + 20, 0);
            }
            if (loot9 == 1) {
                evCon.setzeCoin(9, lp9, hp9 + 20, 0);
            }
            if (loot10 == 1) {
                evCon.setzeCoin(10, lp10, hp10 + 20, 0);
            }
            if (loot11 == 1) {
                evCon.setzeCoin(11, lp11, hp11 + 20, 0);
            }
            if (loot12 == 1) {
                evCon.setzeCoin(12, lp12, hp12 + 20, 0);
            }
            if (loot13 == 1) {
                evCon.setzeCoin(13, lp13, hp13 + 20, 0);
            }
            if (loot14 == 1) {
                evCon.setzeCoin(14, lp14, hp14 + 20, 0);
            }
            if (loot15 == 1) {
                evCon.setzeCoin(15, lp15, hp15 + 20, 0);
            }

            if (loot1 == 2) {
                evCon.setzeBenzin(1, lp1, hp1 + 20, 0);
            }
            if (loot2 == 2) {
                evCon.setzeBenzin(2, lp2, hp2 + 20, 0);
            }
            if (loot3 == 2) {
                evCon.setzeBenzin(3, lp3, hp3 + 20, 0);
            }
            if (loot4 == 2) {
                evCon.setzeBenzin(4, lp4, hp4 + 20, 0);
            }
            if (loot5 == 2) {
                evCon.setzeBenzin(5, lp5, hp5 + 20, 0);
            }
            if (loot6 == 2) {
                evCon.setzeBenzin(6, lp6, hp6 + 20, 0);
            }
            if (loot7 == 2) {
                evCon.setzeBenzin(7, lp7, hp7 + 20, 0);
            }
            if (loot8 == 2) {
                evCon.setzeBenzin(8, lp8, hp8 + 20, 0);
            }
            if (loot9 == 2) {
                evCon.setzeBenzin(9, lp9, hp9 + 20, 0);
            }
            if (loot10 == 2) {
                evCon.setzeBenzin(10, lp10, hp10 + 20, 0);
            }
            if (loot11 == 2) {
                evCon.setzeBenzin(11, lp11, hp11 + 20, 0);
            }
            if (loot12 == 2) {
                evCon.setzeBenzin(12, lp12, hp12 + 20, 0);
            }
            if (loot13 == 2) {
                evCon.setzeBenzin(13, lp13, hp13 + 20, 0);
            }
            if (loot14 == 2) {
                evCon.setzeBenzin(14, lp14, hp14 + 20, 0);
            }
            if (loot15 == 2) {
                evCon.setzeBenzin(15, lp15, hp15 + 20, 0);
            }

            if (loot1 == 0) {
                evCon.setzeCoin(1, lp1, 700, 0);
                evCon.setzeBenzin(1, 0, 700, 0);
            }
            if (loot2 == 0) {
                evCon.setzeCoin(2, lp2, 700, 0);
                evCon.setzeBenzin(2, 0, 700, 0);
            }
            if (loot3 == 0) {
                evCon.setzeCoin(3, lp3, 700, 0);
                evCon.setzeBenzin(3, 0, 700, 0);
            }
            if (loot4 == 0) {
                evCon.setzeCoin(4, lp4, 700, 0);
                evCon.setzeBenzin(4, 0, 700, 0);
            }
            if (loot5 == 0) {
                evCon.setzeCoin(5, lp5, 700, 0);
                evCon.setzeBenzin(5, 0, 700, 0);
            }
            if (loot6 == 0) {
                evCon.setzeCoin(6, lp6, 700, 0);
                evCon.setzeBenzin(6, 0, 700, 0);
            }
            if (loot7 == 0) {
                evCon.setzeCoin(7, lp7, 700, 0);
                evCon.setzeBenzin(7, 0, 700, 0);
            }
            if (loot8 == 0) {
                evCon.setzeCoin(8, lp8, 700, 0);
                evCon.setzeBenzin(8, 0, 700, 0);
            }
            if (loot9 == 0) {
                evCon.setzeCoin(9, lp9, 700, 0);
                evCon.setzeBenzin(9, 0, 700, 0);
            }
            if (loot10 == 0) {
                evCon.setzeCoin(10, lp10, 700, 0);
                evCon.setzeBenzin(10, 0, 700, 0);
            }
            if (loot11 == 0) {
                evCon.setzeCoin(11, lp11, 700, 0);
                evCon.setzeBenzin(11, 0, 700, 0);
            }
            if (loot12 == 0) {
                evCon.setzeCoin(12, lp12, 700, 0);
                evCon.setzeBenzin(12, 0, 700, 0);
            }
            if (loot13 == 0) {
                evCon.setzeCoin(13, lp13, 700, 0);
                evCon.setzeBenzin(13, 0, 700, 0);
            }
            if (loot14 == 0) {
                evCon.setzeCoin(14, lp14, 700, 0);
                evCon.setzeBenzin(14, 0, 700, 0);
            }
            if (loot15 == 0) {
                evCon.setzeCoin(15, lp15, 700, 0);
                evCon.setzeBenzin(15, 0, 700, 0);
            }

            evCon.animation();
            pfCon.kugelSetzen();

            // --------------
            // Plattform Reset Ende
            // --------------

            // --------------
            // Schwerkraft & Hintergrund
            // --------------

            Springer.verschiebe(0, gravity, 0);
            if (hSpringer >= 100 && gravity >= 0) {
                Hintergrund1.verschiebe(0, -gravity * 0.5, 0);
                Hintergrund2.verschiebe(0, -gravity * 0.5, 0);
                Hintergrund3.verschiebe(0, -gravity * 0.5, 0);
                Hintergrund4.verschiebe(0, -gravity * 0.5, 0);
                Hintergrund5.verschiebe(0, -gravity * 0.5, 0);
                Hintergrund6.verschiebe(0, -gravity * 0.5, 0);
            }
            if (Hintergrund1.gibY() <= -500) {
                Hintergrund1.setzePosition(Hintergrund1.gibX(), Hintergrund3.gibY() + 411, -20);
                Hintergrund4.setzePosition(Hintergrund4.gibX(), Hintergrund3.gibY() + 411, -20);
            }
            if (Hintergrund2.gibY() <= -500) {
                Hintergrund2.setzePosition(Hintergrund2.gibX(), Hintergrund1.gibY() + 411, -20);
                Hintergrund5.setzePosition(Hintergrund5.gibX(), Hintergrund1.gibY() + 411, -20);
            }
            if (Hintergrund3.gibY() <= -500) {
                Hintergrund3.setzePosition(Hintergrund3.gibX(), Hintergrund2.gibY() + 411, -20);
                Hintergrund6.setzePosition(Hintergrund6.gibX(), Hintergrund2.gibY() + 411, -20);
            }

            grCount = skCon.schwerkraftZaehler(grCount, gravity);
            gravity = skCon.schwerkraftBerechner(grCount, gravity);

            // --------------
            // Schwerkraft Ende
            // --------------

            // --------------
            // Warten
            // --------------

            try {
                Thread.sleep(1);
            } catch (Exception ex) {
                System.out.println("[â˜¢ ] Ein Fehler ist aufgetreten! Das Programm wird daher beendet!");
                System.out.println("[â˜¢ ] Fehlerbeschreibung: " + ex);
                Sys.beenden();
            }

            timeSurvived++;
            if (benzinan == 1) {
                benzTimer--;
            } else {
                benzTimer = 20000;
            }
        }
    }

}
