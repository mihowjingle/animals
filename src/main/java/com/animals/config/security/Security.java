package com.animals.config.security;

import org.jooby.Jooby;

public class Security extends Jooby {

    {
        use("*", (req, rsp, chain) -> {

            // ISSUE 2 below:
            System.out.println("role = " + req.route().attr("role")); // <- null
            System.out.println("role = " + req.route().<String>attr("role")); // <- null
            System.out.println("role = " + req.route().attributes().get("role")); // <- ok

            final String requiredRole = (String) req.route().attributes().get("role");

            final String roleFromToken = "admin"; //let's say we decoded JWT here

            if (requiredRole != null && !requiredRole.equals(roleFromToken)) rsp.status(403);
            else chain.next(req, rsp);
        }).name("Security");
    }
}
