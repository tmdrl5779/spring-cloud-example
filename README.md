# spring-cloud-example

port
Eureka Service Discovery : 8761
config-server : 8888
apigateway-service : 8000

localhost:8000/user-service
user-service
- [GET] /welcome : welcome message
- [GET] /health_check : data information
- [POST] /users : create user
- [GET] /users : select all user
- [POST] /login : user login -> response header : token
- [GET] /users/{userId} : select user one
                          - order


localhost:8000/order-service
order-service
- [GET] /health_check : data information
- [POST] {userId}/orders : insert order of userId
- [GET] {userId}/orders : select order of userId


localhost:8000/catalog-service
catalog-service
- [GET] /health_check : data information
- [GET] /catalogs : select item information (catalogs)


RabbitMQ
- apigateway-service
- user-service
- order-service
- catalog-service

Kafka
- producer: order-service
- comsumer : catalog-service
: order-service order itme -> catalog-service update item quantity

Kafka connect
- producer : order-serivce 
- sink : MariaDB
{
    "name":"my-order-sink-connect",
    "config":{
        "connector.class":"io.confluent.connect.jdbc.JdbcSinkConnector",
        "connection.url":"jdbc:mysql://localhost:3307/mydb",
        "connection.user":"root",
        "connection.password":"test1234",
        "auto.create":"true",
        "auto.evolve":"true",
        "delete.enabled":"false",
        "tasks.max":"1",
        "topics":"orders"
    }
}




Distributed Tracing
- Spring Cloud Sleuth
- Zipkin

Monitoring
- Prometheus
- Grafana

