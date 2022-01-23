import React from "react";
import ReactDOM from "react-dom";
import './index.css'

function BookList(){
  return (
    <section className="booklist">
      <Book/>
      <Book/>
      <Book/>
      <Book/>
      <Book/>
      <Book/>
      <Book/>
      <Book/>
    </section>
  )
}

const Book = () => {
  return <article className="book">
    <Image/>
    <Title/>
    <Author/>
  </article>
}

const Image = () => {
  return <img src="https://images.morele.net/i256/9615167_0_i256.jpg" alt=""/>
}

const Title = () => {
  return <h1>Tytuł</h1>
}

const Author = () => {
  return <h4>this is an author</h4>
}

ReactDOM.render(<BookList/>, document.getElementById("root"));