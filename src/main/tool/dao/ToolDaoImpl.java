package tool.dao;

import tool.model.Tool;
import tool.model.ToolType;

import java.util.Arrays;
import java.util.List;

public class ToolDaoImpl implements ToolDao {

    private List<Tool> tools;

    public ToolDaoImpl() {
        Tool tool1 = new Tool(1, "Sonic screwdriver", ToolType.SCREWDRIVER, true);
        Tool tool2 = new Tool(2, "Srubokret od kamaza", ToolType.SCREWDRIVER, false);
        Tool tool3 = new Tool(3, "Stara pila", ToolType.SAW, true);
        Tool tool4 = new Tool(4, "Czerwony mlotek", ToolType.HAMMER, true);

        tools = Arrays.asList(tool1, tool2, tool3, tool4);
    }

    @Override
    public List<Tool> getAll() {

        return tools;
    }

    @Override
    public void setAvailability(boolean isAvailable, long id) {

//        INNE MOZLIWOSCI:
//        for (int i = 0; i < tools.size(); i++) {
//            if (tools.get(i).getId() == id) {
//                tools.get(i).setAvailable(isAvailable);
//                return;
//            }
//        }
//
//        for(Tool tool: tools) {
//            if (tool.getId() == id) {
//                tool.setAvailable(isAvailable);
//                return;
//            }
//        }

        tools.stream()
                .filter(tool -> tool.getId() == id)
                .findAny()
                .ifPresent(tool -> tool.setAvailable(isAvailable));
    }
}