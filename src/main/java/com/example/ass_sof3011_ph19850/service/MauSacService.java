package com.example.ass_sof3011_ph19850.service;

import com.example.ass_sof3011_ph19850.entity.MauSac;

import java.util.HashMap;
import java.util.List;

public interface MauSacService {
    List<MauSac> getAll();

    MauSac getOne(String id);

    HashMap<String, String> save(MauSac mauSac);

    HashMap<String, String> update(MauSac mauSac);

    String delete(MauSac mauSac);

    String genMauSac();
}
