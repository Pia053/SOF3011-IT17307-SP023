package com.example.ass_sof3011_ph19850.service.impl;

import com.example.ass_sof3011_ph19850.entity.CuaHang;
import com.example.ass_sof3011_ph19850.repository.CuaHangRepository;
import com.example.ass_sof3011_ph19850.repository.impl.CuaHangRepositoryImpl;
import com.example.ass_sof3011_ph19850.service.CuaHangService;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.List;

public class CuaHangServiceImpl implements CuaHangService {
    private CuaHangRepository cuaHangRepository = new CuaHangRepositoryImpl();


    @Override
    public List<CuaHang> getAll() {
        return cuaHangRepository.getAll();
    }

    @Override
    public CuaHang getOne(String id) {
        return cuaHangRepository.getOne(id);
    }

    @Override
    public HashMap<String, String> save(CuaHang cuaHang) {
        HashMap<String, String> lists = new HashMap<>();
        if (StringUtils.isEmpty(cuaHang.getTen()) || StringUtils.isBlank(cuaHang.getTen())) {
            lists.put("ERR_TEN", "Không được để trống tên");
        }

        if (StringUtils.isEmpty(cuaHang.getDiaChi()) || StringUtils.isBlank(cuaHang.getDiaChi())) {
            lists.put("ERR_DIACHI", "Không được để trống địa chỉ");
        }

        if (StringUtils.isEmpty(cuaHang.getThanhPho()) || StringUtils.isBlank(cuaHang.getThanhPho())) {
            lists.put("ERR_THANHPHO", "Không được để trống thành phố");
        }

        if (StringUtils.isEmpty(cuaHang.getQuocGia()) || StringUtils.isBlank(cuaHang.getQuocGia())) {
            lists.put("ERR_QUOCGIA", "Không được để trống quốc gia");
        }

        if (lists.isEmpty()) {
            cuaHangRepository.saveOrUpdate(cuaHang);
        }
        return lists;
    }

    @Override
    public HashMap<String, String> update(CuaHang cuaHang) {
        HashMap<String, String> lists = new HashMap<>();
        if (StringUtils.isEmpty(cuaHang.getTen()) || StringUtils.isBlank(cuaHang.getTen())) {
            lists.put("ERR_TEN", "Không được để trống tên");
        }

        if (StringUtils.isEmpty(cuaHang.getDiaChi()) || StringUtils.isBlank(cuaHang.getDiaChi())) {
            lists.put("ERR_DIACHI", "Không được để trống địa chỉ");
        }

        if (StringUtils.isEmpty(cuaHang.getThanhPho()) || StringUtils.isBlank(cuaHang.getThanhPho())) {
            lists.put("ERR_THANHPHO", "Không được để trống thành phố");
        }

        if (StringUtils.isEmpty(cuaHang.getQuocGia()) || StringUtils.isBlank(cuaHang.getQuocGia())) {
            lists.put("ERR_QUOCGIA", "Không được để trống quốc gia");
        }

        if (lists.isEmpty()) {
            cuaHangRepository.saveOrUpdate(cuaHang);
        }
        return lists;
    }

    @Override
    public String delete(CuaHang cuaHang) {
        if (cuaHangRepository.delete(cuaHang)) {
            return "Xóa Thành Công";
        } else {
            return "Xóa Thất Bại";
        }
    }

    @Override
    public String genCuaHang() {
        int maAC = cuaHangRepository.genMaCuaHang();
        return "CH000" + maAC;
    }
}
