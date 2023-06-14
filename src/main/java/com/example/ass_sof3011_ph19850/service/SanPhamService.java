package com.example.ass_sof3011_ph19850.service;

import com.example.ass_sof3011_ph19850.entity.SanPham;

import java.util.HashMap;
import java.util.List;

public interface SanPhamService {
    List<SanPham> getAll();

    SanPham getOne(String id);

    HashMap<String, String> save(SanPham sanPham);

    HashMap<String, String> update(SanPham sanPham);

    String delete(SanPham sanPham);

    String genSanPham();
}
