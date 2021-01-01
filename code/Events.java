import GLOOP.*;
import java.util.concurrent.ThreadLocalRandom;

public class Events {
    GLZylinder z1, z2, z3, z4, z5, z6, z7, z8, z9, z10, z11, z12, z13, z14, z15;
    GLQuader k1, k2, k3, k4, k5, k6, k7, k8, k9, k10, k11, k12, k13, k14, k15;

    public Events() {
        z1 = new GLZylinder(0, 700, 0, 10, 5, "coin.png");
        z2 = new GLZylinder(0, 700, 0, 10, 5, "coin.png");
        z3 = new GLZylinder(0, 700, 0, 10, 5, "coin.png");
        z4 = new GLZylinder(0, 700, 0, 10, 5, "coin.png");
        z5 = new GLZylinder(0, 700, 0, 10, 5, "coin.png");
        z6 = new GLZylinder(0, 700, 0, 10, 5, "coin.png");
        z7 = new GLZylinder(0, 700, 0, 10, 5, "coin.png");
        z8 = new GLZylinder(0, 700, 0, 10, 5, "coin.png");
        z9 = new GLZylinder(0, 700, 0, 10, 5, "coin.png");
        z10 = new GLZylinder(0, 700, 0, 10, 5, "coin.png");
        z11 = new GLZylinder(0, 700, 0, 10, 5, "coin.png");
        z12 = new GLZylinder(0, 700, 0, 10, 5, "coin.png");
        z13 = new GLZylinder(0, 700, 0, 10, 5, "coin.png");
        z14 = new GLZylinder(0, 700, 0, 10, 5, "coin.png");
        z15 = new GLZylinder(0, 700, 0, 10, 5, "coin.png");
        k1 = new GLQuader(0, 700, 10, 15, 25, 5, "benzin.png");
        k2 = new GLQuader(0, 700, 0, 15, 25, 5, "benzin.png");
        k3 = new GLQuader(0, 700, 0, 15, 25, 5, "benzin.png");
        k4 = new GLQuader(0, 700, 0, 15, 25, 5, "benzin.png");
        k5 = new GLQuader(0, 700, 0, 15, 25, 5, "benzin.png");
        k6 = new GLQuader(0, 700, 0, 15, 25, 5, "benzin.png");
        k7 = new GLQuader(0, 700, 0, 15, 25, 5, "benzin.png");
        k8 = new GLQuader(0, 700, 0, 15, 25, 5, "benzin.png");
        k9 = new GLQuader(0, 700, 0, 15, 25, 5, "benzin.png");
        k10 = new GLQuader(0, 700, 0, 15, 25, 5, "benzin.png");
        k11 = new GLQuader(0, 700, 0, 15, 25, 5, "benzin.png");
        k12 = new GLQuader(0, 700, 0, 15, 25, 5, "benzin.png");
        k13 = new GLQuader(0, 700, 0, 15, 25, 5, "benzin.png");
        k14 = new GLQuader(0, 700, 0, 15, 25, 5, "benzin.png");
        k15 = new GLQuader(0, 700, 0, 15, 25, 5, "benzin.png");

        z1.setzeDrehung(0, 0, 180);
        z2.setzeDrehung(0, 0, 180);
        z3.setzeDrehung(0, 0, 180);
        z4.setzeDrehung(0, 0, 180);
        z5.setzeDrehung(0, 0, 180);
        z6.setzeDrehung(0, 0, 180);
        z7.setzeDrehung(0, 0, 180);
        z8.setzeDrehung(0, 0, 180);
        z9.setzeDrehung(0, 0, 180);
        z10.setzeDrehung(0, 0, 180);
        z11.setzeDrehung(0, 0, 180);
        z12.setzeDrehung(0, 0, 180);
        z13.setzeDrehung(0, 0, 180);
        z14.setzeDrehung(0, 0, 180);
        z15.setzeDrehung(0, 0, 180);
        k1.setzeDrehung(0, 0, 180);
        k2.setzeDrehung(0, 0, 180);
        k3.setzeDrehung(0, 0, 180);
        k4.setzeDrehung(0, 0, 180);
        k5.setzeDrehung(0, 0, 180);
        k6.setzeDrehung(0, 0, 180);
        k7.setzeDrehung(0, 0, 180);
        k8.setzeDrehung(0, 0, 180);
        k9.setzeDrehung(0, 0, 180);
        k10.setzeDrehung(0, 0, 180);
        k11.setzeDrehung(0, 0, 180);
        k12.setzeDrehung(0, 0, 180);
        k13.setzeDrehung(0, 0, 180);
        k14.setzeDrehung(0, 0, 180);
        k15.setzeDrehung(0, 0, 180);
    }

