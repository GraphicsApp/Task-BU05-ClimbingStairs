package de.mi.ur.bouncer.stairs;

import de.ur.mi.bouncer.apps.BouncerApp;
import de.ur.mi.bouncer.apps.BouncerLauncher;

public class ClimbingStairs extends BouncerApp {

    @Override
    public void bounce() {
        loadMap("Stairs");
        climbStairs();
    }

    private void climbStairs() {
        // Vor Beginn des Stufenaufstiegs richten wir Bouncer initial nach Norden aus
        bouncer.turnLeft();
        // Solange Bouncer eine Ebene höher steigen kann, steigt er auf die nächste Stufe
        while (bouncer.canMoveForward()) {
            climbOneStair();
            // Bouncer wird vor dem nächsten Schritt nach Norden ausgerichtet
            bouncer.turnLeft();
        }
        // Auf der obersten Stufe angekommen richten wir Bouncer zuletzt nach WESTEN aus
        turnRight();
    }

    /**
     * Bouncer steigt eine Stufe der Treppe hoch
     * <p>
     * Pre-Condition: Bouncer blickt nach Norden und steht direkt vor der Stufe
     * Post-Condition: Bouncer befindet sich auf der Stufe und blickt nach Westen
     */
    private void climbOneStair() {
        bouncer.move();
        turnRight();
        bouncer.move();
    }

    /**
     * Bouncer dreht sich um 90 Grad nach rechts
     * <p>
     * Pre-Condition: -
     * Post-Condition: Bouncers Blickrichtung hat sich um 90 Grad nach Rechts verschoben
     */
    private void turnRight() {
        bouncer.turnLeft();
        bouncer.turnLeft();
        bouncer.turnLeft();
    }

    public static void main(String[] args) {
        BouncerLauncher.launch();
    }
}