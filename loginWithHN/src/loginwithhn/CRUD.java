/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginwithhn;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

public class CRUD {

    public void insert(String userName,String password,String FName,String LName,String phone,String age ) {
        Session se = NewHibernateUtil.getSessionFactory().openSession();

        try {
            se.beginTransaction();
            employees e = new employees();
            e.setUserNameDB(userName);
            e.setPasswordDB(password);
            DataDetails d = new DataDetails();
            d.setFirstName(FName);
            d.setLastName(LName);
            d.setAge(age);
            d.setPhone(phone);
            e.setD(d);

            se.save(e);
            se.getTransaction().commit();

        } catch (HibernateException ex) {
            se.getTransaction().rollback();
        } finally {
            se.close();
        }

    }

    public List<employees> select() {
        Session se = NewHibernateUtil.getSessionFactory().openSession();
        List<employees> list = null;
        try {
            se.beginTransaction();
            Query q = se.createQuery("from employees");
            list = q.list();

        } catch (HibernateException ex) {
            se.getTransaction().rollback();
        } finally {
            se.close();
        }
        return list;

    }

}
