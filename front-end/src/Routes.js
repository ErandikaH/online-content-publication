import React, { Component } from "react";
import { Router, Switch, Route } from "react-router-dom";

import Publication from "./components/publication";
import LogIn from "./components/login";
import Home from "./components/home";
import Welcome from './components/welcome';

import history from './history';

export default class Routes extends Component {
    render() {
        return (
            <Router history={history}>
                <Switch>
                    <Route path="/" exact component={Welcome} />
                    <Route path="/login" exact component={LogIn} />
                    <Route path="/home" component={Home} />
                    <Route path="/publication" component={Publication} />
                </Switch>
            </Router>
        )
    }
}