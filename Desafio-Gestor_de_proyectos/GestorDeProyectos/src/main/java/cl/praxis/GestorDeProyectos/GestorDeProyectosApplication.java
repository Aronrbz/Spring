package cl.praxis.GestorDeProyectos;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GestorDeProyectosApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(GestorDeProyectosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Persona persona = new Persona("Aron", "Bustos", 35);

		System.out.println(persona);
	}
}
