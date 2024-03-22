package com.crud.democrud.db.House;

import com.crud.democrud.db.TenantHouse.TenantHouseRequest;
import com.crud.democrud.db.User.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/houses")
public class HouseController {
    @Autowired
    private HouseService houseService;

    @GetMapping
    public List<House> getAllHouses() {
        return houseService.getAllHouses();
    }

    @PostMapping
    public House createHouse(@RequestBody House house) {
        return houseService.createHouse(house);
    }

    @PutMapping
    public House updateHouse(@RequestBody House house) {
        return houseService.updateHouse(house);
    }

    @DeleteMapping("/{houseId}")
    public void deleteHouse(@PathVariable Long houseId) {
        houseService.deleteHouse(houseId);
    }

    @GetMapping("/owner/{ownerId}")
    public List<House> getHousesByOwnerId(@PathVariable Long ownerId) {
        return houseService.getHousesByOwnerId(ownerId);
    }

    @PostMapping("/addTenant")
    public void addTenantToHouse(@RequestBody TenantHouseRequest request) {
        houseService.addTenantToHouse(request.getHouseId(), request.getOwnerId(), request.getTenantId());
    }

    @GetMapping("/{houseId}/tenants")
    public List<AppUser> getTenantsByHouseId(@PathVariable Long houseId) {
        return houseService.getTenantsByHouseId(houseId);
    }
}