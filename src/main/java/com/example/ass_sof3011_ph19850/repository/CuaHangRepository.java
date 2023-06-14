package com.example.ass_sof3011_ph19850.repository;

import com.example.ass_sof3011_ph19850.entity.CuaHang;

import java.util.List;

public interface CuaHangRepository {
    List<CuaHang> getAll();

    CuaHang getOne(String id);

    Boolean saveOrUpdate(CuaHang cuaHang);

    Boolean delete(CuaHang cuaHang);

    int genMaCuaHang();
}
