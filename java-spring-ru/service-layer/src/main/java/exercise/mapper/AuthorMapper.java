package exercise.mapper;

import exercise.dto.AuthorCreateDTO;
import exercise.dto.AuthorDTO;
import exercise.dto.AuthorUpdateDTO;
import exercise.model.Author;
import org.mapstruct.*;

@Mapper(
        uses = {JsonNullableMapper.class, ReferenceMapper.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public abstract class AuthorMapper {

    // BEGIN
//    @Mapping(target = "author.firstName", source = "firstName")
//    @Mapping(target = "author.lastName", source = "lastName")
    public abstract Author map(AuthorCreateDTO authorCreateDTO);


//    @Mapping(target = "firstName", source = "author.firstName")
//    @Mapping(target = "lastName", source = "author.lastName")
//    @Mapping(target = "id", source = "author.id")
    public abstract AuthorDTO map(Author author);
    // END

    public abstract void update(AuthorUpdateDTO dto, @MappingTarget Author model);
}
