import React from 'react';
import { Row, Col, Image } from 'react-bootstrap';
import './index.css'

const container = {
    height: "130px",
    maxWidth: "800px",
    minWidth: "400px"
}

const stores = [
    {
    id: 1,
    img: "https://bulldogjob.pl/system/companies/logos/000/002/034/original/znak-podstawowy-rgb-01.png"

    },
    {
    id: 2,
    img: "https://prowly-uploads.s3.eu-west-1.amazonaws.com/uploads/6576/assets/175474/original-150354839c9061f0f108754a125c5829.jpg"

    },
    {
    id: 3,
    img: "https://galeriamlociny.pl/app/uploads/wayfinder/url_logo/3048.png"
    }
];

export const PriceCard = () => {
    return ( <Row  className="d-flex justify-content-center flex-nowrap border border-warning">
        {stores.map((store, index) => { 
        return <Col className="border border-secondary col-4" style={{margin: "2px"}} align='center'>     
                    <Image className="img-fluid store-image align-self-start" src={store.img}/>
                    <p className="">5555,55PLN</p>
            </Col>
        })}
        </Row>
    );
}
