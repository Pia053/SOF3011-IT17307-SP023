package com.example.ass_sof3011_ph19850.repository;


import com.example.ass_sof3011_ph19850.entity.ChiTietSanPham;

import java.util.List;

public interface ChiTietSanPhamRepository {
    List<ChiTietSanPham> getAll();

    ChiTietSanPham getOne(String id);

    Boolean saveOrUpdate(ChiTietSanPham chiTietSanPham);

    Boolean delete(ChiTietSanPham chiTietSanPham);

    List<ChiTietSanPham> getByIdNSX(String idNSX);

    int genMaChiTietSP();
}
