import javax.servlet.*

import com.manydesigns.elements.messages.*
import com.manydesigns.elements.reflection.*
import com.manydesigns.portofino.*
import com.manydesigns.portofino.buttons.*
import com.manydesigns.portofino.buttons.annotations.*
import com.manydesigns.portofino.dispatcher.*
import com.manydesigns.portofino.model.database.*
import com.manydesigns.portofino.pageactions.*
import com.manydesigns.portofino.security.*
import com.manydesigns.portofino.shiro.*

import net.sourceforge.stripes.action.*
import org.apache.shiro.*
import org.hibernate.*
import org.hibernate.criterion.*

import com.manydesigns.portofino.pageactions.custom.*

@RequiresPermissions(level = AccessLevel.VIEW)
class MyCustomAction extends CustomAction {

    //Automatically generated on Mon Dec 23 15:04:19 CST 2013 by ManyDesigns Portofino
    //Write your code here

    @DefaultHandler
    public Resolution execute() {
        String fwd = "/echarts/map.jsp";
        return forwardTo(fwd);
    }

}