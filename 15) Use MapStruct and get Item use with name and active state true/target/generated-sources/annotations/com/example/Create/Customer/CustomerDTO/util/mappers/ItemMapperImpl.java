package com.example.Create.Customer.CustomerDTO.util.mappers;

import com.example.Create.Customer.CustomerDTO.dto.response.ItemGetResponseDTO;
import com.example.Create.Customer.CustomerDTO.entity.Item;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-07-07T11:29:05+0530",
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
