package cn.yematech.heaver.repository;

import cn.yematech.heaver.domain.Word;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface WordMapper extends BaseMapper<Word> {
}
