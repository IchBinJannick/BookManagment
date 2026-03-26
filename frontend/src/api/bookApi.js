import axios from "axios";

const API = axios.create({
    baseURL: "http://localhost:8080/api",
});

export const getAllBooks = () => API.get("/books");
export const getBookById = (id) => API.get(`/books/${id}`);
export const createBook = (book) => API.post("/books", book);
export const updateBook = (id, book) => API.put(`/books/${id}`, book);
export const deleteBook = (id) => API.delete(`/books/${id}`);
export const getNotRead = () => API.get("/books/unread");
