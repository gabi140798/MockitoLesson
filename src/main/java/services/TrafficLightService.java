package services;

import interfaces.DistanceSensor;
import interfaces.LightController;
import interfaces.SpeedSensor;

public class TrafficLightService {

    private final DistanceSensor distanceSensor;
    private final SpeedSensor speedSensor;
    private final LightController lightController;

    public TrafficLightService(DistanceSensor distanceSensor, SpeedSensor speedSensor, LightController lightController) {
        this.distanceSensor = distanceSensor;
        this.speedSensor = speedSensor;
        this.lightController = lightController;
    }

    public void checkAndControlTrafficLight() {
        double speed = speedSensor.getSpeed();
        double distance = distanceSensor.getDistance();

        if (speed > 40 && distance <= 50) {
            lightController.turnRed();
        } else {
            lightController.turnOff();
        }
    }
}
