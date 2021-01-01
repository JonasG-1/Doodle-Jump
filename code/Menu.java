import GLOOP.*;

public class Menu {
    GLKamera Kamera;
    GLLicht Licht;

    public Menu() {
        Kamera = new GLKamera(1400, 1000);
        Licht = new GLLicht(0, 0, 2000);

    }

public void menuScreen() {

        Duhdel ddCon = new Duhdel();
        ddCon.PlatformEngine(0);

    }
}
