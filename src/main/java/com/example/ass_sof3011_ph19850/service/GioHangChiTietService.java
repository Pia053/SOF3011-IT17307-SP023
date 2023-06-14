package com.example.ass_sof3011_ph19850.service;

import com.example.ass_sof3011_ph19850.entity.GioHangChiTiet;

import java.util.List;

public interface GioHangChiTietService {
    List<GioHangChiTiet> getAll();

    GioHangChiTiet getOne(String id);
    String saveGioHangChiTiet(GioHangChiTiet gioHangChiTiet);

    String updateGioHangChiTiet(GioHangChiTiet gioHangChiTiet);
}
