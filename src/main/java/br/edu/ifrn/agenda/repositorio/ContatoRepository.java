package br.edu.ifrn.agenda.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifrn.agenda.modelo.Contato;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Integer>{ 
	
}
