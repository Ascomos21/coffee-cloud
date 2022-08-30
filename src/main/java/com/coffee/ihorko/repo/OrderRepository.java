package com.coffee.ihorko.repo;

import com.coffee.ihorko.model.PizzaOrder;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface OrderRepository extends CrudRepository<PizzaOrder, Long> {

    List<PizzaOrder> findByDeliveryZip(String deliveryZip);

    List<PizzaOrder> readOrdersByDeliveryZipAndPlacedAtBetween(String deliveryZip, Date startDate, Date endDate);
}
