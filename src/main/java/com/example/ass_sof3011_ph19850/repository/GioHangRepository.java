package com.example.ass_sof3011_ph19850.repository;


import com.example.ass_sof3011_ph19850.entity.GioHang;

import java.util.List;

public interface GioHangRepository {
    List<GioHang> getAll();

    Boolean saveOrUpdate(GioHang gioHang);

    int genMaGioHang();
}
