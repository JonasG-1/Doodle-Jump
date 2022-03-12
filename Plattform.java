import GLOOP.GLQuader;
import GLOOP.GLZylinder;

public class Plattform {

    protected GLQuader mitte;
    protected GLZylinder links, rechts;
    public boolean animation = false;
    public boolean active = true;
    private int animationCounter = 0;
    public double plattformTyp = 0;
    // (plattformTyp: 0 ist Standard, 1 ist Super Plattform, 2 ist Brech Plattform)

    public Plattform(double pX, double pY){
        // Erstellt eine Plattform und macht sie blau.
        mitte = new GLQuader(pX,pY,1,60,10,1);
        links = new GLZylinder(pX-30,pY,1,5,1);
        rechts = new GLZylinder(pX+30,pY,1,5,1);
        mitte.setzeFarbe(0,0.5,1);
        links.setzeFarbe(0,0.5,1);
        rechts.setzeFarbe(0,0.5,1);
    }

    public void setzeFarbe(double pR, double pG, double pB){
        mitte.setzeFarbe(pR, pG, pB);
        links.setzeFarbe(pR, pG, pB);
        rechts.setzeFarbe(pR, pG, pB);
    }

    public void verschiebe(double pX, double pY){
        // Verschiebt die Plattform.
        mitte.verschiebe(pX,pY,0);
        links.verschiebe(pX,pY,0);
        rechts.verschiebe(pX,pY,0);
    }

    public void setzePosition(double pX,double pY,double pZ){
        // Setzt die Position der Plattform.
        mitte.setzePosition(pX, pY, pZ);
        links.setzePosition(pX-30, pY, pZ);
        rechts.setzePosition(pX+30, pY, pZ);
    }

    public void setzeSichtbarkeit(boolean pS){
        // Wird benutzt, um z.B. die Sichtbarkeit der Plattformen wiederherzustellen, nachdem sie z.B. zerbrochen sind
        mitte.setzeSichtbarkeit(pS);
        links.setzeSichtbarkeit(pS);
        rechts.setzeSichtbarkeit(pS);
    }

    public void loesche() {
        // Löscht die Plattform.
        mitte.loesche();
        links.loesche();
        rechts.loesche();
    }

    public void animiere(){
        // Animiert die Plattform, wenn sie zerbricht (Nur bei zerbrechenden Plattformen)
        mitte.verschiebe(0,-0.5,0);
        links.verschiebe(0,-0.5,0);
        rechts.verschiebe(0,-0.5,0);
        animationCounter++;
        if (animationCounter >= 100){
            animation = false;
            animationCounter = 0;
            mitte.setzeSichtbarkeit(false);
            links.setzeSichtbarkeit(false);
            rechts.setzeSichtbarkeit(false);
            mitte.verschiebe(0,50,0);
            links.verschiebe(0,50,0);
            rechts.verschiebe(0,50,0);
        }
    }

    public double[] gibKoordinaten(){
        // Gibt die Koordinaten der Mittel Plattform als Array zurück.
        return new double[]{mitte.gibX(), mitte.gibY(), mitte.gibZ()};
    }
}
