package br.com.nt.springdata;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import br.com.nt.springdata.service.CargoService;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {

	private boolean system = true;
	private final CargoService cargoService;

	public SpringDataApplication(CargoService cargoService) {
		this.cargoService = cargoService;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Scanner scanner = new Scanner(System.in);

		while (system) {
			System.out.println(" #####################################");
			System.out.println(" Qual acao voce quer executar" + "\n");
			System.out.println(" 0-Sair");
			System.out.println(" 1-Cargo");
			System.out.println(" 2-Atualizar");
			System.out.println(" 3-Deletar");

			int action = scanner.nextInt();

			switch (action) {
			case 1: {

				cargoService.salvar(scanner);
				break;
			}
			case 2: {

				cargoService.update(scanner);
				break;
			}
			case 3: {

				cargoService.delete(scanner);
				break;
			}
			default:
				system = false;
			}

		}

	}

}
