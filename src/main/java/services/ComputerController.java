package services;


import interfaces.RoofController;
import interfaces.SpeedSensor;

public class ComputerController {


    private RoofController roofController;
    private SpeedSensor speedSensor;

    public ComputerController(RoofController roofController, SpeedSensor speedSensor) {
        this.roofController = roofController;
        this.speedSensor = speedSensor;
    }

    public void openRoof() {
        double speed = speedSensor.getSpeed();

        if (speed <= 30) {
            roofController.open();
        } else {
            System.out.println("jedziesz za szybko");
        }
    }

    public void closeRoof() {
        double speed = speedSensor.getSpeed();

        if (speed > 30) {
            throw new IllegalArgumentException("jedziesz za szybko");
        }
        roofController.close();
    }
}
