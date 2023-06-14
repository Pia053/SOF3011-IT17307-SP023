package com.example.ass_sof3011_ph19850.service.impl;


import com.example.ass_sof3011_ph19850.entity.ChucVu;
import com.example.ass_sof3011_ph19850.repository.ChucVuRepository;
import com.example.ass_sof3011_ph19850.repository.impl.ChucVuRepositoryImpl;
import com.example.ass_sof3011_ph19850.service.ChucVuService;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.List;

public class ChucVuServiceImpl implements ChucVuService {
    private ChucVuRepository chucVuRepository = new ChucVuRepositoryImpl();

    @Override
    public List<ChucVu> getAll() {
        return chucVuRepository.getAll();
    }

    @Override
    public ChucVu getOne(String id) {
        return chucVuRepository.getOne(id);
    }

    @Override
    public HashMap<String, String> save(ChucVu chucVu) {
        HashMap<String, String> lists = new HashMap<>();
        if (StringUtils.isEmpty(chucVu.getTen()) || StringUtils.isBlank(chucVu.getTen())) {
            lists.put("ERR_TEN", "Không được để trống tên");
        }

        if (lists.isEmpty()) {
            chucVuRepository.saveOrUpdate(chucVu);
        }
        return lists;
    }

    @Override
    public HashMap<String, String> update(ChucVu chucVu) {
        HashMap<String, String> lists = new HashMap<>();
        if (StringUtils.isEmpty(chucVu.getTen()) || StringUtils.isBlank(chucVu.getTen())) {
            lists.put("ERR_TEN", "Không được để trống tên");
        }

        if (lists.isEmpty()) {
            chucVuRepository.saveOrUpdate(chucVu);
        }
        return lists;
    }

    @Override
    public String delete(ChucVu chucVu) {
        if (chucVuRepository.delete(chucVu)) {
            return "Xóa Thành Công";
        } else {
            return "Xóa Thất Bại";
        }
    }

    @Override
    public String genChucVu() {
        int maAC = chucVuRepository.genMaChucVu();
        return "CV00" + maAC;
    }
}
