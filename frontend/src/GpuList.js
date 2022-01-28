import React from 'react';
import  {GpuCard}  from './GpuCard';
import {Container} from 'react-bootstrap';
import { data } from './gpus';

export const GpuList = () => {
  return <Container flex className="">

        {data.map((gpu, index) => {
            return<GpuCard key={gpu.id} {...gpu}/>
        })}
            
      </Container>
};

