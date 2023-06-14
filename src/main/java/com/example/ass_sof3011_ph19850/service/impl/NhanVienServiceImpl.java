package com.example.ass_sof3011_ph19850.service.impl;


import com.example.ass_sof3011_ph19850.entity.NhanVien;
import com.example.ass_sof3011_ph19850.repository.NhanVienRepository;
import com.example.ass_sof3011_ph19850.repository.impl.NhanVienRepositoryImpl;
import com.example.ass_sof3011_ph19850.service.NhanVienService;
import org.apache.commons.lang3.StringUtils;


import java.util.HashMap;
import java.util.List;


public class NhanVienServiceImpl implements NhanVienService {
    private NhanVienRepository nhanVienRepository = new NhanVienRepositoryImpl();


    @Override
    public List<NhanVien> getAll() {
        return nhanVienRepository.getAll();
    }

    @Override
    public NhanVien getOne(String id) {
        return nhanVienRepository.getOne(id);
    }

    @Override
    public HashMap<String, String> save(NhanVien nhanVien) {
        HashMap<String, String> lists = new HashMap<>();
        if (StringUtils.isEmpty(nhanVien.getTen()) || StringUtils.isBlank(nhanVien.getTen())) {
            lists.put("ERR_TEN", "Không được để trống tên");
        }
        if (StringUtils.isEmpty(nhanVien.getTenDem()) || StringUtils.isBlank(nhanVien.getTenDem())) {
            lists.put("ERR_TENDEM", "Không được để trống tên đệm");
        }
        if (StringUtils.isEmpty(nhanVien.getHo()) || StringUtils.isBlank(nhanVien.getHo())) {
            lists.put("ERR_HO", "Không được để trống Họ");
        }
        if (StringUtils.isEmpty(nhanVien.getGioiTinh()) || StringUtils.isBlank(nhanVien.getGioiTinh())) {
            lists.put("ERR_GIOITINH", "Không được để trống giới tính");
        }
        if (StringUtils.isEmpty(String.valueOf(nhanVien.getNgaySinh()))) {
            lists.put("ERR_NGAYSINH", "Không được để trống ngày sinh");
        }
        if (StringUtils.isEmpty(nhanVien.getDiaChi()) || StringUtils.isBlank(nhanVien.getDiaChi())) {
            lists.put("ERR_DIACHI", "Không được để trống địa chỉ");
        }
        if (StringUtils.isEmpty(nhanVien.getSdt()) || StringUtils.isBlank(nhanVien.getSdt())) {
            lists.put("ERR_SODIENTHOAI", "Không được để trống số điện thoại");
        }
        if (StringUtils.isEmpty(nhanVien.getMatKhau()) || StringUtils.isBlank(nhanVien.getMatKhau())) {
            lists.put("ERR_MATKHAU", "Không được để trống mật khẩu");
        }
        if (StringUtils.isEmpty(String.valueOf(nhanVien.getTrangThai()))) {
            lists.put("ERR_TRANGTHAI", "Không được để trống trạng thái");
        }

        if (lists.isEmpty()) {
            nhanVienRepository.saveOrUpdate(nhanVien);
        }
        return lists;
    }

    @Override
    public HashMap<String, String> update(NhanVien nhanVien) {
        HashMap<String, String> lists = new HashMap<>();
        if (StringUtils.isEmpty(nhanVien.getTen()) || StringUtils.isBlank(nhanVien.getTen())) {
            lists.put("ERR_TEN", "Không được để trống tên");
        }
        if (StringUtils.isEmpty(nhanVien.getTenDem()) || StringUtils.isBlank(nhanVien.getTenDem())) {
            lists.put("ERR_TENDEM", "Không được để trống tên đệm");
        }
        if (StringUtils.isEmpty(nhanVien.getHo()) || StringUtils.isBlank(nhanVien.getHo())) {
            lists.put("ERR_HO", "Không được để trống Họ");
        }
        if (StringUtils.isEmpty(nhanVien.getGioiTinh()) || StringUtils.isBlank(nhanVien.getGioiTinh())) {
            lists.put("ERR_GIOITINH", "Không được để trống giới tính");
        }
        if (StringUtils.isEmpty(String.valueOf(nhanVien.getNgaySinh()))) {
            lists.put("ERR_NGAYSINH", "Không được để trống ngày sinh");
        }
        if (StringUtils.isEmpty(nhanVien.getDiaChi()) || StringUtils.isBlank(nhanVien.getDiaChi())) {
            lists.put("ERR_DIACHI", "Không được để trống địa chỉ");
        }
        if (StringUtils.isEmpty(nhanVien.getSdt()) || StringUtils.isBlank(nhanVien.getSdt())) {
            lists.put("ERR_SODIENTHOAI", "Không được để trống số điện thoại");
        }
        if (StringUtils.isEmpty(nhanVien.getMatKhau()) || StringUtils.isBlank(nhanVien.getMatKhau())) {
            lists.put("ERR_MATKHAU", "Không được để trống mật khẩu");
        }

        if (lists.isEmpty()) {
            nhanVienRepository.saveOrUpdate(nhanVien);
        }
        return lists;
    }

    @Override
    public String delete(NhanVien nhanVien) {
        if (nhanVienRepository.delete(nhanVien)) {
            return "Xóa Thành Công";
        } else {
            return "Xóa Thất Bại";
        }
    }

    @Override
    public String genNhanVien() {
        int maAC = nhanVienRepository.genMaNhanVien();
        return "NV00" + maAC;
    }

    public static void main(String[] args) {
        System.out.println("" + new NhanVienServiceImpl().getOne("0422349E-6E08-4A01-B9B2-0E6C8140E263").toString());
        System.out.println("" + new NhanVienServiceImpl().getAll().size());
    }
}
