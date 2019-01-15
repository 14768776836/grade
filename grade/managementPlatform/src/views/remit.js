import React, {Component} from 'react';

import {
	Checkbox,
	message
} from 'antd';
import { Redirect ,Link } from 'react-router-dom';
import './../assets/css/remit.css';

message.config({
	duration: 3
});
const CheckboxGroup = Checkbox.Group;



class RemitCom extends Component {
	state = {	
		indeterminate: true, // 控制选中的样式
		checkAll     : true,// 是否全选
		checkedList  : [],   // 默认选中的列表
		optionsList  : [],   // 可选择的选项
	}
	constructor () {
		super();
		let overdueDate = localStorage.getItem('overdueDate');
		if (new Date(Number(overdueDate)).getTime() < new Date().getTime()) {
			localStorage.removeItem('overdueDate');
		}
	}
	componentDidMount () {
		this.getData();
		console.log(this.state.checkAll)
	}
	/* 获取打款人列表 */
	getData = () => {
		let self = this;
		/*fetch(`/runPercent/findDataByUserId?userId=${self.state.userId}`)
		.then( res => res.json())
		.then( data => {
			if (data.success) {*/
				let checkedList = ['第一项','第二项','第三项','第四项'];
				self.setState({
					checkedList: checkedList,
					optionsList: checkedList
				})
	/*		}
		})*/
	}
	/* 全选 */
	handleCheckAll = (e) => {
		console.log('++++++',e.target)
		this.setState({
			checkedList  : e.target.checked ? this.state.optionsList : [],
	  		indeterminate: false,
	  		checkAll     : e.target.checked,
		})
	}
	/* 单个选择 */
	groupChange = (checkedList) => {
		const { optionsList } = this.state;
		console.log('单个选择---',checkedList)
		this.setState({
			checkedList,
		  	indeterminate: !!checkedList.length && (checkedList.length < optionsList.length),
		  	checkAll: checkedList.length === optionsList.length,
		});
	}
	/* 开始打款 */
	handleSubmit = (e) => {
		e.preventDefault();
		let self = this;
		console.log('可选项---',this.state.optionsList)
		console.log('选中项---',this.state.checkedList)
	}
	render () {
		const { indeterminate , optionsList ,checkedList ,checkAll} = this.state;
		const overdueDate = localStorage.getItem('overdueDate');
		if (!overdueDate) {
			message.warning('登录失效，请重新登录！');
            return <Redirect push to={'/login'}/>
		}

		return (
			<div className='remitBox'>
				<div className='returnBox'><Link to='' className='returnBtn'>返回</Link></div>
				<div className='checkBox'>
					<Checkbox
						indeterminate={indeterminate}
						onChange={this.handleCheckAll}
						checked={checkAll}
					>全选</Checkbox>
					<CheckboxGroup options={optionsList} value={checkedList} onChange={this.groupChange}></CheckboxGroup>
					<div className='remitBtn' onClick={this.handleSubmit}>开始打款</div>
				</div>
			</div>
		)
	}
}
export default RemitCom;

