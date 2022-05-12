package com.example.nutrient.domain.repository;

import com.example.nutrient.domain.Supplement;

import java.util.List;
import java.util.UUID;

public interface SupplementRepository {

    Supplement save(Supplement supplement);

    List<Supplement> findAllById(Iterable<UUID> ids);
}
