package com.yowshu.ipc.sessions.portlet;

import javax.portlet.Portlet;
import javax.portlet.PortletSession;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;

import org.osgi.service.component.annotations.Component;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.ProcessAction;

/**
 * @author fanqi
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.yowshu",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Sessions Producer",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/sessions-producer/view.jsp",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class SessionsProducerPortlet extends MVCPortlet {

	@ProcessAction(name = "sendData")
	public void sendData(ActionRequest actionRequest, ActionResponse actionResponse) {
		String data = ParamUtil.getString(actionRequest, "data");
		actionRequest.getPortletSession().setAttribute("data",data,PortletSession.APPLICATION_SCOPE);
	}
}