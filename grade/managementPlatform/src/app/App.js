import React, { Component } from 'react';
import PropTypes from 'prop-types';


import RouterCom from './router';
import '../assets/css/App.css';


class App extends Component {
  	render() {
    	return (
      		<div className="App">
        		<RouterCom /> 
      		</div>
    	);
  	}
}
export default App;
