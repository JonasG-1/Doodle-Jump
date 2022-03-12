import GLOOP.GLQuader;

public class Jetpack extends Powerup {

    private GLQuader jetpack;
    public double relCoords = 0;

    public Jetpack(double pX, double pY, double pZ) {
        super(pX, pY, pZ);
        jetpack = new GLQuader(pX,pY,pZ,25,25,0,"jetpack.png");
    }

    @Override
    public void setzePosition(double pX, double pY, double pZ) {
        // Überschreibt die Oberklasse, um die Position des Markers und des Jetpacks zu setzen.
        super.setzePosition(pX, pY, pZ);
        jetpack.setzePosition(pX, pY, pZ);
    }

    @Override
    public void verschiebe(double pX, double pY, double pZ) {
        // Überschreibt die Oberklasse, um den Marker und den Kanister zu verschieben.
        super.verschiebe(pX, pY, pZ);
        jetpack.verschiebe(pX, pY, pZ);
    }

    public void drehe(double pX,double pY,double pZ){
        // Dreht das Jetpack (Für Animationen)
        jetpack.drehe(pX,pY,pZ);
    }

    public void setzeDrehung(double pX, double pY, double pZ){
        // Kann verwendet werden, um z.B. die Drehung zurückzusetzen
        jetpack.setzeDrehung(pX, pY, pZ);
    }

    @Override
    public void loesche() {
        super.loesche();
        jetpack.loesche();
    }
}
