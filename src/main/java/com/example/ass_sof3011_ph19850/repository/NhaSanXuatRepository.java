package com.example.ass_sof3011_ph19850.repository;



import com.example.ass_sof3011_ph19850.entity.NhaSanXuat;

import java.util.List;

public interface NhaSanXuatRepository {
    List<NhaSanXuat> getAll();

    NhaSanXuat getOne(String id);

    Boolean saveOrUpdate(NhaSanXuat nhaSanXuat);

    Boolean delete(NhaSanXuat nhaSanXuat);

    int genMaNSX();
}
