package com.example.MakingApi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.MakingApi.model.Model;

public interface Repository extends JpaRepository<Model, Long> {
    List<Model> findByPublished(boolean published);
    List<Model> findByTitleContaining(String title);
}
