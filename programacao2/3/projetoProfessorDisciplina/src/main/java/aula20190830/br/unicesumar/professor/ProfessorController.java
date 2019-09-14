package br.unicesumar.professor;

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
@RequestMapping("/api/professores")
public class ProfessorController {
    @Autowired
    private ProfessorRepository repo;
    @GetMapping
    public List<Professor> getAll(){
        return repo.findAll();
    }
    @PostMapping
    public String post(@RequestBody Professor novo) {
        repo.save(novo);
        return novo.getId();
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        repo.deleteById(id);
    }
    @GetMapping("/{id}")
    public Professor getProfessorById(@PathVariable("id") String id) {
        return repo.findById(id).get();
    }
    @PutMapping("/{id}")
    public void putById(@RequestBody Professor novo, @PathVariable String id) {
        if(!id.equals(novo.getId())) {
            throw new RuntimeException("Id do professor está incorreto!");
        }
        repo.save(novo);
    }
}