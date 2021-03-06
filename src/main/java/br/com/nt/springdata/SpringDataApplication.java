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

		LOGGER.info(" SpringApplication :: run :: system value :: -> " + system);
		LOGGER.info(" SpringApplication :: this.cargoService :: -> " + cargoService);
		LOGGER.info(" SpringApplication :: this.funcionarioService :: -> " + funcionarioService);
		LOGGER.info(" SpringApplication :: this.unidadeTrabalhoService :: -> " + unidadeTrabalhoService);
		LOGGER.info(" SpringApplication :: this.relatorioService :: -> " + relatorioService);

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
				// LOGGER.info(" SpringApplication :: digitou opção -> " + opcao);
				cargoService.iniciar(scanner);
				break;

			}
			case 2: {
				// LOGGER.info(" SpringApplication :: digitou opção -> " + opcao);
				funcionarioService.iniciar(scanner);
				break;
			}

			case 3: {
				// LOGGER.info(" SpringApplication :: digitou opção -> " + opcao);
				unidadeTrabalhoService.iniciar(scanner);
				break;
			}
			case 4: {
				// LOGGER.info(" SpringApplication :: digitou opção -> " + opcao);
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
