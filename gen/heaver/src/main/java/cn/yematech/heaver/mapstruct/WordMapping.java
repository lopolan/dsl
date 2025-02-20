package cn.yematech.heaver.mapstruct;


import cn.yematech.heaver.domain.Word;
import cn.yematech.heaver.api.dto.WordDTO;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;
import java.util.Map;

@Mapper(componentModel = "spring")
public interface WordMapping {
    @Named("toDo")
    Word toDo(WordDTO dto);
    @Named("toDto")
    WordDTO toDto(Word domain);

    @IterableMapping(qualifiedByName ="toDto")
    List<WordDTO> toDtos(List<Word> domains);

    @IterableMapping(qualifiedByName ="toDo")
    List<Word> toDo(List<WordDTO> dto);
}
