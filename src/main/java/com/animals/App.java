package com.animals;

import com.animals.config.database.EbeanProvider;
import com.animals.config.security.Security;
import com.animals.domain.AnimalResource;
import com.google.inject.Scopes;
import io.ebean.EbeanServer;
import org.jooby.Jooby;
import org.jooby.RequestLogger;
import org.jooby.flyway.Flywaydb;
import org.jooby.jdbc.Jdbc;
import org.jooby.json.Gzon;
import org.jooby.json.Jackson;

/**
 * @author jooby generator
 */
public class App extends Jooby {

    {
        use(new Jackson()); // <- ok
//        use(new Gzon()); // <- ISSUE 1: serialization fails, deserialization ok

        use("*", new RequestLogger().latency().extended());

        use(new Security());

        use(AnimalResource.class);

        use(new Jdbc());

        use(new Flywaydb());

        use((env, conf, binder) -> binder.bind(EbeanServer.class).toProvider(EbeanProvider.class).in(Scopes.SINGLETON));
    }

    public static void main(final String[] args) {
        run(App::new, args);
    }
}
