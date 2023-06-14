package com.example.ass_sof3011_ph19850.repository.impl;

import com.example.ass_sof3011_ph19850.entity.SanPham;
import com.example.ass_sof3011_ph19850.repository.SanPhamRepository;
import com.example.ass_sof3011_ph19850.util.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import java.util.ArrayList;
import java.util.List;

public class SanPhamRepositoryImpl implements SanPhamRepository {
    @Override
    public List<SanPham> getAll() {
        List<SanPham> listSanPham = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM SanPham", SanPham.class);
            listSanPham = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return listSanPham;
    }

    @Override
    public SanPham getOne(String id) {
        SanPham sanPham = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("From SanPham where id = :id");
            query.setParameter("id", id);
            sanPham = (SanPham) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return sanPham;
    }

    @Override
    public Boolean saveOrUpdate(SanPham sanPham) {
        Transaction tran = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            tran = session.beginTransaction();
            session.saveOrUpdate(sanPham);
            tran.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
    }

    @Override
    public Boolean delete(SanPham sanPham) {
        Transaction tran = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            tran = session.beginTransaction();
            session.delete(sanPham);
            tran.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
    }

    @Override
    public int genMaSanPham() {
        String maAC = "";
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "Select MAX(CONVERT(INT,SUBSTRING(ma,5,100))) from SanPham";
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
