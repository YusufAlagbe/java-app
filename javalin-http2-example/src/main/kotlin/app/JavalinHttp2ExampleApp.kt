package app

import io.javalin.Javalin
import io.javalin.community.ssl.SslPlugin
import io.javalin.http.staticfiles.Location

fun main() {

    Javalin.create { javalinConfig ->
        // Set up the SSL plugin (Enables HTTP2 by default)
        javalinConfig.registerPlugin(SslPlugin { ssl ->
            ssl.keystoreFromClasspath("keystore.jks", "password")
            ssl.insecurePort = 8080
            ssl.securePort = 8443
        })
        javalinConfig.staticFiles.add("/public", Location.CLASSPATH)

        javalinConfig.routes.get("/") { it.result("Hello World") }
    }.start()

    println("Server started with HTTP/2 support!")
    println("  HTTP/1.1: http://localhost:8080/static-files-test.html")
    println("  HTTP/2:   https://localhost:8443/static-files-test.html")
    println("Compare the network tab in your browser to see HTTP/2 in action")
    println("Notice the order of execution/number of simultaneous requests")

}

