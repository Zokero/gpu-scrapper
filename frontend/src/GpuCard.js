import React from 'react';
import { Card, Col, Row } from 'react-bootstrap';
// import { PriceCard } from './PriceCard';



export const GpuCard = ({chipsetType, manufacturer, img}) => {
  return (
        <Card className="m-2" style={{maxWidth: '600px'}}>
            <Row className='g-0 d-flex flex-nowrap'>
                <Col className='col-4 p-2' >
                    <Card.Img className='img-fluid' style={{maxHeight: '150px'}} src={img}/>
                </Col>
                <Col className='col-8'>
                    <Card.Body className=''>
                        <Card.Title>
                            {chipsetType + " " + manufacturer}
                        </Card.Title>
                        <Card.Text>
                            This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer
                        </Card.Text>
                    </Card.Body>
                </Col>
            </Row>
        </Card>
)};


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
