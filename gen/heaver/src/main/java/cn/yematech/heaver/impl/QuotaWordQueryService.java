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

import cn.yematech.heaver.service.domain.QuotaWord;
import cn.yematech.heaver.service.common.BaseQueryService;
import cn.yematech.heaver.api.dto.QuotaWordDTO;
import cn.yematech.heaver.service.mapstruct.QuotaWordMapping;
import cn.yematech.heaver.service.repository.QuotaWordMapper;

@Service
@Transactional(readOnly = true)
public class QuotaWordQueryService extends BaseQueryService {

  private final Logger log = LoggerFactory.getLogger(QuotaWordQueryService.class);

  private QuotaWordMapper quotaWordMapper;
  private QuotaWordMapping quotaWordMapping;

  @Service
  @Transactional(readOnly = true)
  public long countByCriteria(QuotaWordCriteria criteria) {
    log.debug("count by criteria : {}", criteria);
    return createSpecification(criteria).count();
  }

  @Transactional(readOnly = true)
  public List<QuotaWordDTO> findByCriteria(QuotaWordCriteria criteria) {
    log.debug("find by criteria : {}", criteria);
    return quotaWordMapper.toDtos(createSpecification(criteria).list());
  }

  @Transactional(readOnly = true)
  public Page<QuotaWordDTO> findByCriteria(QuotaWordCriteria criteria,
      IPage page) {
    log.debug("find by criteria : {}, page: {}", criteria, page);
    IPage<QuotaWord> result = createSpecification(criteria).page(page);
    List<QuotaWordDTO> records = Optional.ofNullable(result.getRecords())
        .map(
            entities -> entities.stream().map( < %= entityToDtoReference % >
        ).collect(Collectors.toList())).orElse(Collections.emptyList());
    return new Page<QuotaWordDTO>(page.getCurrent(), page.getSize(), result.getTotal())
        .setRecords(records);
  }

  protected LambdaQueryChainWrapper<QuotaWord> createSpecification(QuotaWordCriteria criteria) {
    LambdaQueryChainWrapper<QuotaWord> specification = fetchWapper();
    if (criteria != null) {
      if (criteria.getId() != null) {
        specification = specification.and(buildRangeSpecification(criteria.getId(), QuotaWord::getId,specification));
      }
      if (criteria.getCreatedDate() != null) {
        specification = specification.and(buildRangeSpecification(criteria.getCreatedDate(), QuotaWord::getCreatedDate,specification));
      }
      if (criteria.getLastModifiedDate() != null) {
        specification = specification.and(buildRangeSpecification(criteria.getLastModifiedDate(), QuotaWord::getLastModifiedDate,specification));
      }
      if (criteria.getCreatedBy() != null) {
        specification = specification.and(buildStringSpecification(criteria.getCreatedBy(), QuotaWord::getCreatedBy,specification));
      }
      if (criteria.getLastModifiedBy() != null) {
        specification = specification.and(buildStringSpecification(criteria.getLastModifiedBy(), QuotaWord::getLastModifiedBy,specification));
      }
      if (criteria.getCreatedById() != null) {
        specification = specification.and(buildStringSpecification(criteria.getCreatedById(), QuotaWord::getCreatedById,specification));
      }
      if (criteria.getLastModifiedById() != null) {
        specification = specification.and(buildStringSpecification(criteria.getLastModifiedById(), QuotaWord::getLastModifiedById,specification));
      }
      if(criteria.getDegree() != null){
        specification = buildRangeSpecification(criteria.getDegree(),QuotaWord::getDegree,specification)
      }
      if(criteria.getRefId() != null){
        specification = buildStringSpecification(criteria.getRefId(),QuotaWord::getRefId,specification)
      }
      if(criteria.getWordId() != null){
        specification = buildStringSpecification(criteria.getWordId(),QuotaWord::getWordId,specification)
      }
    }
    return specification;
  }
}