    public int EventGen(int platid, int event) {
        int eventtype = 0;
        int generator = ThreadLocalRandom.current().nextInt(0, 20 + 1);
        switch (generator) {
            case 1:
            case 2:
                eventtype = 1;
                break;
            case 3:
                eventtype = 2;
                break;
            default:
                break;
        }

        // System.out.println("Plattform: " + platid + " Event: " + eventtype);
        return eventtype;
    }

    public int LootGen(int platid, int lootid, int benzinan, int muenzenan) {
        int eventtype = 0;
        int generator = ThreadLocalRandom.current().nextInt(0, 20 + 1);
        switch (generator) {
            case 1:
            case 2:
            case 3:
                eventtype = 1;
                break;
            case 5:
            case 6:
            case 7:
                eventtype = 2;
                break;
            default:
                break;
        }
        if (benzinan == 0) {
            if (eventtype == 2) {
                eventtype = 0;
            }
        }
        if (muenzenan == 0) {
            if (eventtype == 1) {
                eventtype = 0;
            }
        }

        // System.out.println("Plattform: " + platid + " Loot: " + eventtype);
        return eventtype;

    }

    public int springerHit(int platid, double lSpringer, double hSpringer, int loot) {
        int hit = 0;
        double z1h = z1.gibY();
        double z2h = z2.gibY();
        double z3h = z3.gibY();
        double z4h = z4.gibY();
        double z5h = z5.gibY();
        double z6h = z6.gibY();
        double z7h = z7.gibY();
        double z8h = z8.gibY();
        double z9h = z9.gibY();
        double z10h = z10.gibY();
        double z11h = z11.gibY();
        double z12h = z12.gibY();
        double z13h = z13.gibY();
        double z14h = z14.gibY();
        double z15h = z15.gibY();

        double z1l = z1.gibX();
        double z2l = z2.gibX();
        double z3l = z3.gibX();
        double z4l = z4.gibX();
        double z5l = z5.gibX();
        double z6l = z6.gibX();
        double z7l = z7.gibX();
        double z8l = z8.gibX();
        double z9l = z9.gibX();
        double z10l = z10.gibX();
        double z11l = z11.gibX();
        double z12l = z12.gibX();
        double z13l = z13.gibX();
        double z14l = z14.gibX();
        double z15l = z15.gibX();

        if (hSpringer >= z1h - 15 && hSpringer <= z1h + 15 && lSpringer >= z1l - 25 && lSpringer <= z1l + 25) {
            hit = 1;
            // System.out.println("Benzin 1");
        }
        if (hSpringer >= z2h - 15 && hSpringer <= z2h + 15 && lSpringer >= z2l - 25 && lSpringer <= z2l + 25) {
            hit = 2;
            // System.out.println("Benzin 2");
        }
        if (hSpringer >= z3h - 15 && hSpringer <= z3h + 15 && lSpringer >= z3l - 25 && lSpringer <= z3l + 25) {
            hit = 3;
            // System.out.println("Benzin 3");
        }
        if (hSpringer >= z4h - 15 && hSpringer <= z4h + 15 && lSpringer >= z4l - 25 && lSpringer <= z4l + 25) {
            hit = 4;
            // System.out.println("Benzin 4");
        }
        if (hSpringer >= z5h - 15 && hSpringer <= z5h + 15 && lSpringer >= z5l - 25 && lSpringer <= z5l + 25) {
            hit = 5;
            // System.out.println("Benzin 5");
        }
        if (hSpringer >= z6h - 15 && hSpringer <= z6h + 15 && lSpringer >= z6l - 25 && lSpringer <= z6l + 25) {
            hit = 6;
            // System.out.println("Benzin 6");
        }
        if (hSpringer >= z7h - 15 && hSpringer <= z7h + 15 && lSpringer >= z7l - 25 && lSpringer <= z7l + 25) {
            hit = 7;
            // System.out.println("Benzin 7");
        }
        if (hSpringer >= z8h - 15 && hSpringer <= z8h + 15 && lSpringer >= z8l - 25 && lSpringer <= z8l + 25) {
            hit = 8;
            // System.out.println("Benzin 8");
        }
        if (hSpringer >= z9h - 15 && hSpringer <= z9h + 15 && lSpringer >= z9l - 25 && lSpringer <= z9l + 25) {
            hit = 9;
            // System.out.println("Benzin 9");
        }
        if (hSpringer >= z10h - 15 && hSpringer <= z10h + 15 && lSpringer >= z10l - 25 && lSpringer <= z10l + 25) {
            hit = 10;
            // System.out.println("Benzin 10");
        }
        if (hSpringer >= z11h - 15 && hSpringer <= z11h + 15 && lSpringer >= z11l - 25 && lSpringer <= z11l + 25) {
            hit = 11;
            // System.out.println("Benzin 11");
        }
        if (hSpringer >= z12h - 15 && hSpringer <= z12h + 15 && lSpringer >= z12l - 25 && lSpringer <= z12l + 25) {
            hit = 12;
            // System.out.println("Benzin 12");
        }
        if (hSpringer >= z13h - 15 && hSpringer <= z13h + 15 && lSpringer >= z13l - 25 && lSpringer <= z13l + 25) {
            hit = 13;
            // System.out.println("Benzin 13");
        }
        if (hSpringer >= z14h - 15 && hSpringer <= z14h + 15 && lSpringer >= z14l - 25 && lSpringer <= z14l + 25) {
            hit = 14;
            // System.out.println("Benzin 14");
        }
        if (hSpringer >= z15h - 15 && hSpringer <= z15h + 15 && lSpringer >= z15l - 25 && lSpringer <= z15l + 25) {
            hit = 15;
            // System.out.println("Benzin 15");
        }
        return hit;
    }

