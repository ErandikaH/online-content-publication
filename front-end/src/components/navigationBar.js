import React from 'react';

import { Navbar, Nav, Form, FormControl, Button } from 'react-bootstrap';
import { Link } from "react-router-dom";

import history from '../history';

export class NavigationBar extends React.Component {
    render() {
        return (
            <Navbar bg="dark" variant="dark">
                <Link to={""} className="navbar-brand">
                    <img src="https://upload.wikimedia.org/wikipedia/commons/b/ba/Book_icon_1.png" width="25" height="25" alt="brand" />
                    Content Publication
                </Link>

                <Nav className="mr-auto">
                    <Nav.Link href="/home">Home</Nav.Link>
                    <Nav.Link href="/features">Features</Nav.Link>
                </Nav>

                <Form inline>
                    <Button variant="outline-info" onClick={() => history.push('/login')}>Sign in</Button>&nbsp;&nbsp;&nbsp;
                    <Button variant="outline-info">Sign up</Button>
                </Form>
            </Navbar>
        );
    }

}

export default NavigationBar;
