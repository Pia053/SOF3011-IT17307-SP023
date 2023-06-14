package com.example.ass_sof3011_ph19850.repository.impl;

import com.example.ass_sof3011_ph19850.entity.GioHang;
import com.example.ass_sof3011_ph19850.repository.GioHangRepository;
import com.example.ass_sof3011_ph19850.util.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import java.util.ArrayList;
import java.util.List;

public class GioHangRepositoryImpl implements GioHangRepository {

    @Override
    public List<GioHang> getAll() {
        List<GioHang> listsGioHang = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM GioHang", GioHang.class);
            listsGioHang = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return listsGioHang;
    }

    @Override
    public Boolean saveOrUpdate(GioHang gioHang) {
        Transaction tran = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            tran = session.beginTransaction();
            session.saveOrUpdate(gioHang);
            tran.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
    }

    @Override
    public int genMaGioHang() {
        String maAC = "";
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "Select MAX(CONVERT(INT,SUBSTRING(ma,5,100))) from GioHang ";
            NativeQuery query = session.createNativeQuery(hql);
            maAC = query.getSingleResult().toString();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        if(maAC == ""){
            maAC = "1";
            int ma = Integer.valueOf(maAC);
            return  ma;
        }
        int ma = Integer.valueOf(maAC);
        return  ++ma;
    }


}
