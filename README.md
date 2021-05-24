#### Prerequisite
- Java 1.8
- Kafka
#### Service registry (Eureka)
- Build/Run
  - mvn clean install
  - java -jar target/ms-discovery-0.0.1-SNAPSHOT.jar
- Check
  - http://localhost:8761/
#### Config server (Spring Cloud Config)
- native profile is active reading propertes from local folder
- Update properties 
  - SET **PATH_TO_MICROSERVICES_PROJECT** in /microservices/ms-config-server/src/main/resources/application.yml
  - SET **YOUR_GMAIL_USERNAME** in /microservices/ms-config-properties/ms-mail/dev/ms-mail.yml
  - SET **YOUR_GMAIL_PASSWORD** in /microservices/ms-config-properties/ms-mail/dev/ms-mail.yml
- Run
  - mvn clean install
  - java -jar target/ms-config-server-0.0.1-SNAPSHOT.jar
- Check
  - http://localhost:8888/ms-user/dev -- expect {"name":"ms-user","profiles":["dev"],"label":null,"version":null,"state":null,"propertySources":[{"name":"file:///home/isilona/git/personal/microservices/ms-config-properties/ms-user/dev/ms-user.yml","source":{"spring.h2.console.enabled":true,"spring.h2.console.path":"/h2-console","spring.datasource.url":"jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE","spring.datasource.username":"sa","spring.datasource.password":"","spring.kafka.bootstrap-servers":"localhost:9092","spring.kafka.topic.userCreated":"POS_TRANSACTIONS","security.basic.enabled":false}}]}
#### Pos Transaction service
- Run
  - mvn clean install
  - java -jar target/ms-pos-0.0.1-SNAPSHOT.jar
- Check
  - localhost:8081/api/pos/transactions/save 
	method:POST
	{"id":"1234","posId":"21221","accountNo","A1221111","amount":"123.10"}
#### Email service
- Run
  - mvn clean install
  - java -jar target/ms-mail-0.0.1-SNAPSHOT.jar
- Check
#### Gateway (Zuul)
- Run
  - mvn clean install
  - java -jar target/ms-gateway-0.0.1-SNAPSHOT.jar