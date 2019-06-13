package decimal.dao;

import decimal.entity.Draw;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class DrawDAO extends Draw implements DAOInterface<Draw>{
    private Session currentSession;
    private Transaction currentTransaction;

    public Session openCurrentSession() {
        currentSession = SessionFactroyUtil.getSessionFactory().openSession();
        return currentSession;
    }

    public Session openCurrentSessionWithTransaction() {
        currentSession = SessionFactroyUtil.getSessionFactory().openSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }

    public void closeCurrentSession() {
        currentSession.close();
    }

    public void closeCurrentSessionWithTransaction() {
        currentTransaction.commit();
        currentSession.close();
    }

    public Session getCurrentSession() {
        return currentSession;
    }

    @Override
    public void persist(Draw enity) {
        getCurrentSession().persist(enity);
    }

    @Override
    public void update(Draw enity) {
        getCurrentSession().update(enity);
    }

    @Override
    public Draw findById(Long id) {
        Draw draw = currentSession.get(Draw.class, id);
        return draw;
    }

    @Override
    public void delete(Draw enity) {
        getCurrentSession().delete(enity);
    }

    @Override
    public List find(String enity) {
        List<Draw> list = (List<Draw>) getCurrentSession().
                createQuery("from Draw where lower(*) like " + "'%" + enity.toLowerCase() + "%'").list();
        return list;
    }
}
