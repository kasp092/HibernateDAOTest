package decimal.service;

import decimal.dao.ProjectDAO;
import decimal.entity.Project;

import java.util.List;

public class ProjectService {
    private static ProjectDAO projectDAO;

    public ProjectService() {
        projectDAO = new ProjectDAO();
    }

    public void persist(Project enity) {
        projectDAO.openCurrentSessionWithTransaction();
        projectDAO.persist(enity);
        projectDAO.closeCurrentSessionWithTransaction();

    }

    public void update(Project enity) {
        projectDAO.openCurrentSessionWithTransaction();
        projectDAO.update(enity);
        projectDAO.closeCurrentSessionWithTransaction();
    }

    public Project findById(Long id) {
        projectDAO.openCurrentSession();
        Project project = projectDAO.findById(id);
        projectDAO.closeCurrentSession();
        return project;
    }

    public void delete(Long id) {
        projectDAO.openCurrentSessionWithTransaction();
        Project project = projectDAO.findById(id);
        projectDAO.delete(project);
        projectDAO.closeCurrentSessionWithTransaction();
    }

    public List<Project> findByName(String enity) {
        projectDAO.openCurrentSession();
        List<Project> projects = projectDAO.find(enity);
        projectDAO.closeCurrentSession();
        return projects;
    }

    public ProjectDAO projectDAO() {
        return projectDAO;
    }
}
