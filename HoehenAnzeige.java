import GLOOP.GLQuader;

public class HoehenAnzeige {
    GLQuader pointer, anzeige;
    private double spX, spY, spZ, spLX, spLY, pntpY;

    public HoehenAnzeige(double pX, double pY, double pZ, double pLX, double pLY){
        spX = pX;
        spY = pY;
        spZ = pZ;
        spLX = pLX;
        spLY = pLY;
        pntpY = pY - pLY / 2;

        anzeige = new GLQuader(pX, pY, pZ, pLX, pLY, 0, "bossanzeige.png");
        pointer = new GLQuader(pX -  pLX / 2, pY - pLY / 2, pZ + 0.1, pLX / 10, pLY / 42.775, 0);
        pointer.setzeFarbe(1,1,0);
        pointer.drehe(0,0,45);
    }

    public void verschiebePointer(double pY){
        pntpY += pY;
        if (pntpY >= spY + (spLY / 2)){
            pntpY = spY + (spLY / 2);
        }
        if (pntpY <= spY - (spLY / 2)){
            pntpY = spY - (spLY / 2);
        }
        pointer.setzePosition(spX -  spLX / 2,pntpY,spZ + 0.1);
    }

    public void setzePointer(double pY){
        pntpY = pY;
        if (pntpY >= spY + (spLY / 2)){
            pntpY = spY + (spLY / 2);
        }
        if (pntpY <= spY - (spLY / 2)){
            pntpY = spY - (spLY / 2);
        }
        pointer.setzePosition(spX -  spLX / 2,pntpY,spZ + 0.1);
    }

    public double gibProzent(){
        double prozent = 0;
        double flaeche = ((spY + (spLY / 2)) - (spY - (spLY / 2))); // z.B. 400
        double flaecheAnteilPointer = pntpY - (spY - (spLY / 2)); // z.B. 200 (Pointer bei 50%)
        double flaecheAnteil = flaeche - flaecheAnteilPointer; // Anteil -> 200
        prozent = flaecheAnteil / (flaeche / 100); // Fläche / 100 = 4 | flächeAnteil / 4 = 50 (Prozent)
        //System.out.println("Prozent: " + prozent + "\nFläche: " + flaeche + "\nFläche Anteil Pointer: " + flaecheAnteilPointer + "\nFläche Anteil: " + flaecheAnteil + "\n---");
        return prozent;
    }

    public void loesche(){
        anzeige.loesche();
        pointer.loesche();
    }
}
