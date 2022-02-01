import React from 'react';
import  {GpuCard}  from './GpuCard';
import {Container, Navbar, Row} from 'react-bootstrap';
import { data } from './gpus';

export const GpuList = () => {
  return (<>
  <Container className='mb-2'>
    <Navbar>
          <div class="container-fluid">
            <a class="navbar-brand">Gpus</a>
            <form class="d-flex">
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search"/>
                <button class="btn btn-outline-success" type="submit">Search</button>
            </form>
          </div>
        </Navbar>
  </Container>
    
  <Container className="border">
          <Row className='d-flex justify-content-xxl-between justify-content-center'>
          {data.map((gpu) => {
            return<GpuCard key={gpu.id} {...gpu}/>   
          })}
          </Row>
    </Container> 
    </>   
  )};
