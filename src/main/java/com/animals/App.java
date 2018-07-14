package com.animals;

import com.animals.config.security.Security;
import com.animals.domain.AnimalResource;
import org.jooby.Jooby;
import org.jooby.RequestLogger;
import org.jooby.ebean.Ebeanby;
import org.jooby.flyway.Flywaydb;
import org.jooby.jdbc.Jdbc;
import org.jooby.json.Jackson;

/**
 * @author jooby generator
 */
public class App extends Jooby {

    {
        use(new Jackson());

        use("*", new RequestLogger().latency().extended());

        use(new Security());

        use(AnimalResource.class);

        use(new Jdbc());

        use(new Flywaydb());

        use(new Ebeanby().doWith(conf -> {
            conf.setAutoCommitMode(false);
            conf.setName("ebean");
            conf.setDefaultServer(true);
            conf.setDisableClasspathSearch(false);
            conf.addPackage("com.animals.domain");
            conf.setExpressionNativeIlike(true);
        }));
    }

    public static void main(final String[] args) {
        run(App::new, args);
    }
}
