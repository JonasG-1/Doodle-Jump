import GLOOP.*;
import java.util.concurrent.ThreadLocalRandom;

public class Platform {
    GLZylinder p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15;
    GLKugel k1, k2, k3, k4, k5, k6, k7, k8, k9, k10, k11, k12, k13, k14, k15, k16, k17, k18, k19, k20, k21, k22, k23,
            k24, k25, k26, k27, k28, k29, k30;

    public Platform() {
        p1 = new GLZylinder(0, 700, 0, 5, 60);
        p2 = new GLZylinder(0, 700, 0, 5, 60);
        p3 = new GLZylinder(0, 700, 0, 5, 60);
        p4 = new GLZylinder(0, 700, 0, 5, 60);
        p5 = new GLZylinder(0, 700, 0, 5, 60);
        p6 = new GLZylinder(0, 700, 0, 5, 60);
        p7 = new GLZylinder(0, 700, 0, 5, 60);
        p8 = new GLZylinder(0, 700, 0, 5, 60);
        p9 = new GLZylinder(0, 700, 0, 5, 60);
        p10 = new GLZylinder(0, 700, 0, 5, 60);
        p11 = new GLZylinder(0, 700, 0, 5, 60);
        p12 = new GLZylinder(0, 700, 0, 5, 60);
        p13 = new GLZylinder(0, 700, 0, 5, 60);
        p14 = new GLZylinder(0, 700, 0, 5, 60);
        p15 = new GLZylinder(0, 700, 0, 5, 60);
        p1.setzeDrehung(0, 90, 0);
        p2.setzeDrehung(0, 90, 0);
        p3.setzeDrehung(0, 90, 0);
        p4.setzeDrehung(0, 90, 0);
        p5.setzeDrehung(0, 90, 0);
        p6.setzeDrehung(0, 90, 0);
        p7.setzeDrehung(0, 90, 0);
        p8.setzeDrehung(0, 90, 0);
        p9.setzeDrehung(0, 90, 0);
        p10.setzeDrehung(0, 90, 0);
        p11.setzeDrehung(0, 90, 0);
        p12.setzeDrehung(0, 90, 0);
        p13.setzeDrehung(0, 90, 0);
        p14.setzeDrehung(0, 90, 0);
        p15.setzeDrehung(0, 90, 0);
        k1 = new GLKugel(0, 700, 0, 5);
        k2 = new GLKugel(0, 700, 0, 5);
        k3 = new GLKugel(0, 700, 0, 5);
        k4 = new GLKugel(0, 700, 0, 5);
        k5 = new GLKugel(0, 700, 0, 5);
        k6 = new GLKugel(0, 700, 0, 5);
        k7 = new GLKugel(0, 700, 0, 5);
        k8 = new GLKugel(0, 700, 0, 5);
        k9 = new GLKugel(0, 700, 0, 5);
        k10 = new GLKugel(0, 700, 0, 5);
        k11 = new GLKugel(0, 700, 0, 5);
        k12 = new GLKugel(0, 700, 0, 5);
        k13 = new GLKugel(0, 700, 0, 5);
        k14 = new GLKugel(0, 700, 0, 5);
        k15 = new GLKugel(0, 700, 0, 5);
        k16 = new GLKugel(0, 700, 0, 5);
        k17 = new GLKugel(0, 700, 0, 5);
        k18 = new GLKugel(0, 700, 0, 5);
        k19 = new GLKugel(0, 700, 0, 5);
        k20 = new GLKugel(0, 700, 0, 5);
        k21 = new GLKugel(0, 700, 0, 5);
        k22 = new GLKugel(0, 700, 0, 5);
        k23 = new GLKugel(0, 700, 0, 5);
        k24 = new GLKugel(0, 700, 0, 5);
        k25 = new GLKugel(0, 700, 0, 5);
        k26 = new GLKugel(0, 700, 0, 5);
        k27 = new GLKugel(0, 700, 0, 5);
        k28 = new GLKugel(0, 700, 0, 5);
        k29 = new GLKugel(0, 700, 0, 5);
        k30 = new GLKugel(0, 700, 0, 5);

        p1.setzeFarbe(0, 0.5, 1);
        p2.setzeFarbe(0, 0.5, 1);
        p3.setzeFarbe(0, 0.5, 1);
        p4.setzeFarbe(0, 0.5, 1);
        p5.setzeFarbe(0, 0.5, 1);
        p6.setzeFarbe(0, 0.5, 1);
        p7.setzeFarbe(0, 0.5, 1);
        p8.setzeFarbe(0, 0.5, 1);
        p9.setzeFarbe(0, 0.5, 1);
        p10.setzeFarbe(0, 0.5, 1);
        p11.setzeFarbe(0, 0.5, 1);
        p12.setzeFarbe(0, 0.5, 1);
        p13.setzeFarbe(0, 0.5, 1);
        p14.setzeFarbe(0, 0.5, 1);
        p15.setzeFarbe(0, 0.5, 1);

        k1.setzeFarbe(0, 0.5, 1);
        k2.setzeFarbe(0, 0.5, 1);
        k3.setzeFarbe(0, 0.5, 1);
        k4.setzeFarbe(0, 0.5, 1);
        k5.setzeFarbe(0, 0.5, 1);
        k6.setzeFarbe(0, 0.5, 1);
        k7.setzeFarbe(0, 0.5, 1);
        k8.setzeFarbe(0, 0.5, 1);
        k9.setzeFarbe(0, 0.5, 1);
        k10.setzeFarbe(0, 0.5, 1);
        k11.setzeFarbe(0, 0.5, 1);
        k12.setzeFarbe(0, 0.5, 1);
        k13.setzeFarbe(0, 0.5, 1);
        k14.setzeFarbe(0, 0.5, 1);
        k15.setzeFarbe(0, 0.5, 1);
        k16.setzeFarbe(0, 0.5, 1);
        k17.setzeFarbe(0, 0.5, 1);
        k18.setzeFarbe(0, 0.5, 1);
        k19.setzeFarbe(0, 0.5, 1);
        k20.setzeFarbe(0, 0.5, 1);
        k21.setzeFarbe(0, 0.5, 1);
        k22.setzeFarbe(0, 0.5, 1);
        k23.setzeFarbe(0, 0.5, 1);
        k24.setzeFarbe(0, 0.5, 1);
        k25.setzeFarbe(0, 0.5, 1);
        k26.setzeFarbe(0, 0.5, 1);
        k27.setzeFarbe(0, 0.5, 1);
        k28.setzeFarbe(0, 0.5, 1);
        k29.setzeFarbe(0, 0.5, 1);
        k30.setzeFarbe(0, 0.5, 1);

    }

