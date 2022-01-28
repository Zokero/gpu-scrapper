import React from 'react';
import {Button} from 'react-bootstrap'


export const Book = (props) => {
  const {img, author} = props.book
 
const clickHandler = (author) => {
  console.log(author)
}
const clickHandlerE = (e) => {
  console.log(e)
  console.log(e.target)
}

  return <article className="book">
    <img src={img} alt=""/>
    <h4>{author}</h4>
    {/* {props.children} */}
    <Button variant='secondary' >test</Button>
    <button type='button' onClick={() => clickHandler(author)}>TestButtons</button>
    <button type='button' onClick={clickHandlerE}>TestButtons</button>
  </article>
}

export default Book