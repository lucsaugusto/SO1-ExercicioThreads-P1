package main;

import java.util.concurrent.Semaphore;

import controller.ThreadAtleta;

public class Main {

    public static void main(String[] args) {
    	
        Semaphore semaforo = new Semaphore(5);
        
        for(int idAtleta = 0; idAtleta < 25; idAtleta++) {
        	Thread tAtleta = new ThreadAtleta(idAtleta+1, semaforo);
        	tAtleta.start();
        }
    }
}
