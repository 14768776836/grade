import React, {Component} from 'react';
import PropTypes from 'prop-types';
import {
	Avatar,
	Row,
	Col,
	message
} from 'antd';
import {
	Redirect,
	Link
} from 'react-router-dom';
import './../assets/css/home.css';


class Home extends Component {
	static contextTypes = {
		userMsg: PropTypes.object
	}
	constructor (props,context) {
		super(props);
		console.log(context)

		const overdueDate = localStorage.getItem('overdueDate');
		var user = JSON.parse(localStorage.getItem('userMsg'));
		user ? user.user.headImg = '' : null;

		
		this.state = {
			user: user,
			// userStatus=1，总代理
			menuItem: [
				{pageName: '下级用户',inx: '0',router: '/childLists'},
				{pageName: '分销比例',inx: '1',router: '/shareProfit',userStatus: 1},
				{pageName: '打款账户',inx: '2',router: '/makeMoney'  ,userStatus: 1},
				{pageName: '微信绑定',inx: '3',router: '/wechatBind'},
				{pageName: '开始打款',inx: '4',router: '/remit'      ,userStatus: 1},
				{pageName: '分享'    ,inx: '5',router: '/share'},
				// {pageName: '账单'    ,inx: '6',router: '/bill',userStatus: 1},
				{pageName: '收款纪录',inx: '7',router: '/recordMoney'},
				{pageName: '退出登录',inx: '8',router: '/login'},
				// {pageName: '商户检查',inx: '10',router: '/makeMoney/checkStore'},
				// {pageName: '上传文件',inx: '9',router: '/uploadFile'},// 测试功能

			],
			menuList: null
		}
		if (new Date(Number(overdueDate)).getTime() < new Date().getTime()) {
			localStorage.removeItem('overdueDate');
		}
	}
	componentWillMount () {
		console.log('组件将要被渲染，适合做数据操作！');
	}
	componentDidMount () {
		localStorage.removeItem('formValues');
		console.log('DOM树渲染完成，数据接入！');
	}
	componentDidUpdate () {
		console.log('组件更新之后调用')
	}
	componentWillUnount () {
		console.log('组件将要被卸载！');
	}
	render () {
		const overdueDate = localStorage.getItem('overdueDate');
		if (!overdueDate) {
            return <Redirect push to={'/login'}/>
		}
		let self = this;
		const user = self.state.user;
		const menuList = self.state.menuItem.map(v=>{
			return <Col span={7} offset={1} className='pageName' key={v.inx} 
			 style={{display: !user.user.userStatus && v.userStatus === 1 ? 'none' : console.log('总代')}}>
					<div>
					<Link to={v.router}>
					{v.pageName}
				</Link>
					</div>
			</Col>
		});
		return (
			<div className='homeBox'>
				<div className='userMsg'>
					<Avatar src={user.user.headImg} className='userHead' />
					<p>{user.user.username}</p>
				</div>
				<Row className='pageRouters' justify='center' type='flex' align='middle'>
					{menuList}
				</Row>
			</div>
		);
	}
}

export default Home;
