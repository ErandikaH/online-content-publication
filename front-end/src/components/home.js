import React from 'react';
import history from '../history';
import { Card, Row, DropdownButton, Dropdown } from 'react-bootstrap';

import axios from 'axios';

export class Home extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            publications: [],
            search: '',
            currentPage: 1,
            publicationsPerPage: 20,
            sortDir: "asc",
            category: "Select an item"
        };
        this.getPubilcationList = this.getPubilcationList.bind(this);
    }

    changeValue(text) {
        this.setState({ category: text });
    }

    handleSelect = (e) => {
        this.getPubilcationList(e);
    }

    getPubilcationList = (e) => {
        axios.get("/content/publications/" + e)
            .then(response => response.data).then(
                (data) => {
                    console.log(data);
                    this.setState({ publications: data });
                }
            );
    }

    render() {
        return (
            <div className="center">
                <h3 className="text-white">PubCon</h3>
                <p className="text-white">Erandika Harshani</p>
                <button onClick={() => history.push('/create_publication')} class="btn btn-primary">Publish My Story</button>
                &nbsp;&nbsp;&nbsp;<button class="btn btn-warning" disabled='true'>Subscribe ML/AI</button>
                &nbsp;&nbsp;&nbsp;<button class="btn btn-info" disabled='true'>Subscribe Big Data</button>
                &nbsp;&nbsp;&nbsp;<button class="btn btn-danger" disabled='true'>Subscribe Micro-services</button>
                <p className="text-white">{this.state.publications.length} Stories</p>

                <DropdownButton id="dropdown-item-button" title={this.state.category} className="format" onSelect={this.handleSelect}>
                    <Dropdown.Item as="button" eventKey="1"><div onClick={(e) => this.changeValue(e.target.textContent)}>ML/AI</div></Dropdown.Item>
                    <Dropdown.Item as="button" eventKey="2"><div onClick={(e) => this.changeValue(e.target.textContent)}>Big Data</div></Dropdown.Item>
                    <Dropdown.Item as="button" eventKey="3"><div onClick={(e) => this.changeValue(e.target.textContent)}>Micro-services</div></Dropdown.Item>
                </DropdownButton>

                <Row>
                    {
                        this.state.publications.length === 0 ?
                            <p className="text-white">0 Articles Available. Please Select Category.</p> :
                            this.state.publications.map((publication) => (
                                <Card style={{ width: '18rem', marginRight: '1rem', marginTop: '1rem' }}>
                                    <Card.Body>
                                        <Card.Title>{publication.title}</Card.Title>
                                        <Card.Subtitle className="mb-2 text-muted">[user]</Card.Subtitle>
                                        <Card.Text>{publication.summary}</Card.Text>
                                        <Card.Link href={"/publication/"+publication.id}>Publication Link</Card.Link>
                                    </Card.Body>
                                </Card>
                            )
                            )
                    }
                </Row>
            </div>

        );
    }
}

export default Home;