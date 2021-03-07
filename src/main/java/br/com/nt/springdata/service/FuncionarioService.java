package br.com.nt.springdata.service;

import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.nt.springdata.repository.FuncionarioRepository;

@Service
public class FuncionarioService {

	private boolean system = true;
	private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private FuncionarioRepository funcionarioRepository;

	public FuncionarioService(FuncionarioRepository funcionarioRepository) {

		this.funcionarioRepository = funcionarioRepository;
	}

	public void iniciar(Scanner scanner) {

		while (system) {
			System.out.println("\n");
			System.out.println("    ## MENU FUNCIONARIO ##");
			System.out.println("  [ Qual a função deseja executar ]" + "\n");
			System.out.println("  * 0 - Sair");
			System.out.println("  * 1 - Salvar");
			System.out.println("  * 2 - Deletar");
			System.out.println("  * 3 - Atualizar");
			System.out.println("  * 4 - Listar" + "\n");
			Integer opcao = scanner.nextInt();

			switch (opcao) {
			case 1: {
				salvar(scanner);
				break;

			}
			case 2: {

				break;
			}

			case 3: {

				break;
			}
			case 4: {

				break;
			}

			default:
				system = false;

			}
		}
	}

	public void salvar(Scanner scanner) {
	}

}