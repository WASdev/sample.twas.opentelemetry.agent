FROM ibmcom/websphere-traditional:latest-ubi

COPY --chown=was:root target/twas-opentelemetry-agent-system.war /work/app/twas-opentelemetry-agent-system.war
COPY --chown=was:root target/opentelemetry-javaagent.jar /work/app/opentelemetry-javaagent.jar
COPY --chown=was:root src/main/config/installApp.py /work/config/installApp.py

ENV ENABLE_BASIC_LOGGING=true
RUN /work/configure.sh
