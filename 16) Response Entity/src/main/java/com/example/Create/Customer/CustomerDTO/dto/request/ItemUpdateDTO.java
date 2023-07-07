package com.example.Create.Customer.CustomerDTO.dto.request;

import com.example.Create.Customer.CustomerDTO.entity.enums.MeasuringUnitType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
//@Getter
//@Setter
//@ToString
@Data
public class ItemUpdateDTO {

        private int itemId;
        private String itemName;
        private MeasuringUnitType measuringUnitType;
        private double balanceQty;
        private double supplierPrice;
        private double sellingPrice;
        private boolean activeState;

}