    public int springerHitBenzin(int platid, double lSpringer, double hSpringer, int loot) {
        int hit = 0;
        double z1h = k1.gibY();
        double z2h = k2.gibY();
        double z3h = k3.gibY();
        double z4h = k4.gibY();
        double z5h = k5.gibY();
        double z6h = k6.gibY();
        double z7h = k7.gibY();
        double z8h = k8.gibY();
        double z9h = k9.gibY();
        double z10h = k10.gibY();
        double z11h = k11.gibY();
        double z12h = k12.gibY();
        double z13h = k13.gibY();
        double z14h = k14.gibY();
        double z15h = k15.gibY();

        double z1l = k1.gibX();
        double z2l = k2.gibX();
        double z3l = k3.gibX();
        double z4l = k4.gibX();
        double z5l = k5.gibX();
        double z6l = k6.gibX();
        double z7l = k7.gibX();
        double z8l = k8.gibX();
        double z9l = k9.gibX();
        double z10l = k10.gibX();
        double z11l = k11.gibX();
        double z12l = k12.gibX();
        double z13l = k13.gibX();
        double z14l = k14.gibX();
        double z15l = k15.gibX();

        if (hSpringer >= z1h - 12 && hSpringer <= z1h + 12 && lSpringer >= z1l - 12 && lSpringer <= z1l + 12) {
            hit = 1;
            // System.out.println("Münze 1");
        }
        if (hSpringer >= z2h - 12 && hSpringer <= z2h + 12 && lSpringer >= z2l - 12 && lSpringer <= z2l + 12) {
            hit = 2;
            // System.out.println("Münze 2");
        }
        if (hSpringer >= z3h - 12 && hSpringer <= z3h + 12 && lSpringer >= z3l - 12 && lSpringer <= z3l + 12) {
            hit = 3;
            // System.out.println("Münze 3");
        }
        if (hSpringer >= z4h - 12 && hSpringer <= z4h + 12 && lSpringer >= z4l - 12 && lSpringer <= z4l + 12) {
            hit = 4;
            // System.out.println("Münze 4");
        }
        if (hSpringer >= z5h - 12 && hSpringer <= z5h + 12 && lSpringer >= z5l - 12 && lSpringer <= z5l + 12) {
            hit = 5;
            // System.out.println("Münze 5");
        }
        if (hSpringer >= z6h - 12 && hSpringer <= z6h + 12 && lSpringer >= z6l - 12 && lSpringer <= z6l + 12) {
            hit = 6;
            // System.out.println("Münze 6");
        }
        if (hSpringer >= z7h - 12 && hSpringer <= z7h + 12 && lSpringer >= z7l - 12 && lSpringer <= z7l + 12) {
            hit = 7;
            // System.out.println("Münze 7");
        }
        if (hSpringer >= z8h - 12 && hSpringer <= z8h + 12 && lSpringer >= z8l - 12 && lSpringer <= z8l + 12) {
            hit = 8;
            // System.out.println("Münze 8");
        }
        if (hSpringer >= z9h - 12 && hSpringer <= z9h + 12 && lSpringer >= z9l - 12 && lSpringer <= z9l + 12) {
            hit = 9;
            // System.out.println("Münze 9");
        }
        if (hSpringer >= z10h - 12 && hSpringer <= z10h + 12 && lSpringer >= z10l - 12 && lSpringer <= z10l + 12) {
            hit = 10;
            setzeCoin(10, 0, 700, 0);
            // System.out.println("Münze 10");
        }
        if (hSpringer >= z11h - 12 && hSpringer <= z11h + 12 && lSpringer >= z11l - 12 && lSpringer <= z11l + 12) {
            hit = 11;
            // System.out.println("Münze 11");
        }
        if (hSpringer >= z12h - 12 && hSpringer <= z12h + 12 && lSpringer >= z12l - 12 && lSpringer <= z12l + 12) {
            hit = 12;
            // System.out.println("Münze 12");
        }
        if (hSpringer >= z13h - 12 && hSpringer <= z13h + 12 && lSpringer >= z13l - 12 && lSpringer <= z13l + 12) {
            hit = 13;
            // System.out.println("Münze 13");
        }
        if (hSpringer >= z14h - 12 && hSpringer <= z14h + 12 && lSpringer >= z14l - 12 && lSpringer <= z14l + 12) {
            hit = 14;
            // System.out.println("Münze 14");
        }
        if (hSpringer >= z15h - 12 && hSpringer <= z15h + 12 && lSpringer >= z15l - 12 && lSpringer <= z15l + 12) {
            hit = 15;
            // System.out.println("Münze 15");
        }
        return hit;
    }

