package org.elasticsearch.cs.plugin.elasticcrudplugin;

import static org.elasticsearch.rest.RestStatus.OK;

import org.elasticsearch.action.ActionFuture;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexRequestBuilder;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.rest.BaseRestHandler;
import org.elasticsearch.rest.BytesRestResponse;
import org.elasticsearch.rest.RestChannel;
import org.elasticsearch.rest.RestController;
import org.elasticsearch.rest.RestRequest;

/**
 * Hello world!
 *
 */
public class CreateIndexHandler extends BaseRestHandler
{

	public CreateIndexHandler(Settings settings, RestController controller, Client client) {
		super(settings, controller, client);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void handleRequest(RestRequest request, RestChannel channel, Client client) throws Exception {
	
		IndexResponse res = client.prepareIndex().setId(request.param("id")).setIndex(request.param("index")).setType(request.param("type")).setSource(request.content()).get();
	    if(res != null) {
	    	channel.sendResponse(new BytesRestResponse(OK, res.toString()));
	    }
	  
	}
   
}
