import React from 'react';
import { Card } from 'react-bootstrap';

import axios from 'axios';

export class Publication extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            publication: [],
            search: '',
            currentPage: 1,
            publicationsPerPage: 20,
            sortDir: "asc",
            category: "Select an item"
        };
    }

    componentDidMount() {
        let publicationId = this.props.match.params.id;
        axios.get("/content/" + publicationId)
            .then(response => response.data).then(
                (data) => {
                    console.log(data);
                    this.setState({ publication: data });
                }
            );
    }

    render() {
        return (
            <div className="center">
                <Card>
                    <Card.Body>
                        <Card.Title>{this.state.publication.title}</Card.Title>
                        <Card.Subtitle className="mb-2 text-muted">[user]</Card.Subtitle>
                        <Card.Subtitle className="mb-2 text-muted">[{this.state.publication.publishedDate}]</Card.Subtitle>
                        <Card.Text>{this.state.publication.summary}</Card.Text>
                        <Card.Text>{this.state.publication.details}</Card.Text>
                    </Card.Body>
                </Card>
            </div>

        );
    }
}

export default Publication;