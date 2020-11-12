// ListClass
package mockitojava.stabbing.logic;

import java.util.ArrayList;
import java.util.List;

public class ListClass {
    public ListService listService;

    public ListClass(ListService listService)
    {
        this.listService=listService;
    }

    public List<String> getListMethod(String match)
    {
        List<String> retrievedList1=listService.getList(match);
        List<String> retrievedList= new ArrayList<String>();
        for(String list : retrievedList1)
        {
            if(list.contains("Spring"))
            {
                retrievedList.add(list);
            }
        }
        return retrievedList;
    }
}


