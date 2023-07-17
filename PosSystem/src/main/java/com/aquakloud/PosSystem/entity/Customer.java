package com.aquakloud.PosSystem.entity;

import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.util.ArrayList;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "customer")
@TypeDefs(
        {
                @TypeDef(name = "json", typeClass = JsonType.class)
        }
)


public class Customer {

    @Id
    @Column(name = "customer_id", length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int customerId;

    @Column(name = "customer_name", length = 100, nullable = false)
    private String customerName;

    @Column(name = "customer_address", length = 100)
    private String customerAddress;

    @Type(type = "json")
    @Column(name = "contact_number", columnDefinition = "json")
    private ArrayList contactNumber;

    @Column(name = "nic", length = 20)
    private String nic;

    @Column(name = "active_status", columnDefinition = "TINYINT")
    private boolean activeState;


}
