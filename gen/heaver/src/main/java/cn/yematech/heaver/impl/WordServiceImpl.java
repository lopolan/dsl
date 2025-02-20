package cn.yematech.heaver.impl;

import cn.yematech.heaver.domain.Word;
import cn.yematech.heaver.api.dto.WordDTO;
import cn.yematech.heaver.mapstruct.WordMapping;
import cn.yematech.heaver.mapstruct.WordMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class WordServiceImpl extends
    ServiceImpl<WordMapper, Word> {

  private final Logger logger = LoggerFactory.getLogger(WordServiceImpl.class);
  private WordMapping wordMapping;
  public WordServiceImpl(WordMapping wordMapping){
    this.wordMapping = wordMapping;
  }
  public WordDTO save(WordDTO dto) {
    Optional.ofNullable(dto).map(wordMapping::toDo).map(t -> {
      this.save(t);
      return wordMapping.toDto(t);
    }).orElseThrow(() -> new IllegalArgumentException("参数错误"));
  }

  public WordDTO partialUpdate(WordDTO dto) {
    if (dto.getId() == null) {
      throw new IllegalArgumentException("identity could not be null");
    }
    Optional.ofNullable(dto).map(wordMapping::toDo).map(t -> {
      this.saveOrUpdate(t);
      return wordMapping.toDto(t);
    }).orElseThrow(() -> new IllegalArgumentException("参数错误"));
  }

  @Transactional(readOnly = true)
  public WordDTO findOne(${environment.keyType} key) {
    return Optional.ofNullable(this.getById(id)).map(wordMapping::toDto);
  }

  public void delete(${environment.keyType} key) {
    this.removeById(id);
  }
}
