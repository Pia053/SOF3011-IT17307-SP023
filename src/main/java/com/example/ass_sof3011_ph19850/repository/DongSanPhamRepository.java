package com.example.ass_sof3011_ph19850.repository;


import com.example.ass_sof3011_ph19850.entity.DongSanPham;

import java.util.List;

public interface DongSanPhamRepository {
    List<DongSanPham> getAll();

    DongSanPham getOne(String id);

    Boolean saveOrUpdate(DongSanPham dongSanPham);

    Boolean delete(DongSanPham dongSanPham);

    int genMaDongSP();
}
