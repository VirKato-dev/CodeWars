package versioning;

import java.util.Objects;

public class MapperIdentifier {
    private String version;
    private Class<?> clazz;

    public MapperIdentifier(String version, Class<?> clazz) {
        this.version = version;
        this.clazz = clazz;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Class<?> getClassName() {
        return clazz;
    }

    public void setClassName(Class<?> className) {
        this.clazz = className;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        MapperIdentifier that = (MapperIdentifier) o;
        return Objects.equals(version, that.version) && Objects.equals(clazz, that.clazz);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(version);
        result = 31 * result + Objects.hashCode(clazz);
        return result;
    }
}
