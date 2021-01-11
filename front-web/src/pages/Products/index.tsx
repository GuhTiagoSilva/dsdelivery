import React from 'react';
import Footer from '../../core/components/Footer';
import ProductCard from '../../core/components/ProductCard';
import './styles.scss'

const Products = () => {
    return (
        <>
            <div className="products-container">
                <div className="products-information-container">
                    <div className="products-informations-steps">
                        <div className="follow-steps">
                            <h1 className="information-title">SIGA AS <br /> ETAPAS</h1>
                        </div>
                        <div className="product-request-steps">
                            <p className="product-step-description"> <b className="number-one"> 1 </b> Selecione os produtos e localização</p>
                            <p className="product-step-description"><b className="number-one" >2 </b> Depois clique em <b>"ENVIAR PEDIDO"</b></p>
                        </div>
                        <button className="btn btn-primary button-request"><h2 className="button-text">Pedido enviado com sucesso</h2></button>
                    </div>
                </div>

                <div className="products-list">
                    <ProductCard/>
                </div>

            </div>
            <Footer />
        </>
    );
};

export default Products;