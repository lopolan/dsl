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

import cn.yematech.heaver.service.domain.Word;
import cn.yematech.heaver.service.common.BaseQueryService;
import cn.yematech.heaver.api.dto.WordDTO;
import cn.yematech.heaver.service.mapstruct.WordMapping;
import cn.yematech.heaver.service.repository.WordMapper;

@Service
@Transactional(readOnly = true)
public class WordQueryService extends BaseQueryService {

  private final Logger log = LoggerFactory.getLogger(WordQueryService.class);

  private WordMapper wordMapper;
  private WordMapping wordMapping;

  @Service
  @Transactional(readOnly = true)
  public long countByCriteria(WordCriteria criteria) {
    log.debug("count by criteria : {}", criteria);
    return createSpecification(criteria).count();
  }

  @Transactional(readOnly = true)
  public List<WordDTO> findByCriteria(WordCriteria criteria) {
    log.debug("find by criteria : {}", criteria);
    return wordMapper.toDtos(createSpecification(criteria).list());
  }

  @Transactional(readOnly = true)
  public Page<WordDTO> findByCriteria(WordCriteria criteria,
      IPage page) {
    log.debug("find by criteria : {}, page: {}", criteria, page);
    IPage<Word> result = createSpecification(criteria).page(page);
    List<WordDTO> records = Optional.ofNullable(result.getRecords())
        .map(
            entities -> entities.stream().map( < %= entityToDtoReference % >
        ).collect(Collectors.toList())).orElse(Collections.emptyList());
    return new Page<WordDTO>(page.getCurrent(), page.getSize(), result.getTotal())
        .setRecords(records);
  }

  protected LambdaQueryChainWrapper<Word> createSpecification(WordCriteria criteria) {
    LambdaQueryChainWrapper<Word> specification = fetchWapper();
    if (criteria != null) {
      if (criteria.getId() != null) {
        specification = specification.and(buildRangeSpecification(criteria.getId(), Word::getId,specification));
      }
      if (criteria.getCreatedDate() != null) {
        specification = specification.and(buildRangeSpecification(criteria.getCreatedDate(), Word::getCreatedDate,specification));
      }
      if (criteria.getLastModifiedDate() != null) {
        specification = specification.and(buildRangeSpecification(criteria.getLastModifiedDate(), Word::getLastModifiedDate,specification));
      }
      if (criteria.getCreatedBy() != null) {
        specification = specification.and(buildStringSpecification(criteria.getCreatedBy(), Word::getCreatedBy,specification));
      }
      if (criteria.getLastModifiedBy() != null) {
        specification = specification.and(buildStringSpecification(criteria.getLastModifiedBy(), Word::getLastModifiedBy,specification));
      }
      if (criteria.getCreatedById() != null) {
        specification = specification.and(buildStringSpecification(criteria.getCreatedById(), Word::getCreatedById,specification));
      }
      if (criteria.getLastModifiedById() != null) {
        specification = specification.and(buildStringSpecification(criteria.getLastModifiedById(), Word::getLastModifiedById,specification));
      }
      if(criteria.getText() != null){
        specification = buildStringSpecification(criteria.getText(),Word::getText,specification)
      }
    }
    return specification;
  }
}