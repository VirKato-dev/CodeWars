package versioning;

public interface VersionedMapper {

    MapperIdentifier getIdentifier();

    Object mapToDTO(Object obj);
}
