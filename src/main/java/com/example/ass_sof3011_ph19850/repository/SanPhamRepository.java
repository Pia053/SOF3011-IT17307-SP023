package com.example.ass_sof3011_ph19850.repository;

import com.example.ass_sof3011_ph19850.entity.SanPham;

import java.util.List;

public interface SanPhamRepository {
    List<SanPham> getAll();

    SanPham getOne(String id);

    Boolean saveOrUpdate(SanPham sanPham);

    Boolean delete(SanPham sanPham);

    int genMaSanPham();
}
