package com.gitturami.bikeserver.controller.leisure;

import com.gitturami.bikeserver.controller.leisure.exception.LeisureNotFoundException;
import com.gitturami.bikeserver.infra.leisure.LeisureApi;
import com.gitturami.bikeserver.infra.leisure.constants.ContentTypeIds;
import com.gitturami.bikeserver.infra.leisure.impl.LeisureApiImpl;
import com.gitturami.bikeserver.infra.leisure.repository.LeisureResponse;
import com.gitturami.bikeserver.infra.leisure.repository.LightLeisure;
import com.gitturami.bikeserver.infra.leisure.repository.body.item.LeisureItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/leisure")
public class LeisureController {

    @Autowired
    private LeisureApi leisureApi;

    @GetMapping("/list")
    public LeisureResponse getLeisureList() {
        return leisureApi.getAllLeisureInformation();
    }

    @GetMapping("/parks")
    public List<LeisureItem> getParkList() {
        return leisureApi.getLeisureListByContentId(ContentTypeIds.PARK);
    }

    @GetMapping("/cultures")
    public List<LeisureItem> getCultureList() {
        return leisureApi.getLeisureListByContentId(ContentTypeIds.CULTURE);
    }

    @GetMapping("/festivals")
    public List<LeisureItem> getFestivalList() {
        return leisureApi.getLeisureListByContentId(ContentTypeIds.FESTIVAL);
    }

    @GetMapping("/leports")
    public List<LeisureItem> getLeportList() {
        return leisureApi.getLeisureListByContentId(ContentTypeIds.LEPORTS);
    }

    @GetMapping("/courses")
    public List<LeisureItem> getCourseList() {
        return leisureApi.getLeisureListByContentId(ContentTypeIds.COURSE);
    }

    @GetMapping("/hotels")
    public List<LeisureItem> getHotelList() {
        return leisureApi.getLeisureListByContentId(ContentTypeIds.HOTEL);
    }

    @GetMapping("/shopping")
    public List<LeisureItem> getShoppingList() {
        return leisureApi.getLeisureListByContentId(ContentTypeIds.SHOPPING);
    }

    @GetMapping("/foods")
    public List<LeisureItem> getFoodList() {
        return leisureApi.getLeisureListByContentId(ContentTypeIds.FOOD);
    }

    @GetMapping("/summaries")
    public List<LightLeisure> getLightLeisureList() {
        return leisureApi.getLightLeisureList();
    }

    @GetMapping("/terrain/summaries")
    public List<LightLeisure> getLightTerrainList(int townCode) {
        return leisureApi.getLightTerrainList(townCode);
    }

    @GetMapping("/name")
    public LeisureItem getLeisureByName(@RequestParam String name) {
        return leisureApi.getLeisureByName(name);
    }
}