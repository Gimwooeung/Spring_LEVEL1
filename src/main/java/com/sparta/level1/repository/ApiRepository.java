package com.sparta.level1.repository;

import com.sparta.level1.entity.Api;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApiRepository extends JpaRepository<Api, Long>{
    List<Api> findAllByOrderByModifiedAtDesc();
}
