import React, {Component} from 'react';
import {
	Form,
	Input,
	Button,
	Modal,
	Row,
	Col,
	Icon,
	Popconfirm,
	message,
	Upload
} from 'antd';
import {
	Redirect,
	Link
} from 'react-router-dom';

import './../assets/css/makeMoney.css';


const FormItem = Form.Item;
const {TextArea} = Input;
message.config({
    duration: 3
})
class MoneyForm extends Component {
	state = {
		userId      : null,
		visible     : false,
		accountArr  : null,
		accountLists: null,
		uploadProps : null,
	  	fileList    : [],
	  	appId       : null,
	  	// 未上传授权文件时，输入框禁止使用
	  	isFileSuccess: true,
	}
	constructor (props) {
		super(props);
		const overdueDate = localStorage.getItem('overdueDate');
		if (new Date(Number(overdueDate)).getTime() < new Date().getTime()) {
			localStorage.removeItem('overdueDate');
		}
		
	}
	componentDidMount () {
		this.searchBusinessList();
	}
	/*查询商户列表*/
	searchBusinessList = () => {
		let userId = JSON.parse(localStorage.getItem('userMsg')).user.id;
		




		/*let user = JSON.parse(JSON.stringify({"success":true,"user":{"id":15,"username":"admin","telno":null,"extensionCode":"ID15PSNDZM","parentCode":"","faction":"","truename":"","loginPswd":"e10adc3949ba59abbe56e057f20f883e","payPswd":"e10adc3949ba59abbe56e057f20f883e","noPrice":900,"isPrice":100,"gmtCreate":"2018-11-28T13:13:14.000+0000","gmtModified":"2018-12-25T06:51:49.000+0000","userType":0,"userStatus":1,"token":"6c661b6a0c717a065427c8a64d5f5ba3","isDel":0},"parentUser":""}));
		let userId = user.user.id;*/







		this.setState({
			userId: userId
		})
		fetch(`/wxMch/getMchList?userId=${userId}`)
		.then(res => res.json())
		.then(data => {
			if (data.success) {
				/*data.mchList = [{appSecrect: "测试secrect"
				appid: "测试appid"
				gmtCreate: "2019-01-03T10:58:08.000+0000"
				gmtModified: "2019-01-03T10:58:11.000+0000"
				gzName: "测试公众号名称"
				id: 1
				isDel: 0
				mchId: "测试商户号"
				status: 0
				userId: 10}]*/

				const accountLists = data.mchList.map((v,inx)=>{
					return <div className='accountList' key={v.id}>
						<p>公众号名称&nbsp;&nbsp;：{v.gzName}</p>
						<p>公众号appId：{v.appid}</p>
						<p>秘钥&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;：{v.appSecrect}</p>
						<p>商户号&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;：{v.mchId}</p>
						<div className='deleteBtn' onClick={(e)=>this.accountListDelete(e,inx,v.id)}>删除</div>
					</div>
				});
				this.setState({
					accountArr  : data.mchList,
					accountLists: accountLists
				});
			} else {
				message.error(data.msg);
			}
		});
	}
	/*打开新增页面*/
	modalAction = (e,cancel) => {
		e.preventDefault();
		let flag = this.state.visible;
		let isFileSuccess = cancel ? false : true;
		this.setState({
			visible      : !flag,
			isFileSuccess: isFileSuccess
		});
	}
	/* 打开校验商家信息页 */
	modalStore = (e) => {
		this.setState({
			visibleStore: !this.state.visibleStore
		});
	}
	/*新增打款账户*/
	addAccount = (e) => {
		if (this.state.isFileSuccess) return;
		let self = this,
			formValues = {};
		this.props.form.validateFields((err,values) => {
			console.log(values)
			if (!err) {
				formValues.appid      = values.appid;
				formValues.gzName     = values.gzName;
				formValues.appSecrect = values.appSecrect;
				formValues.mchId      = values.mchId;
				formValues.apiKey     = values.apiKey;
				formValues.filePath   = values.fileLoad.file.response.path;
				localStorage.setItem('formValues',JSON.stringify(formValues));
				
				if (!self.checkWechatId({
					userId  : self.state.userId,
					appId   : values.appid
				})) return;
		

				/*let params = `
					userId=${self.state.userId}&
					gzName=${values.gzName}&
					appid=${values.appid}&
					appSecrect=${values.appSecrect}&
					mchId=${values.mchId}
				`;

				// 提交新增内容
				fetch(`/wxMch/addMch?${params}`)
				.then(res => res.json())
				.then(data => {
					if (data.success) {
						message.success('添加成功！');
						this.setState({
							visible: false
						});
						self.searchBusinessList();
						localStorage.removeItem('wechatSuccess');
					} else {
						message.error(data.msg);
					}
				})*/

			}
		})		
	}
	/* 删除账户
	 * @param e
	 * @param inx 数据下标
	 * @param id  列表id
	*/
	accountListDelete = (e,inx,id) => {
		let self = this,
			params = `
				id=${id}
			`;
		fetch(`/wxMch/delMch?${params}`)
		.then(res => res.json())
		.then(data => {
			if (data.success) {
				message.success(data.msg);
				self.searchBusinessList();
				self.setState({
					accountArr: self.state.accountArr.filter((item,i) => i !== inx)
				});
			} else {
				message.error(data.msg);
			}
		});
	}
	/*校验微信公众号 
	* @param userId  用户id
	* @param appId   公众号id
	* return url     微信授权成功后跳转的地址
	*/
	// 在确定提交之前进行校验
	// wxPublicNum/getWxLoginOauth2URLBoss
	checkWechatId = ({userId,appId}) => {
		let flag,
			self = this;
		console.log(userId,appId);
		let params = `userId=${userId}&appId=${appId}`;
		fetch(`/wxPublicNum/getWxLoginOauth2URLBoss?${params}`)
		.then(res => res.json())
		.then(data => {
			if (data.success) {
				message.success('微信公众号校验成功！');
				let url = decodeURI(data.url);
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
								self.savePublicNumUser({
									code   : option,
									userId :userId,
									appId  : appId
								});
								break;
							}
						}
					}
				}
				localStorage.setItem('wechatSuccess','true');
				window.location.href = decodeURI(data.url);
				flag = true;
			} else {
				message.error(data.msg);
				flag = false;
			}
		});
		return flag;
	}
	/* 上传文件 */
	onChange = (info) => {
    	if (info.file.status !== 'uploading') {
      		console.log(info.file, info.fileList);
    	}
   		if (info.file.status === 'done') {
      		message.success(`${info.file.name} 文件上传成功！`);

      		this.setState({
      			isFileSuccess: false
      		})
		} else if (info.file.status === 'error') {
      		message.error(`${info.file.name} 文件上传失败！`);
    	}
  	}
  	/* 获取appId，配置上传文件参数 */
  	appIdChange = (e) => {
  		let self = this,a=e.target.value;
  		this.setState({
  			appId: e.target.value,
  			uploadProps: {
			  	name   : 'file',
			  	action : '/wxMch/upload',
			  	headers: {
				    authorization: 'authorization-text',
		  		},
		  		data: {appId: e.target.value} 
		  	},
  		})
  	}
  	/*保存授权用户信息,微信授权之后*/
  	savePublicNumUser = ({code,appId,userId}) => {
  		let appSecrect = JSON.parse(localStorage.getItem('formValues')).appSecrect;
  		// let requestUrl = 
		fetch(`/wxPublicNum/savePublicNumUser?userId=${userId}&appId=${appId}&code=${code}&appSecrect=${appSecrect}`)
		.then(res => res.json())
		.then(data => {
			if (data.success) {
				message.success('');
			} else {
				message.error(data.msg);
			}
		});
  	}
	render () {
		const {getFieldDecorator} = this.props.form;
		const itemStyle = {
			labelCol: {span: 8},
			wrapperCol: {span: 8},
		}
		const overdueDate = localStorage.getItem('overdueDate');
		if (!overdueDate) {
			message.warning('登录失效，请重新登录！');
            return <Redirect push to={'/login'}/>
		}		
		return (
			<div className='moneyBox' id='moneyBox'>
				<div className='returnBox'><Link to='' className='returnBtn'>返回</Link></div>
				<Button onClick={this.modalAction} className='addBtn'>新增打款账户</Button>
				<div className='accountBox'>
					{this.state.accountLists}
				</div>
				<Modal
					className='moneyModal'
					title='新增打款账户'
					visible={this.state.visible}
					onOk={this.addAccount}
					onCancel={(e)=>this.modalAction(e,'cancel')}
					okText={'校验公众号'}
				>
					<Form>	
						<FormItem label='公众号名称'>
							{getFieldDecorator('gzName',{
								rules:[{required: true,message: '请填写微信公众号'}]})(<Input placeholder='微信公众号' />)
							}
						</FormItem>
						<FormItem label='公众号ID'>
							{getFieldDecorator('appid',{
								rules:[{required: true,message: '请填写微信公众号ID'}]})
							(<Input placeholder='微信公众号ID' onBlur={this.appIdChange} />)
							}
						</FormItem>
						<FormItem label='公众号Key'>
							{getFieldDecorator
							('appSecrect',{
								rules:[{required: true,message: '微信公众号Key'}]})
							(<Input placeholder='微信公众号Key' />)
							}
						</FormItem>
						<FormItem label='商户ID'>
							{getFieldDecorator
							('mchId',{
								rules:[{required: true,message: '请填写商户号ID'}]})
							(<Input placeholder='商户号ID' />)
							}
						</FormItem>
						<FormItem label='商户Key'>
							{getFieldDecorator
							('apiKey',{
								rules:[{required: true,message: '请填写商户Key'}]})
							(<Input placeholder='商户号Key' />)
							}
						</FormItem>
						<FormItem label='配置文件'>
							{getFieldDecorator('fileLoad',{
								rules:[{required: true,message: '请填写微信公众号'}]})(<Upload {...this.state.uploadProps} onChange={this.onChange} showUploadList={true}>
								    <Button disabled={this.state.appId ? false : true}>
								      	<Icon type="upload" /> 选择授权文件
								    </Button>
						  		</Upload>)
							}
						</FormItem>
						{/*			<FormItem label='文本域'>
										{getFieldDecorator
										('longStr',{
											rules:[{required: true,message: '请黏贴那么长的字段'}]})
										(<TextArea placeholder='' style={{height: '2.5rem'}} />)
										}
									</FormItem>*/}
					</Form>
				</Modal>
			</div>
		)
	}
}

const MoneyBox = Form.create()(MoneyForm);
class MoneyCom extends Component {
	render () {

		return (
			<MoneyBox />
		)
	}
}
export default MoneyCom;
