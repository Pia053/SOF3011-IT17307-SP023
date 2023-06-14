package com.example.ass_sof3011_ph19850.repository.impl;

import com.example.ass_sof3011_ph19850.entity.CuaHang;
import com.example.ass_sof3011_ph19850.repository.CuaHangRepository;
import com.example.ass_sof3011_ph19850.util.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import java.util.ArrayList;
import java.util.List;

public class CuaHangRepositoryImpl implements CuaHangRepository {
    @Override
    public List<CuaHang> getAll() {
        List<CuaHang> listsCuaHang = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM CuaHang", CuaHang.class);
            listsCuaHang = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return listsCuaHang;
    }

    @Override
    public CuaHang getOne(String id) {
        CuaHang cuaHang = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("From CuaHang where id = :id");
            query.setParameter("id", id);
            cuaHang = (CuaHang) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return cuaHang;
    }

    @Override
    public Boolean saveOrUpdate(CuaHang cuaHang) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(cuaHang);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
    }

    @Override
    public Boolean delete(CuaHang cuaHang) {

        Transaction tran = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            tran = session.beginTransaction();
            session.delete(cuaHang);
            tran.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
    }

    @Override
    public int genMaCuaHang() {
        String maAC = "";
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "Select MAX(CONVERT(INT,SUBSTRING(ma,5,100))) from CuaHang";
            NativeQuery query = session.createNativeQuery(hql);
            maAC = query.getSingleResult().toString();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        if (maAC == "") {
            maAC = "1";
            int ma = Integer.valueOf(maAC);
            return ma;
        }
        int ma = Integer.valueOf(maAC);
        return ++ma;
    }

    public static void main(String[] args) {
//        new CuaHangRepositoryImpl().saveOrUpdate(CuaHang.builder().id("").ma("CH01").ten("Kim").diaChi("Vinh").thanhPho("Vinh").quocGia("VN").build());
//        new CuaHangRepositoryImpl().saveOrUpdate(CuaHang.builder().id("").ma("CH02").ten("2NH").diaChi("đv").thanhPho("Hà Giang").quocGia("VN").build());
        System.out.println(new CuaHangRepositoryImpl().getAll().size());
    }
}
