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
@Api("词")
@RequestMapping("/word")
public class WordResource {

  private final Logger log = LoggerFactory.getLogger(WordResource.class);

  private WordMapping wordMapping;
  private WordService wordService;
  private WordQueryService wordQueryService;


  @PostMapping
  public WordDTO create(@RequestBody WordDTO dto)
      throws URISyntaxException {
    if (dto.getId() != null) {
      throw new IllegalArgumentException("ID");
    }
    return wordService.save(dto);
  }

  @PutMapping
  public WordDTO update(@RequestBody WordDTO dto)
      throws URISyntaxException {
    if (dto.getId() == null) {
      throw new IllegalArgumentException("ID");
    }
    return wordService.partialUpdate(dto);
  }

  @DeleteMapping("/{id}")
  public Boolean remove(@PathVariable("id") String id) {
    if (dto.getId() == null) {
      throw new IllegalArgumentException("ID");
    }
    return wordService.delete(id);
  }

  @GetMapping("/{id}")
  public WordDTO get(@PathVariable("id") String id) {
    if (dto.getId() == null) {
      throw new IllegalArgumentException("ID");
    }
    return wordService.findOne(id);
  }

  @GetMapping("/page")
  public StandardPageView<WordDTO> get(WordCriteria criteria, Pageable pageable) throws URISyntaxException {
    return StandardPageUtil.mybatisPlusTransfer(
                wordQueryService.findByCriteria(
            criteria,
            new Page<>(pageable.getPageNumber(), pageable.getPageSize())
        ),
        wordMapping::toDto
    );
  }
}