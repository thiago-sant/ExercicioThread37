package controller;

import java.util.concurrent.Semaphore;

public class ThreadCruzamento extends Thread {
	private int idThread;
	private Semaphore semaforo;
	private String sentido [] = {"Norte", "Sul", "Leste", "Oeste"};
	
	public ThreadCruzamento (int idThread, Semaphore semaforo) {
		this.idThread = idThread;
		this.semaforo = semaforo;
	}
	
	@Override
	public void run() {
		try {
			semaforo.acquire();
			Cruzamento();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}
	}

	private void Cruzamento() {
		System.out.println("O carro #" +idThread+ " esta indo para o "+ sentido[idThread] +".");
		
	}
}
