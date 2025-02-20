package cn.yematech.heaver.mapstruct;


import cn.yematech.heaver.domain.QuotaWord;
import cn.yematech.heaver.api.dto.QuotaWordDTO;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;
import java.util.Map;

@Mapper(componentModel = "spring")
public interface QuotaWordMapping {
    @Named("toDo")
    QuotaWord toDo(QuotaWordDTO dto);
    @Named("toDto")
    QuotaWordDTO toDto(QuotaWord domain);

    @IterableMapping(qualifiedByName ="toDto")
    List<QuotaWordDTO> toDtos(List<QuotaWord> domains);

    @IterableMapping(qualifiedByName ="toDo")
    List<QuotaWord> toDo(List<QuotaWordDTO> dto);
}
