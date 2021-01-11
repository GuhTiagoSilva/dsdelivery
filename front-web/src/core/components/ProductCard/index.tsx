import React from 'react';
import './styles.scss';


const ProductCard = () => {
    return (
        <div className="product-card-container container">
            <div className="cards-container">
                <h1 className="product-title">Pizza Calabresa</h1>
                <img src="https://i2.wp.com/www.receitasdepizza.com.br/wp-content/uploads/2017/04/pizzacalabresaacebolada.jpg?fit=600%2C400&ssl=1" alt="" className="product-image" />
                <h1 className="product-price">R$ 35,90</h1>

                <div className="description">
                    <h1 className="product-description-title">Descrição</h1>
                    <p className="product-description">
                        Uma deliciosa combinação de <br />  Linguiça Calabresa, rodelas de <br /> cebolas frescas, azeitonas <br /> pretas, mussarela, polpa de <br /> tomate,
                    orégano e massa <br /> especial.
                </p>
                </div>


            </div>
        </div>
    );
};


export default ProductCard;