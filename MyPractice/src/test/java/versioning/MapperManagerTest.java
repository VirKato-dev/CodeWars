package versioning;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import versioning.dto.DtoV1;
import versioning.dto.DtoV2;
import versioning.entity.EntityV1;
import versioning.entity.EntityV2;
import versioning.mapper.EntityV1Mapper;
import versioning.mapper.EntityV2Mapper;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MapperManagerTest {

    @Test
    public void test() throws IOException, ClassNotFoundException {
        ObjectMapper mapper = new ObjectMapper();

        MapperManager mapperManager = new MapperManager();
        List<VersionedMapper> mappers = List.of(new EntityV1Mapper(), new EntityV2Mapper());
        mapperManager.addMappers(mappers);

        byte[] entityV1 = mapper.writeValueAsBytes(new EntityV1());
        byte[] entityV2 = mapper.writeValueAsBytes(new EntityV2());

        DtoV1 dtoV1 = mapperManager.map(entityV1,
                new MapperIdentifier("v1.0", EntityV1.class));
        assertEquals("entity V1", dtoV1.name);

        DtoV2 dtoV2 = mapperManager.map(entityV2,
                new MapperIdentifier("V2.0", EntityV2.class));
        assertEquals("сущность V2", dtoV2.name);

        assertThrows(ClassCastException.class, () -> {
            DtoV2 dto = mapperManager.map(entityV1, new MapperIdentifier("v1.0", EntityV1.class));
        });

    }
}