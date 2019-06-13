package decimal.dao;

import decimal.entity.Project;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;


public class ProjectDAO implements DAOInterface<Project> {

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
    public void persist(Project enity) {

        getCurrentSession().persist(enity);
    }

    @Override
    public void update(Project enity) {
        getCurrentSession().update(enity);
    }

    @Override
    public Project findById(Long id) {
        Project project = getCurrentSession().get(Project.class, id);
        return project;
    }

    @Override
    public void delete(Project enity) {
        getCurrentSession().delete(enity);
    }

    @Override
    public List<Project> find(String enity) {

        List<Project> projects = (List<Project>) getCurrentSession().
                createQuery("from Project where lower(projectName) like " + "'%" + enity.toLowerCase() + "%'").list();
        return projects;
    }
}
