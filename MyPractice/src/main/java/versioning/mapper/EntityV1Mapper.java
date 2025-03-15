package versioning.mapper;

import versioning.MapperIdentifier;
import versioning.VersionedMapper;
import versioning.dto.DtoV1;
import versioning.entity.EntityV1;

public class EntityV1Mapper implements VersionedMapper {

    private final MapperIdentifier mapperIdentifier = new MapperIdentifier("v1.0", EntityV1.class);

    @Override
    public MapperIdentifier getIdentifier() {
        return mapperIdentifier;
    }

    @Override
    public DtoV1 mapToDTO(Object obj) {
        if (obj instanceof EntityV1 entity) {

            final DtoV1 dto = new DtoV1();
            dto.name = entity.nameEn;

            return dto;
        }
        throw new IllegalArgumentException("Cannot convert " + obj + " to EntityV1");
    }
}
