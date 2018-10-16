package com.tale;

import com.blade.Blade;
import com.blade.security.web.csrf.CsrfMiddleware;
import com.tale.bootstrap.TaleLoader;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

/**
 * Tale启动类
 *
 * @author biezhi
 */
public class Application {

    public static void main(String[] args) {
        Blade blade = Blade.of();
        TaleLoader.init(blade);
        String ePort = System.getenv("PORT");
        blade.listen(Integer.valueOf(ePort == null ? "9000" : ePort))
                .enableCors(true).devMode(false)
                .use(new CsrfMiddleware()).start(Application.class, args);
    }

}
