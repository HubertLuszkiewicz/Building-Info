package pl.put.poznan.buildinginfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.put.poznan.buildinginfo.models.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BuildingInfoController {
    final private static Logger log = LoggerFactory.getLogger(BuildingInfoController.class);
    @GetMapping("/area")
    public Float getArea(@RequestBody Location body){
        Float area = body.getArea();
        log.info("For location: " + body.name + " area is: " + area.toString() + " m^2");
        return area;
    }

    @GetMapping("/volume")
    public Float getVolume(@RequestBody Location body){
        Float volume = body.getVolume();
        log.info("For location: " + body.name + " volume is: " + volume.toString() + " m^3");
        return volume;
    }

    @GetMapping("/lighting")
    public Float getLightingPerArea(@RequestBody Location body) {
        Integer lighting = body.getTotalLighting();
        Float area = body.getArea();
        Float out = lighting / area;
        log.info("For location: " + body.name + " lighting per m^2 is: " + lighting + "/" + area + "=" + out);
        return out;
    }

    @GetMapping("/heating")
    public Float getHeatingPerVolume(@RequestBody Location body) {
        Float heating = body.getTotalHeating();
        Float volume = body.getVolume();
        Float out = heating / volume;
        log.info("For location: " + body.name + " heating per m^3 is: " + heating + "/" + volume + "=" + out);
        return out;
    }

    @GetMapping("/overheating")
    public List<Integer> getOverheatedRooms(@RequestBody Building building, @RequestParam("threshold") Float threshold) {
        List<Integer> out = new ArrayList<Integer>();

        for (Floor floor : building.getLocations()) {
            for (Room room : floor.getLocations()) {
                float val = room.getTotalHeating() / room.getVolume();
                if (val >= threshold) {
                    log.info("Location: " + room.name + " (" + room.id + ") heating per m^3: " + val + " is above the threshold of " + threshold);
                    out.add(room.id);
                } else {
                    log.info("Location: " + room.name + " (" + room.id + ") heating per m^3: " + val + " is below the threshold of " + threshold);
                }
            }
        }

        return out;
    }
    
    @GetMapping("/lightinglowest")
    public List<String> getLightingLowest(@RequestBody Building building) {
        List<String> out = new ArrayList<String>();
        Integer min = Integer.MAX_VALUE;

        for (Floor floor : building.getLocations()) {
            for (Room room : floor.getLocations()) {
                Integer val = room.getTotalLighting();

                if (val < min) {
                    out.clear();
                    min = val;
                }

                if (val.intValue() == min.intValue()) {
                    out.add(room.name);
                }
            }
        }

        return out;
    }
}
