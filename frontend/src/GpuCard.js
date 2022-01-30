import React from 'react';
import { Col, Image, Row } from 'react-bootstrap';
import { PriceCard } from './PriceCard';



export const GpuCard = ({chipsetType, manufacturer, index}) => {
  return (
        <Row className="p-3 bg-success main-row d-flex flex-nowrap" >
                <Col className=" image-col bg-secondary col-auto" >
                    <Image className="gpu-img" src="https://images.morele.net/i256/9289668_0_i256.jpg"/>
                    {/* TEST */}
                </Col>
                <Col className=" h-100 col-auto prices-col bg-primary">
                    <Row className="bg-light p-1 m-1">
                        <Col>{/* <h4>{chipsetType + " " + manufacturer}</h4> */}
                        TEST
                        </Col>
                    </Row>
                    <Row className="bg-info m-1 d-flex flex-nowrap">
                       <PriceCard /> 
                    </Row>
                </Col>
        </Row>   
)};


// export const GpuCard = ({chipsetType, manufacturer, index}) => {
//   return<Container className="justify-content-center" style={container}>
//             <Row className='border border-info d-flex justify-content-center flex-nowrap'>
//                 <Col className="col-3  d-flex align-items-center justify-content-center border border-danger" >
//                     <Image className="img-fluid px-3" src="https://images.morele.net/i256/9289668_0_i256.jpg"/>
//                 </Col>
//                 <Col className="col-9 border h=100">
//                     {/* <Row  className="justify-content-center justify-content-center border border-danger h-25"> */}
//                         <h4>{chipsetType + " " + manufacturer}</h4>
                    
//                     <PriceCard />
//                 </Col>
//             </Row>
//         </Container>
// };


// export const GpuCard = ({chipsetType, manufacturer, index}) => {
//   return<Container fluid className="h-100">
//             <Row className='border border-info h-100'>
//                 <Col className="col-4 d-flex justify-content-center ">
//                     {/* <Image className="" src="https://images.morele.net/i256/9289668_0_i256.jpg"/> */}
//                 </Col>
//                 <Col className=" col-md-8 border border-secondary">
//                     <Row className="border border-danger">
//                         {/* <h2>{chipsetType + " " + manufacturer}</h2> */}
//                     </Row>
//                     <Row  className="flex-nowrap border border-warning ">
//                         <Col  >
//                         {/* <PriceCard /> */}
//                         </Col>
//                         <Col >
//                         {/* <PriceCard /> */}
//                         </Col>
//                         <Col >
//                         {/* <PriceCard /> */}
//                         </Col>
//                     </Row>
//                 </Col>
//             </Row>
//         </Container>
// };
