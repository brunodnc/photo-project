# photo-project

A simple, slim and fast solution to photographer-client relation.

## Commands

to run containers just execute docker-compose-up at the docker-compose.yaml folder:

```bash
sudo docker-compose-up
```


access http://localhost:8080/ to manage database after container start

```
main database name: pp
```
TODO: check if dump is beign loaded on first container initialization



to run only front-end for development enter app folder and run

```
ng serve --open
```


routes: 
```
/login
/home
/new-password
/register
/profile
/client/1
```