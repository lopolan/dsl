package cn.yematech.heaver.mapstruct;


import cn.yematech.heaver.domain.Quota;
import cn.yematech.heaver.api.dto.QuotaDTO;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;
import java.util.Map;

@Mapper(componentModel = "spring")
public interface QuotaMapping {
    @Named("toDo")
    Quota toDo(QuotaDTO dto);
    @Named("toDto")
    QuotaDTO toDto(Quota domain);

    @IterableMapping(qualifiedByName ="toDto")
    List<QuotaDTO> toDtos(List<Quota> domains);

    @IterableMapping(qualifiedByName ="toDo")
    List<Quota> toDo(List<QuotaDTO> dto);
}
