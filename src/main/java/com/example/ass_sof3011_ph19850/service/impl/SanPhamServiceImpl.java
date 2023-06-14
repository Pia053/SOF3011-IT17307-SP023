package com.example.ass_sof3011_ph19850.service.impl;


import com.example.ass_sof3011_ph19850.entity.SanPham;
import com.example.ass_sof3011_ph19850.repository.SanPhamRepository;
import com.example.ass_sof3011_ph19850.repository.impl.SanPhamRepositoryImpl;
import com.example.ass_sof3011_ph19850.service.SanPhamService;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.List;

public class SanPhamServiceImpl implements SanPhamService {
    SanPhamRepository sanPhamRepository = new SanPhamRepositoryImpl();


    @Override
    public List<SanPham> getAll() {
        return sanPhamRepository.getAll();
    }

    @Override
    public SanPham getOne(String id) {
        return sanPhamRepository.getOne(id);
    }

    @Override
    public HashMap<String, String> save(SanPham sanPham) {
        HashMap<String, String> lists = new HashMap<>();
        if (StringUtils.isEmpty(sanPham.getTen()) || StringUtils.isBlank(sanPham.getTen())) {
            lists.put("TEN_ISEMTY", "Không được để trống tên Sản Phẩm");
        }
        if (lists.isEmpty()) {
            sanPhamRepository.saveOrUpdate(sanPham);
        }
        return lists;
    }

    @Override
    public HashMap<String, String> update(SanPham sanPham) {
        HashMap<String, String> lists = new HashMap<>();
        if (StringUtils.isEmpty(sanPham.getTen()) || StringUtils.isBlank(sanPham.getTen())) {
            lists.put("TEN_ISEMTY", "Không được để trống tên Sản Phẩm");
        }
        if (lists.isEmpty()) {
            sanPhamRepository.saveOrUpdate(sanPham);
        }
        return lists;
    }

    @Override
    public String delete(SanPham sanPham) {
        if (sanPhamRepository.delete(sanPham)) {
            return "Xóa Thành Công";
        } else {
            return "Xóa Thất Bại";
        }
    }

    @Override
    public String genSanPham() {
        int maAC = sanPhamRepository.genMaSanPham();
        return "SP000" + maAC;
    }
}
