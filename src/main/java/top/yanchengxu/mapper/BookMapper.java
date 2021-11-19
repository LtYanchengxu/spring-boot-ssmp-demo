package top.yanchengxu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import top.yanchengxu.domain.Book;

@Mapper
public interface BookMapper extends BaseMapper<Book> {

}
