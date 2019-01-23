import React, {Component} from 'react';
import {
	message
} from 'antd';
import {
	Redirect,
	Link
} from 'react-router-dom';

import './../assets/css/makeMoney.css';

class ShareCom extends Component {
	state = {
		userMsg      : localStorage.getItem('userMsg')
	}
	constructor () {
		super();
	}
	componentDidMount () {	
		message.info('即将开放，敬请期待！');
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
				
			</div>
		);
	}
}


export default ShareCom;

