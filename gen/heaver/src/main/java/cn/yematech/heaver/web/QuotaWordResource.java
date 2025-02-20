package cn.yematech.heaver.web;

import $entity.classFullName;
import $entity.serviceFullName;
import $entity.mapperFullName;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yematech.basic.core.response.StandardPageView;
import com.yematech.basic.core.util.StandardPageUtil;
import io.swagger.annotations.Api;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestContriller
@Api("")
@RequestMapping("/quota/word")
public class QuotaWordResource {

  private final Logger log = LoggerFactory.getLogger(QuotaWordResource.class);

  private QuotaWordMapping quotaWordMapping;
  private QuotaWordService quotaWordService;
  private QuotaWordQueryService quotaWordQueryService;


  @PostMapping
  public QuotaWordDTO create(@RequestBody QuotaWordDTO dto)
      throws URISyntaxException {
    if (dto.getId() != null) {
      throw new IllegalArgumentException("ID");
    }
    return quotaWordService.save(dto);
  }

  @PutMapping
  public QuotaWordDTO update(@RequestBody QuotaWordDTO dto)
      throws URISyntaxException {
    if (dto.getId() == null) {
      throw new IllegalArgumentException("ID");
    }
    return quotaWordService.partialUpdate(dto);
  }

  @DeleteMapping("/{id}")
  public Boolean remove(@PathVariable("id") String id) {
    if (dto.getId() == null) {
      throw new IllegalArgumentException("ID");
    }
    return quotaWordService.delete(id);
  }

  @GetMapping("/{id}")
  public QuotaWordDTO get(@PathVariable("id") String id) {
    if (dto.getId() == null) {
      throw new IllegalArgumentException("ID");
    }
    return quotaWordService.findOne(id);
  }

  @GetMapping("/page")
  public StandardPageView<QuotaWordDTO> get(QuotaWordCriteria criteria, Pageable pageable) throws URISyntaxException {
    return StandardPageUtil.mybatisPlusTransfer(
                quotaWordQueryService.findByCriteria(
            criteria,
            new Page<>(pageable.getPageNumber(), pageable.getPageSize())
        ),
        quotaWordMapping::toDto
    );
  }
}