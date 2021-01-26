package com.rogui.gatewayzuul.paths;

public class PathContaDigitalSwagger {

	public static final String[] PUBLIC = { "/rogui-contadigital/v2/api-docs", "/rogui-contadigital/configuration/ui",
			"/rogui-contadigital/swagger-resources/**", "/rogui-contadigital/configuration/security",
			"/rogui-contadigital/swagger-ui.html", "/rogui-contadigital/webjars/**", "/rogui-contadigital/csrf",
			"/rogui-contadigital/", "/rogui-contadigital/definitions/Error" };

	public static final String[] OPERATOR = { "/rogui-contadigital/**" };

	public static final String[] ADMIN = { "/rogui-contadigital/**", "/actuator/**" };

}
