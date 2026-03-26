import { useState } from 'react'
import './App.css'
import BookFormular from "./components/BookFormular.jsx";
import BookList from "./components/BookList.jsx";

function App() {
  const [selected, setSelected] = useState(null);
  const [update, setUpdate] = useState(0);

  function handleSaved() {
    setSelected(null);
    setUpdate((n) => n + 1);
  }

  return (
      <div style={{ maxWidth: "900px", margin: "0 auto", padding: "2rem"}}>
        <h1>BookManagment</h1>
        <BookFormular buch={selected} onSaved={handleSaved} />
        <hr />
        <BookList key={update} onEdit={setSelected} />
      </div>
  );
}

export default App
