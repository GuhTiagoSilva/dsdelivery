import React from 'react';
import { BrowserRouter, Switch, Route } from 'react-router-dom'
import Navbar from './core/components/Navbar';


const Routes = () => {

    <BrowserRouter>
        <Navbar />
        <Switch>
            <Route path="/home" exact>
                
            </Route>
        </Switch>
    </BrowserRouter>
};

export default Routes;