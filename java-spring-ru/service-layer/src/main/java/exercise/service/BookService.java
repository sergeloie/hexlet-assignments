package exercise.service;

import exercise.dto.BookCreateDTO;
import exercise.dto.BookDTO;
import exercise.dto.BookUpdateDTO;
import exercise.exception.ResourceNotFoundException;
import exercise.mapper.BookMapper;
import exercise.model.Book;
import exercise.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    // BEGIN
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookMapper bookMapper;

    public List<BookDTO> getAll() {
        return bookRepository.findAll().stream()
                .map(bookMapper::map)
                .toList();
    }

    public BookDTO findById(long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book with id " + id + " not found"));
        return bookMapper.map(book);
    }

    public BookDTO create(BookCreateDTO bookCreateDTO) {
        Book book = bookMapper.map(bookCreateDTO);
        bookRepository.save(book);
        return bookMapper.map(book);
    }

    public BookDTO update(BookUpdateDTO bookUpdateDTO, long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book with id " + id + " not found"));
        bookMapper.update(bookUpdateDTO, book);
        bookRepository.save(book);
        return bookMapper.map(book);
    }

    public void delete(long id) {
        bookRepository.deleteById(id);
    }
    // END
}
