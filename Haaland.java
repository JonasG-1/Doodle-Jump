import GLOOP.GLQuader;

public class Haaland {
    private GLQuader haaland;
    public int bossAnimation = 0;
    public int state = 1;

    public Haaland(){
        // Erstellt Haaland und ändert die Variable "bossActive" in der Klasse Spiel auf "true".
        // 975 / 549 = 1,775 (1,775 * pLY = pLX)
        haaland = new GLQuader(0,-180,4,355,200,0, "haaland_peace.png");
        haaland.verschiebe(0,-200,0);
        Spiel.bossActive = true;
    }

    public void changeState(int state){
        // (state: 1 = haaland_peace, 2 = haaland_running, 3 = haaland_win)
        switch (state){
            case 1:
                haaland.loesche();
                // 975 / 549 = 1,775 (1,775 * pLY = pLX)
                haaland = new GLQuader(0,-180,0,355,200,0, "haaland_peace.png");
                break;
            case 2:
                haaland.loesche();
                // Quadratisch
                haaland = new GLQuader(0,0,0,200,200,0, "haaland_running_right.png");
                //System.out.println("Debug: -> haaland.state = 2, confirmed");
                break;
            case 3:
                haaland.loesche();
                // 1200 / 675 = 1,777 (1,777 * pLY = pLX)
                haaland = new GLQuader(0,0,4,355.4,200,0, "haaland_win.png");
                //System.out.println("Debug: -> haaland.state = 3, confirmed");
                break;
            default:
                System.out.println("Debug: -> Fehler im Bosskampf! 'state' hatte keinen der erlaubten Werte! Breche den Bosskampf ab!");
                this.loesche();
                Spiel.bossActive = false;
        }
    }

    public void setzeTextur(String textur){
        haaland.setzeTextur(textur);
    }

    public void setzePosition(double pX, double pY, double pZ){
        // Setzt die Position von Haaland.
        haaland.setzePosition(pX, pY, pZ);
    }

    public void verschiebe(double pX, double pY, double pZ){
        // Verschiebt Haaland.
        haaland.verschiebe(pX, pY, pZ);
    }

    public void loesche(){
        // Löscht Haaland (nicht cool)
        haaland.loesche();
    }

    public double[] gibKoordinaten(){
        // Gibt die Koordinaten von Haaland zurück.
        return new double[] {haaland.gibX(), haaland.gibY(), haaland.gibZ()};
    }
}
