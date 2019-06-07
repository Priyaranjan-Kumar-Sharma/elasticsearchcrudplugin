package org.elasticsearch.cs.plugin.config;

import org.elasticsearch.client.Client;
import org.elasticsearch.common.inject.Inject;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.cs.plugin.elasticcrudplugin.CreateIndexHandler;
import org.elasticsearch.rest.BaseRestHandler;
import org.elasticsearch.rest.RestChannel;
import org.elasticsearch.rest.RestController;
import org.elasticsearch.rest.RestRequest;
import org.elasticsearch.rest.RestRequest.Method;

public class RequestMappingHandler extends BaseRestHandler{

	@Inject
	public RequestMappingHandler(Settings settings, RestController controller, Client client) {
		super(settings, controller, client);
		controller.registerHandler(Method.PUT, "/createindex/{index}/{type}/{id}", new CreateIndexHandler(settings, controller, client));
	}
	
	@Override
	public void handleRequest(RestRequest request, RestChannel channel, Client client) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