    public double gibposX(int platid) {

        double posX;

        switch (platid) {
            case 1:
                posX = p1.gibX();
                return posX;
            case 2:
                posX = p2.gibX();
                return posX;
            case 3:
                posX = p3.gibX();
                return posX;
            case 4:
                posX = p4.gibX();
                return posX;
            case 5:
                posX = p5.gibX();
                return posX;
            case 6:
                posX = p6.gibX();
                return posX;
            case 7:
                posX = p7.gibX();
                return posX;
            case 8:
                posX = p8.gibX();
                return posX;
            case 9:
                posX = p9.gibX();
                return posX;
            case 10:
                posX = p10.gibX();
                return posX;
            case 11:
                posX = p11.gibX();
                return posX;
            case 12:
                posX = p12.gibX();
                return posX;
            case 13:
                posX = p13.gibX();
                return posX;
            case 14:
                posX = p14.gibX();
                return posX;
            case 15:
                posX = p15.gibX();
                return posX;
            default:
                posX = 0;
                System.out.println("[☢ ] Ein Fehler ist aufgetreten!");
                Sys.beenden();
                return posX;
        }

    }

    public double gibposY(int platid) {
        double posY;
        switch (platid) {
            case 1:
                posY = p1.gibY();
                return posY;
            case 2:
                posY = p2.gibY();
                return posY;
            case 3:
                posY = p3.gibY();
                return posY;
            case 4:
                posY = p4.gibY();
                return posY;
            case 5:
                posY = p5.gibY();
                return posY;
            case 6:
                posY = p6.gibY();
                return posY;
            case 7:
                posY = p7.gibY();
                return posY;
            case 8:
                posY = p8.gibY();
                return posY;
            case 9:
                posY = p9.gibY();
                return posY;
            case 10:
                posY = p10.gibY();
                return posY;
            case 11:
                posY = p11.gibY();
                return posY;
            case 12:
                posY = p12.gibY();
                return posY;
            case 13:
                posY = p13.gibY();
                return posY;
            case 14:
                posY = p14.gibY();
                return posY;
            case 15:
                posY = p15.gibY();
                return posY;
            default:
                posY = 0;
                System.out.println("[☢ ] Ein Fehler ist aufgetreten!");
                Sys.beenden();
                return posY;
        }

    }

