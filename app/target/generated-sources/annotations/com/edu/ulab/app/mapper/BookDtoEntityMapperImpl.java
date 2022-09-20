package com.edu.ulab.app.mapper;

import com.edu.ulab.app.dto.BookDto;
import com.edu.ulab.app.entity.BookEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-09-19T20:09:16+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.4.1 (Amazon.com Inc.)"
)
@Component
public class BookDtoEntityMapperImpl implements BookDtoEntityMapper {

    @Override
    public BookDto bookEntityToBookDto(BookEntity bookEntity) {
        if ( bookEntity == null ) {
            return null;
        }

        BookDto bookDto = new BookDto();

        bookDto.setId( bookEntity.getId() );
        bookDto.setUserId( bookEntity.getUserId() );
        bookDto.setTitle( bookEntity.getTitle() );
        bookDto.setAuthor( bookEntity.getAuthor() );
        bookDto.setPageCount( bookEntity.getPageCount() );

        return bookDto;
    }

    @Override
    public BookEntity bookDtoToBookEntity(BookDto bookDto) {
        if ( bookDto == null ) {
            return null;
        }

        BookEntity bookEntity = new BookEntity();

        bookEntity.setId( bookDto.getId() );
        bookEntity.setUserId( bookDto.getUserId() );
        bookEntity.setTitle( bookDto.getTitle() );
        bookEntity.setAuthor( bookDto.getAuthor() );
        bookEntity.setPageCount( bookDto.getPageCount() );

        return bookEntity;
    }
}
