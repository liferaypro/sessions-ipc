package com.yowshu.ipc.sessions.portlet;

import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import org.osgi.service.component.annotations.Component;

/**
 * @author fanqi
 */
@Component(
	immediate = true,
	property = {
        "com.liferay.portlet.display-category=category.yowshu",
        "com.liferay.portlet.instanceable=true",
        "javax.portlet.display-name=Sessions Consumer",
        "javax.portlet.init-param.template-path=/",
        "javax.portlet.init-param.view-template=/sessions-consumer/view.jsp",
        "javax.portlet.resource-bundle=content.Language",
        "javax.portlet.security-role-ref=power-user,user"
    },
    service = Portlet.class
)
public class SessionsConsumerPortlet extends MVCPortlet {
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		
		String data = (String)renderRequest.getPortletSession().getAttribute("data",PortletSession.APPLICATION_SCOPE);
		
		renderRequest.setAttribute("data", data);
		super.doView(renderRequest, renderResponse);
	}
}