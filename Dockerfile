################################################################################
# Setup React App
################################################################################
FROM node:bullseye-slim as build-react

# set working directory
WORKDIR /usr/app/frontend
# add `/usr/src/app/node_modules/.bin` to $PATH
# see: https://stackoverflow.com/a/65407744
ENV PATH /usr/app/frontend/node_modules/.bin:$PATH
# install and cache app dependencies
COPY ./frontend/package.json .
COPY ./frontend/package-lock.json .
RUN npm install
ENV NODE_ENV production
# add app
COPY ./frontend .
RUN npm run build
# see https://stackoverflow.com/a/71262331
RUN npm prune --production

################################################################################
# Setup Nginx & Run Commands
################################################################################
FROM nginx:stable-alpine
WORKDIR /usr/app
# Copy React files from build-react stage
COPY --from=build-react /usr/app/frontend/dist /usr/share/nginx/html
#  Copy nginx.conf file
COPY ./proxy/default.conf /etc/nginx/conf.d/default.conf
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]