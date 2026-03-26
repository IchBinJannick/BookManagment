import { useState, useEffect } from "react";
import { createBook, updateBook} from "../api/bookApi.js";

function BookFormular({ book, onSaved }) {
    const [formular, setFormular] = useState({
        title: "",
        author: "",
        isbn: "",
        releaseYear: "",
        read: false,
    });

    useEffect(() => {
        if (book) setFormular(book);
    }, [book]);

    function handleChange(e) {
        const { name, value, type, checked } = e.target;
        setFormular((prev) => ({
            ...prev,
            [name]: type === "checkbox" ? checked : value,
        }));
    }

    function handleSubmit(e) {
        e.preventDefault();
        const action = book
          ? updateBook(book.id, formular)
            : createBook(formular);
        action.then(() => {
            onSaved();
            setFormular({title: "", author: "", isbn: "", releaseYear: "", read: false});
        });
    }

    return (
        <form onSubmit={handleSubmit}>
            <input name="title" placeholder="Title" value={formular.title} onChange={handleChange} required />
            <input name="author" placeholder="Author" value={formular.author} onChange={handleChange} required />
            <input name="isbn" placeholder="ISBN" value={formular.isbn} onChange={handleChange} />
            <input name="releaseYear" placeholder="ReleaseYear" value={formular.releaseYear} onChange={handleChange} />
            <label>
                <input type="checkbox" name="read" checked={formular.read} onChange={handleChange} />
                Read
            </label>
            <button type="submit">{book ? "Update" : "Add"}</button>
        </form>
    );
}

export default BookFormular;