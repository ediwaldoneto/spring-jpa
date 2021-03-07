package br.com.nt.springdata.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.nt.springdata.entities.Cargo;
import br.com.nt.springdata.entities.Funcionario;
import br.com.nt.springdata.repository.CargoRespository;
import br.com.nt.springdata.repository.FuncionarioRepository;

@Service
public class FuncionarioService {

	private boolean system = true;
	private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private FuncionarioRepository funcionarioRepository;
	private CargoRespository cargoRespository;

	public FuncionarioService(FuncionarioRepository funcionarioRepository, CargoRespository cargoRespository) {

		this.funcionarioRepository = funcionarioRepository;
		this.cargoRespository = cargoRespository;
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
			System.out.println("  * 4 - Listar");
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

		System.out.println("Informe o nome");
		String nome = scanner.next();

		System.out.println("Informe CPF");
		String cpf = scanner.next();

		System.out.println("Informe salario");
		double salario = scanner.nextDouble();

		System.out.println("Data da contratacao");
		String data = scanner.next();

		System.out.println("Cargo ID");
		Integer id = scanner.nextInt();

		Funcionario funcionario = new Funcionario();

		try {

			funcionario.setNome(nome);
			funcionario.setCpf(cpf);
			funcionario.setSalario(salario);
			funcionario.setDataContratacao(LocalDate.parse(data, formatter));
			Optional<Cargo> cargo = cargoRespository.findById(id);
			funcionario.setCargo(cargo.get());
			funcionarioRepository.save(funcionario);

			System.out.println("Registro");

		} catch (Exception e) {

			System.out.println("ERRO ->" + e.getMessage());
		}

	}

}