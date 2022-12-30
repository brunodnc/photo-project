### STAGE 1: Build ###
FROM node:alpine AS build
WORKDIR /usr/src/app
COPY package.json package-lock.json ./
RUN npm install
COPY . .
RUN npm run build

### STAGE 2: Run ###
FROM nginx:alpine
#COPY nginx.conf /etc/nginx/nginx.conf
COPY --from=build /usr/src/app/dist/angular-project/* /usr/share/nginx/html
EXPOSE 80


#Change copy directory to angular dist files, remember to update dist everytime