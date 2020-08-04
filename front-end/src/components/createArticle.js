import React from 'react';
import { Form, Button } from 'react-bootstrap';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faSave, faUndo } from '@fortawesome/free-solid-svg-icons';

import axios from 'axios';

import './publication.css';

export class CreateArticle extends React.Component {

    constructor(props) {
        super(props);
        this.state = this.initialState;
        this.submitPublication = this.submitPublication.bind(this);
        this.publicationChange = this.publicationChange.bind(this);
    }

    initialState = {
        title: '', category: '', summary: '', details: ''
    }

    resetPublication = () => {
        this.setState(() => this.initialState);
    }

    publicationChange(event) {
        this.setState({
            [event.target.name]: event.target.value
        });
    }

    submitPublication = event => {
        event.preventDefault();
        const publication = {
            title: this.state.title,
            category: this.state.category,
            summary: this.state.summary,
            details: this.state.details
        };

        axios.post("http://ec2-52-77-223-85.ap-southeast-1.compute.amazonaws.com/content/publish/1", publication)
            .then(response => {
                if (response.data != null) {
                    this.setState(this.initialState);
                    alert('Article saved successfully.');
                }
            });
    }

    render() {
        const { title, summary, details } = this.state;
        return (
            <Form onReset={this.resetPublication} onSubmit={this.submitPublication} id="publicationFormId">
                <div className="Publication text-white">
                    <div class="form-group row">
                        <label for="title" class="col-sm-2 col-form-label">Title</label>
                        <div class="col-sm-10">
                            <input type="title" class="form-control" id="title" placeholder="Title" value={title} name="title" required onChange={this.publicationChange}></input>
                        </div>
                    </div>

                    <div class="form-group row">
                        <label for="category" class="col-sm-2 col-form-label">Select Category</label>
                        <div class="col-sm-10">
                            <select id="inlineFormCustomSelect" name="category" onChange={this.publicationChange}>
                                <option selected>Choose...</option>
                                <option value="1">ML/AI</option>
                                <option value="2">Big Data</option>
                                <option value="3">Micro-services</option>
                            </select>
                        </div>
                    </div>

                    <div class="form-group row">
                        <label for="summary" class="col-sm-2 col-form-label">Summary</label>
                        <div class="col-sm-10">
                            <textarea class="form-control" id="summary" rows="3" value={summary} name="summary" required onChange={this.publicationChange}></textarea>
                        </div>
                    </div>

                    <div class="form-group row">
                        <label for="content" class="col-sm-2 col-form-label">Content</label>
                        <div class="col-sm-10">
                            <textarea class="form-control" id="details" rows="10" value={details} name="details" required onChange={this.publicationChange}></textarea>
                        </div>
                    </div>
                    <Button size="sm" variant="success" type="submit">
                        <FontAwesomeIcon icon={faSave} /> Publish
                            </Button>{' '}
                    <Button size="sm" variant="info" type="reset">
                        <FontAwesomeIcon icon={faUndo} /> Reset
                            </Button>{' '}
                </div>
            </Form>
        );
    }
}

export default CreateArticle;