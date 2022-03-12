import GLOOP.GLKugel;
import GLOOP.GLZylinder;

public class Schuss {

    private GLZylinder koerper;
    private GLKugel kopf;

    public Schuss(double pX, double pY, double pZ){
        koerper = new GLZylinder(pX, pY, pZ,3,8);
        kopf = new GLKugel(pX,pY+4, pZ, 2.8);
        koerper.setzeFarbe(0.2,0.2,0.2);
        kopf.setzeFarbe(1,0.8,0);
        koerper.drehe(90,0,0);
    }

    public void schiesse(){
        koerper.verschiebe(0,0.3,0);
        kopf.verschiebe(0,0.3,0);
    }

    public void loesche(){
        koerper.loesche();
        kopf.loesche();
    }

    public double[] gibKoordinaten(){
        // Gibt die Koordinaten des Körpers als Array zurück.
        return new double[]{koerper.gibX(), koerper.gibY(), koerper.gibZ()};
    }
}
