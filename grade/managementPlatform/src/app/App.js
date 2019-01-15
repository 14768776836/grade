import React, { Component } from 'react';

import RouterCom from './router';


import logo from '../assets/imgs/logo.svg';
import '../assets/css/App.css';

class App extends Component {
  	render() {
    	return (
      		<div className="App">
        		<RouterCom></RouterCom> 
      		</div>
    	);
  	}
}

export default App;
