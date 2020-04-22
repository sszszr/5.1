package com.xiaowang.lianxi;



import com.ceshi.StudyEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OperaterStudy {
    public static void main(String[]args){

        Configuration configuration =new Configuration() .configure();
        SessionFactory sessionFactory=configuration.buildSessionFactory();
        Session session =sessionFactory.openSession();
        Transaction transaction=null;
        try{
            transaction=session.beginTransaction();
            StudyEntity studyEntity=new StudyEntity();
            studyEntity.setName("xiaolu");
            studyEntity.setLesson("1336");

            session.save(studyEntity);

            transaction.commit();
        }catch (Exception e){
            if(transaction!=null)
                transaction.rollback();
        }
    }
}