    public void setzeCoin(int coinid, double x, double y, double z) {
        switch (coinid) {
            case 1:
                z1.setzePosition(x, y, z);
                break;
            case 2:
                z2.setzePosition(x, y, z);
                break;
            case 3:
                z3.setzePosition(x, y, z);
                break;
            case 4:
                z4.setzePosition(x, y, z);
                break;
            case 5:
                z5.setzePosition(x, y, z);
                break;
            case 6:
                z6.setzePosition(x, y, z);
                break;
            case 7:
                z7.setzePosition(x, y, z);
                break;
            case 8:
                z8.setzePosition(x, y, z);
                break;
            case 9:
                z9.setzePosition(x, y, z);
                break;
            case 10:
                z10.setzePosition(x, y, z);
                break;
            case 11:
                z11.setzePosition(x, y, z);
                break;
            case 12:
                z12.setzePosition(x, y, z);
                break;
            case 13:
                z13.setzePosition(x, y, z);
                break;
            case 14:
                z14.setzePosition(x, y, z);
                break;
            case 15:
                z15.setzePosition(x, y, z);
                break;
        }
    }

    public void setzeBenzin(int benzinid, double x, double y, double z) {
        switch (benzinid) {
            case 1:
                k1.setzePosition(x, y, z);
                break;
            case 2:
                k2.setzePosition(x, y, z);
                break;
            case 3:
                k3.setzePosition(x, y, z);
                break;
            case 4:
                k4.setzePosition(x, y, z);
                break;
            case 5:
                k5.setzePosition(x, y, z);
                break;
            case 6:
                k6.setzePosition(x, y, z);
                break;
            case 7:
                k7.setzePosition(x, y, z);
                break;
            case 8:
                k8.setzePosition(x, y, z);
                break;
            case 9:
                k9.setzePosition(x, y, z);
                break;
            case 10:
                k10.setzePosition(x, y, z);
                break;
            case 11:
                k11.setzePosition(x, y, z);
                break;
            case 12:
                k12.setzePosition(x, y, z);
                break;
            case 13:
                k13.setzePosition(x, y, z);
                break;
            case 14:
                k14.setzePosition(x, y, z);
                break;
            case 15:
                k15.setzePosition(x, y, z);
                break;
        }
    }

