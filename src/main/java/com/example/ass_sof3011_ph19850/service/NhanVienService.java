package com.example.ass_sof3011_ph19850.service;


import com.example.ass_sof3011_ph19850.entity.NhanVien;

import java.util.HashMap;
import java.util.List;


public interface NhanVienService {
    List<NhanVien> getAll();

    NhanVien getOne(String id);

    HashMap<String, String> save(NhanVien nhanVien);

    HashMap<String, String> update(NhanVien nhanVien);

    String delete(NhanVien nhanVien);

    String genNhanVien();
}
