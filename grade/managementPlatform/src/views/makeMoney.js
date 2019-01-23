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
import ReactPullLoad ,{ STATS } from 'react-pullload';
/*import HeadNode from './../components/toUpdate/HeadNode';
import FooterNode from './../components/toUpdate/FooterNode';
import './../components/toUpdate/ReactPullLoad.css';*/
import HeadNode from './../../node_modules/react-pullload/dist/HeadNode';
import FooterNode from './../../node_modules/react-pullload/dist/FooterNode';
import './../../node_modules/react-pullload/dist/ReactPullLoad.css';
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
		accountArr  : [],
		accountLists: null,
		uploadProps : null,
	  	fileList    : [],
	  	appId       : null,
	  	// 未上传授权文件时，输入框禁止使用
	  	isFileSuccess: true,
	  	// 上传文件按钮
	  	isUse       : null,
  		pageNum      : 1,
		pageLast     : 0,
		datas        : [], // 就是accountArr
		// 上滑、下拉
		hasMore      : true,
      	action       : STATS.init
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

				this.setState({
					accountArr  : data.mchList,
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
			/*	formValues.appid      = values.appid;
				formValues.gzName     = values.gzName;
				formValues.appSecrect = values.appSecrect;
				formValues.mchId      = values.mchId;
				formValues.filePath   = values.fileLoad.file.response.path;
				formValues.apiKey     = values.apiKey;*/
				
				// 测试数据开始------
				formValues.appid      = 'wx97f93285af090c3e';
				formValues.gzName     = '骚帅';
				formValues.appSecrect = '1f9470d9289615b41e0a6b487bbe5b85';
				formValues.mchId      = '1455666502';
				formValues.apiKey     = 'C50E092772003E8BAFAD8FB7D453888C';
				formValues.filePath   =  encodeURI(values.fileLoad.file.response.path);
				// 测试数据结束------
				
				localStorage.setItem('formValues',JSON.stringify(formValues));
				
				if (!self.checkWechatId({
					userId  : self.state.userId,
					appId   : values.appid
				})) return;
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
   			console.log(decodeURI(info.file.response.path));
      		message.success(`${info.file.name} 文件上传成功！`);

      		this.setState({
      			isFileSuccess: false,
      			isUse        : 1
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
  	/* 移除文件之后 */
  	removeFile = () => {
  		this.setState({
  			isUse: null
  		});
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
  	/* 下拉、上滑状态处理 */
	handleAction = (action) => {
	    console.info(action, this.state.action,action === this.state.action);
	    if(action === this.state.action){
	       return false
	    }
	    if(action === STATS.refreshing){//刷新
	       	this.handRefreshing();
	    } else if(action === STATS.loading){//加载更多
	       	this.handLoadMore();
	    } else{
	        this.setState({
	          	action: action
	       	})
	    }
	}
	/* 是否'刷新'状态 */
	handRefreshing = () => {
		if(STATS.refreshing === this.state.action){
	      	return false
	    }
	    let timer = setTimeout(()=>{
	     	this.setState({
		        hasMore: true,
		        action: STATS.refreshed,
	      	});
	      	clearTimeout(timer);
	    }, 1500)

	    this.setState({
	      	action: STATS.refreshing
	    });	
	}
	/* 是否'更多'状态,'更多'状态处理 */
	handLoadMore = () => {
		if(STATS.loading === this.state.action){
	      	return false
	    }

	    let timer = setTimeout( () => {
	      	if(this.state.index === 0){
	        	this.setState({
	          		action: STATS.reset,
	          		hasMore: false
	        	});
      		} else{
      			let pageNum = this.state.pageNum;
      			pageNum++;
		        this.setState({
		         	action: STATS.reset,
		          	pageNum: pageNum
		        });
		        console.log('---------pageNum---',pageNum)
		        this.searchBusinessList(pageNum);
	      	}
	      	clearTimeout(timer);
	    }, 1500);

	    this.setState({
	      action: STATS.loading
	    })
	}
	render () {
		const { 
			accountArr,
			hasMore,
			action
		} = this.state;
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
		const accountLists = accountArr.map((v,inx)=>{
			return <div className='accountList' key={v.id}>
				<p>公众号名称&nbsp;&nbsp;：{v.gzName}</p>
				<p>公众号appId：{v.appid}</p>
				<p>秘钥&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;：{v.appSecrect}</p>
				<p>商户号&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;：{v.mchId}</p>
				<div className='deleteBtn' onClick={(e)=>this.accountListDelete(e,inx,v.id)}>删除</div>
			</div>
		});	
		return (
			<div className='moneyBox' id='moneyBox'>
				<div className='returnBox'>
					<Link to='' className='returnBtn'>返回</Link>
					<Button onClick={this.modalAction} className='addBtn'>新增打款账户</Button>
				</div>
				{/*<ReactPullLoad 
						          	downEnough={100}
						          	action={action}
						          	handleAction={this.handleAction}
						          	hasMore={hasMore}
						          	distanceBottom={100}
						          	HeadNode={HeadNode}
						          	FooterNode={FooterNode}
						        >
						          	<ul className='accountBox' style={{paddingLeft: 0}}>
						            	{accountLists}
						          	</ul>
						        </ReactPullLoad>*/}
				<div className='accountBox'>
					{accountLists}
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
								rules:[{required: true,message: '请填写微信公众号'}]})(<Upload {...this.state.uploadProps} onChange={this.onChange} showUploadList={true} onRemove={this.removeFile}>
								    <Button disabled={!this.state.appId || this.state.isUse === 1 ? true : false}>
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
