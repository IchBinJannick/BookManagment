import { useEffect, useState } from "react";
import { getAllBooks, deleteBook } from "../api/bookApi.js";

function BookList({ onEdit }) {
    const [books, setBooks] = useState([]);
    const [load, setLoad] = useState(true);

    function loads() {
        getAllBooks()
            .then((res) => setBooks(res.data))
            .finally(() => setLoad(false));
    }

    useEffect(() => {
        loads();
    }, []);


    function handleDeletion(id) {
        if (window.confirm("Do you really want to delete?")) {
            deleteBook(id).then(load);
        }
    }

    if (load) return <p>Loading...</p>;

    return (
        <table style={{ width: "100%", borderCollapse: "collapse"}}>
            <thead>
            <tr>
                <th>Title</th>
                <th>Author</th>
                <th>Year</th>
                <th>Read</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            {books.map((book) => (
                <tr key={book.id}>
                    <td>{book.title}</td>
                    <td>{book.author}</td>
                    <td>{book.releaseYear}</td>
                    <td>{book.read ? "Yes" : "No"}</td>
                    <td>
                        <button onClick={() => onEdit(book)}>Edit</button>
                        <button onClick={() => handleDeletion(book.id)}>Delete</button>
                    </td>
                </tr>
            ))}
            </tbody>
        </table>
    );
}

export default BookList;