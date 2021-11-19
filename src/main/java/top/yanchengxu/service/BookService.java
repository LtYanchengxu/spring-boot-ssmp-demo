package top.yanchengxu.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import top.yanchengxu.domain.Book;

import java.util.List;

public interface BookService extends IService<Book> {

    boolean saveBook(Book book);

    boolean delete(Integer id);

    boolean update(Book book);

    Book getById(Integer id);

    List<Book> getAll();

    IPage<Book> getByPage(int current, int size, Book book);
    IPage<Book> getByPage(int current, int size);

}
