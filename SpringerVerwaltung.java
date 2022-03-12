public class SpringerVerwaltung {

    Springer springer;
    SpringerRainbow springerRainbow;

    private final String cs = Spiel.characterSkin;

    public SpringerVerwaltung(){
        switch (cs){
            case "rainbow":
                springerRainbow = new SpringerRainbow();
                break;
            case "default":
            default:
                springer = new Springer();
                break;
        }
    }

    public void verschiebe(double pX, double pY, double pZ, int pFacing){
        switch (cs){
            case "rainbow":
                springerRainbow.verschiebe(pX,pY,pZ,pFacing);
                break;
            case "default":
            default:
                springer.verschiebe(pX,pY,pZ,pFacing);
                break;
        }
    }

    public void setzePosition(double pX, double pY, double pZ, int pFacing){
        switch (cs){
            case "rainbow":
                springerRainbow.setzePosition(pX,pY,pZ,pFacing);
                break;
            case "default":
            default:
                springer.setzePosition(pX,pY,pZ,pFacing);
                break;
        }
    }

    public void loesche(){
        switch (cs){
            case "rainbow":
                springerRainbow.loesche();
                break;
            case "default":
            default:
                springer.loesche();
                break;
        }
    }

    public void animate(boolean spawn) {
        switch (cs){
            case "rainbow":
                springerRainbow.animate(spawn);
                break;
            case "default":
            default:
                springer.animate(spawn);
                break;
        }
    }

    public void resetAnim() {
        switch (cs){
            case "rainbow":
                springerRainbow.resetAnim();
                break;
            case "default":
            default:
                springer.resetAnim();
                break;
        }
    }

    public double[] gibKoordinaten(boolean pLowest){
        double[] x;
        switch (cs){
            case "rainbow":
                x = springerRainbow.gibKoordinaten(pLowest);
                break;
            case "default":
            default:
                x = springer.gibKoordinaten(pLowest);
                break;
        }
        return x;
    }
}
