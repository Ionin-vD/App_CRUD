package com.crud.democrud.db.TenantHouse;

import com.crud.democrud.db.User.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TenantHouseRepository extends JpaRepository<TenantHouse, Long> {
    List<TenantHouse> findByIdHouse_Id(Long houseId);
}
