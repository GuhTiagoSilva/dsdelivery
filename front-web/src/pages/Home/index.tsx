import React from 'react';
import './styles.scss';
import { ReactComponent as MainImage } from '../../core/assets/images/main-image.svg';
import Footer from '../../core/components/Footer';

const Home = () => {
    return (
        <>
            <div className="home-container container">
                <div className="home-content col-6">
                    <h1 className="home-title">Faça seu pedido que entregamos pra você!!!</h1>
                    <p>Escolha o seu pedido e em poucos minutos <br />  levaremos na sua porta</p>
                    <button className="btn btn-primary btn-request">
                        <h1 className="button-text">FAZER PEDIDO</h1>
                    </button>
                </div>

                <div className="col-6 home-content-image">
                    <MainImage />
                </div>
            </div>
            <Footer />
        </>

    );
};

export default Home;