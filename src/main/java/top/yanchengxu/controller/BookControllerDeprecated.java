package top.yanchengxu.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.web.bind.annotation.*;
import top.yanchengxu.domain.Book;
import top.yanchengxu.service.BookService;

import javax.annotation.Resource;
import java.util.List;

// @RestController
@RequestMapping("/books")
public class BookControllerDeprecated {

    @Resource
    private BookService bookService;

    @GetMapping
    public List<Book> getAll() {
        return bookService.getAll();
    }

    @GetMapping("{id}")
    public Book getById(@PathVariable Integer id) {
        return bookService.getById(id);
    }

    @GetMapping("{current}/{size}")
    public IPage<Book> getPage(@PathVariable int current, @PathVariable int size) {
        return bookService.getByPage(current, size);
    }


    @PostMapping
    public Boolean saveBook(@RequestBody Book book) {
        return bookService.saveBook(book);
    }

    @PutMapping
    public Boolean update(@RequestBody Book book) {
        return bookService.update(book);
    }

    @DeleteMapping("{id}")
    public Boolean delete(@PathVariable Integer id) {
        return bookService.delete(id);
    }

}
