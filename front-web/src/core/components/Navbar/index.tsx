import React from 'react';
import { Link } from 'react-router-dom';
import './styles.scss';

const Navbar = () => {
    return (
        <nav className="nav-container bg-primary">
            <div className="col-6">

                <h1 className="nav-title">DS Delivery</h1>

            </div>
        </nav>
    );
};

export default Navbar;