package com.example.ass_sof3011_ph19850.service.impl;

import com.example.ass_sof3011_ph19850.entity.KhachHang;
import com.example.ass_sof3011_ph19850.repository.KhachHangRepository;
import com.example.ass_sof3011_ph19850.repository.impl.KhachHangRepositoryImpl;
import com.example.ass_sof3011_ph19850.service.KhachHangService;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.List;

public class KhachHangServiceImpl implements KhachHangService {
    private KhachHangRepository khachHangRepository = new KhachHangRepositoryImpl();

    @Override
    public List<KhachHang> getAll() {
        return khachHangRepository.getAll();
    }

    @Override
    public KhachHang getOne(String id) {
        return khachHangRepository.getOne(id);
    }

    @Override
    public KhachHang getOneByMaAndMatKhau(String ma, String matKhau) {
        return khachHangRepository.getOneByMaAndMatKhau(ma, matKhau);
    }


    @Override
    public HashMap<String, String> save(KhachHang khachHang) {
        HashMap<String, String> lists = new HashMap<>();
        if (StringUtils.isEmpty(khachHang.getTenDem()) || StringUtils.isBlank(khachHang.getTenDem())) {
            lists.put("ERR_TENDEM", "Không được để trống tên đệm");
        }
        if (StringUtils.isEmpty(khachHang.getHo()) || StringUtils.isBlank(khachHang.getHo())) {
            lists.put("ERR_HO", "Không được để trống Họ");
        }
        if (StringUtils.isEmpty(khachHang.getTen()) || StringUtils.isBlank(khachHang.getTen())) {
            lists.put("ERR_TEN", "Không được để trống tên");
        }
        if (StringUtils.isEmpty(String.valueOf(khachHang.getNgaySinh()))) {
            lists.put("ERR_NGAYSINH", "Không được để trống ngày Sinh");
        }
        if (StringUtils.isEmpty(khachHang.getDiaChi()) || StringUtils.isBlank(khachHang.getDiaChi())) {
            lists.put("ERR_DIACHI", "Không được để trống địa chỉ");
        }
        if (StringUtils.isEmpty(khachHang.getSdt()) || StringUtils.isBlank(khachHang.getSdt())) {
            lists.put("ERR_SODIENTHOAI", "Không được để trống số điện thoại");
        }
        if (StringUtils.isEmpty(khachHang.getMatKhau()) || StringUtils.isBlank(khachHang.getMatKhau())) {
            lists.put("ERR_MATKHAU", "Không được để trống mật khẩu");
        }
        if (StringUtils.isEmpty(khachHang.getQuocGia()) || StringUtils.isBlank(khachHang.getQuocGia())) {
            lists.put("ERR_QUOCGIA", "Không được để trống quốc gia");
        }
        if (StringUtils.isEmpty(khachHang.getThanhPho()) || StringUtils.isBlank(khachHang.getThanhPho())) {
            lists.put("ERR_QUOCGIA", "Không được để trống thành phố");
        }

        if (StringUtils.isEmpty(khachHang.getSdt()) || StringUtils.isBlank(khachHang.getSdt())) {
            lists.put("ERR_SODIENTHOAI", "Không được để trống số điện thoại");
        }

        if (lists.isEmpty()) {
            khachHangRepository.saveOrUpdate(khachHang);
        }
        return lists;
    }

    @Override
    public HashMap<String, String> update(KhachHang khachHang) {
        HashMap<String, String> lists = new HashMap<>();
        if (StringUtils.isEmpty(khachHang.getTenDem()) || StringUtils.isBlank(khachHang.getTenDem())) {
            lists.put("ERR_TENDEM", "Không được để trống tên đệm");
        }
        if (StringUtils.isEmpty(khachHang.getHo()) || StringUtils.isBlank(khachHang.getHo())) {
            lists.put("ERR_HO", "Không được để trống Họ");
        }
        if (StringUtils.isEmpty(khachHang.getTen()) || StringUtils.isBlank(khachHang.getTen())) {
            lists.put("ERR_TEN", "Không được để trống tên");
        }
        if (StringUtils.isEmpty(String.valueOf(khachHang.getNgaySinh()))) {
            lists.put("ERR_NGAYSINH", "Không được để trống ngày Sinh");
        }
        if (StringUtils.isEmpty(khachHang.getDiaChi()) || StringUtils.isBlank(khachHang.getDiaChi())) {
            lists.put("ERR_DIACHI", "Không được để trống địa chỉ");
        }
        if (StringUtils.isEmpty(khachHang.getSdt()) || StringUtils.isBlank(khachHang.getSdt())) {
            lists.put("ERR_SODIENTHOAI", "Không được để trống số điện thoại");
        }
        if (StringUtils.isEmpty(khachHang.getMatKhau()) || StringUtils.isBlank(khachHang.getMatKhau())) {
            lists.put("ERR_MATKHAU", "Không được để trống mật khẩu");
        }
        if (StringUtils.isEmpty(khachHang.getQuocGia()) || StringUtils.isBlank(khachHang.getQuocGia())) {
            lists.put("ERR_QUOCGIA", "Không được để trống quốc gia");
        }
        if (StringUtils.isEmpty(khachHang.getThanhPho()) || StringUtils.isBlank(khachHang.getThanhPho())) {
            lists.put("ERR_QUOCGIA", "Không được để trống thành phố");
        }

        if (StringUtils.isEmpty(khachHang.getSdt()) || StringUtils.isBlank(khachHang.getSdt())) {
            lists.put("ERR_SODIENTHOAI", "Không được để trống số điện thoại");
        }

        if (lists.isEmpty()) {
            khachHangRepository.saveOrUpdate(khachHang);
        }
        return lists;
    }

    @Override
    public String delete(KhachHang khachHang) {
        if (khachHangRepository.delete(khachHang)) {
            return "Xóa Thành Công";
        } else {
            return "Xóa Không Thành Công";
        }
    }

    @Override
    public String genKhachHang() {
        int maAC = khachHangRepository.genMaKhachHang();
        return "KH00" + maAC;
    }
}
