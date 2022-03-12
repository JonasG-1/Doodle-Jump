import GLOOP.GLQuader;
import GLOOP.GLZylinder;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Springer {

    // "Körperteile", bzw. Skin des Standard Springers

    GLQuader koerper, hose, hoseLinie1, hoseLinie2;
    GLZylinder kopf, nase, auge1, auge2, fuss1, fuss2, fuss3;

    // Erstellen von Arrays für relative Koordinaten zum Körper. (Für Skins, die nicht die Standard Größen benutzen)

    double[] modHose;
    double[] modHoseLinie1;
    double[] modHoseLinie2;
    double[] modKopf;
    double[] modNase;
    double[] modAuge1;
    double[] modAuge2;
    double[] modFuss1;
    double[] modFuss2;
    double[] modFuss3;
    double r = 1;
    double g = 0;
    double b = 0;
    int[] move = {2,1,2};
    private List<GLZylinder> particles = new ArrayList<GLZylinder>();
    private int animCounter = 20;
    private List<Float> particlePosX = new ArrayList<>();
    private List<Float> particlePosY = new ArrayList<>();


    public Springer(){
        // Ändern der Werte der Arrays (relative Koordinaten zum Körper)
        modHose = new double[]{0, -5.75, 0.2};
        modHoseLinie1 = new double[]{0, -3.25, 0.3};
        modHoseLinie2 = new double[]{0, -8.25, 0.3};
        modKopf = new double[]{0,12.5,-0.1};
        modNase = new double[]{12.5,9,-0.1};
        modAuge1 = new double[]{-3,12,0.2};
        modAuge2 = new double[]{8,12,0.2};
        modFuss1 = new double[]{0,-12.5,0.1};
        modFuss2 = new double[]{9.5,-12.5,0.1};
        modFuss3 = new double[]{-9.5,-12.5,0.1};

        // Erstellen des Springers
        koerper = new GLQuader(0,100,0,25,25,0);
        hose = new GLQuader(0,94.25,0.2,26,12.5,0);
        hoseLinie1 = new GLQuader(0,96.75,0.3,26,1,0);
        hoseLinie2 = new GLQuader(0,91.75,0.3,26,1,0);
        kopf = new GLZylinder(0,112.5,-0.1,12.5,0);
        nase = new GLZylinder(12.5,109,-0.1,6, 0);
        auge1 = new GLZylinder(-3,112,0.2,2.5,0);
        auge2 = new GLZylinder(8,112,0.2,2.5,0);
        fuss1 = new GLZylinder(0,87.5,0.1,3,0);
        fuss2 = new GLZylinder(9.5,87.5,0.1,3,0);
        fuss3 = new GLZylinder(-9.5,87.5,0.1,3,0);

        // Ändern der Farbe & Skalierung
        koerper.setzeFarbe(0.1,1,0.2);
        hose.setzeFarbe(0.005,0.35,0.01);
        hoseLinie1.setzeFarbe(0,0,0);
        hoseLinie2.setzeFarbe(0,0,0);
        kopf.setzeFarbe(0.1,1,0.2);
        nase.setzeFarbe(0.1,1,0.2);
        auge1.setzeFarbe(0,0,0);
        auge2.setzeFarbe(0,0,0);
        fuss1.setzeFarbe(0.1,1,0.2);
        fuss2.setzeFarbe(0.1,1,0.2);
        fuss3.setzeFarbe(0.1,1,0.2);
        nase.setzeSkalierung(1.5,0.9,1);
        verschiebe(0,0,0, 1);
    }

    public void verschiebe(double pX, double pY, double pZ, int pFacing){
        // (pFacing: 0 steht für links, 1 steht für rechts, bei 2 passiert nichts)
        koerper.verschiebe(pX,pY,pZ);
        hose.verschiebe(pX,pY,pZ);
        hoseLinie1.verschiebe(pX,pY,pZ);
        hoseLinie2.verschiebe(pX,pY,pZ);
        kopf.verschiebe(pX,pY,pZ);
        nase.verschiebe(pX,pY,pZ);
        auge1.verschiebe(pX,pY,pZ);
        auge2.verschiebe(pX,pY,pZ);
        fuss1.verschiebe(pX,pY,pZ);
        fuss2.verschiebe(pX,pY,pZ);
        fuss3.verschiebe(pX,pY,pZ);
        if (pFacing == 0){
            nase.setzePosition(koerper.gibX()-modNase[0], nase.gibY(), nase.gibZ());
        } else if (pFacing == 1){
            nase.setzePosition(koerper.gibX()+modNase[0], nase.gibY(), nase.gibZ());
        }
        if (pY < 0) {
            for (int i = 0; i < particles.size(); i++) {
                particles.get(i).verschiebe(0, pY, 0);
                particlePosY.set(i, particlePosY.get(i) + (float) pY);
            }
        } else {
            for (int i = 0; i < particles.size(); i++) {
                particles.get(i).verschiebe(0, pY / 1.3, 0);
                particlePosY.set(i, particlePosY.get(i) + (float) pY);
            }
        }
    }

    public void setzePosition(double pX,double pY,double pZ, int pFacing){
        // Orientierung.
        koerper.setzePosition(pX,pY,pZ);

        // Anpassen der anderen Teile.
        hose.setzePosition(pX+modHose[0],pY+modHose[1],pZ+modHose[2]);
        hoseLinie1.setzePosition(pX+modHoseLinie1[0],pY+modHoseLinie1[1],pZ+modHoseLinie1[2]);
        hoseLinie2.setzePosition(pX+modHoseLinie2[0],pY+modHoseLinie2[1],pZ+modHoseLinie2[2]);
        kopf.setzePosition(pX+modKopf[0],pY+modKopf[1],pZ+modKopf[2]);
        nase.setzePosition(pX+modNase[0],pY+modNase[1],pZ+modNase[2]);
        auge1.setzePosition(pX+modAuge1[0],pY+modAuge1[1],pZ+modAuge1[2]);
        auge2.setzePosition(pX+modAuge2[0],pY+modAuge2[1],pZ+modAuge2[2]);
        fuss1.setzePosition(pX+modFuss1[0],pY+modFuss1[1],pZ+modFuss1[2]);
        fuss2.setzePosition(pX+modFuss2[0],pY+modFuss2[1],pZ+modFuss2[2]);
        fuss3.setzePosition(pX+modFuss3[0],pY+modFuss3[1],pZ+modFuss3[2]);
        verschiebe(0,0,0,pFacing);
    }

    public void loesche(){
        // Löscht den ganzen Springer.
        koerper.loesche();
        hose.loesche();
        hoseLinie1.loesche();
        hoseLinie2.loesche();
        kopf.loesche();
        nase.loesche();
        auge1.loesche();
        auge2.loesche();
        fuss1.loesche();
        fuss2.loesche();
        fuss3.loesche();
        for (int i = 0; i < particles.size(); i++) {
            particles.get(i).loesche();
        }
    }

    public void animate(boolean spawn) {
        if (animCounter > 0) {
            animCounter--;
        } else if (spawn){
            double x = koerper.gibX() + 10 * Math.cos(ThreadLocalRandom.current().nextDouble(175,185));
            double y = koerper.gibY() + 10 * Math.sin(ThreadLocalRandom.current().nextDouble(175,185));
            GLZylinder temp = new GLZylinder(x, y - 25, 0, 3.5, 0);
            temp.setzeFarbe(ThreadLocalRandom.current().nextDouble(0.5,0.9), ThreadLocalRandom.current().nextDouble(0.1,0.4), 0);
            particles.add(temp);
            particlePosX.add(koerper.gibX());
            particlePosY.add(koerper.gibY() - 15);
            animCounter = 5;
        }
        for (int i = 0; i < particles.size(); i++) {
            double xDir = (particles.get(i).gibX() - particlePosX.get(i)) / 400;
            double yDir = (particles.get(i).gibY() - particlePosY.get(i)) / 100;
            particlePosX.set(i, particlePosX.get(i) + (float) xDir);
            particlePosY.set(i, particlePosY.get(i) + (float) yDir);
            particles.get(i).verschiebe(xDir,yDir,0);
            particles.get(i).skaliere(1.0025);
        }
        if (particles.size() > 70) {
            particles.get(0).loesche();
            particles.remove(0);
            particlePosX.remove(0);
            particlePosY.remove(0);
        }
    }

    public void resetAnim() {
        for (int i = 0; i < particles.size(); i++) {
            particles.get(i).loesche();
        }
        animCounter = 0;
    }

    public double[] gibKoordinaten(boolean lowestPoint){
        // Gibt die Koordinaten des Springers als Array zurück. Wenn lowestPoint war ist, werden die Koordinaten des untersten Punktes zurückgegeben (Die Füße).
        double[] koordinaten;
        if (lowestPoint){
            koordinaten = new double[]{koerper.gibX(), koerper.gibY(), koerper.gibZ()};
        } else {
            koordinaten = new double[]{koerper.gibX(), fuss2.gibY() - 1.5, koerper.gibZ()};
        }
        return koordinaten;
    }
}
