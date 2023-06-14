package com.example.ass_sof3011_ph19850.service.impl;

import com.example.ass_sof3011_ph19850.entity.GioHang;
import com.example.ass_sof3011_ph19850.repository.GioHangRepository;
import com.example.ass_sof3011_ph19850.repository.impl.GioHangRepositoryImpl;
import com.example.ass_sof3011_ph19850.service.GioHangService;

import java.util.List;

public class GioHangServiceImpl implements GioHangService {

    private GioHangRepository gioHangRepository = new GioHangRepositoryImpl();
    @Override
    public List<GioHang> getAll() {
        return gioHangRepository.getAll();
    }

    @Override
    public String saveGioHang(GioHang gioHang) {
        if(gioHangRepository.saveOrUpdate(gioHang)){
            return "Thêm Gio Hang Thành Công";

        }else{
            return "Thêm Gio Hang Ko Thành Công";
        }
    }

    @Override
    public String updateGioHang(GioHang gioHang) {
        if(gioHangRepository.saveOrUpdate(gioHang)){
            return "Cập nhập Gio Hang Thành Công";

        }else{
            return "TCập nhập Gio Hang Ko Thành Công";
        }
    }

    @Override
    public String genGioHang() {
        int maAC = gioHangRepository.genMaGioHang();
        return "GH00"+maAC;
    }
}
