import React from 'react';
import { BrowserRouter, Switch, Route } from 'react-router-dom'
import Navbar from './core/components/Navbar';
import Home from './pages/Home';
import Products from './pages/Products';


const Routes = () => {
    return (
        <BrowserRouter>
            <Navbar />
            <Switch>
                <Route path="/" exact>
                    <Home />
                </Route>
                <Route path="/products">
                   <Products/>
                </Route>
            </Switch>
        </BrowserRouter>
    )
};

export default Routes;