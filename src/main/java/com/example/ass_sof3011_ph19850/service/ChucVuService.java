package com.example.ass_sof3011_ph19850.service;


import com.example.ass_sof3011_ph19850.entity.ChucVu;

import java.util.HashMap;
import java.util.List;

public interface ChucVuService {
    List<ChucVu> getAll();

    ChucVu getOne(String id);

    HashMap<String,String>  save(ChucVu chucVu);

    HashMap<String,String> update(ChucVu chucVu);

    String delete(ChucVu chucVu);

    String genChucVu();
}
