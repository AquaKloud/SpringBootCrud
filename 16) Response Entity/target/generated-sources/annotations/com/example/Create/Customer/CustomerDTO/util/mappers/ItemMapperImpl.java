package com.example.Create.Customer.CustomerDTO.util.mappers;

import com.example.Create.Customer.CustomerDTO.dto.ItemDTO;
import com.example.Create.Customer.CustomerDTO.dto.response.ItemGetResponseDTO;
import com.example.Create.Customer.CustomerDTO.entity.Item;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-07-07T13:35:09+0530",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_51 (Oracle Corporation)"
)
@Component
public class ItemMapperImpl implements ItemMapper {

    @Override
    public List<ItemGetResponseDTO> entityListToDtoList(List<Item> items) {
        if ( items == null ) {
            return null;
        }

        List<ItemGetResponseDTO> list = new ArrayList<ItemGetResponseDTO>( items.size() );
        for ( Item item : items ) {
            list.add( itemToItemGetResponseDTO( item ) );
        }

        return list;
    }

    @Override
    public ItemDTO entityToDto(Item item) {
        if ( item == null ) {
            return null;
        }

        ItemDTO itemDTO = new ItemDTO();

        itemDTO.setItemId( item.getItemId() );
        itemDTO.setItemName( item.getItemName() );
        itemDTO.setMeasuringUnitType( item.getMeasuringUnitType() );
        itemDTO.setBalanceQty( item.getBalanceQty() );
        itemDTO.setSupplierPrice( item.getSupplierPrice() );
        itemDTO.setSellingPrice( item.getSellingPrice() );
        itemDTO.setActiveState( item.isActiveState() );

        return itemDTO;
    }

    protected ItemGetResponseDTO itemToItemGetResponseDTO(Item item) {
        if ( item == null ) {
            return null;
        }

        ItemGetResponseDTO itemGetResponseDTO = new ItemGetResponseDTO();

        itemGetResponseDTO.setItemName( item.getItemName() );
        itemGetResponseDTO.setBalanceQty( item.getBalanceQty() );
        itemGetResponseDTO.setSellingPrice( item.getSellingPrice() );
        itemGetResponseDTO.setActiveState( item.isActiveState() );

        return itemGetResponseDTO;
    }
}
