# FROM node:20.12.2-bookworm-slim
FROM node:20-slim AS builder



WORKDIR /app
COPY . .
RUN npm install
RUN npm run build

# Serve using nginx
FROM nginx:1.26-alpine
COPY --from=0 /app/dist /usr/share/nginx/html
