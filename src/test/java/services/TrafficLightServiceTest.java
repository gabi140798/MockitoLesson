package services;

import interfaces.DistanceSensor;
import interfaces.LightController;
import interfaces.SpeedSensor;
import org.junit.Test;
import org.mockito.Mockito;

public class TrafficLightServiceTest {

    @Test
    public void testTrafficLightTurnsRedWhenSpeedGreaterThan40AndDistanceLessThan50() {
        DistanceSensor distanceSensor = Mockito.mock(DistanceSensor.class);
        SpeedSensor speedSensor = Mockito.mock(SpeedSensor.class);
        LightController lightController = Mockito.mock(LightController.class);

        Mockito.when(distanceSensor.getDistance()).thenReturn(40.0);
        Mockito.when(speedSensor.getSpeed()).thenReturn(50.0);

        TrafficLightService trafficLightService = new TrafficLightService(distanceSensor, speedSensor, lightController);
        trafficLightService.checkAndControlTrafficLight();

        Mockito.verify(lightController, Mockito.times(1)).turnRed();
    }
}
