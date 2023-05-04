package sshukla.springhibernatemappingv2.onetomany.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sshukla.springhibernatemappingv2.onetomany.model.bidirectional.Cart;
import sshukla.springhibernatemappingv2.onetomany.model.bidirectional.Item;
import sshukla.springhibernatemappingv2.onetomany.repo.CartRepo;
import sshukla.springhibernatemappingv2.onetomany.repo.ItemRepo;

import java.util.List;
import java.util.UUID;

/**
 * Created by `Seemant Shukla` on 03-05-2023
 */

@RestController
@RequestMapping("/onetomany/bi/v1/api")
public class OneToManyBiDirectionalController {

    Logger LOGGER = LoggerFactory.getLogger(OneToManyBiDirectionalController.class);

    @Autowired
    ItemRepo itemRepo;

    @Autowired
    CartRepo cartRepo;

    @PostMapping("/cart/create")
    public ResponseEntity<Cart> createCart(@RequestBody Cart cart) {
        LOGGER.info("Controller.createCart() --- {}", cart.toString());
        cart.setId(UUID.randomUUID().toString());
//        cart.getItems().stream().map(item -> {
////            item.setId(UUID.randomUUID().toString());
//            return item;
//        }).filter(item -> item.getCart() == null).forEach(cart.getItems()::add);
        return ResponseEntity.ok(cartRepo.save(cart));
    }

    @PostMapping("/item/create")
    public ResponseEntity<Item> createItem(@RequestBody Item item) {
        LOGGER.info("Controller.createItem() ---");
        item.setId(UUID.randomUUID().toString());
        return ResponseEntity.ok(itemRepo.save(item));
    }

    @PutMapping("/item/update")
    public ResponseEntity<Item> updateItem(@RequestBody Item item) {
        LOGGER.info("Controller.updateItem() ---");
        Item savedItem = itemRepo.findById(item.getId()).orElseThrow(() -> new RuntimeException("Item Not Found!!!"));
        savedItem.setItemName(item.getItemName());
        savedItem.setExpirationDate(item.getExpirationDate());
        savedItem.setManufacturingDate(item.getManufacturingDate());
        savedItem.setManufacturer(item.getManufacturer());
//        savedItem.getContents().clear();
//        savedItem.getContents().addAll(item.getContents());
        savedItem.setCart(item.getCart());
        return ResponseEntity.ok(savedItem);
    }

    @GetMapping("/item/all")
    public ResponseEntity<List<Item>> getAllItem() {
        LOGGER.info("Controller.getAllItem() ---");
        return ResponseEntity.ok(itemRepo.findAll());
    }

    @GetMapping("/item/itemId")
    public ResponseEntity<Item> getItemById(@RequestParam("itemId") String itemId) {
        LOGGER.info("Controller.getItemById() ---");
        return ResponseEntity.ok(itemRepo.findById(itemId).orElseThrow(() -> new RuntimeException("Item Not Found!!!")));
    }

    @DeleteMapping("/item/itemId")
    public ResponseEntity<HttpStatus> deleteItemById() {
        LOGGER.info("Controller.deleteItemById() ---");
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
