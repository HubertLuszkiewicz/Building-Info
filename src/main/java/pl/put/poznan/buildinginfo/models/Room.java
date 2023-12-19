package pl.put.poznan.buildinginfo.models;

/**
 * Class representing room in a building
 */
public class Room extends Location {
    /**
     * Room's area (use getArea() instead)
     * @see Room#getArea()
     */
    public Float area;
    /**
     * Room's volume (use getVolume() instead)
     * @see Room#getVolume()
     */
    public Float volume;
    /**
     * Room's heating power usage (use getTotalHeating() instead)
     * @see Room#getTotalHeating()
     */
    public Float heating;
    /**
     * Room's total lighting intensity (use getTotalLighting() instead)
     * @see Room#getTotalLighting()
     *
     */
    public Integer lighting;

    /**
     * Default constructor for initializing all properties
     * @param id Location ID
     * @param name Location name
     * @param area Room's area
     * @param volume Room's volume
     * @param heating Room's heating power usage
     * @param lighting Room's total lighting intensity
     */
    public Room(Integer id, String name, Float area, Float volume, Float heating, Integer lighting) {
        super(id, name);
        this.area = area;
        this.type = Types.ROOM;
        this.volume = volume;
        this.heating = heating;
        this.lighting = lighting;
    }

    /** @return Room's area */
    @Override
    public Float getArea() { return this.area; }

    /** @return Room's volume */
    @Override
    public Float getVolume() { return this.volume; }

    /** @return Room's heating power usage */
    @Override
    public Float getTotalHeating() { return this.heating; }

    /** @return Room's total lighting intensity */
    @Override
    public Integer getTotalLighting() { return this.lighting; }
}
