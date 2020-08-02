import React from 'react';
import { Form, Button } from 'react-bootstrap';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faSave, faUndo } from '@fortawesome/free-solid-svg-icons';

import history from '../history';

import axios from 'axios';

import './publication.css';

export class SignUp extends React.Component {

    constructor(props) {
        super(props);
        this.state = this.initialState;
        this.submitProfile = this.submitProfile.bind(this);
        this.profileChange = this.profileChange.bind(this);
    }

    initialState = {
        email: '', fullName: '', countryOfOrigin: '', description: '', password: ''
    }

    resetProfile = () => {
        this.setState(() => this.initialState);
    }

    profileChange(event) {
        this.setState({
            [event.target.name]: event.target.value
        });
    }

    submitProfile = event => {
        event.preventDefault();
        const user = {
            email: this.state.email,
            fullName: this.state.fullName,
            countryOfOrigin: this.state.countryOfOrigin,
            description: this.state.description,
            password: this.state.password
        };

        axios.post("http://localhost:8080/user", user)
            .then(response => {
                if (response.data != null) {
                    this.setState(this.initialState);
                    alert('User saved successfully.');
                    history.push('/login');
                }
            });
    }

    render() {
        const { email, fullName, countryOfOrigin, description, password } = this.state;
        return (
            <Form onReset={this.resetProfile} onSubmit={this.submitProfile} id="profileFormId">
                <div className="Publication text-white">
                    <div class="form-group row">
                        <label for="email" class="col-sm-2 col-form-label">Email</label>
                        <div class="col-sm-10">
                            <input type="email" class="form-control" id="email" placeholder="Email" value={email} name="email" required onChange={this.profileChange}></input>
                        </div>
                    </div>

                    <div class="form-group row">
                        <label for="fullName" class="col-sm-2 col-form-label">Full Name</label>
                        <div class="col-sm-10">
                            <input type="fullName" class="form-control" id="fullName" placeholder="Full Name" value={fullName} name="fullName" onChange={this.profileChange}></input>
                        </div>
                    </div>

                    <div class="form-group row">
                        <label for="countryOfOrigin" class="col-sm-2 col-form-label">Country Of Origin</label>
                        <div class="col-sm-10">
                            <input type="countryOfOrigin" class="form-control" id="countryOfOrigin" placeholder="Country Of Origin" value={countryOfOrigin} name="countryOfOrigin" onChange={this.profileChange}></input>
                        </div>
                    </div>

                    <div class="form-group row">
                        <label for="description" class="col-sm-2 col-form-label">Description</label>
                        <div class="col-sm-10">
                            <textarea class="form-control" id="description" rows="3" value={description} name="description" onChange={this.profileChange}></textarea>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="formControlInput" class="col-sm-2 col-form-label">Password</label>
                        <div class="col-sm-10">
                            <input type="password" class="form-control" id="password" value={password} name="password" onChange={this.profileChange} required></input>
                        </div>
                    </div>

                    <div class="form-group row">
                        <label for="formControlInput" class="col-sm-2 col-form-label">Confirm Password</label>
                        <div class="col-sm-10">
                            <input type="password" class="form-control" id="confirmPassword" name="confirmPassword" onChange={this.profileChange} required></input>
                        </div>
                    </div>
                    <Button size="sm" variant="success" type="submit">
                        <FontAwesomeIcon icon={faSave} /> Submit
                            </Button>{' '}
                    <Button size="sm" variant="info" type="reset">
                        <FontAwesomeIcon icon={faUndo} /> Reset
                            </Button>{' '}
                </div>
            </Form>
        );
    }
}

export default SignUp;