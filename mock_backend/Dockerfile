FROM node:12

COPY package.json package-lock.json ./
RUN npm ci

COPY . /

EXPOSE 3000

ENTRYPOINT ["npm", "run", "mock-docker"]