package kh.farrukh.springcore.eventadvanced.http;

import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;
import javax.annotation.PostConstruct;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class CommentHttpServer {

  private final ApplicationEventPublisher publisher;
  private HttpServer server;

  public CommentHttpServer(ApplicationEventPublisher publisher) {
    this.publisher = publisher;
  }

  @PostConstruct
  private void start() {
    createServer();
    startServer();
  }

  private void createServer() {
    System.out.println("Starting HTTP server...");

    try {
      server = HttpServer.create(new InetSocketAddress(8080), 5);
      server.createContext("/comment", exchange -> {

        if (!exchange.getRequestMethod().equalsIgnoreCase("POST")) {
          exchange.sendResponseHeaders(405, -1);
          exchange.close();
          return;
        }

        var comment = exchange.getRequestBody().readAllBytes();
        publisher.publishEvent(new String(comment));

        var response = "Comment added";
        exchange.sendResponseHeaders(200, response.length());
        exchange.getResponseBody().write(response.getBytes());
        exchange.getResponseBody().close();
      });
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    System.out.println("HTTP server started on port 8080");
  }

  private void startServer() {
    server.start();
  }

  public void stopServer() {
    server.stop(0);
  }

}
