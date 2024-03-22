package com.crud.democrud.db.House;

import com.crud.democrud.db.TenantHouse.TenantHouse;
import com.crud.democrud.db.TenantHouse.TenantHouseRepository;
import com.crud.democrud.db.User.AppUser;
import com.crud.democrud.db.User.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HouseService {
    @Autowired
    private HouseRepository houseRepository;
    @Autowired
    private AppUserRepository userRepository;
    @Autowired
    private TenantHouseRepository tenantHouseRepository;

    public List<House> getAllHouses() {
        return houseRepository.findAll();
    }

    public House createHouse(House house) {
        AppUser owner = userRepository.findById(house.getOwner().getId())
                .orElseThrow(() -> new RuntimeException("Owner not found")); // Поиск пользователя по id

        house.setOwner(owner);  // Устанавливаем пользователя в качестве владельца дома
        return houseRepository.save(house);
    }
    public House updateHouse(House house) {
        return houseRepository.save(house);
    }

    public void deleteHouse(Long houseId) {
        houseRepository.deleteById(houseId);
    }

    public List<House> getHousesByOwnerId(Long ownerId) {
        return houseRepository.findByOwnerId(ownerId);
    }

    public void addTenantToHouse(Long houseId, Long ownerId, Long tenantId) {
        House house = houseRepository.findById(houseId)
                .orElseThrow(() -> new RuntimeException("House not found"));
        AppUser owner = userRepository.findById(ownerId)
                .orElseThrow(() -> new RuntimeException("Owner not found"));
        AppUser tenant = userRepository.findById(tenantId)
                .orElseThrow(() -> new RuntimeException("Tenant not found"));

        if (!house.getOwner().equals(owner)) {
            throw new RuntimeException("Only the owner can add tenants to the house.");
        }

        TenantHouse tenantHouse = new TenantHouse();
        tenantHouse.setIdHouse(house);
        tenantHouse.setIdUser(tenant);
        tenantHouseRepository.save(tenantHouse);
    }
    public List<AppUser> getTenantsByHouseId(Long houseId) {
        List<TenantHouse> tenantHouses = tenantHouseRepository.findByIdHouse_Id(houseId);
        List<AppUser> tenants = new ArrayList<>();

        for (TenantHouse tenantHouse : tenantHouses) {
            tenants.add(tenantHouse.getIdUser());
        }

        return tenants;
    }
}
