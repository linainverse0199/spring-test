package com.example.demo.repositories;

import com.example.demo.domain.GiftItem;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GiftItemRepository extends CrudRepository<GiftItem, Long> {

    @Query("select gf from GiftItem gf where gf.title = :param")
    List<GiftItem> getAllGiftItems(String param);
}
