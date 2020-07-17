package MyServeResourceExample.portlet;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;

import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

import MyServeResourceExample.constants.MyServeResourceExamplePortletKeys;

/**
 * @author marceltanuri
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + MyServeResourceExamplePortletKeys.MyServeResourceExample,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class MyServeResourceExamplePortlet extends MVCPortlet {

	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {
		String username = ParamUtil.getString(resourceRequest, "username");
		System.out.println(" : " + username);
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
		jsonObject.put("message", "Hello World " + username + "!");
		writeJSON(resourceRequest, resourceResponse, jsonObject);
	}

}