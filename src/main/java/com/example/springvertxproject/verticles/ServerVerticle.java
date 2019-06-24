package com.example.springvertxproject.verticles;

import com.example.springvertxproject.verticles.ArticleRecipientVerticle;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpServer;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import org.springframework.stereotype.Component;

/**
 * Accepts HTTP requests and sends them as messages to a designated address.
 */
@Component
public class ServerVerticle extends AbstractVerticle {

    @Override
    public void start() throws Exception {
        super.start();

        Router router = Router.router(vertx);
        router.get("/api/articles")
                .handler(this::getAllArticlesHandler);

        HttpServer httpServer = vertx.createHttpServer();

        httpServer.requestHandler(router::accept)
                  .listen(config().getInteger("http.port", 8080));
    }

    private void getAllArticlesHandler(RoutingContext routingContext) {
        vertx.eventBus().<String>send(ArticleRecipientVerticle.GET_ALL_ARTICLES, "",
                result -> {
                    if (result.succeeded()) {
                        routingContext.response()
                                .putHeader("content-type", "application/json")
                                .setStatusCode(200)
                                .end(result.result()
                                        .body());
                    } else {
                        routingContext.response()
                                .setStatusCode(500)
                                .end();
                    }
                });
    }

}
