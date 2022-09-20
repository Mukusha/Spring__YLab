package com.edu.ulab.app.storage;

import com.edu.ulab.app.dto.BookDto;
import com.edu.ulab.app.dto.UserDto;
import com.edu.ulab.app.entity.BookEntity;
import com.edu.ulab.app.entity.UserEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//todo создать хранилище в котором будут содержаться данные
// сделать абстракции через которые можно будет производить операции с хранилищем
// продумать логику поиска и сохранения
// продумать возможные ошибки
// учесть, что при сохранеии юзера или книги, должен генерироваться идентификатор
// продумать что у узера может быть много книг и нужно создать эту связь
// так же учесть, что методы хранилища принимают друго тип данных - учесть это в абстракции
public class Storage {

    private static final HashMap<Long, UserEntity> UserStorage = new HashMap<>();

    private static final HashMap<Long, BookEntity> BookStorage = new HashMap<>();
    public static void addUserEntity(UserEntity userEntity){
        UserStorage.put(userEntity.getId(), userEntity);
    }

    public static void updateUserEntity(UserDto userDto){
        if (UserStorage.containsKey(userDto.getId())) {
            UserStorage.get(userDto.getId()).setAge(userDto.getAge());
            UserStorage.get(userDto.getId()).setTitle(userDto.getTitle());
            UserStorage.get(userDto.getId()).setFullName(userDto.getFullName());

            List<Long> books = getBooks(userDto.getId());
            for (Long l: books) {
                deleteBook(l);
            }
        }

    }

    public static UserEntity getUser(Long id){
            return UserStorage.get(id) ;
    }

    public static void deleteUser(Long id){
        UserStorage.remove(id);
    }

    public static void addBookEntity(BookEntity bookEntity){
        BookStorage.put(bookEntity.getId(), bookEntity);
    }

    public static void updateBookEntity(BookEntity bookEntity){
        if (BookStorage.containsKey(bookEntity.getId())) {
            BookStorage.put(bookEntity.getId(),bookEntity);
        }
        else {
            deleteBook(bookEntity.getId());
        }
    }

    public static BookEntity getBook(Long id){
        return BookStorage.get(id) ;
    }

    public static void deleteBook(Long id){
        BookStorage.remove(id);
    }

    public static List<Long> getBooks(Long idUser) {
        List<Long> books = new ArrayList<>();

        BookStorage.entrySet().stream()
                .filter(x->x.getValue().getUserId()==idUser)
                .forEach(y-> books.add(y.getValue().getId()));
        return books;
    }
}
