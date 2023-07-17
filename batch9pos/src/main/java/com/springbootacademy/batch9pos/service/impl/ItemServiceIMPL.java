package com.springbootacademy.batch9pos.service.impl;

import com.springbootacademy.batch9pos.dto.CustomerDTO;
import com.springbootacademy.batch9pos.dto.ItemDTO;
import com.springbootacademy.batch9pos.dto.request.ItemSaveRequestDTO;
import com.springbootacademy.batch9pos.dto.request.ItemUpdateDTO;
import com.springbootacademy.batch9pos.entity.Customer;
import com.springbootacademy.batch9pos.entity.Item;
import com.springbootacademy.batch9pos.entity.enums.MeasuringUnitType;
import com.springbootacademy.batch9pos.repo.ItemRepo;
import com.springbootacademy.batch9pos.service.ItemService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
 //               itemSaveRequestDTO.getSupplierPrice(),
 //               itemSaveRequestDTO.getSellingPrice(),
//                itemSaveRequestDTO.isActiveState()
//        );

        Item item = modelMapper.map(itemSaveRequestDTO,Item.class);
        itemRepo.save(item);
        return item.getItemName() + "Saved";
    }

    @Override
    public ItemDTO getItemById(int itemId) {
        if(itemRepo.existsById(itemId)) {
            Item item = itemRepo.getReferenceById(itemId);
//            ItemDTO itemDTO = new ItemDTO(
 //           item.getItemId(),
 //                   item.getItemName(),
 //                   item.getMeasuringUnitType(),
 //                   item.getBalanceQty(),
 //                   item.getSupplierPrice(),
 //                   item.getSellingPrice(),
 //                   item.isActiveState()
  //          );
            ItemDTO itemDTO =  modelMapper.map(item,ItemDTO.class);
            return itemDTO;
        }else{
            throw new RuntimeException("No Customer");
        }
    }

    @Override
    public String updateItem(ItemUpdateDTO itemUpdateDTO) {
        if (itemRepo.existsById(itemUpdateDTO.getItemId())) {
//            Item item = itemRepo.getReferenceById(itemUpdateDTO.getItemId());

//            item.s(itemUpdateDTO.getMeasuringUnitType());
//            Item.setNic(itemUpdateDTO.getBalanceQty());
//            Item.setNic(itemUpdateDTO.getSupplierPrice());
//            Item.setNic(itemUpdateDTO.getSellingPrice());
//            Item.setNic(itemUpdateDTO.isActiveState());


            Item item =  modelMapper.map(itemUpdateDTO,Item.class);



            itemRepo.save(item);
            return itemUpdateDTO.getItemName() + "Update";
        } else {
            throw new RuntimeException("No Data Found for that id");
        }

    }

    @Override
    public String deleteItem(int itemId) {
        if(itemRepo.existsById(itemId)){
            itemRepo.deleteById(itemId);
            return itemId + "deleted";
        }else{
            throw new RuntimeException("No Customer for delete");
        }
    }

    @Override
    public List<ItemDTO> getAllItemByActiveState(boolean activeStatus) {
        List<Item> itemDTOList = itemRepo.findAllByActiveState(activeStatus);
        //List<ItemDTO> customerDTOS = new ArrayList<>();

//        for(Customer customer : customerDTOList){
//            CustomerDTO customerDTO = new CustomerDTO(
//                    customer.getCustomerId(),
//                    customer.getCustomerName(),
//                    customer.getCustomerAddress(),
//                    customer.getContactNumber(),
//                    customer.getNic(),
//                    customer.isActiveState()
//            );
//            customerDTOS.add(customerDTO);
//        }
        List<ItemDTO> itemDTOS = modelMapper.map(itemDTOList,new TypeToken<List<ItemDTO>>() {}.getType());
        return itemDTOS;
    }

    @Override
    public List<ItemDTO> getAllItem() {
        List<Item> itemDTOList = itemRepo.findAll();
//        List<ItemDTO> itemDTOS = new ArrayList<>();
//
//        for(Item item : itemDTOList){
//            ItemDTO itemDTO = new ItemDTO(
//                    item.getItemId(),
//                    item.getItemName(),
//                    item.getMeasuringUnitType(),
//                    item.getBalanceQty(),
//                    item.getSupplierPrice(),
//                    item.getSellingPrice(),
//                    item.isActiveState()
//            );
//            itemDTOS.add(itemDTO);
//        }

        List<ItemDTO> itemDTOS = modelMapper.map(itemDTOList, new TypeToken<List<ItemDTO>>() {}.getType());
        return itemDTOS;
    }
}
