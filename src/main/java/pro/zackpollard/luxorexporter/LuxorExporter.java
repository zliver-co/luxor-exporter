package pro.zackpollard.luxorexporter;

import com.sun.net.httpserver.HttpServer;
import io.micrometer.prometheus.PrometheusConfig;
import io.micrometer.prometheus.PrometheusMeterRegistry;
import io.prometheus.client.exporter.HTTPServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class LuxorExporter {

    static final LuxorCollector requests = new LuxorCollector().register();

    public static void main(String[] args) {

        new LuxorExporter(args).startPrometheusExporter();
    }

    public LuxorExporter(String[] args) {
    }

    public void startMicrometer() {
        PrometheusMeterRegistry registry = new PrometheusMeterRegistry(PrometheusConfig.DEFAULT);
        registry.config().commonTags("application", "Luxor-Exporter");

        try {
            HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
            server.createContext("/metrics", httpExchange -> {
                String response = registry.scrape();
                httpExchange.sendResponseHeaders(200, response.getBytes().length);
                try (OutputStream os = httpExchange.getResponseBody()) {
                    os.write(response.getBytes());
                }
            });

            new Thread(server::start).start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void startPrometheusExporter() {

        try {
            HTTPServer server = new HTTPServer(8080);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //DefaultExports.initialize();
    }
}