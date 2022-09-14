package com.cadians.techserver.domain.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
@Table(name = Authentication.TABLE_NAME)
@Getter
@Setter
public class Authentication {

        public static final String TABLE_NAME = "Authentication";
        public static final String COL_ProductKey = "productKey";
        public static final String COL_Timsim = "timsim";
        public static final String COL_AnyDrawing = "anyDrawing";
        public static final String COL_Moldream = "moldream";
        public static final String COL_Company = "company";

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        //@GeneratedValue(strategy = GenerationType.IDENTITY)
        //@GenericGenerator(name = "USER_GENERATOR", strategy = "uuid")
        @Column(name = COL_ProductKey)
        private String productKey ="";


        @Column(name = COL_Timsim ,length = 1)
        private String timsim ="N";

        @Column(name = COL_AnyDrawing ,length = 1)
        private String anyDrawing = "N";

        @Column(name = COL_Moldream , length = 1)
        private String moldream ="N";

        @Column(name = COL_Company)
        private String company ="";
}
