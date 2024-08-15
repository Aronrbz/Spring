package cl.praxis.GestorBiblioteca;

import cl.praxis.GestorBiblioteca.service.BibliotecaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GestorBibliotecaApplication implements CommandLineRunner {

	@Autowired
	private BibliotecaService bibliotecaService;

	public static void main(String[] args) {
		SpringApplication.run(GestorBibliotecaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Llamando al método del servicio
		bibliotecaService.registrarLibro("El Quijote de la Mancha");
	}
}
