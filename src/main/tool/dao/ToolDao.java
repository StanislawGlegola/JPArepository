package tool.dao;

import tool.model.Tool;

import java.util.List;

public interface ToolDao {
    List<Tool> getAll();
    void setAvailability(boolean isAvailable, long id);
}