package com.crud.democrud.db.TenantHouse;

import com.crud.democrud.db.House.House;
import com.crud.democrud.db.User.AppUser;
import jakarta.persistence.*;

@Entity
public class TenantHouse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idHouse_id")
    private House idHouse;

    @ManyToOne
    @JoinColumn(name = "idUser_id")
    private AppUser idUser;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public House getIdHouse() {
        return idHouse;
    }

    public void setIdHouse(House idHouse) {
        this.idHouse = idHouse;
    }

    public AppUser getIdUser() {
        return idUser;
    }

    public void setIdUser(AppUser idUser) {
        this.idUser = idUser;
    }
}
