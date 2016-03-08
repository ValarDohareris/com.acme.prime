package com.acme.prime.eval.application;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.acme.prime.eval.api.Eval;

//import osgi.enroute.configurer.api.RequireConfigurerExtender;
import osgi.enroute.debug.api.Debug;
//import osgi.enroute.google.angular.capabilities.RequireAngularWebResource;
//import osgi.enroute.rest.api.REST;
//import osgi.enroute.twitter.bootstrap.capabilities.RequireBootstrapWebResource;
//import osgi.enroute.webserver.capabilities.RequireWebServerExtender;

//@RequireAngularWebResource(resource={"angular.js","angular-resource.js", "angular-route.js"}, priority=1000)
//@RequireBootstrapWebResource(resource="css/bootstrap.css")
//@RequireWebServerExtender
//@RequireConfigurerExtender
@Component(
		service=EvalApplication.class,
		property = {
				Debug.COMMAND_SCOPE + "=eval",
				Debug.COMMAND_FUNCTION + "=eval"
		},
		name="com.acme.prime.eval"
	)

public class EvalApplication  {
	private Eval eval;
	@Reference
	public void setEval(Eval eval) {
		this.eval = eval;
	}
	
	public double eval(String m) throws Exception{
		return eval.eval(m);
	}

}