    public void verschiebe(int platid, double verschiebung) {
        switch (platid) {
            case 1:
                p1.verschiebe(0, verschiebung, 0);
                break;
            case 2:
                p2.verschiebe(0, verschiebung, 0);
                break;
            case 3:
                p3.verschiebe(0, verschiebung, 0);
                break;
            case 4:
                p4.verschiebe(0, verschiebung, 0);
                break;
            case 5:
                p5.verschiebe(0, verschiebung, 0);
                break;
            case 6:
                p6.verschiebe(0, verschiebung, 0);
                break;
            case 7:
                p7.verschiebe(0, verschiebung, 0);
                break;
            case 8:
                p8.verschiebe(0, verschiebung, 0);
                break;
            case 9:
                p9.verschiebe(0, verschiebung, 0);
                break;
            case 10:
                p10.verschiebe(0, verschiebung, 0);
                break;
            case 11:
                p11.verschiebe(0, verschiebung, 0);
                break;
            case 12:
                p12.verschiebe(0, verschiebung, 0);
                break;
            case 13:
                p13.verschiebe(0, verschiebung, 0);
                break;
            case 14:
                p14.verschiebe(0, verschiebung, 0);
                break;
            case 15:
                p15.verschiebe(0, verschiebung, 0);
                break;
            case 16:
                p1.verschiebe(0, verschiebung, 0);
                p2.verschiebe(0, verschiebung, 0);
                p3.verschiebe(0, verschiebung, 0);
                p4.verschiebe(0, verschiebung, 0);
                p5.verschiebe(0, verschiebung, 0);
                p6.verschiebe(0, verschiebung, 0);
                p7.verschiebe(0, verschiebung, 0);
                p8.verschiebe(0, verschiebung, 0);
                p9.verschiebe(0, verschiebung, 0);
                p10.verschiebe(0, verschiebung, 0);
                p11.verschiebe(0, verschiebung, 0);
                p12.verschiebe(0, verschiebung, 0);
                p13.verschiebe(0, verschiebung, 0);
                p14.verschiebe(0, verschiebung, 0);
                p15.verschiebe(0, verschiebung, 0);
                break;
            default:
                System.out.println("[☢ ] Ein Fehler ist aufgetreten!");
                Sys.beenden();
                break;
        }
    }

    public void setzePosition(int platid, int xPos, double yPos) {
        switch (platid) {
            case 1:
                p1.setzePosition(xPos, yPos, 0);
                break;
            case 2:
                p2.setzePosition(xPos, yPos, 0);
                break;
            case 3:
                p3.setzePosition(xPos, yPos, 0);
                break;
            case 4:
                p4.setzePosition(xPos, yPos, 0);
                break;
            case 5:
                p5.setzePosition(xPos, yPos, 0);
                break;
            case 6:
                p6.setzePosition(xPos, yPos, 0);
                break;
            case 7:
                p7.setzePosition(xPos, yPos, 0);
                break;
            case 8:
                p8.setzePosition(xPos, yPos, 0);
                break;
            case 9:
                p9.setzePosition(xPos, yPos, 0);
                break;
            case 10:
                p10.setzePosition(xPos, yPos, 0);
                break;
            case 11:
                p11.setzePosition(xPos, yPos, 0);
                break;
            case 12:
                p12.setzePosition(xPos, yPos, 0);
                break;
            case 13:
                p13.setzePosition(xPos, yPos, 0);
                break;
            case 14:
                p14.setzePosition(xPos, yPos, 0);
                break;
            case 15:
                p15.setzePosition(xPos, yPos, 0);
                break;
            default:
                System.out.println("[☢ ] Ein Fehler ist aufgetreten!");
                Sys.beenden();
                break;
        }
    }

