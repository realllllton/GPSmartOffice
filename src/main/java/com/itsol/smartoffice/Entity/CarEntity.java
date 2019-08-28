package com.itsol.smartoffice.Entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "CAR")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class CarEntity implements Serializable {

    @Id
    @Column(name = "NUMBERPLATE")
    private String numberplate;

    @Column(name = "NAMECAR")
    private String namecar;

    @Column(name = "YEAROFMANUFACTURE")
    private int yearofmanufacture;
    @Column(name = "BRAND")
    private String brand;

    @Column(name = "HAVEINSURANCE")
    private boolean haveinsurance;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "STATUS")
    private boolean status;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "EMAIL", insertable = false, updatable = false)
//    private UserEntity userEntity;
//
//    @OneToMany(mappedBy = "carEntity", fetch = FetchType.LAZY)
////    @JsonManagedReference
//    private List<InsuranceofcarEntity> insuranceofcarEntities;
}
