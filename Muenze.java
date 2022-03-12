import GLOOP.GLZylinder;




public class Muenze extends Powerup {

    private GLZylinder muenze;

    public Muenze(double pX, double pY, double pZ) {
        super(pX, pY, pZ);
        muenze = new GLZylinder(pX, pY, pZ, 10, 0, "coin.png");
    }

    @Override
    public void setzePosition(double pX, double pY, double pZ) {
        // Überschreibt die Oberklasse, um die Position des Markers und der Münze zu setzen.
        super.setzePosition(pX, pY, pZ);
        muenze.setzePosition(pX, pY, pZ);
    }

    @Override
    public void verschiebe(double pX, double pY, double pZ) {
        // Überschreibt die Oberklasse, um den Marker und die Münze zu verschieben.
        super.verschiebe(pX, pY, pZ);
        muenze.verschiebe(pX, pY, pZ);
    }

    public void drehe(double pX, double pY, double pZ) {
        // Dreht die Münze (Für Animationen)
        muenze.drehe(pX, pY, pZ);
    }

    public void setzeDrehung(double pX, double pY, double pZ) {
        // Kann verwendet werden, um z.B. die Drehung zurückzusetzen
        muenze.setzeDrehung(pX, pY, pZ);
    }

    @Override
    public void loesche() {
        super.loesche();
        muenze.loesche();
    }

}