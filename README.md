# boot-mogodb
MongoDB and SpringBoot 


swgger-ui entry point uri: http://localhost:8080/swagger-ui

````
... via docker stack deploy or docker-compose
Example stack.yml for mongo:

# Use root/example as user/password credentials
version: '3.1'

services:

  mongo:
    image: mongo
    restart: always
    environment:
      MONGO_INITDB_ROOT_USERNAME: root
      MONGO_INITDB_ROOT_PASSWORD: example

  mongo-express:
    image: mongo-express
    restart: always
    ports:
      - 8081:8081
    environment:
      ME_CONFIG_MONGODB_ADMINUSERNAME: root
      ME_CONFIG_MONGODB_ADMINPASSWORD: example
````      
