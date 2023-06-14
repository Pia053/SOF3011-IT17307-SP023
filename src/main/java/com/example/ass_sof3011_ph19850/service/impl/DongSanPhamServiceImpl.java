package com.example.ass_sof3011_ph19850.service.impl;


import com.example.ass_sof3011_ph19850.entity.DongSanPham;
import com.example.ass_sof3011_ph19850.repository.DongSanPhamRepository;
import com.example.ass_sof3011_ph19850.repository.impl.DongSanPhamRepositoryImpl;
import com.example.ass_sof3011_ph19850.service.DongSanPhamService;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.List;

public class DongSanPhamServiceImpl implements DongSanPhamService {
    private DongSanPhamRepository dongSPRepository = new DongSanPhamRepositoryImpl();

    @Override
    public List<DongSanPham> getAll() {
        return dongSPRepository.getAll();
    }

    @Override
    public DongSanPham getOne(String id) {
        return dongSPRepository.getOne(id);
    }

    @Override
    public HashMap<String, String> save(DongSanPham dongSanPham) {
        HashMap<String, String> lists = new HashMap<>();
        if (StringUtils.isEmpty(dongSanPham.getTen()) || StringUtils.isBlank(dongSanPham.getTen())) {
            lists.put("ERR_TENDONGSP", "Tên dòng sản phẩm không hợp lệ");
        }

        if (lists.isEmpty()) {
            dongSPRepository.saveOrUpdate(dongSanPham);
        }
        return lists;
    }

    @Override
    public HashMap<String, String> update(DongSanPham dongSanPham) {
        HashMap<String, String> lists = new HashMap<>();
        if (StringUtils.isEmpty(dongSanPham.getTen()) || StringUtils.isBlank(dongSanPham.getTen())) {
            lists.put("ERR_TENDONGSP", "Không được để trống dòng sản phẩm");
        }

        if (lists.isEmpty()) {
            dongSPRepository.saveOrUpdate(dongSanPham);
        }
        return lists;
    }

    @Override
    public String delete(DongSanPham dongSanPham) {
        if (dongSPRepository.delete(dongSanPham)) {
            return "Cập Nhập Thành Công";
        } else {
            return "Cập Nhập Không Thành Công";
        }
    }

    @Override
    public String genDongSP() {
        int maAC = dongSPRepository.genMaDongSP();
        return "DSP00" + maAC;
    }


}
