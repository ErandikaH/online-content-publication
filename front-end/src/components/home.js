import React from 'react';
import history from '../history';
import { Card, Row } from 'react-bootstrap';

import axios from 'axios';

export class Home extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            publications: [],
            search: '',
            currentPage: 1,
            publicationsPerPage: 20,
            sortDir: "asc"
        };
    }

    componentDidMount() {
        axios.get("http://localhost:8081/content/publications/3")
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
                <button onClick={() => history.push('/publication')} class="btn btn-primary">Publish My Story</button>
                &nbsp;&nbsp;&nbsp;<button class="btn btn-warning">Subscribe ML/AI</button>
                &nbsp;&nbsp;&nbsp;<button class="btn btn-info">Subscribe Big Data</button>
                &nbsp;&nbsp;&nbsp;<button class="btn btn-danger">Subscribe Micro-services</button>
                <p className="text-white">{this.state.publications.length} Stories</p>
                <Row>

                    {
                        this.state.publications.length === 0 ?
                            <p className="text-white">0 Articles Available. Please Subscribe</p> :
                            this.state.publications.map((publication) => (
                                <Card style={{ width: '18rem', marginRight: '1rem' , marginBottom: '1rem'}}>
                                    <Card.Body>
                                        <Card.Title>{publication.title}</Card.Title>
                                        <Card.Subtitle className="mb-2 text-muted">[user]</Card.Subtitle>
                                        <Card.Text>{publication.summary}</Card.Text>
                                        <Card.Link href="#">Publication Link</Card.Link>
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