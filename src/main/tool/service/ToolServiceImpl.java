package tool.service;

import tool.dao.ToolDao;
import tool.dao.ToolDaoImpl;
import tool.model.Tool;

import java.util.List;

public class ToolServiceImpl implements ToolService {

    private final ToolDao toolDao = new ToolDaoImpl();

    @Override
    public List<Tool> getAllTools() {
        return toolDao.getAll();
    }

    @Override
    public void setAvailability(boolean isAvailable, long id) {
        toolDao.setAvailability(isAvailable, id);
    }
}