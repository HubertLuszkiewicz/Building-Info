package pl.put.poznan.buildinginfo.models;

public class Room extends Location {
    public Float area;
    public Float cube;
    public Float heating;
    public Integer lighting;

    public Room(Integer id, String name, Float area, Float cube, Float heating, Integer lighting) {
        super(id, name);
        this.area = area;
        this.type = Types.ROOM;
        this.cube = cube;
        this.heating = heating;
        this.lighting = lighting;
    }

    @Override
    public Float getArea() {
        return this.area;
    }

    @Override
    public Float getCube() { return this.cube; }
}
