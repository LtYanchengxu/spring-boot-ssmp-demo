package top.yanchengxu.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.web.bind.annotation.*;
import top.yanchengxu.controller.utils.Result;
import top.yanchengxu.domain.Book;
import top.yanchengxu.service.BookService;

import javax.annotation.Resource;
import java.io.IOException;


@RestController
@RequestMapping("/books")
public class BookController {

    @Resource
    private BookService bookService;

    @GetMapping
    public Result getAll() {
        return new Result(true, bookService.getAll());
    }

    @GetMapping("{id}")
    public Result getById(@PathVariable Integer id) {
        return new Result(true, bookService.getById(id));
    }

    @GetMapping("{current}/{size}")
    public Result getPage(@PathVariable int current, @PathVariable int size, Book book) {
        IPage<Book> page = bookService.getByPage(current, size, book);
        // 如果当前请求的页码数 大于 总页码数
        if (current > page.getPages()) {
            // 重新执行getByPage，跳转到最后一页
            page = bookService.getByPage((int) page.getPages(), size, book);
        }
        return new Result(true, page);
    }


    @PostMapping
    public Result saveBook(@RequestBody Book book) throws IOException {
        // 模拟异常
        if (book.getName().equals("123")) {
            throw new IOException("模拟异常发生了");
        }

        boolean flag = bookService.saveBook(book);

        return new Result(flag, null, flag ? "保存成功" : "保存失败");
    }

    @PutMapping
    public Result update(@RequestBody Book book) {
        return new Result(bookService.update(book), null);
    }

    @DeleteMapping("{id}")
    public Result delete(@PathVariable Integer id) {
        return new Result(bookService.delete(id), null);
    }

}
