// src/lib/axios.ts
import axios, { type AxiosInstance, type InternalAxiosRequestConfig } from 'axios'

const API: AxiosInstance = axios.create({
  baseURL: import.meta.env.VITE_BACKEND_URL || 'http://localhost:8080',
  withCredentials: true, // Important for session cookies (if used)
})

API.interceptors.request.use((config: InternalAxiosRequestConfig) => {
  const token = localStorage.getItem('token')
  if (token && config.headers) {
    config.headers.Authorization = `Bearer ${token}`
  }
  return config
})

export default API
