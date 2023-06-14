package com.example.ass_sof3011_ph19850.repository.impl;


import com.example.ass_sof3011_ph19850.entity.KhachHang;
import com.example.ass_sof3011_ph19850.repository.KhachHangRepository;
import com.example.ass_sof3011_ph19850.util.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import java.util.ArrayList;
import java.util.List;

public class KhachHangRepositoryImpl implements KhachHangRepository {

    @Override
    public List<KhachHang> getAll() {
        List<KhachHang> listsKhachHang = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM KhachHang", KhachHang.class);
            listsKhachHang = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return listsKhachHang;
    }

    @Override
    public KhachHang getOne(String id) {
        KhachHang khacHang = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM KhachHang Where id =:id", KhachHang.class).setParameter("id", id);
            khacHang = (KhachHang) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return khacHang;
    }

    @Override
    public Boolean saveOrUpdate(KhachHang khachHang) {
        Transaction tran = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            tran = session.beginTransaction();
            session.saveOrUpdate(khachHang);
            tran.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
    }

    @Override
    public Boolean delete(KhachHang khachHang) {
        Transaction tran = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            tran = session.beginTransaction();
            session.delete(khachHang);
            tran.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
    }

    @Override
    public KhachHang getOneByMaAndMatKhau(String ma, String matKhau) {
        KhachHang khachHang = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("From KhachHang where ma = :ma And matKhau =:matKhau");
            query.setParameter("ma", ma);
            query.setParameter("matKhau", matKhau);
            khachHang = (KhachHang) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return khachHang;
    }

    @Override
    public int genMaKhachHang() {
        String maAC = "";
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "Select MAX(CONVERT(INT,SUBSTRING(ma,5,100))) from KhachHang ";
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
}
