import React from "react";
import ReactDOM from "react-dom";
import './index.css'
// import {books} from './books'
// import Book from './Book'
import App from './App'
import 'bootstrap/dist/css/bootstrap.min.css';

// function BookList(){
//   return (
//     <section className="booklist">
//       {books.map((book)=> {
//         const {id, img, author} = book;
//         return <Book key={book.id} book= {book}/> 
//       })}
//     </section>
//   )
// }

ReactDOM.render(
  <React.StrictMode>
      <App />
  </React.StrictMode>,
document.getElementById("root")
);