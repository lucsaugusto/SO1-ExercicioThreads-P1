package controller;

import java.util.concurrent.Semaphore;

import model.Atleta;

public class ThreadAtleta extends Thread{
	
	private Semaphore semaforo;
	private Atleta atleta;
	private static int posicao;
	private static int pontuacao = 250;
	private static Atleta[] atletas = new Atleta[25];
	
	
	public ThreadAtleta(int idAtleta, Semaphore semaforo) {
		this.atleta = new Atleta(idAtleta);
		this.semaforo = semaforo;
	}

	@Override
	public void run() {
		corrida();
		try {
			semaforo.acquire();
			tiro();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		semaforo.release();
		ciclismo();
		posicao();
	}
	
	private void corrida() {
		int distanciaTotal = 3000;
		int distanciaPercorrida = 0;
		int deslocamento;
		int tempo = 30;
		while(distanciaPercorrida < distanciaTotal) {
			deslocamento = (int)((Math.random() * 6) + 20);
			distanciaPercorrida += deslocamento;
			try {
				sleep(tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void tiro() {
		int tentativas = 3;
		int disparos = 0;
		int pontos;
		int tempo;
		while(disparos < tentativas) {
			disparos++;
			pontos = (int)(Math.random() * 11);
			tempo = (int)((Math.random() * 2501) + 500);
			try {
				this.atleta.setPontos(pontos);
				sleep(tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void ciclismo() {
		int distanciaTotal = 5000;
		int distanciaPercorrida = 0;
		int deslocamento;
		int tempo = 40;
		while(distanciaPercorrida < distanciaTotal) {
			deslocamento = (int)((Math.random() * 11) + 30);
			distanciaPercorrida += deslocamento;
			try {
				sleep(tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void posicao() {
		this.atleta.setPontos(pontuacao);
		atletas[posicao] = atleta;
		pontuacao -= 10;
		posicao++;
		if(posicao == 25) {
			Atleta aux = new Atleta();
			for(int idAtleta = 0; idAtleta < 25; idAtleta++) {
	        	for(int cont = 0; cont < 24; cont++) {
	        		if(atletas[idAtleta].getPontos() > atletas[cont].getPontos()) {
	        			aux = atletas[cont];
	        			atletas[cont] = atletas[idAtleta];
	        			atletas[idAtleta] = aux;
	        		}
	        	}
	        }
			
			for(int idAtleta = 0; idAtleta < 25; idAtleta++) {
	        	System.out.println((idAtleta + 1) + "º - " + atletas[idAtleta].getNome() +" : " + atletas[idAtleta].getPontos() + " Pontos.\n");
	        }
		}
	}
}
