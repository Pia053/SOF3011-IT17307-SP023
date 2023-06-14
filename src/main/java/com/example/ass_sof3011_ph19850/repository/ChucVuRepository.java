package com.example.ass_sof3011_ph19850.repository;


import com.example.ass_sof3011_ph19850.entity.ChucVu;

import java.util.List;

public interface ChucVuRepository {
    List<ChucVu> getAll();

    ChucVu getOne(String id);

    Boolean saveOrUpdate(ChucVu chucVu);

    Boolean delete(ChucVu chucVu);


    int genMaChucVu();
}