    public void setzeCoinDrehung(int coinid, double x, double y, double z) {
        switch (coinid) {
            case 1:
                z1.setzeDrehung(x, y, z);
                break;
            case 2:
                z2.setzeDrehung(x, y, z);
                break;
            case 3:
                z3.setzeDrehung(x, y, z);
                break;
            case 4:
                z4.setzeDrehung(x, y, z);
                break;
            case 5:
                z5.setzeDrehung(x, y, z);
                break;
            case 6:
                z6.setzeDrehung(x, y, z);
                break;
            case 7:
                z7.setzeDrehung(x, y, z);
                break;
            case 8:
                z8.setzeDrehung(x, y, z);
                break;
            case 9:
                z9.setzeDrehung(x, y, z);
                break;
            case 10:
                z10.setzeDrehung(x, y, z);
                break;
            case 11:
                z11.setzeDrehung(x, y, z);
                break;
            case 12:
                z12.setzeDrehung(x, y, z);
                break;
            case 13:
                z13.setzeDrehung(x, y, z);
                break;
            case 14:
                z14.setzeDrehung(x, y, z);
                break;
            case 15:
                z15.setzeDrehung(x, y, z);
                break;
        }
    }

    public void setzeBenzinDrehung(int benzinid, double x, double y, double z) {
        switch (benzinid) {
            case 1:
                k1.setzeDrehung(x, y, z);
                break;
            case 2:
                k2.setzeDrehung(x, y, z);
                break;
            case 3:
                k3.setzeDrehung(x, y, z);
                break;
            case 4:
                k4.setzeDrehung(x, y, z);
                break;
            case 5:
                k5.setzeDrehung(x, y, z);
                break;
            case 6:
                k6.setzeDrehung(x, y, z);
                break;
            case 7:
                k7.setzeDrehung(x, y, z);
                break;
            case 8:
                k8.setzeDrehung(x, y, z);
                break;
            case 9:
                k9.setzeDrehung(x, y, z);
                break;
            case 10:
                k10.setzeDrehung(x, y, z);
                break;
            case 11:
                k11.setzeDrehung(x, y, z);
                break;
            case 12:
                k12.setzeDrehung(x, y, z);
                break;
            case 13:
                k13.setzeDrehung(x, y, z);
                break;
            case 14:
                k14.setzeDrehung(x, y, z);
                break;
            case 15:
                k15.setzeDrehung(x, y, z);
                break;
        }
    }

