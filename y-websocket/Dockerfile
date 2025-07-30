# FROM node:20.12.2-bookworm-slim
FROM node:20-slim AS builder



WORKDIR /app
COPY . .
RUN npm install

CMD ["node", "server.js"]
