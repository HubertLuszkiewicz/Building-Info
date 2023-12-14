package pl.put.poznan.buildinginfo.models;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Room.class, name = "ROOM"),
        @JsonSubTypes.Type(value = RoomComponent.class, name = "CONDIGNATION"),
        @JsonSubTypes.Type(value = RoomComponent.class, name = "BUILDING")
})

public abstract class Location {
    public Integer id;
    public String name;
    public Types type;
    abstract public Float getArea();
    abstract public Float getCube();

    Location(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
