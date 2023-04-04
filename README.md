# Distributed Tracing with OpenTelemetry Automatic Instrumentation Agent in WebSphere Application Server traditional

This repository shows how to setup OpenTelemetry automatic instrumentation with Java agent on traditional WebSphere Application Server. This sample contains one JAX-RS application running in traditional WebSphere version 9.0.5. You can invoke the JAX-RS application and examine the trace created by the OpenTelemetry Java agent in Jaeger UI.

## Containers

The docker compose file will run the following containers:
- jaeger: jaegertracing:all-in-one
- system: ibmcom/websphere-traditional:latest-ubi

## Build
- Clone the repository
- `cd sample.twas.opentelemetry.agent`
- `mvn clean install`
- `docker compose build`

## Run
- Start `docker compose up -d` (It will take a minute or two to start up the server.)
- System service: https://localhost:9443/system/properties
- Jaeger UI: http://localhost:16686/
- WebSphere admin console: https://localhost:9043/ibm/console (Username is `wsadmin` and password can be obtained from this command `docker exec system cat /tmp/PASSWORD`)
- Stop `docker compose down`

