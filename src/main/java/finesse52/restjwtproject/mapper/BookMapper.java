package finesse52.restjwtproject.mapper;

import finesse52.restjwtproject.domain.Book;
import finesse52.restjwtproject.dto.BookDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = BaseMapper.class)
public interface BookMapper {

    BookDto convertToDto(Book book);

    Book convertToDomain(BookDto bookDto);
}