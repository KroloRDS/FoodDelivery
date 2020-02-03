package food_delivery.utils;

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
	
	public static void delete(Object o)
	{
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		session.delete(o);
		session.getTransaction().commit();
	}
	
	public static void update(Object o)
	{
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		session.update(o);
		session.getTransaction().commit();
	}
	
	//Selects all records of given entity
	public static <T> List<T> selectAll(Class<T> entity)
	{
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		Query<T> query = session.createQuery("FROM " + entity.getName(), entity);
		session.getTransaction().commit();
		return query.list();
	}
	
	//Selects all records of given entity where given column matches given parameter
	public static <T> List<T> selectAllWhere(Class<T> entity, String colName, String param)
	{
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		Query<T> query = session.createQuery("FROM " + entity.getName() + " WHERE " + colName + " = :param", entity);
		query.setParameter("param", param);
		session.getTransaction().commit();
		return query.list();
	}
	
	//Selects all records of given entity where two given columns match two given parameters
	public static <T> List<T> selectAllWhere(Class<T> entity, String coL1, String col2, String param1, String param2)
	{
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		String HQL = "FROM " + entity.getName() + " WHERE " + coL1 + " = :param1 AND " + col2 + "= :param2";
		Query<T> q = session.createQuery(HQL, entity);
		q.setParameter("param1", param1);
		q.setParameter("param2", param2);
		session.getTransaction().commit();
		return q.list();
	}
}
