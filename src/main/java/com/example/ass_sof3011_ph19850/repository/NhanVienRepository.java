package com.example.ass_sof3011_ph19850.repository;



import com.example.ass_sof3011_ph19850.entity.NhanVien;

import java.util.List;

public interface NhanVienRepository {
    List<NhanVien> getAll();

    Boolean saveOrUpdate(NhanVien nhanVien);

    Boolean delete(NhanVien nhanVien);

    NhanVien getOne(String id);


    int genMaNhanVien();
}
