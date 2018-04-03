# Docker para javeros

[Slides](./Slides-Docker-Para-Javeros.pdf)

[Descarga docker](https://www.docker.com/community-edition#/download)

[DockerHub hello-vigojug image](https://hub.docker.com/r/danybmx/hello-vigojug/)

[DockerHub hello-from-java image](https://hub.docker.com/r/danybmx/hello-from-java/)

[Springboot initializer](https://start.spring.io/) Para crear los proyectos springboot

[angular-cli](https://github.com/angular/angular-cli) Para crear el proyecto angular en el usecase

[Gradle docker plugin](https://github.com/palantir/gradle-docker) Para lanzar el build de imagenes docker desde gradle

[Gradle node plugin](https://github.com/srs/gradle-node-plugin) Para compilar/transpilar/minificar el proyecto angular desde gradle

## Como iniciar el caso de uso

1. Clonar el repositorio
2. Moverse a la carpeta usecase
3. Ejecutar: `./build_docker_images.sh`
4. Ejecutar: `docker-compose up -d`
5. Acceder a [localhost/web](http://localhost/web/)
6. Para escalar un servicio ejecutar por ej: `docker-compose up -d --scale api=4` donde api es el servicio a escalar y 4 el número de instancias.

(Necesario tener docker instalado y java para ejecutar el ./gradlew)