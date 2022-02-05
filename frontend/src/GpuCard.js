import React from 'react';
import { Card, Col, Row } from 'react-bootstrap';

export const GpuCard = ({chipsetType, chipset, manufacturer, price}) => {
  return (
        <Card className="m-2" style={{maxWidth: '600px'}}>
            <Row className='g-0 d-flex flex-nowrap'>
                <Col className='col-4 p-2' >
                    <Card.Img className='img-fluid' style={{maxHeight: '150px'}} src="https://images.morele.net/i256/4144583_0_i256.jpg"/>
                </Col>
                <Col className='col-8'>
                    <Card.Body className=''>
                        <Card.Title>
                            {chipset + " " + chipsetType + " " + manufacturer}
                        </Card.Title>
                        <Card.Text>
                            {price}
                        </Card.Text>
                    </Card.Body>
                </Col>
            </Row>
        </Card>
)};
