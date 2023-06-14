package com.example.ass_sof3011_ph19850.service;

import com.example.ass_sof3011_ph19850.entity.ChiTietSanPham;

import java.util.HashMap;
import java.util.List;

public interface ChiTietSanPhamService {
    List<ChiTietSanPham> getAll();

    List<ChiTietSanPham> getByIdNSX(String idNSX);

    ChiTietSanPham getOne(String id);

    HashMap<String,String>  save(ChiTietSanPham chiTietSanPham);

    HashMap<String,String> update(ChiTietSanPham chiTietSanPham);

    String delete(ChiTietSanPham chiTietSanPham);

    String genChiTietSP();
}
