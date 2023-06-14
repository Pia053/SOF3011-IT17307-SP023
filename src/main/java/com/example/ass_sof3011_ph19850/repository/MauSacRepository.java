package com.example.ass_sof3011_ph19850.repository;

import com.example.ass_sof3011_ph19850.entity.MauSac;

import java.util.List;

public interface MauSacRepository {
    List<MauSac> getAll();

    MauSac getOne(String id);

    Boolean saveOrUpdate(MauSac mauSac);

    Boolean delete(MauSac mauSac);

    int genMaMauSac();
}
