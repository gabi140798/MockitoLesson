package services;

import interfaces.DistanceSensor;
import interfaces.LightController;
import interfaces.SpeedSensor;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class TrafficLightServiceTest {

    private TrafficLightService trafficLightService;
    @Mock
    private DistanceSensor distanceSensorMock;
    @Mock
    private SpeedSensor speedSensorMock;
    @Mock
    private LightController lightControllerMock;


    @Before
    public void init(){
        MockitoAnnotations.openMocks(this);
        trafficLightService = new TrafficLightService(distanceSensorMock,speedSensorMock, lightControllerMock);
    }
    @Test
    public void shouldTrafficLightTurnRed() {
        Mockito.when(distanceSensorMock.getDistance()).thenReturn(50.0);
        Mockito.when(speedSensorMock.getSpeed()).thenReturn(41.0);
        trafficLightService.checkAndControlTrafficLight();
        Mockito.verify(lightControllerMock).turnRed();
    }

    @Test
    public void shouldTrafficLightTurnOffWhenSpeedIs40() {
        Mockito.when(distanceSensorMock.getDistance()).thenReturn(50.0);
        Mockito.when(speedSensorMock.getSpeed()).thenReturn(40.0);
        trafficLightService.checkAndControlTrafficLight();
        Mockito.verify(lightControllerMock).turnOff();
    }

    @Test
    public void shouldTrafficLightTurnOffWhenDistanceIs51() {
        Mockito.when(distanceSensorMock.getDistance()).thenReturn(51.0);
        Mockito.when(speedSensorMock.getSpeed()).thenReturn(41.0);
        trafficLightService.checkAndControlTrafficLight();
        Mockito.verify(lightControllerMock).turnOff();
    }
}
