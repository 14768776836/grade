import React , {Component} from 'react';

import {
	message,
	Button

} from 'antd';
import  { 
	Redirect,
	Link
} from 'react-router-dom';
import './../assets/css/makeMoney.css';
import throttle from 'lodash.throttle';

message.config({
	duration: 3
})
class WechatCom extends Component {
	state = {
		user           : JSON.parse(localStorage.getItem('userMsg')).user,
		accountLists   : [],
		accountListsNot: []
	}
	constructor () {
		super();
		this.validateWechat = throttle(this.validateWechat,2500);
	}
	componentDidMount () {
		let overdueDate = localStorage.getItem('overdueDate');
		if (new Date(Number(overdueDate)).getTime() < new Date().getTime()) {
			localStorage.removeItem('overdueDate');
		}
		this.searchWechatLists();
	}
	componentWillUnmount () {
		this.validateWechat.cancel();
	}
	/*查询公众号列表*/
	searchWechatLists = () => {
		let self = this,
			userId = self.state.user.id;

		/*// 测试开始------
		var data = {
			publicNumList: [
				{
					wxUserName: '微信用户昵称---1',
					gzName    : '公众号名称---1',
					bindTime  : '认证时间---1',
					id        : 0,
					appId     : 0,
				}, 
				{
					wxUserName: '微信用户昵称---2',
					gzName    : '公众号名称---2',
					bindTime  : '认证时间---2',
					id        : 1,
					appId     : 1,
				}
			]
		}
		self.addWechatList({
			list     : data,
			stateList: 'accountLists',
			isPub    : true,// 已经认证
		});
		// 测试结束------*/
		fetch(`/wxPublicNum/getPublicNumList?userId=${userId}`)
		.then(res => res.json())
		.then(data => {
			// console.log(data)
			if (data.success) {

				const accountLists = data.publicNumList.map((v,inx)=>{
					return <div className='accountList' key={v.id}>
						<p>微信用户昵称：{v.wxUserName}</p>
						<p>公众号名称&nbsp;&nbsp;&nbsp;&nbsp;：{v.gzName}</p>
						<p>认证时间&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;：{v.bindTime}</p>
					</div>
				});
				const accountListsNot = data.notPublicNum.map((v,inx)=>{
					return <div className='accountList' key={v.id}>
						<p>微信用户昵称：{v.wxUserName}</p>
						<p>公众号名称&nbsp;&nbsp;&nbsp;&nbsp;：{v.gzName}</p>
						<p>认证时间&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;：{v.bindTime}</p>
					</div>
				});
				this.setState({
					accountLists: accountLists,
					accountListsNot: accountListsNot
				});
			} else {
				message.error(data.msg);
			}
		});
	}
	/* 添加公众号列表 
	 * @param list      数据列表
	 * @param stateList 把最终结果添加到state中
	 * @param isPub     是否是已经认证过的公众号
	*/
	addWechatList = ({list,stateList,isPub}) => {
		const accountLists = list.publicNumList.map((v,inx)=>{
			return <div className='accountList' key={v.id}>
				<p>微信用户昵称：{v.wxUserName}</p>
				<p>公众号名称&nbsp;&nbsp;&nbsp;&nbsp;：{v.gzName}</p>
				<p>认证时间&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;：{v.bindTime}</p>
				<div className='deleteBtn' onClick={(e)=>this.validateWechat(e,v.appId)}>{!isPub ? '认证' : '已认证'}</div>
			</div>
		});
		this.setState({
			[stateList]: accountLists
		});
	}
	/* 认证公众号
	 * @param appId 公众号appId
	 * return url   微信授权成功后跳转的地址
	 */
	 // wxPublicNum/getWxLoginOauth2URL
	validateWechat = (e,appId) => {
		console.log('appId---',appId);
		const self = this;
		let userId = this.state.user.id;
		// let userId = 15;
		fetch(`/wxPublicNum/getWxLoginOauth2URL?userId=${userId}&appId=${appId}`)
		.then(res => res.json())
		.then(data => {
			if (data.success) {
				
				self.searchWechatLists();
				// message.success(data.msg);
				let url = data.url;
				let option,strs,param;
				if (url) {
					if (url.indexOf("?") != -1) {
						let str = url.substr(0);
						strs = str.split("&");
						for (let i = 0;i < strs.length;i++) {
							param = (strs[i].split("="))[0];
							if (param === 'code') {
								option = (strs[i].split("="))[1];// 拿到的参数
								localStorage.setItem('code',option);
								break;
							}
						}
					}
				}
				message.success('认证成功了');
			} else {
				message.error(data.msg);
			}
		});
	}
	render () {
		const overdueDate = localStorage.getItem('overdueDate');
		if (!overdueDate) {
			message.warning('登录失效，请重新登录！');
            return <Redirect push to={'/login'}/>
		}
		return (
			<div className='weChatBindBox moneyBox'>
				<div className='returnBox'><Link to='' className='returnBtn'>返回</Link></div>
				<div className='accountBox'>
					{this.state.accountLists}
					{this.state.accountListsNot}
				</div>
			</div>
		)
	}
}

export default WechatCom;