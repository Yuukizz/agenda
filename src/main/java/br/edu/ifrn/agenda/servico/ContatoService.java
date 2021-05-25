package br.edu.ifrn.agenda.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifrn.agenda.modelo.Contato;
import br.edu.ifrn.agenda.repositorio.ContatoRepository;

@Service
public class ContatoService {
	
	@Autowired
	private ContatoRepository repository;

	public Contato salvar(Contato entity) {
		return repository.save(entity);
	}

	public List<Contato> buscarTodos() {
		return repository.findAll();
	}

	public void remover(Integer id) {
		repository.deleteById(id);
	}

	public Contato findById(Integer id) {
		Optional<Contato> contato = repository.findById(id);
		if (contato.isPresent()) {
			return contato.get();
		}
		return null;
	}

	
}
