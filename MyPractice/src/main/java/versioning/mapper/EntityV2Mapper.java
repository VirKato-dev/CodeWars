package versioning.mapper;

import versioning.MapperIdentifier;
import versioning.VersionedMapper;
import versioning.dto.DtoV2;
import versioning.entity.EntityV2;

public class EntityV2Mapper implements VersionedMapper {

    private final MapperIdentifier mapperIdentifier = new MapperIdentifier("V2.0", EntityV2.class);

    @Override
    public MapperIdentifier getIdentifier() {
        return mapperIdentifier;
    }

    @Override
    public DtoV2 mapToDTO(Object obj) {
        if (obj instanceof EntityV2 entity) {

            final DtoV2 dto = new DtoV2();
            dto.name = entity.nameRu;

            return dto;
        }
        throw new IllegalArgumentException("Cannot convert " + obj + " to EntityV2");
    }
}
