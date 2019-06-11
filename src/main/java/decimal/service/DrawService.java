package decimal.service;

import decimal.dao.DrawDAO;
import decimal.entity.Draw;

import java.util.List;

public class DrawService {

    private static DrawDAO drawDAO;

    public DrawService() {
        drawDAO = new DrawDAO();
    }

    public void persist(Draw enity) {
        drawDAO.openCurrentSessionWithTransaction();
        drawDAO.persist(enity);
        drawDAO.closeCurrentSessionWithTransaction();
    }

    public void update(Draw enity) {
        drawDAO.openCurrentSessionWithTransaction();
        drawDAO.update(enity);
        drawDAO.closeCurrentSessionWithTransaction();
    }

    public Draw findById(Long id) {
        drawDAO.openCurrentSession();
        Draw draw = drawDAO.findById(id);
        drawDAO.closeCurrentSession();
        return draw;
    }

    public void delete(Long id) {
        drawDAO.openCurrentSessionWithTransaction();
        Draw draw = drawDAO.findById(id);
        drawDAO.delete(draw);
        drawDAO.closeCurrentSessionWithTransaction();
    }

    public List<Draw> findByName(String enity) {
        drawDAO.openCurrentSession();
        List<Draw> projects = drawDAO.findByString(enity);
        drawDAO.closeCurrentSession();
        return projects;
    }

    public DrawDAO projectDAO() {
        return drawDAO;
    }
}
