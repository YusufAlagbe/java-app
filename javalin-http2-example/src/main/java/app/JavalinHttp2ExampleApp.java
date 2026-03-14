package app;

import io.javalin.Javalin;
import io.javalin.community.ssl.SslPlugin;
import io.javalin.http.staticfiles.Location;

public class JavalinHttp2ExampleApp {

    public static void main(String[] args) {

        Javalin app = Javalin.create(config -> {

            // Set up the SSL plugin (Enables HTTP2 by default)
            config.registerPlugin(new SslPlugin(ssl -> {
                ssl.keystoreFromClasspath("keystore.jks", "password"); // The ssl plugin will enable HTTP/2 by default
                ssl.insecurePort = 8080;
                ssl.securePort = 8443;
            }));

            config.staticFiles.add("/public", Location.CLASSPATH);

            config.routes.get("/", ctx -> ctx.result("Hello World"));
        }).start();

        System.out.println("Server started with HTTP/2 support!");
        System.out.println("  HTTP/1.1: http://localhost:8080/static-files-test.html");
        System.out.println("  HTTP/2:   https://localhost:8443/static-files-test.html");
        System.out.println("Compare the network tab in your browser to see HTTP/2 in action");
        System.out.println("Notice the order of execution/number of simultaneous requests");

    }

}
