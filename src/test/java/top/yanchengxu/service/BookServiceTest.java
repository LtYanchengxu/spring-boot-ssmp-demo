package top.yanchengxu.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import top.yanchengxu.domain.Book;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class BookServiceTest {

    @Resource
    BookService bookService;

    @Test
    public void testInsert() {
        Book book = new Book();
        book.setName("宁波往事");
        book.setDescription("浙软就是宁波");
        book.setType("纪实");
        boolean save = bookService.save(book);
        System.out.println("save = " + save);
    }


    @Test
    public void testDeleteById() {
        boolean delete = bookService.delete(13);
        System.out.println("delete = " + delete);
    }

    @Test
    public void testUpdateById() {
        Book book = new Book();
        book.setId(13);
        book.setDescription("hahaha");
        boolean update = bookService.update(book);
        System.out.println("update = " + update);
    }

    @Test
    public void testSelectById() {
        Book book = bookService.getById(1);
        System.out.println("book = " + book);
    }

    @Test
    public void testSelectList() {
        List<Book> books = bookService.getAll();
        books.forEach(System.out::println);
    }

    @Test
    public void testSelectPage() {
        // String name = "Spring";
        // IPage<Book> page = new Page<>(1, 5);
        // LambdaQueryWrapper<Book> queryWrapper = new LambdaQueryWrapper<>();
        // queryWrapper.like(Strings.isNotEmpty(name), Book::getName, name);
        IPage<Book> page = bookService.getByPage(1, 5);
        System.out.println("page.getCurrent() = " + page.getCurrent());
        System.out.println("page.getSize() = " + page.getSize());
        System.out.println("page.getTotal() = " + page.getTotal());
        System.out.println("page.getRecords() = " + page.getRecords());
    }
}
