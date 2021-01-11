import React from 'react';
import './styles.scss';
import { ReactComponent as InstagramImage } from '../../assets/images/instagram-image.svg';
import { ReactComponent as LinkedinImage } from '../../assets/images/linkedin-image.svg';
import { ReactComponent as YoutubeImage } from '../../assets/images/youtube-image.svg';

const Footer = () => {
    return (
        <footer className="footer-container">
            <p className="footer-text">App desenvolvido durante a 2ª ed. do evento Semana DevSuperior</p>
            <ul className="icon-container">
                <li><InstagramImage /></li>
                <li><LinkedinImage /></li>
                <li><YoutubeImage /></li>                
            </ul>
        </footer>
    );
};

export default Footer;