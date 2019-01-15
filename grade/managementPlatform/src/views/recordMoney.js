import React, {Component} from 'react';
import {
	message
} from 'antd';
import {
	Redirect,
	Link
} from 'react-router-dom';

import './../assets/css/makeMoney.css';

class BillCom extends Component {
	state = {
		userMsg      : localStorage.getItem('userMsg')
	}
	constructor () {
		super();

	}
	componentDidMount () {	
	}	
	render () {
		const overdueDate = localStorage.getItem('overdueDate');
		if (!overdueDate) {
			message.warning('登录失效，请重新登录！');
            return <Redirect push to={'/login'}/>
		}
		return (
			<div>
				<div className='returnBox'><Link to='' className='returnBtn'>返回</Link></div>
				收款纪录
				
			</div>
		);
	}
}


export default BillCom;

