package com.animals.config.security;

import org.jooby.Jooby;

public class Security extends Jooby {

    {
        use("*", (req, rsp, chain) -> {

            final Role requiredRole = req.route().attr("requiredRole");
            final Role roleFromToken = Role.ADMIN; //let's say we decoded JWT here

            if (requiredRole != null && requiredRole != roleFromToken) rsp.status(403);
            else chain.next(req, rsp);
        }).name("Security");
    }
}
