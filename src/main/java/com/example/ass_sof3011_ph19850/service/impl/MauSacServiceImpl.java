package com.example.ass_sof3011_ph19850.service.impl;

import com.example.ass_sof3011_ph19850.entity.MauSac;
import com.example.ass_sof3011_ph19850.repository.MauSacRepository;
import com.example.ass_sof3011_ph19850.repository.impl.MauSacRepositoryImpl;
import com.example.ass_sof3011_ph19850.service.MauSacService;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.List;

public class MauSacServiceImpl implements MauSacService {
    private MauSacRepository mauSacRepository = new MauSacRepositoryImpl();

    @Override
    public List<MauSac> getAll() {
        return mauSacRepository.getAll();
    }

    @Override
    public MauSac getOne(String id) {
        return mauSacRepository.getOne(id);
    }

    @Override
    public HashMap<String, String> save(MauSac mauSac) {
        HashMap<String, String> lists = new HashMap<>();
        if (StringUtils.isEmpty(mauSac.getTen()) || StringUtils.isBlank(mauSac.getTen())) {
            lists.put("ERR_TEN", "Tên màu sắc không được để trống");
        }

        if (lists.isEmpty()) {
            mauSacRepository.saveOrUpdate(mauSac);
        }
        return lists;
    }

    @Override
    public HashMap<String, String> update(MauSac mauSac) {
        HashMap<String, String> lists = new HashMap<>();
        if (StringUtils.isEmpty(mauSac.getTen()) || StringUtils.isBlank(mauSac.getTen())) {
            lists.put("ERR_TEN", "Tên màu sắc không được để trống");
        }
        if (lists.isEmpty()) {
            mauSacRepository.saveOrUpdate(mauSac);
        }
        return lists;
    }

    @Override
    public String delete(MauSac mauSac) {
        if (mauSacRepository.delete(mauSac)) {
            return "Xóa thành công";
        } else {
            return "Xóa không thành công";
        }
    }

    @Override
    public String genMauSac() {
        int maAC = mauSacRepository.genMaMauSac();
        return "MS00" + maAC;
    }

}
