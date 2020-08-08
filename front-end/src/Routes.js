import React, { Component } from "react";
import { Router, Switch, Route } from "react-router-dom";

import CreateArticle from "./components/createArticle";
import LogIn from "./components/login";
import Home from "./components/home";
import Welcome from './components/welcome';
import Publication from './components/publication';
import SignUp from './components/signup';

import history from './history';

export default class Routes extends Component {
    render() {
        return (
            <Router history={history}>
                <Switch>
                    <Route path="/online_publication" exact component={Welcome} />
                    <Route path="/login" exact component={LogIn} />
                    <Route path="/home" component={Home} />
                    <Route path="/create_publication" component={CreateArticle} />
                    <Route path="/publication/:id" component={Publication} />
                    <Route path="/signup" component={SignUp} />
                </Switch>
            </Router>
        )
    }
}