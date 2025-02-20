package cn.yematech.heaver.impl;

import cn.yematech.heaver.domain.Quota;
import cn.yematech.heaver.api.dto.QuotaDTO;
import cn.yematech.heaver.mapstruct.QuotaMapping;
import cn.yematech.heaver.mapstruct.QuotaMapper;
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
public class QuotaServiceImpl extends
    ServiceImpl<QuotaMapper, Quota> {

  private final Logger logger = LoggerFactory.getLogger(QuotaServiceImpl.class);
  private QuotaMapping quotaMapping;
  public QuotaServiceImpl(QuotaMapping quotaMapping){
    this.quotaMapping = quotaMapping;
  }
  public QuotaDTO save(QuotaDTO dto) {
    Optional.ofNullable(dto).map(quotaMapping::toDo).map(t -> {
      this.save(t);
      return quotaMapping.toDto(t);
    }).orElseThrow(() -> new IllegalArgumentException("参数错误"));
  }

  public QuotaDTO partialUpdate(QuotaDTO dto) {
    if (dto.getId() == null) {
      throw new IllegalArgumentException("identity could not be null");
    }
    Optional.ofNullable(dto).map(quotaMapping::toDo).map(t -> {
      this.saveOrUpdate(t);
      return quotaMapping.toDto(t);
    }).orElseThrow(() -> new IllegalArgumentException("参数错误"));
  }

  @Transactional(readOnly = true)
  public QuotaDTO findOne(${environment.keyType} key) {
    return Optional.ofNullable(this.getById(id)).map(quotaMapping::toDto);
  }

  public void delete(${environment.keyType} key) {
    this.removeById(id);
  }
}