    public void verschiebeCoin(int coinid, double x, double y, double z) {
        switch (coinid) {
            case 1:
                z1.verschiebe(x, y, z);
                break;
            case 2:
                z2.verschiebe(x, y, z);
                break;
            case 3:
                z3.verschiebe(x, y, z);
                break;
            case 4:
                z4.verschiebe(x, y, z);
                break;
            case 5:
                z5.verschiebe(x, y, z);
                break;
            case 6:
                z6.verschiebe(x, y, z);
                break;
            case 7:
                z7.verschiebe(x, y, z);
                break;
            case 8:
                z8.verschiebe(x, y, z);
                break;
            case 9:
                z9.verschiebe(x, y, z);
                break;
            case 10:
                z10.verschiebe(x, y, z);
                break;
            case 11:
                z11.verschiebe(x, y, z);
                break;
            case 12:
                z12.verschiebe(x, y, z);
                break;
            case 13:
                z13.verschiebe(x, y, z);
                break;
            case 14:
                z14.verschiebe(x, y, z);
                break;
            case 15:
                z15.verschiebe(x, y, z);
                break;
        }
    }

    public void verschiebeBenzin(int benzinid, double x, double y, double z) {
        switch (benzinid) {
            case 1:
                k1.verschiebe(x, y, z);
                break;
            case 2:
                k2.verschiebe(x, y, z);
                break;
            case 3:
                k3.verschiebe(x, y, z);
                break;
            case 4:
                k4.verschiebe(x, y, z);
                break;
            case 5:
                k5.verschiebe(x, y, z);
                break;
            case 6:
                k6.verschiebe(x, y, z);
                break;
            case 7:
                k7.verschiebe(x, y, z);
                break;
            case 8:
                k8.verschiebe(x, y, z);
                break;
            case 9:
                k9.verschiebe(x, y, z);
                break;
            case 10:
                k10.verschiebe(x, y, z);
                break;
            case 11:
                k11.verschiebe(x, y, z);
                break;
            case 12:
                k12.verschiebe(x, y, z);
                break;
            case 13:
                k13.verschiebe(x, y, z);
                break;
            case 14:
                k14.verschiebe(x, y, z);
                break;
            case 15:
                k15.verschiebe(x, y, z);
                break;
        }
    }

    public void animation() {
        z1.drehe(0, 0.5, 0);
        z2.drehe(0, 0.5, 0);
        z3.drehe(0, 0.5, 0);
        z4.drehe(0, 0.5, 0);
        z5.drehe(0, 0.5, 0);
        z6.drehe(0, 0.5, 0);
        z7.drehe(0, 0.5, 0);
        z8.drehe(0, 0.5, 0);
        z9.drehe(0, 0.5, 0);
        z10.drehe(0, 0.5, 0);
        z11.drehe(0, 0.5, 0);
        z12.drehe(0, 0.5, 0);
        z13.drehe(0, 0.5, 0);
        z14.drehe(0, 0.5, 0);
        z15.drehe(0, 0.5, 0);
        k1.drehe(0, 0.5, 0);
        k2.drehe(0, 0.5, 0);
        k3.drehe(0, 0.5, 0);
        k4.drehe(0, 0.5, 0);
        k5.drehe(0, 0.5, 0);
        k6.drehe(0, 0.5, 0);
        k7.drehe(0, 0.5, 0);
        k8.drehe(0, 0.5, 0);
        k9.drehe(0, 0.5, 0);
        k10.drehe(0, 0.5, 0);
        k11.drehe(0, 0.5, 0);
        k12.drehe(0, 0.5, 0);
        k13.drehe(0, 0.5, 0);
        k14.drehe(0, 0.5, 0);
        k15.drehe(0, 0.5, 0);

    }

    public void szeneReset() {
        System.out.println("     🡶  Loesche alle Objekte vom Typ Coin und Benzin...");
        z1.loesche();
        z2.loesche();
        z3.loesche();
        z4.loesche();
        z5.loesche();
        z6.loesche();
        z7.loesche();
        z8.loesche();
        z9.loesche();
        z10.loesche();
        z11.loesche();
        z12.loesche();
        z13.loesche();
        z14.loesche();
        z15.loesche();
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
    }
}
