package com.example.ass_sof3011_ph19850.service.impl;

import com.example.ass_sof3011_ph19850.entity.GioHangChiTiet;
import com.example.ass_sof3011_ph19850.repository.GioHangChiTietRepository;
import com.example.ass_sof3011_ph19850.repository.impl.GioHangChiTietRepositoryImpl;
import com.example.ass_sof3011_ph19850.service.GioHangChiTietService;

import java.util.List;

public class GioHangChiTietServiceImpl implements GioHangChiTietService {
    private GioHangChiTietRepository gioHangChiTietRepository = new GioHangChiTietRepositoryImpl();
    @Override
    public List<GioHangChiTiet> getAll() {
        return gioHangChiTietRepository.getAll();
    }

    @Override
    public GioHangChiTiet getOne(String id) {
        return gioHangChiTietRepository.getOne(id);
    }

    @Override
    public String saveGioHangChiTiet(GioHangChiTiet gioHangChiTiet) {
        if(gioHangChiTietRepository.saveOrUpdate(gioHangChiTiet)){
            return "Thêm Không Thành Công";
        }else{
            return "Thêm Thành Công";
        }
    }

    @Override
    public String updateGioHangChiTiet(GioHangChiTiet gioHangChiTiet) {
        if(gioHangChiTietRepository.saveOrUpdate(gioHangChiTiet)){
            return "Cập Nhập Không Thành Công";
        }else{
            return "Cập Nhập Thành Công";
        }
    }
}
