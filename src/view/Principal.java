package view;

import java.util.concurrent.Semaphore;

import controller.ThreadCruzamento;

public class Principal {
	public static void main(String[] args) {
		int permissoes = 1;
		Semaphore semaforo = new Semaphore(permissoes);
		for (int idThread = 0; idThread < 4; idThread++) {
			Thread tCruzamento = new ThreadCruzamento(idThread, semaforo);
			tCruzamento.start();
		}
	}
}
