package com.cadians.techserver.domain.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = FriendShipCompany.TABLE_NAME)
@Getter
@Setter
public class FriendShipCompany {
    public static final String TABLE_NAME ="FriendShipCompany";
    public static final String COL_Company ="company";
    public static final String  COL_PartnerCompany="partnerCompany";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = COL_Company)
    private String company ="";

    @Column(name = COL_PartnerCompany)
    private String partnerCompany = "";
}
