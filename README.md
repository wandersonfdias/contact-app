# contact-app project

Ajusta ## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```
./mvnw quarkus:dev
```

## Packaging and running the application

The application can be packaged using `./mvnw package`.
It produces the `contact-app-1.0.0-SNAPSHOT-runner.jar` file in the `/target` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/lib` directory.

The application is now runnable using `java -jar target/contact-app-1.0.0-SNAPSHOT-runner.jar`.

## Docker

### Build
```
docker build -f src/main/docker/Dockerfile.jvm -t fiap/challenge/contact-app .
```

### Run 
```
docker run -i --rm -p 8080:8080 fiap/challenge/contact-app
```

## Postman File

View file `postman/fiap-challenge-container.postman_collection.json.

### Implemented Operations

- GET /contact
- POST /contact
- PUT /contact/{id}
- DELETE /contact/{id}

## Creating a native executable

You can create a native executable using: `./mvnw package -Pnative`.

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: `./mvnw package -Pnative -Dquarkus.native.container-build=true`.

You can then execute your native executable with: `./target/contact-app-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/building-native-image.