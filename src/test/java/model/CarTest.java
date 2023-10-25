package model;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class CarTest {


//    @Test
//    public void shouldReturnOpelOnGetProducer(){
//        Car car = new Car("Ferrari");
//        String producer = car.getProducer();
//        assertEquals("Ferrari", producer);
//    }


    // pokazuje jak dziala mockito/ TAKICH TESTOW NIE MA PO CO PISAC, bo byscie testowali mockito a nie funkcjonalnosc
    @Test
    public void shouldReturnOpelOnGetProducer(){
        Car carMock = Mockito.mock(Car.class); // tworzymy atrape obiektu
        Mockito.when(carMock.getProducer()).thenReturn("Porsche"); // uczymy metode co ma zwracac
        assertEquals("Porsche", carMock.getProducer());
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