package es.uniovi.carlos;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 * 
 * Aqui podemos ver metodos de la clase ExecutorService:
 *
 * http://tutorials.jenkov.com/java-util-concurrent/executorservice.html
 * 
 * Aqui podemos ver un ejemplo de ExecutorService y su funcionamiento
 * 
 * https://jarroba.com/multitarea-e-hilos-en-java-con-ejemplos-ii-runnable-executors/
 * 
 * uando un programa ejecuta muchas tareas concurrentes, todo el código relacionado con los threads 
 * tiene que ser implementado, se tiene que crear un objeto por thread, ejecutar el thread, obtener sus resultados,
 * y así sucesivamente. Esto puede traer algunos problemas tales como no administrar de manera eficiente los recursos 
 * de la máquina y afectar el rendimiento de la aplicación. Para aplicaciones de gran tamaño se necesita un mejor enfoque y 
 * el executor freamwork puede ayudar con esto.
 * 
 */

public class ExecutorServicePrueba {

	//newFixedThreadPool es piscina (pool) de threads
	ExecutorService executorService = Executors.newFixedThreadPool(10);

	public ExecutorServicePrueba() {
		pruebaExecutorService();
	}

	public static void main(String[] argumentos) {
		new ExecutorServicePrueba();
	}

	/* 
	 * De esta forma lo que estamos diciendo al objeto "executor" es que tiene que procesar a los 50 peticiones y 
	 * que se encargará de procesarlos en orden, utilizando 10 threads o hilos que le hemos dicho al constructor de newFixedThreadPool,
	 * es decir, que se encargue de gestionar la cola de procesos que son 50 con esos 10 threads.
	 * 
	 * Como resultado de la ejecución del programa, obtenemos 50 procesos que imprimen "Asynchronous task" por consola impresos por 10 threads:
	 * 
	 * SI pusiesemos por ejemplo a ejecutar 5 procesos y 5 threads entonces iria mas rapido ya que cada thread ejecutaria un proceso a la vez
	 * y el tiempo total seria el tiempo que tardase el proceso que mas tiempo tarde. El problema es que si tenemos 100 ,1000,10.000 o muchos procesos
	 * no podemos asignarle un thread a cada uno ya que consumiria un tiempo DESORBITAOD
	 * 
	 */
	public void pruebaExecutorService() {
		for (int i = 0; i < 50; i++) {
			executorService.execute(new Runnable() {
				public void run() {
					System.out.println("Asynchronous task");
				}
			});
		}

		executorService.shutdown();

	}

}
