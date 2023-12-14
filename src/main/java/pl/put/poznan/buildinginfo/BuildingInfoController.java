package pl.put.poznan.buildinginfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import pl.put.poznan.buildinginfo.models.Location;

@RestController
public class BuildingInfoController {
    @GetMapping("/area")
    public Float getArea(@RequestBody Location body){
        return body.getArea();
        }

    @GetMapping("/cube")
    public Float getCube(@RequestBody Location body){
        return body.getCube();
    }
}

