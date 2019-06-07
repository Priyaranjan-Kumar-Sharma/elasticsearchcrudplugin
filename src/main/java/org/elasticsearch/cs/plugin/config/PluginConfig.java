package org.elasticsearch.cs.plugin.config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.elasticsearch.common.inject.AbstractModule;
import org.elasticsearch.common.inject.Module;
import org.elasticsearch.plugins.Plugin;

public class PluginConfig extends Plugin{
	
	@Override
	  public String description()
	  {
	    return "Elasticsearch plugin for CRUD Operation";
	  }
	  
	  @Override
	  public String name()
	  {
	    return "ElasticCRUD-plugin";
	  }
	  
	  @Override
	  public Collection<Module> nodeModules()
	  {
	    List<Module> modules = new ArrayList<>();
	    modules.add(new CrudPluginsModuleConfiguration());
	    return modules;
	  }
	  
	  public static class CrudPluginsModuleConfiguration extends AbstractModule {
	    
	    @Override
	    protected void configure()
	    {
	      bind(RequestMappingHandler.class).asEagerSingleton();
	    }
	  }

}
