================
Purpose
================
This assignment is to create a new Web Application for calling Restful Service of Github through URL 
https://api.github.com/search/repositories and return the information to Clients.


=================
Restful TEST
=================
To test restful service, you can use:
	1. Postman Rest Client: it is Google Chrome plugin to test Restful service. It is very simple and useful for testing Restful service.
	2. soupUI: this tool is very powerful for testing web service. It supports both Restful and Soup Service.
	3. Client Java Codes: you can use Java Codes for testing restful service; please see ClientTest.java in this project for more detail. 
	......



=================
Reference API
=================
1. Google Gson: is a Java library that can be used to convert Java Objects into respective JSON format and JSON format into Java Object.
   	Please read http://howtodoinjava.com/best-practices/google-gson-tutorial-convert-java-object-to-from-json/
2. JAXB: is an API that can be used to convert Java Object into XML format and XML format into Java Object.
	Please read https://docs.oracle.com/javase/tutorial/jaxb/intro/
3. RESTEasy: is a JBoss project that provides various frameworks to help you build RESTful Web Services and RESTful Java applications.
	Please read http://resteasy.jboss.org/
	------------------------------------------------------------------------
	Option Name							Default Value			Description 
	------------------------------------------------------------------------
	resteasy.servlet.mapping.prefix		no default				If the url-pattern for the Resteasy servlet-mapping is not /*
	resteasy.scan.providers				false					Scan for @Provider classes and register them
	resteasy.scan.resources				false					Scan for JAX-RS resource classes
	resteasy.scan						false					Scan for both @Provider and JAX-RS resource classes (@Path, @GET, @POST etc..) and register them
	resteasy.providers					no default				A comma delimited list of fully qualified @Provider class names you want to register
	resteasy.use.builtin.providers		true					Whether or not to register default, built-in @Provider classes. (Only available in 1.0-beta-5 and later)
	resteasy.resources					no default				A comma delimited list of fully qualified JAX-RS resource class names you want to register
	resteasy.jndi.resources				no default				A comma delimited list of JNDI names which reference objects you want to register as JAX-RS resources
	javax.ws.rs.core.Application		no default				Fully qualified name of Application class to bootstrap in a spec portable way
   
   
  