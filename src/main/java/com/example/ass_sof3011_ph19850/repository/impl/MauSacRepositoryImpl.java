package com.example.ass_sof3011_ph19850.repository.impl;


import com.example.ass_sof3011_ph19850.entity.MauSac;
import com.example.ass_sof3011_ph19850.repository.MauSacRepository;
import com.example.ass_sof3011_ph19850.util.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import java.util.ArrayList;
import java.util.List;

public class MauSacRepositoryImpl implements MauSacRepository {
    @Override
    public List<MauSac> getAll() {
        List<MauSac> listsMauSac = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "FROM MauSac";
            Query query = session.createQuery(hql);
            listsMauSac = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return listsMauSac;
    }

    @Override
    public MauSac getOne(String id) {
        MauSac mauSac = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("From MauSac where id = :id");
            query.setParameter("id", id);
            mauSac = (MauSac) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return mauSac;
    }

    @Override
    public Boolean saveOrUpdate(MauSac mauSac) {
        Transaction tran = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            tran = session.beginTransaction();
            session.saveOrUpdate(mauSac);
            tran.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
    }

    @Override
    public Boolean delete(MauSac mauSac) {
        Transaction tran = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            tran = session.beginTransaction();
            session.delete(mauSac);
            tran.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
    }

    @Override
    public int genMaMauSac() {
        String maAC = "";
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "Select MAX(CONVERT(INT,SUBSTRING(ma,5,100))) from MauSac ";
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
