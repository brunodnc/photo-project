# photo-project

A simple, slim and fast solution to photographer-client relation.

## Commands

to run containers just execute docker-compose-up at the docker-compose.yaml folder:

```bash
sudo docker-compose-up
```

Remember if there is any change in the Dockerfiles or Docker-compose you need to run the command below to rebuild the containers

```bash
sudo docker-compose-up --build
```


access adminer at http://localhost:8080/ to manage database after container start

TODO: check if dump is beign loaded on first container initialization


when docker compose is up
access back-end routes at http://localhost:8999/api
access front-end routes at http://localhost:9000/



to run only front-end app for development execute at app folder after installing all depencies with npm install: 

```bash
ng serve --open
```


routes to visit at app: 
```bash
/login
/home
/new-password
/register
/profile
/client/1
```