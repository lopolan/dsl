package cn.yematech.heaver.impl;

import cn.yematech.heaver.domain.QuotaWord;
import cn.yematech.heaver.api.dto.QuotaWordDTO;
import cn.yematech.heaver.mapstruct.QuotaWordMapping;
import cn.yematech.heaver.mapstruct.QuotaWordMapper;
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
public class QuotaWordServiceImpl extends
    ServiceImpl<QuotaWordMapper, QuotaWord> {

  private final Logger logger = LoggerFactory.getLogger(QuotaWordServiceImpl.class);
  private QuotaWordMapping quotaWordMapping;
  public QuotaWordServiceImpl(QuotaWordMapping quotaWordMapping){
    this.quotaWordMapping = quotaWordMapping;
  }
  public QuotaWordDTO save(QuotaWordDTO dto) {
    Optional.ofNullable(dto).map(quotaWordMapping::toDo).map(t -> {
      this.save(t);
      return quotaWordMapping.toDto(t);
    }).orElseThrow(() -> new IllegalArgumentException("参数错误"));
  }

  public QuotaWordDTO partialUpdate(QuotaWordDTO dto) {
    if (dto.getId() == null) {
      throw new IllegalArgumentException("identity could not be null");
    }
    Optional.ofNullable(dto).map(quotaWordMapping::toDo).map(t -> {
      this.saveOrUpdate(t);
      return quotaWordMapping.toDto(t);
    }).orElseThrow(() -> new IllegalArgumentException("参数错误"));
  }

  @Transactional(readOnly = true)
  public QuotaWordDTO findOne(${environment.keyType} key) {
    return Optional.ofNullable(this.getById(id)).map(quotaWordMapping::toDto);
  }

  public void delete(${environment.keyType} key) {
    this.removeById(id);
  }
}
