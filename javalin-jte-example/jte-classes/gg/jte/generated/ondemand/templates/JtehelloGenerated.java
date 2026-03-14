package gg.jte.generated.ondemand.templates;
@SuppressWarnings("unchecked")
public final class JtehelloGenerated {
	public static final String JTE_NAME = "templates/hello.jte";
	public static final int[] JTE_LINE_INFO = {0,0,0,0,0,2,2,2,2,4,4,4,0,0,0,0};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, String name) {
		jteOutput.writeContent("\n<h1>Hello, ");
		jteOutput.setContext("h1", null);
		jteOutput.writeUserContent(name);
		jteOutput.writeContent("!</h1>\n\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		String name = (String)params.get("name");
		render(jteOutput, jteHtmlInterceptor, name);
	}
}
