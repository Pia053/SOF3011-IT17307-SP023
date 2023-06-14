package com.example.ass_sof3011_ph19850.repository;


import com.example.ass_sof3011_ph19850.entity.GioHangChiTiet;

import java.util.List;

public interface GioHangChiTietRepository {
    List<GioHangChiTiet> getAll();

    GioHangChiTiet getOne(String idSP);
    Boolean saveOrUpdate(GioHangChiTiet gioHangChiTiet);
}
