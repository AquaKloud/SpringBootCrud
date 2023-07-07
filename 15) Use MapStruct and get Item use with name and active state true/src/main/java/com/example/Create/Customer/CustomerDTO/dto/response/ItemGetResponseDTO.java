package com.example.Create.Customer.CustomerDTO.dto.response;

import com.example.Create.Customer.CustomerDTO.entity.enums.MeasuringUnitType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ItemGetResponseDTO {

    private String itemName;
    private double balanceQty;

    private double sellingPrice;
    private boolean activeState;
}
