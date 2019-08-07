package tool.dao;

import tool.model.Tool;
import tool.model.ToolType;
import java.util.Arrays;
import java.util.List;

public class ToolDaoImpl implements ToolDao {
    @Override
    public List<Tool> getAll() {
        Tool tool1 = new Tool(1, "Hammer", ToolType.HAMMER, true);
        Tool tool2 = new Tool(2, "Screwdriver", ToolType.SCREWDRIVER, false);
        Tool tool3 = new Tool(3, "Saw", ToolType.SAW, false);
        Tool tool4 = new Tool(4, "Wrench", ToolType.WRENCH, true);

        return Arrays.asList(tool1, tool2, tool3, tool4);
    }
}
