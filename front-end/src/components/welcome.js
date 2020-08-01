import React from 'react';

import { Jumbotron } from 'react-bootstrap';

export class Welcome extends React.Component {
    render() {
        return (
            <Jumbotron className="bg-dark text-white">
                <h1>Welcome to Content Publication!</h1>
                <p>
                    Good friends. Good Articles. Plan your research with Content Publication.
                </p>
            </Jumbotron>
        );
    }

}

export default Welcome;
