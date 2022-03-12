import GLOOP.GLKugel;
import GLOOP.GLQuader;

import java.util.concurrent.ThreadLocalRandom;

public class Powerup {

    GLKugel marker;
    public boolean active = false;
    private boolean animation = false;
    private int animationState = 0;
    private double[] markerAnimPos = {0.0,0.0};
    private GLQuader[] particles = new GLQuader[16];
    private double[] particlePosX = new double[16];
    private double[] particlePosY = new double[16];
    private double[] drehung = new double[16];

    public Powerup(double pX,double pY,double pZ){
        // Erstellt einen Marker und macht ihn unsichtbar.
        marker = new GLKugel(pX,pY,pZ,1);
        marker.setzeSichtbarkeit(false);
    }

    public void setzePosition(double pX, double pY, double pZ){
        // Setzt den Marker an eine bestimmte Position.
        marker.setzePosition(pX, pY, pZ);
    }

    public void verschiebe(double pX, double pY, double pZ){
        // Verschiebt den Marker.
        marker.verschiebe(pX, pY, pZ);
    }

    public void loesche(){
        // Löscht den Marker.
        // td - Partikell löschen!
        if (animation) {
            animation = false;
            animationState = 0;
            for (GLQuader particle : particles) {
                particle.loesche();
            }
        }
        marker.loesche();
    }

    public void collected () {
        animation = true;
        animationState = 300;
        markerAnimPos = new double[]{(double) marker.gibX(), (double) marker.gibY()};
        for (int i = 0; i < particles.length; i++) {
            double x = markerAnimPos[0] + ThreadLocalRandom.current().nextDouble(9,15) * Math.cos(ThreadLocalRandom.current().nextDouble(0,361) );
            double y = markerAnimPos[1] + ThreadLocalRandom.current().nextDouble(9,15) * Math.sin(ThreadLocalRandom.current().nextDouble(0,361) );
            particles[i] = new GLQuader(x, y, 0.1,7,7,0);
            particlePosX[i] = marker.gibX();
            particlePosY[i] = marker.gibY();
            drehung[i] = ThreadLocalRandom.current().nextDouble(-1,1);
            particles[i].setzeFarbe(ThreadLocalRandom.current().nextDouble(0.5,0.8), ThreadLocalRandom.current().nextDouble(0.3,0.8),0);
        }
    }

    public boolean isAnimation () {
        return animation;
    }

    public void animate (double yMove) {
        if (animationState > 0) {
            animationState--;
            for (int i = 0; i < particles.length; i++) {
                markerAnimPos[1] += yMove;
                particles[i].verschiebe(0,yMove,0);
                particlePosY[i] += yMove;
                double xDir = (particles[i].gibX() - particlePosX[i]) / 600;
                double yDir = (particles[i].gibY() - particlePosY[i]) / 600;
                xDir = xDir * (animationState / 20.0);
                yDir = yDir * (animationState / 20.0);
                particles[i].verschiebe(xDir, yDir, 0);
                particlePosX[i] += xDir;
                particlePosY[i] += yDir;
                particles[i].drehe(0, 0, drehung[i] * 1.2);
            }
        } else {
            animation = false;
            animationState = 0;
            for (GLQuader particle : particles) {
                particle.loesche();
            }
        }
    }

    public double[] gibKoordinaten(){
        // Gibt die Koordinaten des Markers, bzw. des Power-Ups als Array zurück.
        return new double[] {marker.gibX(), marker.gibY(), marker.gibZ()};
    }
}