    public void kugelSetzen() {
        double p1X = p1.gibX();
        double p1Y = p1.gibY();
        double p2X = p2.gibX();
        double p2Y = p2.gibY();
        double p3X = p3.gibX();
        double p3Y = p3.gibY();
        double p4X = p4.gibX();
        double p4Y = p4.gibY();
        double p5X = p5.gibX();
        double p5Y = p5.gibY();
        double p6X = p6.gibX();
        double p6Y = p6.gibY();
        double p7X = p7.gibX();
        double p7Y = p7.gibY();
        double p8X = p8.gibX();
        double p8Y = p8.gibY();
        double p9X = p9.gibX();
        double p9Y = p9.gibY();
        double p10X = p10.gibX();
        double p10Y = p10.gibY();
        double p11X = p11.gibX();
        double p11Y = p11.gibY();
        double p12X = p12.gibX();
        double p12Y = p12.gibY();
        double p13X = p13.gibX();
        double p13Y = p13.gibY();
        double p14X = p14.gibX();
        double p14Y = p14.gibY();
        double p15X = p15.gibX();
        double p15Y = p15.gibY();

        k1.setzePosition(p1X + 30, p1Y, 0);
        k2.setzePosition(p1X - 30, p1Y, 0);
        k3.setzePosition(p2X + 30, p2Y, 0);
        k4.setzePosition(p2X - 30, p2Y, 0);
        k5.setzePosition(p3X + 30, p3Y, 0);
        k6.setzePosition(p3X - 30, p3Y, 0);
        k7.setzePosition(p4X + 30, p4Y, 0);
        k8.setzePosition(p4X - 30, p4Y, 0);
        k9.setzePosition(p5X + 30, p5Y, 0);
        k10.setzePosition(p5X - 30, p5Y, 0);
        k11.setzePosition(p6X + 30, p6Y, 0);
        k12.setzePosition(p6X - 30, p6Y, 0);
        k13.setzePosition(p7X + 30, p7Y, 0);
        k14.setzePosition(p7X - 30, p7Y, 0);
        k15.setzePosition(p8X + 30, p8Y, 0);
        k16.setzePosition(p8X - 30, p8Y, 0);
        k17.setzePosition(p9X + 30, p9Y, 0);
        k18.setzePosition(p9X - 30, p9Y, 0);
        k19.setzePosition(p10X + 30, p10Y, 0);
        k20.setzePosition(p10X - 30, p10Y, 0);
        k21.setzePosition(p11X + 30, p11Y, 0);
        k22.setzePosition(p11X - 30, p11Y, 0);
        k23.setzePosition(p12X + 30, p12Y, 0);
        k24.setzePosition(p12X - 30, p12Y, 0);
        k25.setzePosition(p13X + 30, p13Y, 0);
        k26.setzePosition(p13X - 30, p13Y, 0);
        k27.setzePosition(p14X + 30, p14Y, 0);
        k28.setzePosition(p14X - 30, p14Y, 0);
        k29.setzePosition(p15X + 30, p15Y, 0);
        k30.setzePosition(p15X - 30, p15Y, 0);

    }

    /**
     * public void plattformLoeschen(int platid){ switch(platid){ case 1:
     * p1.loesche(); break; case 2: p2.loesche(); break; case 3: p3.loesche();
     * break; case 4: p4.loesche(); break; case 5: p5.loesche(); break; case 6:
     * p6.loesche(); break; case 7: p7.loesche(); break; case 8: p8.loesche();
     * break; case 9: p9.loesche(); break; case 10: p10.loesche(); break; case 11:
     * p11.loesche(); break; case 12: p12.loesche(); break; case 13: p13.loesche();
     * break; case 14: p14.loesche(); break; case 15: p15.loesche(); break; default:
     * 
     * System.out.println("[☢ ] Ein Fehler ist aufgetreten!"); Sys.beenden(); } }
     */
    /*
     * public void plattformErstellen(int platid, double posX, double posY){
     * switch(platid){ case 1: p1 = new GLQuader(posX,posY,0,60,10,0); break; case
     * 2: p2 = new GLQuader(posX,posY,0,60,10,0); break; case 3: p3 = new
     * GLQuader(posX,posY,0,60,10,0); break; case 4: p4 = new
     * GLQuader(posX,posY,0,60,10,0); break; case 5: p5 = new
     * GLQuader(posX,posY,0,60,10,0); break; case 6: p6 = new
     * GLQuader(posX,posY,0,60,10,0); break; case 7: p7 = new
     * GLQuader(posX,posY,0,60,10,0); break; case 8: p8 = new
     * GLQuader(posX,posY,0,60,10,0); break; case 9: p9 = new
     * GLQuader(posX,posY,0,60,10,0); break; case 10: p10 = new
     * GLQuader(posX,posY,0,60,10,0); break; case 11: p11 = new
     * GLQuader(posX,posY,0,60,10,0); break; case 12: p12 = new
     * GLQuader(posX,posY,0,60,10,0); break; case 13: p13 = new
     * GLQuader(posX,posY,0,60,10,0); break; case 14: p14 = new
     * GLQuader(posX,posY,0,60,10,0); break; case 15: p15 = new
     * GLQuader(posX,posY,0,60,10,0); break; default:
     * 
     * System.out.println("[☢ ] Ein Fehler ist aufgetreten!"); Sys.beenden(); } }
     */
    public void setzeFarbe(int platid, double r, double g, double b) {

        switch (platid) {
            case 1:
                p1.setzeFarbe(r, g, b);
                break;
            case 2:
                p2.setzeFarbe(r, g, b);
                break;
            case 3:
                p3.setzeFarbe(r, g, b);
                break;
            case 4:
                p4.setzeFarbe(r, g, b);
                break;
            case 5:
                p5.setzeFarbe(r, g, b);
                break;
            case 6:
                p6.setzeFarbe(r, g, b);
                break;
            case 7:
                p7.setzeFarbe(r, g, b);
                break;
            case 8:
                p8.setzeFarbe(r, g, b);
                break;
            case 9:
                p9.setzeFarbe(r, g, b);
                break;
            case 10:
                p10.setzeFarbe(r, g, b);
                break;
            case 11:
                p11.setzeFarbe(r, g, b);
                break;
            case 12:
                p12.setzeFarbe(r, g, b);
                break;
            case 13:
                p13.setzeFarbe(r, g, b);
                break;
            case 14:
                p14.setzeFarbe(r, g, b);
                break;
            case 15:
                p15.setzeFarbe(r, g, b);
                break;
            default:
                System.out.println("[☢ ] Ein Fehler ist aufgetreten!");
                Sys.beenden();
                break;
        }
    }

