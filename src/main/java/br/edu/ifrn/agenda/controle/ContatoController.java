package br.edu.ifrn.agenda.controle;

import br.edu.ifrn.agenda.modelo.Contato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.ifrn.agenda.servico.ContatoService;

import java.util.List;

@Controller
@RequestMapping("/contatos")
public class ContatoController {
	
	@Autowired
	private ContatoService service;

	@GetMapping
	public String index(Model model) {
		List<Contato> contatos = service.buscarTodos();
		model.addAttribute("contatos", contatos);
		return "index";
	}

	@GetMapping("/form")
	public String formulario (Model model) {
		Contato contato = new Contato();
		model.addAttribute("contato", contato);
		return "formulario";
	}

	@PostMapping
	public String salvar(Contato contato) {
		service.salvar(contato);
		return "redirect:/contatos";
	}

	@GetMapping("/{id}/editar")
	public String editar(@PathVariable("id") Integer id, Model model) {
		Contato contato = service.findById(id);
		model.addAttribute("contato", contato);
		return contato == null ? "nao-encontrado" : "formulario";
	}

	@GetMapping("/{id}/remover")
	public String remover(@PathVariable("id") Integer id) {
		Contato contato = service.findById(id);
		if (contato == null) {
			return "nao-encontrado";
		}
		service.remover(id);
		return "redirect:/contatos";
	}
	
}
