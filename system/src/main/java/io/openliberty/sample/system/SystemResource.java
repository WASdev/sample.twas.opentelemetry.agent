/*******************************************************************************
 * Copyright (c) 2017, 2023 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - Initial implementation
 *******************************************************************************/
package io.openliberty.sample.system;

import java.util.Random;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import io.opentelemetry.instrumentation.annotations.WithSpan;

@RequestScoped
@Path("/properties")
public class SystemResource {

    private static Random rand = new Random(); 
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProperties() throws InterruptedException {
        sleep(rand.nextInt(500));
        return Response.ok(System.getProperties()).build();
    }

    @WithSpan
    private static void sleep(long ms) throws InterruptedException {
        Thread.sleep(ms);
    }
}
