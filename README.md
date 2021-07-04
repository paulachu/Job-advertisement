# tp-job-advertisements Project

## The Team

- Mehdi SEDDIKI - mehdi.seddiki
- Valentin THIRON - valentin.thiron
- Paul RADIC - paul.radic
- Alexia BECOUZE - alexia.becouze

## The Project

### Project tools and requirements

This project was built using:
- ``Java`` 16
- ``maven`` 3.6.3 (at least)
- ``Quarkus``
- ``PostgreSQL``
- ``docker-compose``
- ``Github`` along with Travis for Continuous Integration
- ``Swagger``

### Description

The aim of this project is to ease the process of publishing a service online.
Our product is a REST API that allows users to create, update or search such
services. Each service is composed of a number of fields, among other things the
job description, the price or the location of the job.

From a developper perspective, we built our product using best practices:
- we opted for a layered architecture, composed of a presentation layer, a
  business layer also known as service and a repository layer managing the data;
- we usually build our solution step by step, first by writing unit tests, then
  implementing our different features;
- we tried to make each layer impermeable by using converters;
- we used ``Lombok`` to avoid writing boilerplate code (such as constructors,
  getters, setters...);
- we used ``javax.validation`` to add constraints on objects' properties.

### Building the project

You can build the project from the command line by using:

    42sh mvn package

Don't forget to modify the ``application.properties`` file in the ``resources``
folder to configure the connection to your ``PostgreSQL`` database. A script to
initialize the database using example values is also available in the
``resources`` directory.

## Quarkus

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

### Running the application in dev mode

You can run your application in dev mode that enables live coding using:

```shell script
./mvnw compile quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

### Packaging and running the application

The application can be packaged using:

```shell script
./mvnw package
```

It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory. Be aware that it’s not an _über-jar_ as
the dependencies are copied into the `target/quarkus-app/lib/` directory.

If you want to build an _über-jar_, execute the following command:

```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

### Creating a native executable

You can create a native executable using:

```shell script
./mvnw package -Pnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using:

```shell script
./mvnw package -Pnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/tp-job-advertisements-1.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/maven-tooling.html
.

### Provided Code

#### RESTEasy JAX-RS

Easily start your RESTful Web Services

[Related guide section...](https://quarkus.io/guides/getting-started#the-jax-rs-resources)
