import GLOOP.GLQuader;
import GLOOP.GLZylinder;
import GLOOP.Sys;

public class Anzeige {

    private GLQuader aHintergrund, c1, c2, c3, b1, b2, b3, benzin;
    private GLZylinder muenze;
    private double scaleX, scaleY, scaleYhalf;
    private double[] pos1, pos2, pos3, pos4, pos5, pos6, pos7, pos8;
    private int d1, d2, d3, dc1, dc2, dc3, db1, db2, db3;

    public Anzeige(double pX, double pY, double pZ, double pLX, double pLY) {
        aHintergrund = new GLQuader(pX, pY, pZ, pLX, pLY, 0);
        aHintergrund.setzeSichtbarkeit(false);
        scaleX = pLX / 5;
        scaleY = pLY / 3;
        scaleYhalf = pLY / 4;
        pos1 = new double[]{pX - (scaleX * 2), pY + scaleYhalf};
        pos2 = new double[]{pX - (scaleX / 2), pY + scaleYhalf};
        pos3 = new double[]{pX + (scaleX / 2), pY + scaleYhalf};
        pos4 = new double[]{pX + (scaleX + (scaleX / 2)), pY + scaleYhalf};
        pos5 = new double[]{pX - (scaleX * 2), pY - scaleYhalf};
        pos6 = new double[]{pX - (scaleX / 2), pY - scaleYhalf};
        pos7 = new double[]{pX + (scaleX / 2), pY - scaleYhalf};
        pos8 = new double[]{pX + (scaleX + (scaleX / 2)), pY - scaleYhalf};

        benzin = new GLQuader(pos1[0], pos1[1], pZ, scaleX, scaleY * 0.8, 0, "benzin.png");
        b1 = new GLQuader(pos2[0], pos2[1], pZ, scaleX, scaleY, 0, "0.png");
        b2 = new GLQuader(pos3[0], pos3[1], pZ, scaleX, scaleY, 0, "0.png");
        b3 = new GLQuader(pos4[0], pos4[1], pZ, scaleX, scaleY, 0, "0.png");
        muenze = new GLZylinder(pos5[0], pos5[1], pZ, scaleX / 2, 0, "coin.png");
        c1 = new GLQuader(pos6[0], pos6[1], pZ, scaleX, scaleY, 0, "0.png");
        c2 = new GLQuader(pos7[0], pos7[1], pZ, scaleX, scaleY, 0, "0.png");
        c3 = new GLQuader(pos8[0], pos8[1], pZ, scaleX, scaleY, 0, "0.png");

        d1 = 0;
        d2 = 0;
        d3 = 0;
    }

    public void setzePosition(double pX, double pY, double pZ){
        pos1 = new double[]{pX - (scaleX * 2), pY + scaleYhalf};
        pos2 = new double[]{pX - (scaleX / 2), pY + scaleYhalf};
        pos3 = new double[]{pX + (scaleX / 2), pY + scaleYhalf};
        pos4 = new double[]{pX + (scaleX + (scaleX / 2)), pY + scaleYhalf};
        pos5 = new double[]{pX - (scaleX * 2), pY - scaleYhalf};
        pos6 = new double[]{pX - (scaleX / 2), pY - scaleYhalf};
        pos7 = new double[]{pX + (scaleX / 2), pY - scaleYhalf};
        pos8 = new double[]{pX + (scaleX + (scaleX / 2)), pY - scaleYhalf};
        benzin.setzePosition(pos1[0], pos1[1], pZ);
        b1.setzePosition(pos2[0], pos2[1], pZ);
        b2.setzePosition(pos3[0], pos3[1], pZ);
        b3.setzePosition(pos4[0], pos4[1], pZ);
        muenze.setzePosition(pos5[0], pos5[1], pZ);
        c1.setzePosition(pos6[0], pos6[1], pZ);
        c2.setzePosition(pos7[0], pos7[1], pZ);
        c3.setzePosition(pos8[0], pos8[1], pZ);
        aHintergrund.setzePosition(pX, pY, pZ);
    }

    public void verschiebe(double pX, double pY, double pZ){
        benzin.verschiebe(pX, pY, pZ);
        c1.verschiebe(pX, pY, pZ);
        c2.verschiebe(pX, pY, pZ);
        c3.verschiebe(pX, pY, pZ);
        muenze.verschiebe(pX, pY, pZ);
        b1.verschiebe(pX, pY, pZ);
        b2.verschiebe(pX, pY, pZ);
        b3.verschiebe(pX, pY, pZ);
        aHintergrund.verschiebe(pX, pY, pZ);
    }

    public void loesche(){
        benzin.loesche();
        c1.loesche();
        c2.loesche();
        c3.loesche();
        muenze.loesche();
        b1.loesche();
        b2.loesche();
        b3.loesche();
        aHintergrund.loesche();
    }

    public void updateCounter(int type) {
        //System.out.println("Debug: -> Updated type " + type + " in Anzeige");
        // (type: 1 = Benzin, 2 = Muenzen)
        d1 = 0;
        d2 = 0;
        d3 = 0;
        if (type == 2) {
            for (int i = Spiel.coinSum; i >= 1; i -= 1) {
                d1 = d1 + 1;
                if (d1 >= 10) {
                    d1 = 0;
                    d2 = d2 + 1;
                    if (d2 >= 10) {
                        d2 = 0;
                        d3 = d3 + 1;
                        if (d3 >= 10) {
                            d3 = 9;
                            d2 = 9;
                            d1 = 9;
                        }
                    }
                }
            }
            dc1 = d1;
            dc2 = d2;
            dc3 = d3;
        } else if (type == 1){
            for (int i = Spiel.benzinSum; i >= 1; i -= 1) {
                d1 = d1 + 1;
                if (d1 >= 10) {
                    d1 = 0;
                    d2 = d2 + 1;
                    if (d2 >= 10) {
                        d2 = 0;
                        d3 = d3 + 1;
                        if (d3 >= 10) {
                            d3 = 9;
                            d2 = 9;
                            d1 = 9;
                        }
                    }
                }
            }
            db1 = d1;
            db2 = d2;
            db3 = d3;
        }
        updateDigits(type);
    }

