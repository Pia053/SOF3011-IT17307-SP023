package com.example.ass_sof3011_ph19850.service;


import com.example.ass_sof3011_ph19850.entity.NhaSanXuat;

import java.util.HashMap;
import java.util.List;

public interface NhaSanXuatService {
    List<NhaSanXuat> getAll();

    NhaSanXuat getOne(String id);

    HashMap<String, String> save(NhaSanXuat nhaSanXuat);

    HashMap<String, String> update(NhaSanXuat nhaSanXuat);

    String delete(NhaSanXuat nhaSanXuat);

    String genNSX();
}
