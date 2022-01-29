import React from 'react';
import  {GpuCard}  from './GpuCard';
import {Container} from 'react-bootstrap';
import { data } from './gpus';

const container = {
    height: "130px",
    maxWidth: "800px",
    minWidth: "400px",
    border: "3px solid green",
    margin: "5px"
}

export const GpuList = () => {
  return <Container className="d-flex flex-column" style={{border: "2px solid orange"}}>
      {data.map((gpu, index) => {
        return<GpuCard key={gpu.id} {...gpu}/>
              
      })} 
      </Container>   
};

// export const GpuList = () => {
//   return <Container>

//   {data.map((gpu, index) => {
//       return <Container className="" style={container} >
//                 <GpuCard key={gpu.id} {...gpu}/>
//             </Container>
//       })} 
//       </Container>   
// };

