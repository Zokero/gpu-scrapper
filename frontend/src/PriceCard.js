import React from 'react';
import { Row, Col, Image } from 'react-bootstrap';

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
    return (   
        <>
           <Col className="store-col col-4  bg-danger m-1 img-fluid" >     
                    {/* <Image className="" src={stores[0].img}/> */}
                    <p className="">5555,55PLN</p>
            </Col>
        <Col className="store-col col-4 bg-danger m-1" >     
                    {/* <Image className="" src={store.img}/> */}
                    {/* <p className="">5555,55PLN</p> */}
                    TEST
            </Col>
        <Col className="store-col col-4 bg-danger m-1" >     
                    {/* <Image className="" src={store.img}/> */}
                    {/* <p className="">5555,55PLN</p> */}
                    TEST
            </Col>    
        </>   
         
       )
}

// export const PriceCard = () => {
//     return ( 
//         stores.map((store, index) => { 
//         return <Col className="bg-danger m-1" key={store.id}>     
//                     {/* <Image className="" src={store.img}/> */}
//                     {/* <p className="">5555,55PLN</p> */}
//                     TEST
//             </Col>
//         })
        
//     );
// }
