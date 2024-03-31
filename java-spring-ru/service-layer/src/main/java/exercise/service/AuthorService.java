package exercise.service;

import exercise.dto.AuthorCreateDTO;
import exercise.dto.AuthorDTO;
import exercise.dto.AuthorUpdateDTO;
import exercise.exception.ResourceNotFoundException;
import exercise.mapper.AuthorMapper;
import exercise.model.Author;
import exercise.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    // BEGIN
    @Autowired
    private AuthorMapper authorMapper;

    @Autowired
    private AuthorRepository authorRepository;

    public List<AuthorDTO> getAll() {
        return authorRepository.findAll().stream()
                .map(authorMapper::map)
                .toList();
    }

    public AuthorDTO create(AuthorCreateDTO authorCreateDTO) {
        Author author = authorMapper.map(authorCreateDTO);
        authorRepository.save(author);
        return authorMapper.map(author);
    }

    public AuthorDTO findById(long id) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Author with id = " + id + " not found."));
        return authorMapper.map(author);
    }

    public AuthorDTO update(AuthorUpdateDTO authorUpdateDTO, long id) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Author with id = " + id + " not found."));
        authorMapper.update(authorUpdateDTO, author);
        authorRepository.save(author);
        return authorMapper.map(author);
    }

    public void delete(long id) {
        authorRepository.deleteById(id);
    }
    // END
}
