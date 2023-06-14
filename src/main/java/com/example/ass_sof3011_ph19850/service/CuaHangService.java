package com.example.ass_sof3011_ph19850.service;


import com.example.ass_sof3011_ph19850.entity.CuaHang;

import java.util.HashMap;
import java.util.List;

public interface CuaHangService {
    List<CuaHang> getAll();

    CuaHang getOne(String id);

    HashMap<String,String> save(CuaHang cuaHang);

    HashMap<String,String> update(CuaHang cuaHang);

    String delete(CuaHang cuaHang);

    String genCuaHang();
}
