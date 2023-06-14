package com.example.ass_sof3011_ph19850.repository;


import com.example.ass_sof3011_ph19850.entity.KhachHang;

import java.util.List;

public interface KhachHangRepository {
    List<KhachHang> getAll();

    KhachHang getOne(String id);

    Boolean saveOrUpdate(KhachHang khachHang);

    Boolean delete(KhachHang khachHang);

    KhachHang getOneByMaAndMatKhau(String ma, String matKhau);

    int genMaKhachHang();
}
