package com.example.ass_sof3011_ph19850.service;


import com.example.ass_sof3011_ph19850.entity.GioHang;

import java.util.List;

public interface GioHangService {
    List<GioHang> getAll();

    String saveGioHang(GioHang gioHang);

    String updateGioHang(GioHang gioHang);

    String genGioHang();
}
