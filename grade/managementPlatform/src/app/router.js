import React, {Component} from 'react';
import {
	HashRouter, 
	Route, 
	Link,
} from 'react-router-dom';

import Home        from './../views/home';
import ErrorCom    from './../views/error';
import Login       from './../views/login';
import MakeMoney   from './../views/makeMoney';
import WechatBind  from './../views/weChatBind';
import ShareProfit from './../views/shareProfit';
import Remit       from './../views/remit';
import ChildLists  from './../views/childList';
import CheckStore  from './../views/checkStore';
import Share       from './../views/share';
import Bill        from './../views/bill';
import RecordMoney from './../views/recordMoney';






import UploadFile from './../components/uploadFile';





class RoutersConfig extends Component {
	componentWillUnmount () {
		console.log('componentWillunmount！');
	}
	componentDidMount () {
		console.log('componentDidMount');

	}
	render () {

		return (
			<HashRouter>
				<div className='routerBox'>	
					<Route exact component={Home}        path='/'></Route>
					<Route exact component={ErrorCom}    path='/error'></Route>
					<Route exact component={Login}       path='/login'></Route>
					<Route exact component={MakeMoney}   path='/makeMoney'></Route>
					<Route exact component={WechatBind}  path='/wechatBind'></Route>
					<Route exact component={ShareProfit} path='/shareProfit'></Route>
					<Route exact component={Remit}       path='/remit'></Route>
					<Route exact component={ChildLists}  path='/childLists'></Route>
					<Route exact component={CheckStore}  path='/makeMoney/checkStore'></Route>
					<Route exact component={UploadFile}  path='/uploadFile'></Route>
					<Route exact component={Share}       path='/share'></Route>
					<Route exact component={Bill}        path='/bill'></Route>
					<Route exact component={RecordMoney} path='/recordMoney'></Route>
				</div>
			</HashRouter>

		);
	}
}
export default RoutersConfig;


