package finesse52.restjwtproject.mapper;

import finesse52.restjwtproject.domain.BaseDomain;
import finesse52.restjwtproject.dto.BaseDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BaseMapper {

    BaseDto convertToDto(BaseDomain baseDomain);
}