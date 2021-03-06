package br.com.nt.springdata;

import java.util.Scanner;
import java.util.logging.Logger;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import br.com.nt.springdata.service.CargoService;
import br.com.nt.springdata.service.FuncionarioService;
import br.com.nt.springdata.service.RelatorioService;
import br.com.nt.springdata.service.UnidadeTrabalhoService;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {

	private static final Logger LOGGER = Logger.getLogger(SpringDataApplication.class.getName());

	private boolean system = true;
	private final CargoService cargoService;
	private final FuncionarioService funcionarioService;
	private final UnidadeTrabalhoService unidadeTrabalhoService;
	private final RelatorioService relatorioService;

	public SpringDataApplication(CargoService cargoService, FuncionarioService funcionarioService,
			UnidadeTrabalhoService unidadeTrabalhoService, RelatorioService relatorioService) {

		this.cargoService = cargoService;
		this.funcionarioService = funcionarioService;
		this.unidadeTrabalhoService = unidadeTrabalhoService;
		this.relatorioService = relatorioService;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {

		Scanner scanner = new Scanner(System.in);

		while (system) {
			System.out.println("\n");
			System.out.println("    Qual a função deseja executar " + "\n");
			System.out.println("    0 - Sair");
			System.out.println("    1 - Cargo");
			System.out.println("    2 - Funcionario");
			System.out.println("    3 - Unidade");
			System.out.println("    4 - Relatorios");

			Integer opcao = scanner.nextInt();

			switch (opcao) {
			case 1: {

				cargoService.iniciar(scanner);
				break;

			}
			case 2: {

				funcionarioService.iniciar(scanner);
				break;
			}

			case 3: {

				unidadeTrabalhoService.iniciar(scanner);
				break;
			}
			case 4: {

				relatorioService.inicar(scanner);
				break;
			}

			default:
				system = false;
				LOGGER.info(" SpringApplication :: run :: system value :: -> " + system);
			}
		}
	}

}
