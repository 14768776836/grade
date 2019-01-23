import React, {Component} from 'react';
import {
	message
} from 'antd';
import {
	Redirect,
	Link
} from 'react-router-dom';

import './../assets/css/makeMoney.css';

class CheckStoreCom extends Component {
	state = {
		wechatSuccess: localStorage.getItem('wechatSuccess'),
		formValues   : localStorage.getItem('formValues'),
		userMsg      : localStorage.getItem('userMsg')
	}
	constructor () {
		super();

	}
	componentDidMount () {	
	}	
	cancel = () => {
		localStorage.removeItem('wechatSuccess');
		this.setState({
			wechatSuccess: null
		})
	}
	/* 总代理添加商户信息时，校验商户 
	* @param 
	* @param 
	* return 
	*/
	checkStoreId = (e) => {
		e.preventDefault();
		let self = this,
			userId = JSON.parse(self.state.userMsg).user.id,
			values = JSON.parse(self.state.formValues),
			appId = values.appid;
		let params = `
			userId=${userId}&
			gzName=${values.gzName}&
			appid=${values.appid}&
			appSecrect=${values.appSecrect}&
			mchId=${values.mchId}&
			filePath=${values.filePath}&
		`;
		fetch(`/wxMch/codeMchNum?userId=${userId}&gzName=${values.gzName}&appid=${values.appid}&mchId=${values.mchId}&apiKey=${values.apiKey}&filePath=${values.filePath}`)
		.then(res => res.json())
		.then(data => {
			if (data.success) {
				self.addMchList(params);
				message.success(data.msg);
				window.location.href = '/makeMoney';
			} else {
				message.error(data.msg);
			}
		})
	}
	/* 添加列表 */	
	addMchList = ({params}) => {
		// 提交新增内容
		fetch(`/wxMch/addMch?${params}`)
		.then(res => res.json())
		.then(data => {
			if (data.success) {
				message.success('添加成功！');
				this.setState({
					wechatSuccess: null
				});
				localStorage.removeItem('wechatSuccess');
			} else {
				message.error(data.msg);
			}
		})

	}
	render () {
		const {wechatSuccess} = this.state;
		if (!wechatSuccess) {
			return <Redirect push to={'/makeMoney'} />
		}	
		return (
			<div>
				<div className='returnBox'><Link to='/makeMoney' className='returnBtn'>返回</Link></div>
				<div className='ant-modal-content checkStoreIdBox' style={wechatSuccess ? {display:'block'} : {display:'none'}}>
					<button className='ant-modal-close' onClick={this.cancel}>
						<span className='ant-modal-close-x'></span>
					</button>
					<div className="ant-modal-header">
						<div className="ant-modal-title">校验商户信息</div>
					</div>
					<div className='ant-modal-body'>
						<p>微信公众号校验成功！请校验商户信息！</p>
					</div>
					<div className='ant-modal-footer'>
						<div>
							<button type="button" className="ant-btn" onClick={this.cancel}><span>取 消</span></button>
							<button type="button" className="ant-btn ant-btn-primary" onClick={this.checkStoreId}><span>校验</span></button>
						</div>
					</div>

				</div>
			</div>
		);
	}
}


export default CheckStoreCom;

