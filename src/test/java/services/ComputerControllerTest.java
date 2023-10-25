package services;

import interfaces.RoofController;
import interfaces.SpeedSensor;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;

public class ComputerControllerTest {

    private ComputerController computerController;
    @Mock
    private SpeedSensor speedSensorMock;
    @Mock
    private RoofController roofControllerMock;

    @Before
    public void init(){
        MockitoAnnotations.openMocks(this);
        computerController = new ComputerController(roofControllerMock, speedSensorMock);
    }

    @Test
    public void shouldOpenRoofWhenSpeedIs30(){
        Mockito.when(speedSensorMock.getSpeed()).thenReturn(30.0);
        computerController.openRoof();
        Mockito.verify(roofControllerMock).open();
    }
    @Test(expected = IllegalArgumentException.class)
    public void shouldNotCloseRoofWhenSpeedIs31(){
        Mockito.when(speedSensorMock.getSpeed()).thenReturn(31.0);
        computerController.closeRoof();
    }




}