package com.example.ass_sof3011_ph19850.service;

import com.example.ass_sof3011_ph19850.entity.DongSanPham;

import java.util.HashMap;
import java.util.List;

public interface DongSanPhamService {
    List<DongSanPham> getAll();

    DongSanPham getOne(String id);

    HashMap<String,String> save(DongSanPham dongSanPham);

    HashMap<String,String> update(DongSanPham dongSanPham);

    String delete(DongSanPham dongSanPham);

    String genDongSP();
}
