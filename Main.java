import GLOOP.GLKamera;
import GLOOP.GLLicht;
import GLOOP.Sys;

public class Main {
    static GLKamera kamera;
    static GLLicht licht;

    public static void main(String[] args) {
        System.out.println("\nDoodle Jump Remastered - Von Jonas Goldbach\n\nStartet...");
        System.out.println("Kamera wird gestartet...\n");
        kamera = new GLKamera(1400, 1000);
        licht = new GLLicht(0, 0, 2000);
        while (true) {
            Menu menu;
            Spiel spiel;
            if (!Spiel.optionOWW[0]) {
                System.out.println("\nAufruf des Menus...");
                menu = new Menu();
                Sys.warte(2);
                boolean[] options = menu.getOption();
                spiel = new Spiel(options, false);
                menu.fadeOut();
            } else {
                spiel = new Spiel(Spiel.optionOWW, true);
            }
            spiel.game();
        }
    }
}