    public void setzeKugelFarbe(int platid, double r, double g, double b) {

        switch (platid) {
            case 1:
                k1.setzeFarbe(r, g, b);
                k2.setzeFarbe(r, g, b);
                break;
            case 2:
                k3.setzeFarbe(r, g, b);
                k4.setzeFarbe(r, g, b);
                break;
            case 3:
                k5.setzeFarbe(r, g, b);
                k6.setzeFarbe(r, g, b);
                break;
            case 4:
                k7.setzeFarbe(r, g, b);
                k8.setzeFarbe(r, g, b);
                break;
            case 5:
                k9.setzeFarbe(r, g, b);
                k10.setzeFarbe(r, g, b);
                break;
            case 6:
                k11.setzeFarbe(r, g, b);
                k12.setzeFarbe(r, g, b);
                break;
            case 7:
                k13.setzeFarbe(r, g, b);
                k14.setzeFarbe(r, g, b);
                break;
            case 8:
                k15.setzeFarbe(r, g, b);
                k16.setzeFarbe(r, g, b);
                break;
            case 9:
                k17.setzeFarbe(r, g, b);
                k18.setzeFarbe(r, g, b);
                break;
            case 10:
                k19.setzeFarbe(r, g, b);
                k20.setzeFarbe(r, g, b);
                break;
            case 11:
                k21.setzeFarbe(r, g, b);
                k22.setzeFarbe(r, g, b);
                break;
            case 12:
                k23.setzeFarbe(r, g, b);
                k24.setzeFarbe(r, g, b);
                break;
            case 13:
                k25.setzeFarbe(r, g, b);
                k26.setzeFarbe(r, g, b);
                break;
            case 14:
                k27.setzeFarbe(r, g, b);
                k28.setzeFarbe(r, g, b);
                break;
            case 15:
                k29.setzeFarbe(r, g, b);
                k30.setzeFarbe(r, g, b);
                break;
            default:
                System.out.println("[☢ ] Ein Fehler ist aufgetreten!");
                Sys.beenden();
                break;
        }
    }

