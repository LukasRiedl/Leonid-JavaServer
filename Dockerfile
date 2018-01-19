FROM jboss/wildfly

RUN /opt/jboss/wildfly/bin/add-user.sh admin passme --silent

COPY target/leonidserver.war /opt/jboss/wildfly/standalone/deployments/leonidserver.war

