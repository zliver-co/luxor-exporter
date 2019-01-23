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

        new LuxorExporter(args);
    }

    public LuxorExporter(String[] args) {
        this.startPrometheusExporter();
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