import React, {Component} from 'react';

import {
	Form,
	Input,
	Row,
	Col,
	Button,
	message
} from 'antd';
import { Redirect ,Link } from 'react-router-dom';
import './../assets/css/shareProfit.css';

const FormItem = Form.Item;
message.config({
	duration: 3
});
let levelGlob = {};
class ShareProfitFormBox extends Component {
	state = {	
		userId     : JSON.parse(localStorage.getItem('userMsg')).user.id,




		// userId : JSON.parse(JSON.stringify({"success":true,"user":{"id":15,"username":"admin","telno":null,"extensionCode":"ID15PSNDZM","parentCode":"","faction":"","truename":"","loginPswd":"e10adc3949ba59abbe56e057f20f883e","payPswd":"e10adc3949ba59abbe56e057f20f883e","noPrice":900,"isPrice":100,"gmtCreate":"2018-11-28T13:13:14.000+0000","gmtModified":"2018-12-25T06:51:49.000+0000","userType":0,"userStatus":1,"token":"6c661b6a0c717a065427c8a64d5f5ba3","isDel":0},"parentUser":""})).user.id,
		



		inputFlag  : true,
		btnWord    : '修改',
		// grad       : 0,   // 分润等级
		gradId     : null,// 若有已经设置过分润等级时，gradeRunPercent是有值的，id为其下面字段
		runPercent : null,
		runLevel   : null,
	}
	constructor () {
		let overdueDate = localStorage.getItem('overdueDate');
		super();
		if (new Date(Number(overdueDate)).getTime() < new Date().getTime()) {
			localStorage.removeItem('overdueDate');
		}
	}
	componentDidMount () {
		this.getData();
	}
	/* 获取分润数据 */
	getData = () => {
		let self = this;
		fetch(`/runPercent/findDataByUserId?userId=${self.state.userId}`)
		.then( res => res.json())
		.then( data => {
			if (data.success && data.gradeRunPercent) {
				let runPercent = null,
				level = {
					value1: '',
					value2: '',
					value3: '',
					value4: '',
					value5: ''
				}
				self.setState({
					gradId    : data.gradeRunPercent.id,
					runLevel  : data.gradeRunPercent.runLevel,
					runPercent: data.gradeRunPercent.runPercent,
				})
				runPercent = JSON.parse(data.gradeRunPercent.runPercent);
				localStorage.setItem('profitLevel',runPercent.length);
				for (let i = 0;i < runPercent.length;i++) {
					level[`value${i+1}`] = runPercent[i].value;
				}
				self.props.form.setFieldsValue({
	            	runLevel: data.gradeRunPercent.runLevel,
	            	level1  : level.value1,
					level2  : level.value2,
					level3  : level.value3,
					level4  : level.value4,
					level5  : level.value5 
                });
			}
		})
	}
	/* 根据分润层级添加各级分润 */
	changeHandle = (e) => {
		const value = parseInt(e.target.value);
		if (!value) return;
		var self = this;
		localStorage.setItem('profitLevel',value);
	}
	/* 修改分润 */
	handleSubmit = (e) => {
		e.preventDefault();
		let runPercentArr = [],
			self = this,
			inputFlag = self.state.inputFlag,
			btnWord   = inputFlag ? '保存' : '修改';
		self.setState({
			inputFlag: !inputFlag,
			btnWord  : btnWord
		})
		const {gradId,userId,runLevel,runPercent} = self.state;
		self.props.form.validateFields((err, values) => {
			if (!err && values.runLevel && !inputFlag) {
				let runLevel = values.runLevel;
				// runPercentArr = [{"levle":"1","value":"5"},{"levle":"2","value":"7"}]
				// 将输入框数据拼接成参数
				let i = 0;
				for (let ele in values) {
					if (values[ele] >= 100) {message.error('请填写正确的分润比例！'); return}
					if (/[0-9]$/.test(ele) && values[ele]) {
						runPercentArr.push({
							level: i+1,
							value: values[ele]
						});
						levelGlob[ele] = values[ele]
						i++
					}
				}
				// 清除数据中多余的值
				let j = 0;
				for (let eles in levelGlob) {
					if (j+1 > localStorage.getItem('profitLevel')) {
						delete levelGlob[eles];
						runPercentArr.splice(j);
					}
					j++
				}
				// 服务端接受数据格式为Java对象，所以此处使用encodeURI
				let runPercentCode = encodeURI(JSON.stringify(runPercentArr));
                // let runPercentCode = encodeURI(JSON.stringify([{"levle":"1","value":"5"},{"levle":"2","value":"7"}]));
                if (runPercentCode ==='undefined') {return};
            	let params = gradId ? 'id='+gradId+'&userId='+userId+'&runLevel='+runLevel+'&runPercent='+ runPercentCode
				                    : 'userId='+userId+'&runLevel='+runLevel+'&runPercent='+ runPercentCode;
				self.setState({
					runLevel  : values.runLevel,
					runPercent: JSON.stringify(runPercentArr)
				});
				fetch('/runPercent/saveRunPercent?'+params)
				.then( res => res.json())
				.then( data => {
					if (data.success) {
						message.success(data.msg);
						// 初始输入框值
						self.props.form.setFieldsValue({
			            	runLevel: runLevel,
			            	level1  : levelGlob['level1'],
			            	level2  : levelGlob['level2'],
			            	level3  : levelGlob['level3'],
			            	level4  : levelGlob['level4'],
			            	level5  : levelGlob['level5']
		                });				
					} else {
						message.error(data.msg);
					}
				})
			}
		})
	}
	render () {
		const { inputFlag,btnWord } = this.state;
		const {getFieldDecorator} = this.props.form;
		const inputStyle = {
			borderColor: 'rgba(24, 144, 255,.8)'
		} 
		let profitLevel = localStorage.getItem('profitLevel');
		const overdueDate = localStorage.getItem('overdueDate');
		if (!overdueDate) {
			message.warning('登录失效，请重新登录！');
            return <Redirect push to={'/login'}/>
		}
		return (
			<div className='shareProfitForm'>
				<div className='returnBox'><Link to='' className='returnBtn'>返回</Link></div>
				<Form className='shareBox' layout='vertical' onSubmit={this.handleSubmit}>
					<Row>
						<Col className='shareCol'>
							<FormItem label='分润层级'>
							{getFieldDecorator('runLevel',{})(<Input onChange={this.changeHandle} placeholder='分润层级' disabled={inputFlag} style={!inputFlag ? {...inputStyle} : null} />)}
							</FormItem>
						</Col>
						<Col className='shareCol' style={{display: profitLevel >= 1 ? 'block' : 'none'}}>
							<FormItem label='第1级分润比例：'>
							{getFieldDecorator('level1',{
								rules: [{message: '填写分润层级'}]
							})(<Input placeholder='分润层级' disabled={inputFlag} style={!inputFlag ? {...inputStyle} : null} />)}
								<span className='percent'>%</span>
							</FormItem>
						</Col>
						<Col className='shareCol' style={{display: profitLevel >= 2 ? 'block' : 'none'}}>
							<FormItem label='第2级分润比例：'>
							{getFieldDecorator('level2',{
								rules: [{message: '填写分润层级'}]
							})(<Input placeholder='分润层级' disabled={inputFlag} style={!inputFlag ? {...inputStyle} : null} />)}
								<span className='percent'>%</span>
							</FormItem>
						</Col>
						<Col className='shareCol' style={{display: profitLevel >= 3 ? 'block' : 'none'}}>
							<FormItem label='第3级分润比例：'>
							{getFieldDecorator('level3',{
								rules: [{message: '填写分润层级'}]
							})(<Input placeholder='分润层级' disabled={inputFlag} style={!inputFlag ? {...inputStyle} : null} />)}
								<span className='percent'>%</span>
							</FormItem>
						</Col>
						<Col className='shareCol' style={{display: profitLevel >= 4 ? 'block' : 'none'}}>
							<FormItem label='第4级分润比例：'>
							{getFieldDecorator('level4',{
								rules: [{message: '填写分润层级'}]
							})(<Input placeholder='分润层级' disabled={inputFlag} style={!inputFlag ? {...inputStyle} : null} />)}
								<span className='percent'>%</span>
							</FormItem>
						</Col>
						<Col className='shareCol' style={{display: profitLevel >= 5 ? 'block' : 'none'}}>
							<FormItem label='第5级分润比例：'>
							{getFieldDecorator('level5',{
								rules: [{message: '填写分润层级'}]
							})(<Input placeholder='分润层级' disabled={inputFlag} style={!inputFlag ? {...inputStyle} : null} />)}
								<span className='percent'>%</span>
							</FormItem>
						</Col>
					</Row>
					<div className='shareBtn'><Button type='primary' onClick={this.handleSubmit}>{btnWord}</Button></div>
				</Form>
			</div>
		)
	}
}

const ShareProfitForm = Form.create()(ShareProfitFormBox);
class ShareProfit extends Component {

	render () {
		return (
			<ShareProfitForm />
		)
	}
}
export default ShareProfit;

