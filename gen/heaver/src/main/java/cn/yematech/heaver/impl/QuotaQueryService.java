package cn.yematech.heaver.impl;

import cn.yematech.heaver.api.dto.QuotaCriteria;
import cn.yematech.heaver.domain.Quota;
import cn.yematech.heaver.mapstruct.QuotaMapping;
import cn.yematech.heaver.repository.QuotaMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.Collections;
import java.util.stream.Collectors;

import cn.yematech.heaver.api.dto.QuotaDTO;

@Service
@Transactional(readOnly = true)
public class QuotaQueryService extends BaseQueryService {

  private final Logger log = LoggerFactory.getLogger(QuotaQueryService.class);

  private QuotaMapper quotaMapper;
  private QuotaMapping quotaMapping;

  @Service
  @Transactional(readOnly = true)
  public long countByCriteria(QuotaCriteria criteria) {
    log.debug("count by criteria : {}", criteria);
    return createSpecification(criteria).count();
  }

  @Transactional(readOnly = true)
  public List<QuotaDTO> findByCriteria(QuotaCriteria criteria) {
    log.debug("find by criteria : {}", criteria);
    return quotaMapper.toDtos(createSpecification(criteria).list());
  }

  @Transactional(readOnly = true)
  public Page<QuotaDTO> findByCriteria(QuotaCriteria criteria,
      IPage page) {
    log.debug("find by criteria : {}, page: {}", criteria, page);
    IPage<Quota> result = createSpecification(criteria).page(page);
    List<QuotaDTO> records = Optional.ofNullable(result.getRecords())
        .map(
            entities -> entities.stream().map( < %= entityToDtoReference % >
        ).collect(Collectors.toList())).orElse(Collections.emptyList());
    return new Page<QuotaDTO>(page.getCurrent(), page.getSize(), result.getTotal())
        .setRecords(records);
  }

  protected LambdaQueryChainWrapper<Quota> createSpecification(QuotaCriteria criteria) {
    LambdaQueryChainWrapper<Quota> specification = fetchWapper();
    if (criteria != null) {
      if (criteria.getId() != null) {
        specification = specification.and(buildRangeSpecification(criteria.getId(), Quota::getId,specification));
      }
      if (criteria.getCreatedDate() != null) {
        specification = specification.and(buildRangeSpecification(criteria.getCreatedDate(), Quota::getCreatedDate,specification));
      }
      if (criteria.getLastModifiedDate() != null) {
        specification = specification.and(buildRangeSpecification(criteria.getLastModifiedDate(), Quota::getLastModifiedDate,specification));
      }
      if (criteria.getCreatedBy() != null) {
        specification = specification.and(buildStringSpecification(criteria.getCreatedBy(), Quota::getCreatedBy,specification));
      }
      if (criteria.getLastModifiedBy() != null) {
        specification = specification.and(buildStringSpecification(criteria.getLastModifiedBy(), Quota::getLastModifiedBy,specification));
      }
      if (criteria.getCreatedById() != null) {
        specification = specification.and(buildStringSpecification(criteria.getCreatedById(), Quota::getCreatedById,specification));
      }
      if (criteria.getLastModifiedById() != null) {
        specification = specification.and(buildStringSpecification(criteria.getLastModifiedById(), Quota::getLastModifiedById,specification));
      }
      if(criteria.getCode() != null){
        specification = buildStringSpecification(criteria.getCode(),Quota::getCode,specification)
      }
      if(criteria.getName() != null){
        specification = buildStringSpecification(criteria.getName(),Quota::getName,specification)
      }
      if(criteria.getUnit() != null){
        specification = buildStringSpecification(criteria.getUnit(),Quota::getUnit,specification)
      }
    }
    return specification;
  }
}
