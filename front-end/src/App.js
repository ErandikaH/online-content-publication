import React from 'react';
import './App.css';
import Routes from './Routes';

import { Container, Row, Col } from 'react-bootstrap';
import { BrowserRouter as Router } from "react-router-dom";

import NavigationBar from './components/navigationBar';
import history from './history';

import './App.css';

function App() {
  const marginTop = {
    marginTop: "20px"
  };

  return (
    <Router history={history}>
      <NavigationBar />
      <Container>
        <Row>
          <Col lg={12} style={marginTop}>
            <Routes />
          </Col>
        </Row>
      </Container>
    </Router>
  );
}

export default App;
