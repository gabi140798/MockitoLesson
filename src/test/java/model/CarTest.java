package model;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;

public class CarTest {


//    @Test
//    public void shouldReturnOpelOnGetProducer(){
//        Car car = new Car("Ferrari");
//        String producer = car.getProducer();
//        assertEquals("Ferrari", producer);
//    }

    @Mock
    private Car carMock;

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    // pokazuje jak dziala mockito/ TAKICH TESTOW NIE MA PO CO PISAC, bo byscie testowali mockito a nie funkcjonalnosc
//    @Test
//    public void shouldReturnOpelOnGetProducer(){
//        Car carMock = Mockito.mock(Car.class); // tworzymy atrape obiektu
//        Mockito.when(carMock.getProducer()).thenReturn("Porsche"); // uczymy metode co ma zwracac
//        assertEquals("Porsche", carMock.getProducer());
//    }

    @Test
    public void shouldReturnFerrariOnGetProducer() {
        Mockito.when(carMock.getProducer()).thenReturn("Ferrari");
        assertEquals("Ferrari", carMock.getProducer());
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgExceptionOnGetProducer() {
        Mockito.when(carMock.getProducer()).thenThrow(new IllegalArgumentException());
        carMock.getProducer();
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgExceptionOnSetProducer() {
        Mockito.doThrow(new IllegalArgumentException()).when(carMock).setProducer("Lambo");
        carMock.setProducer("Lambo");
    }

    @Test
    void verify() {
        for(int i = 0; i < 5; i++){
            carMock.setProducer("lamborghini");
        }
        Mockito.verify(carMock, Mockito.atLeastOnce()).setProducer(Mockito.anyString()); // przynajmniej raz
        Mockito.verify(carMock, Mockito.atMost(5)).setProducer(Mockito.anyString()); // najwiecej iles
        Mockito.verify(carMock, Mockito.times(1)).setProducer(Mockito.anyString()); // dokladnie 1
        Mockito.verify(carMock, Mockito.never()).setProducer(Mockito.anyString());

        Mockito.verify(carMock, Mockito.atLeastOnce()).setProducer(Mockito.startsWith("lam"));
        Mockito.verify(carMock, Mockito.atLeastOnce()).setProducer(Mockito.contains("lam"));
        Mockito.verify(carMock, Mockito.atLeastOnce()).setProducer(Mockito.matches("\\w+"));
    }




    /*
    weather service

    getWeather(intefejs od temperatury)->

    jesli temperatura to 30 -> goraco

    jesli temprtura to -5 -> zimno
    ZLE!!!!!!!!!!!!!!!!!!!!
        mockja metode getWeather() ze zwraca ze jest goraco
        i sprawdzaja czy ona zwrocila ze jest goraco

        DOBRZE!!!
        mockujemy interfjes metode getTemprarutre() ze zwraca np 30
        i przy 30 srpawdzamy czy metoda getWeatehr() zwraca ze jest goraco



     */

}