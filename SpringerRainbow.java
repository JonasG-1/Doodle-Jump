public class SpringerRainbow extends Springer {

    public SpringerRainbow(){
        super();
        modHose[1] -= 500;
        modHoseLinie1[1] -= 500;
        modHoseLinie2[1] -= 500;
        hose.verschiebe(0,-500,0);
        hoseLinie1.verschiebe(0,-500,0);
        hoseLinie2.verschiebe(0,-500,0);
    }

    @Override
    public void verschiebe(double pX, double pY, double pZ, int pFacing) {
        super.verschiebe(pX, pY, pZ, pFacing);

        if (move[0] == 1){
            if (r >= 1){
                move[0] = 0;
                move[2] = -1;
            } else {
                r += 0.01;
            }
        }
        if (move[1] == 1){
            if (g >= 1){
                move[1] = 0;
                move[0] = -1;
            } else {
                g += 0.01;
            }
        }
        if (move[2] == 1){
            if (b >= 1){
                move[2] = 0;
                move[1] = -1;
            } else {
                b += 0.01;
            }
        }
        if (move[0] == -1){
            if (r <= 0){
                move[0] = 0;
                move[2] = 1;
            } else {
                r -= 0.01;
            }
        }
        if (move[1] == -1){
            if (g <= 0){
                move[1] = 0;
                move[0] = 1;
            } else {
                g -= 0.01;
            }
        }
        if (move[2] == -1){
            if (b <= 0){
                move[2] = 0;
                move[1] = 1;
            } else {
                b -= 0.01;
            }
        }
        koerper.setzeFarbe(r,g,b);
        fuss1.setzeFarbe(r,g,b);
        fuss2.setzeFarbe(r,g,b);
        fuss3.setzeFarbe(r,g,b);
        kopf.setzeFarbe(r,g,b);
        nase.setzeFarbe(r,g,b);
    }
}
