FROM node:bullseye-slim
WORKDIR /usr/app/frontend
COPY package*.json ./
RUN npm install
COPY . .
EXPOSE 8081
CMD ["npm", "run", "dev-docker"]