package com.example.ass_sof3011_ph19850.service.impl;


import com.example.ass_sof3011_ph19850.entity.NhaSanXuat;
import com.example.ass_sof3011_ph19850.repository.NhaSanXuatRepository;
import com.example.ass_sof3011_ph19850.repository.impl.NhaSanXuatRepositoryImpl;
import com.example.ass_sof3011_ph19850.service.NhaSanXuatService;
import org.apache.commons.lang3.StringUtils;


import java.util.HashMap;
import java.util.List;

public class NhaSanXuatServiceImpl implements NhaSanXuatService {
    private NhaSanXuatRepository nhaSanXuatRepository = new NhaSanXuatRepositoryImpl();


    @Override
    public List<NhaSanXuat> getAll() {
        return nhaSanXuatRepository.getAll();
    }

    @Override
    public NhaSanXuat getOne(String id) {
        return nhaSanXuatRepository.getOne(id);
    }

    @Override
    public HashMap<String, String> save(NhaSanXuat nhaSanXuat) {
        HashMap<String, String> hashNSX = new HashMap<>();
        if (StringUtils.isEmpty(nhaSanXuat.getTen()) || StringUtils.isBlank(nhaSanXuat.getTen())) {
            hashNSX.put("TEN_ISEMPTY", "Tên NSX Không Được Để Trống");
        }

        if (hashNSX.isEmpty()) {
            nhaSanXuatRepository.saveOrUpdate(nhaSanXuat);
        }
        return hashNSX;
    }

    @Override
    public HashMap<String, String> update(NhaSanXuat nhaSanXuat) {
        HashMap<String, String> hashNSX = new HashMap<>();
        if (StringUtils.isEmpty(nhaSanXuat.getTen()) || StringUtils.isBlank(nhaSanXuat.getTen())) {
            hashNSX.put("TEN_ISEMPTY", "Tên NSX Không Được Để Trống");
        }

        if (hashNSX.isEmpty()) {
            nhaSanXuatRepository.saveOrUpdate(nhaSanXuat);
        }
        return hashNSX;
    }

    @Override
    public String delete(NhaSanXuat nhaSanXuat) {
        if (nhaSanXuatRepository.delete(nhaSanXuat)) {
            return "Xóa Thành Công";
        } else {
            return "Xóa Thất Bại";
        }
    }

    @Override
    public String genNSX() {
        int maAC = nhaSanXuatRepository.genMaNSX();
        return "NSX00" + maAC;
    }
}
