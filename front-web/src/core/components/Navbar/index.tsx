import React from 'react';
import { Link } from 'react-router-dom';
import './styles.scss';
import  {ReactComponent as Icon} from '../../assets/images/icon.svg';

const Navbar = () => {
    return (
        <nav className="nav-container bg-primary">
            <div className="col-6">
                
                <Link to="/">
                    <h1 className="nav-title"><Icon/></h1>
                </Link>
            </div>
        </nav>
    );
};

export default Navbar;