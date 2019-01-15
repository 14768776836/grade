import React, {Component} from 'react';
import {
	Row,
	Col,
	Form,
	Icon,
	Input,
	CheckBox,
	message,
	Button
} from 'antd';
import './../assets/css/login.css';

const FormItem = Form.Item;

class LoginFormBox extends Component {
	constructor () {
		super();
		this.state = {
			passWordStr: ''
		}
	}
	/* 表单提交 */
	handleSubmit = (e) => {
		e.preventDefault();
		let self = this;
		this.props.form.validateFields((err, values) => {
	      	if (!err) {
				let params = JSON.stringify({
					username: values.username,
					pswd    : values.pswd
				});
				
				fetch(`/user/userLogin?username=${values.username}&pswd=${values.pswd}`)
				.then(res => res.json())
				.then(data => {
					console.log(data)
					if (data.success) {
						let overdueDate = new Date() + new Date(1000*60*60*24*3);// 登录状态3天以后失效
						// let overdueDate = new Date().getTime() + new Date(6000).getTime();// 6S以后失效
						localStorage.setItem('userMsg',JSON.stringify(data));
						localStorage.setItem('overdueDate',overdueDate);
						window.location.href='/';
						message.success('登录成功!');	
					} else {
						message.error(data.msg);
					}
				});
	     	}
	    });
	}
	/* 密码隐藏 */
	passWordHide = (e) => {
		e.preventDefault();
		let passWordStr = this.state.passWordStr;
		passWordStr += e.currentTarget.value;
		this.setState({
			passWordStr: passWordStr
		});
	}
	render () {
		const {getFieldDecorator} = this.props.form;
		return (
			<div className='login'> 
				<Form layout='vertical' onSubmit={this.handleSubmit} className='login-form'>
					<Row>
						<Col>
							<FormItem>
							{getFieldDecorator
							('username',{
								rules:[{required: true,message: '请填写用户名'}]})
							(<Input prefix={<Icon type='user' style={{color: '#1890ff'}} />} placeholder='用户名' />)
							}
							</FormItem>
						</Col>
						<Col>
							<FormItem>
							{getFieldDecorator
							('pswd',{
								rules:[{required: true,message: '请填写用户密码'}]})
							(<Input type='passWord' prefix={<Icon type='lock' style={{color: '#1890ff'}} />} placeholder='密码' onChange={this.passWordHide} />)
							}
							</FormItem>
						</Col>
						<Col className='btnBox'>
							<Button type='primary' htmlType='submit'>登录</Button>
						</Col>
					</Row>
				</Form>
			</div>
		);
	}
}
const LoginForm = Form.create()(LoginFormBox);
class Login extends Component {
	render () {
		return (
			<LoginForm />
		)
	}
}
export default Login;
