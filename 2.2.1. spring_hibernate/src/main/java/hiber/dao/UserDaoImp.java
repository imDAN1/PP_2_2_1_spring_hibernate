package hiber.dao;

import hiber.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

   public User userByCar(int series, String model) {
      Session session = sessionFactory.getCurrentSession();
      String hql = "FROM User WHERE car.model = :modelName AND car.series = :seriesNum";
      Query query = session.createQuery(hql);
      query.setParameter("modelName", model);
      query.setParameter("seriesNum", series);
      return (User) query.getSingleResult();
   }

}
