package com.example.ass_sof3011_ph19850.repository.impl;


import com.example.ass_sof3011_ph19850.entity.NhaSanXuat;
import com.example.ass_sof3011_ph19850.repository.NhaSanXuatRepository;
import com.example.ass_sof3011_ph19850.util.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import java.util.ArrayList;
import java.util.List;

public class NhaSanXuatRepositoryImpl implements NhaSanXuatRepository {
    @Override
    public List<NhaSanXuat> getAll() {
        List<NhaSanXuat> listNhaSanXuats = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "FROM NhaSanXuat";
            Query query = session.createQuery(hql);
            listNhaSanXuats = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return listNhaSanXuats;
    }

    @Override
    public NhaSanXuat getOne(String id) {
        NhaSanXuat nhaSanXuat = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("From NhaSanXuat where id = :id");
            query.setParameter("id", id);
            nhaSanXuat = (NhaSanXuat) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return nhaSanXuat;
    }

    @Override
    public Boolean saveOrUpdate(NhaSanXuat nhaSanXuat) {
        Transaction tran = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            tran = session.beginTransaction();
            session.saveOrUpdate(nhaSanXuat);
            tran.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
    }

    @Override
    public Boolean delete(NhaSanXuat nhaSanXuat) {
        Transaction tran = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            tran = session.beginTransaction();
            session.delete(nhaSanXuat);
            tran.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
    }

    @Override
    public int genMaNSX() {
        String maAC = "";
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "Select MAX(CONVERT(INT,SUBSTRING(ma,5,100))) from NSX ";
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
