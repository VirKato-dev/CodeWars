package versioning;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Хранит версионированные мапперы и применяет нужный
 */
public class MapperManager {

    private static final Map<MapperIdentifier, VersionedMapper> _mappers = new HashMap<>();

    private final ObjectMapper objectMapper = new ObjectMapper();


    public void addMappers(List<VersionedMapper> mappers) {
        _mappers.putAll(mappers.stream()
                .collect(Collectors.toMap(
                        VersionedMapper::getIdentifier,
                        Function.identity()
                ))
        );
    }

    public <T> T map(byte[] data, MapperIdentifier id)
            throws ClassNotFoundException, ClassCastException, IOException {
        VersionedMapper mapper = _mappers.get(id);
        Object obj = objectMapper.readValue(data, id.getClassName());
        return (T) mapper.mapToDTO(obj);
    }

}
