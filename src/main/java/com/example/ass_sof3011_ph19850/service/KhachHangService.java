package com.example.ass_sof3011_ph19850.service;


import com.example.ass_sof3011_ph19850.entity.KhachHang;

import java.util.HashMap;
import java.util.List;

public interface KhachHangService {
    List<KhachHang> getAll();

    KhachHang getOne(String id);

    KhachHang getOneByMaAndMatKhau(String ma, String matKhau);

    HashMap<String, String> save(KhachHang khachHang);

    HashMap<String, String> update(KhachHang khachHang);

    String delete(KhachHang khachHang);

    String genKhachHang();
}
