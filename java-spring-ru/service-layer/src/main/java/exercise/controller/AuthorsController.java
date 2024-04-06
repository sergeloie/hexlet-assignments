package exercise.controller;

import exercise.dto.AuthorDTO;
import exercise.dto.AuthorCreateDTO;
import exercise.dto.AuthorUpdateDTO;
import exercise.service.AuthorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorsController {

    @Autowired
    private AuthorService authorService;

    // BEGIN
    @GetMapping
    public List<AuthorDTO> index() {
        return authorService.getAll();
    }

    @GetMapping(path = "/{id}")
    public AuthorDTO show(@PathVariable long id) {
        return authorService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AuthorDTO create(@RequestBody AuthorCreateDTO authorCreateDTO) {
        return authorService.create(authorCreateDTO);
    }

    @PutMapping(path = "/{id}")
    public AuthorDTO update(@PathVariable long id, @RequestBody AuthorUpdateDTO authorUpdateDTO) {
        return authorService.update(authorUpdateDTO, id);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable long id) {
        authorService.delete(id);
    }
    // END
}
