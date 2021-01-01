public class Schwerkraft
{

    public Schwerkraft()
    {
        
        
            
            
    }
    public int schwerkraftZaehler(int zahl, double schwerkraft){
        int grCount = zahl;
        if(schwerkraft >= -0.44){
            if(schwerkraft == 0.5){
                grCount = 0;   
            }
            if(schwerkraft == 1) {
                grCount = 1000;
            }
            grCount++;                  
        }
            return grCount;
    }
    public double schwerkraftBerechner(int zahl, double schwerkraft){
        int grCount = zahl;
        double gravity = schwerkraft;
        if(grCount == 1){
            gravity = 0.49;
        }
        if(grCount == 150){
            gravity = 0.35;
        }
        if(grCount == 300){
            gravity = 0.2;
        }
        if(grCount == 400){
            gravity = 0.1;
        }
        if(grCount == 500){
            gravity = 0;
        }
        if(grCount == 600){
            gravity = -0.1;
        }
        if(grCount == 700){
            gravity = -0.2;
        }
        if(grCount == 850){
            gravity = -0.35;
        }
        if(grCount == 950){
            gravity = -0.45;
            grCount = 0;
        }
        if(grCount == 1001) {
            gravity = 0.99;
        }
        if(grCount == 1100) {
            gravity = 0.9;
        }
        if(grCount == 1200) {
            gravity = 0.8;
        }
        if(grCount == 1300) {
            gravity = 0.65;
        }
        if(grCount == 1400) {
            gravity = 0.5;
        }
        return gravity;
    }


}
