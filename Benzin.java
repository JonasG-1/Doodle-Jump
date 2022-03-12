import GLOOP.GLQuader;

public class Benzin extends Powerup {

    private GLQuader kanister;

    public Benzin(double pX, double pY, double pZ) {
        super(pX, pY, pZ);
        kanister = new GLQuader(pX,pY,pZ,15,25,0,"benzin.png");
    }

    @Override
    public void setzePosition(double pX, double pY, double pZ) {
        // Überschreibt die Oberklasse, um die Position des Markers und den Kanisters zu setzen.
        super.setzePosition(pX, pY, pZ);
        kanister.setzePosition(pX, pY, pZ);
    }

    @Override
    public void verschiebe(double pX, double pY, double pZ) {
        // Überschreibt die Oberklasse, um den Marker und den Kanister zu verschieben.
        super.verschiebe(pX, pY, pZ);
        kanister.verschiebe(pX, pY, pZ);
    }

    public void drehe(double pX,double pY,double pZ){
        // Dreht den Kanister (Für Animationen)
        kanister.drehe(pX,pY,pZ);
    }

    public void setzeDrehung(double pX, double pY, double pZ){
        // Kann verwendet werden, um z.B. die Drehung zurückzusetzen
        kanister.setzeDrehung(pX, pY, pZ);
    }

    @Override
    public void loesche() {
        super.loesche();
        kanister.loesche();
    }
}
