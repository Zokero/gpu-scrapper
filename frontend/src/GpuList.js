import React from 'react';
import  {GpuCard}  from './GpuCard';
import {Container} from 'react-bootstrap';
import { data } from './gpus';
import "./index"



export const GpuList = () => {
  return <Container className="border">
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

