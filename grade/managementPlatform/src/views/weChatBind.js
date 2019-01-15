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

message.config({
	duration: 3
})
class WechatCom extends Component {
	state = {
		user           : JSON.parse(localStorage.getItem('userMsg')).user,




		// user :{"success":true,"user":{"id":15,"username":"admin","telno":null,"extensionCode":"ID15PSNDZM","parentCode":"","faction":"","truename":"","loginPswd":"e10adc3949ba59abbe56e057f20f883e","payPswd":"e10adc3949ba59abbe56e057f20f883e","noPrice":900,"isPrice":100,"gmtCreate":"2018-11-28T13:13:14.000+0000","gmtModified":"2018-12-25T06:51:49.000+0000","userType":0,"userStatus":1,"token":"6c661b6a0c717a065427c8a64d5f5ba3","isDel":0},"parentUser":""}.user,






		accountLists   : null,
		accountListsNot: null
	}
	componentDidMount () {
		let overdueDate = localStorage.getItem('overdueDate');
		if (new Date(Number(overdueDate)).getTime() < new Date().getTime()) {
			localStorage.removeItem('overdueDate');
		}
		this.searchWechatLists();
	}
	/*查询公众号列表*/
	searchWechatLists = () => {
		let self = this,
			userId = self.state.user.id;

		// 测试开始------
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
			isPub    : false
		});
		// 测试结束------*/
		fetch(`/wxPublicNum/getPublicNumList?userId=${userId}`)
		.then(res => res.json())
		.then(data => {
			// console.log(data)
			if (data.success) {

				/*const accountLists = data.publicNumList.map((v,inx)=>{
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
					accountLists: accountLists
				});*/
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
				<div className='deleteBtn' style={!isPub ? {display: 'block'} : null } onClick={(e)=>this.validateWechat(e,v.appId)}>认证</div>
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
				</div>
			</div>
		)
	}
}

export default WechatCom;