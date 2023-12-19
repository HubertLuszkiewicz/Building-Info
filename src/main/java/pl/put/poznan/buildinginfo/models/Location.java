package pl.put.poznan.buildinginfo.models;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * Abstract class representing a building location.
 * Allows for accessing basic information about specific parts of the building.
 * All logic should use this class when knowledge about requested scope isn't required.
 * <p>
 * When this class is used as a endpoint parameter type, it'll be deserialized based on the
 * value of <a href="#type">type</a> property to a specific implementation.
 *
 * @see Types Enum distinguishing implementations when deserializing
 */
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Room.class, name = "ROOM"),
        @JsonSubTypes.Type(value = Floor.class, name = "FLOOR"),
        @JsonSubTypes.Type(value = Building.class, name = "BUILDING")
})

public abstract class Location {
    /**
     * Location ID
     */
    public Integer id;
    /**
     * Location name
     */
    public String name;
    /**
     * Type used for distinguishing implementations when deserializing.
     * Each implementation should have its own unique enum constant.
     */
    public Types type;

    /**
     * @return Location area or area sum of its sublocations
     */
    abstract public Float getArea();
    /**
     * @return Location volume or volume sum of its sublocations
     */
    abstract public Float getVolume();
    /**
     * @return Sum of heating power used in the location
     */
    abstract public Float getTotalHeating();
    /**
     * @return Sum of lighting intensity emitted in the location
     */
    abstract public Integer getTotalLighting();

    /**
     * Default constructor
     *
     * @param id Location ID
     * @param name Location Name
     */
    Location(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
