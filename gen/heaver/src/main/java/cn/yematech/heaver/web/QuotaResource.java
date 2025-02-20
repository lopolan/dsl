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
@Api("定额")
@RequestMapping("/quota")
public class QuotaResource {

  private final Logger log = LoggerFactory.getLogger(QuotaResource.class);

  private QuotaMapping quotaMapping;
  private QuotaService quotaService;
  private QuotaQueryService quotaQueryService;


  @PostMapping
  public QuotaDTO create(@RequestBody QuotaDTO dto)
      throws URISyntaxException {
    if (dto.getId() != null) {
      throw new IllegalArgumentException("ID");
    }
    return quotaService.save(dto);
  }

  @PutMapping
  public QuotaDTO update(@RequestBody QuotaDTO dto)
      throws URISyntaxException {
    if (dto.getId() == null) {
      throw new IllegalArgumentException("ID");
    }
    return quotaService.partialUpdate(dto);
  }

  @DeleteMapping("/{id}")
  public Boolean remove(@PathVariable("id") String id) {
    if (dto.getId() == null) {
      throw new IllegalArgumentException("ID");
    }
    return quotaService.delete(id);
  }

  @GetMapping("/{id}")
  public QuotaDTO get(@PathVariable("id") String id) {
    if (dto.getId() == null) {
      throw new IllegalArgumentException("ID");
    }
    return quotaService.findOne(id);
  }

  @GetMapping("/page")
  public StandardPageView<QuotaDTO> get(QuotaCriteria criteria, Pageable pageable) throws URISyntaxException {
    return StandardPageUtil.mybatisPlusTransfer(
                quotaQueryService.findByCriteria(
            criteria,
            new Page<>(pageable.getPageNumber(), pageable.getPageSize())
        ),
        quotaMapping::toDto
    );
  }
}