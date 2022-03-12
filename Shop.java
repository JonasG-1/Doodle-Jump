import GLOOP.GLMaus;
import GLOOP.GLQuader;
import GLOOP.GLTastatur;
import GLOOP.Sys;

public class Shop {

    GLQuader karteBetween, karteText, karteHover;
    GLMaus maus;
    GLTastatur tastatur;

    public Shop(){
        karteBetween = new GLQuader(0,0,50,1050,600,0);
        karteBetween.setzeFarbe(0.2,0.2,0.2);
        karteText = new GLQuader(0,0,51,550,450,0,"shop.png");
        karteHover = new GLQuader(0,0,51,550,450,0, "shopHoverSkins.png");
        karteHover.setzeSichtbarkeit(false);
        maus = new GLMaus();
        tastatur = new GLTastatur();
        shop();
    }

    public void shop(){
        boolean shop = true;
        boolean hoverVisible = false;
        int hoverTexture = 1;
        while (shop){
            // Mausabmessungen
            // Skins
                // X: 235 Y: 430 - X: 813 Y: 570
            // Upgrades
                // X: 235 Y: 686 - X: 813 Y: 830
            //System.out.println(maus.gibX()+ ", " + maus.gibY());
            int mausX = maus.gibX();
            int mausY = maus.gibY();
            if (mausX >= 235 && mausX <= 813 && mausY >= 430 && mausY <= 570) {
                if (!hoverVisible) {
                    karteHover.setzeSichtbarkeit(true);
                    karteText.setzeSichtbarkeit(false);
                    hoverVisible = true;
                }
                if (hoverTexture != 1) {
                    karteHover.setzeTextur("shopHoverSkins.png");
                    hoverTexture = 1;
                }
                if (maus.gedruecktLinks()) {

                }
            } else if (mausX >= 235 && mausX <= 813 && mausY >= 686 && mausY <= 830) {
                if (!hoverVisible) {
                    karteHover.setzeSichtbarkeit(true);
                    karteText.setzeSichtbarkeit(false);
                    hoverVisible = true;
                }
                if (hoverTexture != 2) {
                    karteHover.setzeTextur("shopHoverUpgrades.png");
                    hoverTexture = 2;
                }
                if (maus.gedruecktLinks()) {

                }
            } else {
                hoverVisible = false;
                karteHover.setzeSichtbarkeit(false);
                karteText.setzeSichtbarkeit(true);
            }
            if (tastatur.esc()){
                shop = false;
            }
            Sys.warte();
        }

        loesche();
    }

    public void loesche(){
        karteHover.loesche();
        karteText.loesche();
        karteBetween.loesche();
    }
}
