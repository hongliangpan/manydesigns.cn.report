import javax.servlet.*

import net.sourceforge.stripes.action.*

import org.apache.commons.lang.StringUtils
import org.apache.shiro.*
import org.hibernate.*
import org.hibernate.criterion.*

import com.manydesigns.elements.messages.*
import com.manydesigns.elements.reflection.*
import com.manydesigns.portofino.*
import com.manydesigns.portofino.buttons.*
import com.manydesigns.portofino.buttons.annotations.*
import com.manydesigns.portofino.dispatcher.*
import com.manydesigns.portofino.model.database.*
import com.manydesigns.portofino.pageactions.*
import com.manydesigns.portofino.pageactions.custom.*
import com.manydesigns.portofino.security.*
import com.manydesigns.portofino.shiro.*

@RequiresPermissions(level = AccessLevel.VIEW)
class MyCustomAction extends CustomAction {

	//Automatically generated on Sun Dec 22 20:04:46 CST 2013 by ManyDesigns Portofino
	//Write your code here

	@DefaultHandler
	public Resolution execute() {
		String fwd = "/echarts/warranty.jsp?width=1000&height=400";
		String region =context.getRequest().getParameter("region");
		if(StringUtils.isNotBlank(region)){
			fwd =fwd+ "&region="+region;
		}
		return forwardTo(fwd);
	}

}