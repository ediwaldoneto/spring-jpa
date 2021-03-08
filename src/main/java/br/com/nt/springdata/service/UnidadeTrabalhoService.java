package br.com.nt.springdata.service;

import java.util.Optional;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.nt.springdata.entities.UnidadeTrabalho;
import br.com.nt.springdata.repository.UnidadeRepository;

@Service
public class UnidadeTrabalhoService {

	private boolean system = true;
	private UnidadeRepository unidadeRepository;

	public UnidadeTrabalhoService(UnidadeRepository unidadeRepository) {
		this.unidadeRepository = unidadeRepository;
	}

	public void iniciar(Scanner scanner) {

		while (system) {

			System.out.println("\n");
			System.out.println("    ## MENU UNIDADE DE TRABALHO ##");
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
				deletar(scanner);
				break;
			}

			case 3: {
				atualizar(scanner);
				break;
			}
			case 4: {
				exibirLista();
				break;
			}

			default:
				system = false;

			}
		}
	}

	private void exibirLista() {

		System.out.println("LISTA DE UNIDADES DE TRABALHO" + " \n");

		Iterable<UnidadeTrabalho> unidade = unidadeRepository.findAll();

		for (UnidadeTrabalho unidadeTrabalho : unidade) {

			System.out.println(unidadeTrabalho);
		}
	}

	private void atualizar(Scanner scanner) {

		System.out.println("Informe ID");
		Integer id = scanner.nextInt();

		System.out.println("Informe Descricao");
		String descricao = scanner.next();

		System.out.println("Informe Endereco");
		String endereco = scanner.next();

		Optional<UnidadeTrabalho> unidade = unidadeRepository.findById(id);

		if (unidade.isPresent()) {

			UnidadeTrabalho unidadeTrabalho = new UnidadeTrabalho();

			unidadeTrabalho.setId(id);
			unidadeTrabalho.setDescricao(descricao);
			unidadeTrabalho.setEndereco(endereco);

			unidadeRepository.save(unidadeTrabalho);

		} else {

			System.out.println("Registro nao existe");
		}

	}

	private void deletar(Scanner scanner) {

		System.out.println("Informe ID");
		Integer id = scanner.nextInt();

		unidadeRepository.deleteById(id);

		System.out.println("Registro Deletado");

	}

	private void salvar(Scanner scanner) {

		System.out.println("Informe a Descricao da Unidade");
		String descricao = scanner.next();

		System.out.println("Informe o Endereco");
		String endereco = scanner.next();

		UnidadeTrabalho unidade = new UnidadeTrabalho();

		unidade.setDescricao(descricao);
		unidade.setEndereco(endereco);

		unidadeRepository.save(unidade);

		System.out.println("Registro Salvo");

	}
}
