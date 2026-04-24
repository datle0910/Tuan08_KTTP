// src/services/api.js
import axios from "axios";

const API = axios.create({
  baseURL: "http://172.16.35.48:8080", // Orchestrator
});

export const bookTour = (data) => API.post("/book-tour", data);