import React from 'react';
import  {GpuCard}  from './GpuCard';
import {Container, Navbar, Row} from 'react-bootstrap';
// import { data } from './gpus';
import { useState, useEffect } from 'react';

export const GpuList = () => {
  const [gpus, setGpus] = useState(null);

  useEffect(() => {
    getData();
    async function getData() {
    const response = await fetch("http://localhost:8080/gpus");
    const data = await response.json();

    // store the data into our books variable
    setGpus(data);
    }
  }, []);

  return (<>
  <Container className='mb-2'>
    <Navbar>
          <div className="container-fluid">
            <a className="navbar-brand">Gpus</a>
            <form className="d-flex">
                <input className="form-control me-2" type="search" placeholder="Search" aria-label="Search"/>
                <button className="btn btn-outline-success" type="submit">Search</button>
            </form>
          </div>
        </Navbar>
  </Container>
    
  <Container className="border">
          <Row className='d-flex justify-content-xxl-between justify-content-center'>
          {gpus && (
          gpus.map((gpu, index) => (
            <GpuCard key={gpu.model} {...gpu}/>   
          )))}
          </Row>
    </Container> 
    </>   
  )};
