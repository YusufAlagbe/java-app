package app;

import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinJte;

import java.util.Map;

public class JavalinJteExampleApp {

    public static void main(String[] args) {
        Javalin.create(config -> {
            config.fileRenderer(new JavalinJte());
            config.routes.get("/", ctx -> {
                ctx.render("templates/hello.jte", Map.of("name", "JTE"));
            });
        }).start(7070);
    }
}