    private void updateDigits(int type) {
        // (type: 1 = Benzin, 2 = Muenzen)
        if (type == 1){
            switch (db1){
                case 0:
                    b3.setzeTextur("0.png");
                    break;
                case 1:
                    b3.setzeTextur("1.png");
                    break;
                case 2:
                    b3.setzeTextur("2.png");
                    break;
                case 3:
                    b3.setzeTextur("3.png");
                    break;
                case 4:
                    b3.setzeTextur("4.png");
                    break;
                case 5:
                    b3.setzeTextur("5.png");
                    break;
                case 6:
                    b3.setzeTextur("6.png");
                    break;
                case 7:
                    b3.setzeTextur("7.png");
                    break;
                case 8:
                    b3.setzeTextur("8.png");
                    break;
                case 9:
                    b3.setzeTextur("9.png");
                    break;
                default:
                    System.out.println("Es ist ein Fehler aufgetreten!");
            }
            switch (db2){
                case 0:
                    b2.setzeTextur("0.png");
                    break;
                case 1:
                    b2.setzeTextur("1.png");
                    break;
                case 2:
                    b2.setzeTextur("2.png");
                    break;
                case 3:
                    b2.setzeTextur("3.png");
                    break;
                case 4:
                    b2.setzeTextur("4.png");
                    break;
                case 5:
                    b2.setzeTextur("5.png");
                    break;
                case 6:
                    b2.setzeTextur("6.png");
                    break;
                case 7:
                    b2.setzeTextur("7.png");
                    break;
                case 8:
                    b2.setzeTextur("8.png");
                    break;
                case 9:
                    b2.setzeTextur("9.png");
                    break;
                default:
                    System.out.println("Es ist ein Fehler aufgetreten!");
            }
            switch (db3){
                case 0:
                    b1.setzeTextur("0.png");
                    break;
                case 1:
                    b1.setzeTextur("1.png");
                    break;
                case 2:
                    b1.setzeTextur("2.png");
                    break;
                case 3:
                    b1.setzeTextur("3.png");
                    break;
                case 4:
                    b1.setzeTextur("4.png");
                    break;
                case 5:
                    b1.setzeTextur("5.png");
                    break;
                case 6:
                    b1.setzeTextur("6.png");
                    break;
                case 7:
                    b1.setzeTextur("7.png");
                    break;
                case 8:
                    b1.setzeTextur("8.png");
                    break;
                case 9:
                    b1.setzeTextur("9.png");
                    break;
                default:
                    System.out.println("Es ist ein Fehler aufgetreten!");
            }
        } else {
            switch (dc1){
                case 0:
                    c3.setzeTextur("0.png");
                    break;
                case 1:
                    c3.setzeTextur("1.png");
                    break;
                case 2:
                    c3.setzeTextur("2.png");
                    break;
                case 3:
                    c3.setzeTextur("3.png");
                    break;
                case 4:
                    c3.setzeTextur("4.png");
                    break;
                case 5:
                    c3.setzeTextur("5.png");
                    break;
                case 6:
                    c3.setzeTextur("6.png");
                    break;
                case 7:
                    c3.setzeTextur("7.png");
                    break;
                case 8:
                    c3.setzeTextur("8.png");
                    break;
                case 9:
                    c3.setzeTextur("9.png");
                    break;
                default:
                    System.out.println("Es ist ein Fehler aufgetreten!");
            }
            switch (dc2){
                case 0:
                    c2.setzeTextur("0.png");
                    break;
                case 1:
                    c2.setzeTextur("1.png");
                    break;
                case 2:
                    c2.setzeTextur("2.png");
                    break;
                case 3:
                    c2.setzeTextur("3.png");
                    break;
                case 4:
                    c2.setzeTextur("4.png");
                    break;
                case 5:
                    c2.setzeTextur("5.png");
                    break;
                case 6:
                    c2.setzeTextur("6.png");
                    break;
                case 7:
                    c2.setzeTextur("7.png");
                    break;
                case 8:
                    c2.setzeTextur("8.png");
                    break;
                case 9:
                    c2.setzeTextur("9.png");
                    break;
                default:
                    System.out.println("Es ist ein Fehler aufgetreten!");
            }
            switch (dc3){
                case 0:
                    c1.setzeTextur("0.png");
                    break;
                case 1:
                    c1.setzeTextur("1.png");
                    break;
                case 2:
                    c1.setzeTextur("2.png");
                    break;
                case 3:
                    c1.setzeTextur("3.png");
                    break;
                case 4:
                    c1.setzeTextur("4.png");
                    break;
                case 5:
                    c1.setzeTextur("5.png");
                    break;
                case 6:
                    c1.setzeTextur("6.png");
                    break;
                case 7:
                    c1.setzeTextur("7.png");
                    break;
                case 8:
                    c1.setzeTextur("8.png");
                    break;
                case 9:
                    c1.setzeTextur("9.png");
                    break;
                default:
                    System.out.println("Es ist ein Fehler aufgetreten!");
            }
        }
    }
}