package pl.put.poznan.buildinginfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.put.poznan.buildinginfo.models.Location;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class BuildingInfoController {
    final private static Logger log = LoggerFactory.getLogger(BuildingInfoController.class);
    @GetMapping("/area")
    public Float getArea(@RequestBody Location body){
        log.info("For location: " + body.name + " area is: " + body.getArea().toString() + " m^2");
        return body.getArea();
    }

    @GetMapping("/cube")
    public Float getCube(@RequestBody Location body){
        log.info("For location: " + body.name + " cube is: " + body.getCube().toString() + " m^3");
        return body.getCube();
    }
}

