FROM nginx:alpine
COPY /dist/angular-project/* /usr/share/nginx/html
EXPOSE 80


#Change copy directory to angular dist files, remember to update dist everytime