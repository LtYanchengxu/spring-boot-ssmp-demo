package top.yanchengxu.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sun.corba.se.spi.orb.ParserImplBase;
import org.apache.logging.log4j.util.Strings;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.yanchengxu.SSMPApplication;
import top.yanchengxu.domain.Book;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest(classes = SSMPApplication.class)
public class BookMapperTest {


    @Resource
    BookMapper bookMapper;

    @Test
    public void testInsert() {
        Book book = new Book();
        book.setName("宁波往事");
        book.setDescription("浙软就是宁波");
        book.setType("纪实");
        int count = bookMapper.insert(book);
        System.out.println("id ==> " + book.getId());
        System.out.println("count ==> " + count);
    }


    @Test
    public void testDeleteById() {
        int count = bookMapper.deleteById(14);
        System.out.println("count ==> " + count);
    }

    @Test
    public void testUpdateById() {
        Book book = new Book();
        book.setId(13);
        book.setDescription("hahaha");
        int count = bookMapper.updateById(book);
        System.out.println("count ==> " + count);

    }

    @Test
    public void testSelectById() {
        Book book = bookMapper.selectById(13);
        System.out.println(book);
    }

    @Test
    public void testSelectList() {
        List<Book> books = bookMapper.selectList(null);
        books.forEach(System.out::println);
    }

    @Test
    public void testSelectPage() {
        String name = "Spring";
        IPage<Book> page = new Page<>(1, 5);
        LambdaQueryWrapper<Book> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(Strings.isNotEmpty(name), Book::getName, name);
        bookMapper.selectPage(page, queryWrapper);
        System.out.println("page.getCurrent() = " + page.getCurrent());
        System.out.println("page.getSize() = " + page.getSize());
        System.out.println("page.getTotal() = " + page.getTotal());
        System.out.println("page.getRecords() = " + page.getRecords());
    }

}
