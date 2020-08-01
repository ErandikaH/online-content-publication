import React, { Component } from 'react';
import history from '../history';
import '../App.css';

export class LogIn extends Component {

    render() {
        return (
            <div className="App">
                <header className="App-header">
                    Welcome to Content Publication
                </header>

                <div className="App-body">
                    <form class="px-4 py-3">
                        <div class="form-group">
                            <label for="formControlInput">Email address</label>
                            <input type="email" class="form-control" id="formControlInput" placeholder="user@publisher.com"></input>
                        </div>
                        <div class="form-group">
                            <label for="formControlInput">Password</label>
                            <input type="password" class="form-control" id="formControlInput"></input>
                        </div>
                        <div class="form-group">
                            <div class="form-check">
                                <input type="checkbox" class="form-check-input" id="dropdownCheck"></input>
                                <label class="form-check-label" for="dropdownCheck">
                                    Remember me
                                </label>
                            </div>
                        </div>
                        <button class="btn btn-primary" onClick={() => history.push('/home')}>Sign in</button>
                        <div class="dropdown-divider"></div>
                        <div>
                            New around here?&nbsp;&nbsp;&nbsp;<button type="submit" class="btn btn-primary">Sign Up</button>
                        </div>
                        <a href="#">Forgot password?</a>
                    </form>


                </div>

            </div>
        );
    }
}

export default LogIn;