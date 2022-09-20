package com.edu.ulab.app.service.impl;

import com.edu.ulab.app.dto.BookDto;
import com.edu.ulab.app.entity.BookEntity;
import com.edu.ulab.app.mapper.BookDtoEntityMapperImpl;
import com.edu.ulab.app.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.edu.ulab.app.storage.Storage.*;


@Slf4j
@Service
public class BookServiceImpl implements BookService {
    private static long idBook = 0L;

    private final BookDtoEntityMapperImpl bookDtoEntityMapper;

    public BookServiceImpl(BookDtoEntityMapperImpl bookDtoEntityMapper) {
        this.bookDtoEntityMapper = bookDtoEntityMapper;
    }

    @Override
    public BookDto createBook(BookDto bookDto) {
        if (bookDto == null) { return null;}
        idBook++;        // сгенерировать идентификатор
        BookEntity bookEntity; // создать пользователя
        bookDto.setId(idBook); // вернуть сохраненного пользователя со всеми необходимыми полями id
        bookEntity = bookDtoEntityMapper.bookDtoToBookEntity(bookDto);
        addBookEntity(bookEntity);
        return bookDto;
    }

    @Override
    public BookDto updateBook(BookDto bookDto) {
        BookEntity bookEntity = bookDtoEntityMapper.bookDtoToBookEntity(bookDto);
        updateBookEntity(bookEntity);
        return bookDto;
    }

    @Override
    public BookDto getBookById(Long id) {
        if (id != null && id >= 0) {return null;}
        BookEntity book = getBook(id);
        return bookDtoEntityMapper.bookEntityToBookDto(book);
    }

    @Override
    public void deleteBookById(Long id) {
        if (id != null && id > 0) {
            deleteBook(id);
        }
    }

    public List<Long> getBooksByUserId(Long id) {
        if (id != null && id >= 0) {
            return getBooks(id);
        }
        return null;
    }
}