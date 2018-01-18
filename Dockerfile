FROM jboss/wildfly

RUN /opt/jboss/wildfly/bin/add-user.sh admin passme --silent

ADD target/leonidserver.war /opt/jboss/wildfly/standalone/deployments/

