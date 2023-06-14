package com.example.ass_sof3011_ph19850.service.impl;

import com.example.ass_sof3011_ph19850.entity.ChiTietSanPham;
import com.example.ass_sof3011_ph19850.repository.ChiTietSanPhamRepository;
import com.example.ass_sof3011_ph19850.repository.impl.ChiTietSanPhamRepositoryImpl;
import com.example.ass_sof3011_ph19850.service.ChiTietSanPhamService;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.List;

public class ChiTietSanPhamServiceImpl implements ChiTietSanPhamService {
    private ChiTietSanPhamRepository chiTietSanPhamRepository = new ChiTietSanPhamRepositoryImpl();

    @Override
    public List<ChiTietSanPham> getAll() {
        return chiTietSanPhamRepository.getAll();
    }

    @Override
    public List<ChiTietSanPham> getByIdNSX(String idNSX) {
        return chiTietSanPhamRepository.getByIdNSX(idNSX);
    }

    @Override
    public ChiTietSanPham getOne(String id) {
        return chiTietSanPhamRepository.getOne(id);
    }

    @Override
    public HashMap<String, String> save(ChiTietSanPham chiTietSanPham) {
        HashMap<String, String> lists = new HashMap<>();
        if (StringUtils.isEmpty(chiTietSanPham.getAnh())) {
            lists.put("ERR_ANH", "Không được để trống ảnh");
        }

        if (chiTietSanPham.getGiaBan().intValue() < chiTietSanPham.getGiaNhap().intValue()) {
            lists.put("ERR_GIABAN", "Giá bán lớn hơn giá nhập");
        }

        if (chiTietSanPham.getGiaNhap().intValue() <= 100000) {
            lists.put("ERR_GIANHAP", "Giá nhập phải lớn hơn 100000 VND");
        }
        if (chiTietSanPham.getGiaBan().intValue() <= 150000) {
            lists.put("ERR_GIABAN", "Giá bán phải lớn hơn 150000 VND");
        }

        if (StringUtils.isEmpty(chiTietSanPham.getMoTa()) || StringUtils.isBlank(chiTietSanPham.getMoTa())) {
            lists.put("ERR_MOTA", "Không được để trống mô tả");
        }
        if (lists.isEmpty()) {
            chiTietSanPhamRepository.saveOrUpdate(chiTietSanPham);
        }
        return lists;
    }

    @Override
    public HashMap<String, String> update(ChiTietSanPham chiTietSanPham) {
        HashMap<String, String> lists = new HashMap<>();
        if (StringUtils.isEmpty(chiTietSanPham.getAnh())) {
            lists.put("ERR_ANH", "Không được để trống ảnh");
        }

        if (chiTietSanPham.getGiaBan().intValue() < chiTietSanPham.getGiaNhap().intValue()) {
            lists.put("ERR_GIABAN", "Giá bán lớn hơn giá nhập");
        }

        if (chiTietSanPham.getGiaBan().intValue() <= 150000) {
            lists.put("ERR_GIANHAP", "Giá bán phải lớn hơn 150000 VND");
        }

        if (StringUtils.isEmpty(chiTietSanPham.getMoTa()) || StringUtils.isBlank(chiTietSanPham.getMoTa())) {
            lists.put("ERR_MOTA", "Không được để trống mô tả");
        }

        if (lists.isEmpty()) {
            chiTietSanPhamRepository.saveOrUpdate(chiTietSanPham);
        }
        return lists;
    }

    @Override
    public String delete(ChiTietSanPham chiTietSanPham) {
        if (chiTietSanPhamRepository.delete(chiTietSanPham)) {
            return "Xóa Thành Công";
        } else {
            return "Xóa Không Thành Công";
        }
    }

    @Override
    public String genChiTietSP() {
        int maAC = chiTietSanPhamRepository.genMaChiTietSP();
        return "CTSP00" + maAC;
    }

    public static void main(String[] args) {
        String strValue = null; // your integer value as string
        Integer value = null;

    }
}
