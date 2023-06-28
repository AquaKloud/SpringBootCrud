package com.example.Create.Customer.CustomerDTO.service.IMPL;

import com.example.Create.Customer.CustomerDTO.dto.ItemDTO;
import com.example.Create.Customer.CustomerDTO.dto.request.ItemSaveRequestDTO;
import com.example.Create.Customer.CustomerDTO.dto.request.ItemUpdateDTO;
import com.example.Create.Customer.CustomerDTO.entity.Customer;
import com.example.Create.Customer.CustomerDTO.entity.Item;
import com.example.Create.Customer.CustomerDTO.repo.ItemRepo;
import com.example.Create.Customer.CustomerDTO.service.ItemService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceIMPL implements ItemService {

    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public String saveItem(ItemSaveRequestDTO itemSaveRequestDTO) {
//        Item item = new Item(
//                0,
//                itemSaveRequestDTO.getItemName(),
//                itemSaveRequestDTO.getMeasuringUnitType(),
//                itemSaveRequestDTO.getBalanceQty(),
//                itemSaveRequestDTO.getSupplierPrice(),
//                itemSaveRequestDTO.getSellingPrice(),
//                itemSaveRequestDTO.isActiveState()
//        );
        Item item = modelMapper.map(itemSaveRequestDTO,Item.class);
        itemRepo.save(item);
        return item.getItemName()+"Saved";
    }

    @Override
    public ItemDTO getItemById(int itemId) {
       if(itemRepo.existsById(itemId)){
             Item item = itemRepo.getReferenceById(itemId);
//           ItemDTO itemDTO = new ItemDTO(
//             item.getItemId(),
//             item.getItemName(),
//             item.getMeasuringUnitType(),
//             item.getBalanceQty(),
//             item.getSupplierPrice(),
//             item.getSellingPrice(),
//             item.isActiveState()
//           );


           ItemDTO itemDTO = modelMapper.map(item,ItemDTO.class);
           return itemDTO;

       }else{
           throw new RuntimeException("No Item");
       }

    }

    @Override
    public String updateItem(ItemUpdateDTO itemUpdateDTO) {
        if(itemRepo.existsById(itemUpdateDTO.getItemId())){
 //           Item item = itemRepo.getReferenceById(itemUpdateDTO.getItemId());
//            item.setItemId(itemUpdateDTO.getItemId());
//            item.setItemName(itemUpdateDTO.getItemName());
//            item.setMeasuringUnitType(itemUpdateDTO.getMeasuringUnitType());
//            item.setBalanceQty(item.getBalanceQty());
//            item.setSupplierPrice(item.getSupplierPrice());
//            item.setSellingPrice(item.getSellingPrice());
//            item.setActiveState(itemUpdateDTO.isActiveState());

            Item item = modelMapper.map(itemUpdateDTO,Item.class);

            itemRepo.save(item);
            return itemUpdateDTO.getItemName() + "Update Item";
        }else{
            throw new RuntimeException("No Data Found for that id");
        }
    }
}
