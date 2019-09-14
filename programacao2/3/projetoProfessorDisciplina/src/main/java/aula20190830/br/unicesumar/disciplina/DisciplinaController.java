package br.unicesumar.disciplina;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/disciplinas")
public class DisciplinaController {
	@Autowired
	private DisciplinaRepository repo;
	@GetMapping
	public List<Disciplina> getAll() {
		return repo.findAll();
	}
	@PostMapping
	public String post(@RequestBody Disciplina nova) {
		repo.save(nova);
		return nova.getId();
	}
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") String id) {
		repo.deleteById(id);
	}
	@GetMapping("/{id}")
	public Disciplina getDisciplinaById(@PathVariable("id") String id) {
		return repo.findById(id).get();
	}
	@PutMapping("/{id}")
	public void getById(@PathVariable("id") String id, @RequestBody Disciplina disciplina) {
		if (!id.equals(disciplina.getId())) {
			throw new RuntimeException("Id da disciplina está incorreto!");
		}
		repo.save(disciplina);
	}
}