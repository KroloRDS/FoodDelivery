package Pizzeria.Utils;

import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class DBManager
{
	public static void init()
	{
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		session.getTransaction().commit();
	}
	
	public static void insert(Object o)
	{
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		session.save(o);
		session.getTransaction().commit();
	}
	
	public static <T> List<T> selectAll(String className)
	{
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		List<T> list = session.createQuery("from " + className).list();
		session.getTransaction().commit();
		return list;
	}
	
	public static <T> T selectByIndex(String className, int index)
	{
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		Query q = session.createQuery("from " + className);
		q.setFirstResult(index);
		q.setMaxResults(1);
		return (T) q.list().get(0);
	}
	
	public static void delete(Object o)
	{
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		session.delete(o);
		session.getTransaction().commit();
	}
	
	public static void update(Object edited, Object old)
	{
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		session.delete(old);
		session.save(edited);
		session.getTransaction().commit();
	}
}
