package br.com.nt.springdata.service;

import java.util.Optional;
import java.util.Scanner;
import org.springframework.stereotype.Service;
import br.com.nt.springdata.entities.Cargo;
import br.com.nt.springdata.repository.CargoRespository;

@Service
public class CargoService {

	private boolean system = true;
	private CargoRespository cargoRespository;

	public CargoService(CargoRespository cargoRespository) {
		this.cargoRespository = cargoRespository;
	}

	public void iniciar(Scanner scanner) {
		while (system) {

			System.out.println("\n");
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

				deletar(scanner);
				break;
			}

			case 3: {

				atualizar(scanner);
				break;
			}
			case 4: {

				exibir();
				break;
			}

			default:
				system = false;

			}

		}

	}

	public void salvar(Scanner scanner) {
		System.out.println("Descricao do cargo");
		String descricao = scanner.next();
		Cargo cargo = new Cargo();
		cargo.setDescricao(descricao);
		cargoRespository.save(cargo);
		System.out.println("Registo Salvo");

	}

	public void deletar(Scanner scanner) {
		System.out.println("ID Cargo");
		int id = scanner.nextInt();
		Optional<Cargo> descricao = cargoRespository.findById(id);
		System.out.println("Id selecionado :: " + id + " " + descricao.get().getDescricao());
		cargoRespository.deleteById(id);
		System.out.println("Registro deletado");

	}

	public void atualizar(Scanner scanner) {
		System.out.println("ID");
		int id = scanner.nextInt();
		System.out.println("Descricao do cargo");
		String descricao = scanner.next();
		System.out.println("Id selecionado :: " + id + " Cargo informado :: " + descricao);
		Optional<Cargo> dados = cargoRespository.findById(id);
		if (dados.isPresent()) {
			Cargo cargo = new Cargo();
			cargo.setId(id);
			cargo.setDescricao(descricao);
			cargoRespository.save(cargo);
			System.out.println("Registro Atualizado");
		} else {
			System.out.println("Registro nao encontrado para atualizacao");
		}

	}

	public void exibir() {
		System.out.println("##### LISTA DE REGISTROS ######" + "\n");
		Iterable<Cargo> descricao = cargoRespository.findAll();
		for (Cargo cargo : descricao) {
			System.out.println("Id " + cargo.getId() + " Desc " + cargo.getDescricao());

		}
	}

}
