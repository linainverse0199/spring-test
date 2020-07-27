package com.example.demo.repositories;

import com.example.demo.domain.GiftSet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GiftSetRepository extends CrudRepository<GiftSet, Long> {
}