    public void szeneAufbauen() {
        p1.setzePosition(0, -30, 0);
        System.out.println("     Platform (P1) gesetzt: X: 0, Y: 0");
        // Plat 2
        int p2pv = ThreadLocalRandom.current().nextInt(-250, 250 + 1);
        int p2ph = 50;
        System.out.println("     Platafform (P2) gesetzt: X: " + p2pv + ", Y: " + p2ph);
        p2.setzePosition(p2pv, p2ph, 0);
        // Plat 3
        int p3pv = ThreadLocalRandom.current().nextInt(-250, 250 + 1);
        int p3ph = 100;
        System.out.println("     Platform (P3) gesetzt: X: " + p3pv + ", Y: " + p3ph);
        p3.setzePosition(p3pv, p3ph, 0);
        // Plat 4
        int p4pv = ThreadLocalRandom.current().nextInt(-250, 250 + 1);
        int p4ph = 150;
        System.out.println("     Platform (P4) gesetzt: X: " + p4pv + ", Y: " + p4ph);
        p4.setzePosition(p4pv, p4ph, 0);
        int p5pv = ThreadLocalRandom.current().nextInt(-250, 250 + 1);
        int p5ph = 200;
        System.out.println("     Platform (P5) gesetzt: X: " + p5pv + ", Y: " + p5ph);
        p5.setzePosition(p5pv, p5ph, 0);
        int p6pv = ThreadLocalRandom.current().nextInt(-250, 250 + 1);
        int p6ph = 250;
        System.out.println("     Platform (P6) gesetzt: X: " + p6pv + ", Y: " + p6ph);
        p6.setzePosition(p6pv, p6ph, 0);
        int p7pv = ThreadLocalRandom.current().nextInt(-250, 250 + 1);
        int p7ph = 300;
        System.out.println("     Platform (P7) gesetzt: X: " + p7pv + ", Y: " + p7ph);
        p7.setzePosition(p7pv, p7ph, 0);
        int p8pv = ThreadLocalRandom.current().nextInt(-250, 250 + 1);
        int p8ph = 350;
        System.out.println("     Platform (P8) gesetzt: X: " + p8pv + ", Y: " + p8ph);
        p8.setzePosition(p8pv, p8ph, 0);
        int p9pv = ThreadLocalRandom.current().nextInt(-250, 250 + 1);
        int p9ph = 400;
        System.out.println("     Platform (P9) gesetzt: X: " + p9pv + ", Y: " + p9ph);
        p9.setzePosition(p9pv, p9ph, 0);
        int p10pv = ThreadLocalRandom.current().nextInt(-250, 250 + 1);
        int p10ph = 450;
        System.out.println("     Platform (P10) gesetzt: X: " + p10pv + ", Y: " + p10ph);
        p10.setzePosition(p10pv, p10ph, 0);
        int p11pv = ThreadLocalRandom.current().nextInt(-250, 250 + 1);
        int p11ph = 500;
        System.out.println("     Platform (P11) gesetzt: X: " + p11pv + ", Y: " + p11ph);
        p11.setzePosition(p11pv, p11ph, 0);
        int p12pv = ThreadLocalRandom.current().nextInt(-250, 250 + 1);
        int p12ph = 550;
        System.out.println("     Platform (P12) gesetzt: X: " + p12pv + ", Y: " + p12ph);
        p12.setzePosition(p12pv, p12ph, 0);
        int p13pv = ThreadLocalRandom.current().nextInt(-250, 250 + 1);
        int p13ph = 600;
        System.out.println("     Platform (P13) gesetzt: X: " + p13pv + ", Y: " + p13ph);
        p13.setzePosition(p13pv, p13ph, 0);
        int p14pv = ThreadLocalRandom.current().nextInt(-250, 250 + 1);
        int p14ph = 650;
        System.out.println("     Platform (P14) gesetzt: X: " + p14pv + ", Y: " + p14ph);
        p14.setzePosition(p14pv, p14ph, 0);
        int p15pv = ThreadLocalRandom.current().nextInt(-250, 250 + 1);
        int p15ph = 700;
        System.out.println("     Platform (P15) gesetzt: X: " + p15pv + ", Y: " + p15ph);
        p15.setzePosition(p15pv, p15ph, 0);

    }

    public void szeneReset() {
        System.out.println("     🡶  Loesche alle Objekte vom Typ Plattform...");
        p1.loesche();
        p2.loesche();
        p3.loesche();
        p4.loesche();
        p5.loesche();
        p6.loesche();
        p7.loesche();
        p8.loesche();
        p9.loesche();
        p10.loesche();
        p11.loesche();
        p12.loesche();
        p13.loesche();
        p14.loesche();
        p15.loesche();
        k1.loesche();
        k2.loesche();
        k3.loesche();
        k4.loesche();
        k5.loesche();
        k6.loesche();
        k7.loesche();
        k8.loesche();
        k9.loesche();
        k10.loesche();
        k11.loesche();
        k12.loesche();
        k13.loesche();
        k14.loesche();
        k15.loesche();
        k16.loesche();
        k17.loesche();
        k18.loesche();
        k19.loesche();
        k20.loesche();
        k21.loesche();
        k22.loesche();
        k23.loesche();
        k24.loesche();
        k25.loesche();
        k26.loesche();
        k27.loesche();
        k28.loesche();
        k29.loesche();
        k30.loesche();

    }

}
