import React, {Component} from 'react';
import {
	message
} from 'antd';
import {
	Redirect,
	Link
} from 'react-router-dom';

import './../assets/css/makeMoney.css';

class BillCom extends Component {
	state = {
		userMsg      : localStorage.getItem('userMsg'),
		accountLists : null
	}
	constructor () {
		super();

	}
	componentDidMount () {	
		// 测试---开始---
	    var datas = {"childrenUserList":{"pageNum":2,"pageSize":10,"size":3,"orderBy":null,"startRow":11,"endRow":13,"total":13,"pages":2,"list":[{"id":39,"username":"ege123","telno":null,"extensionCode":"ID39SMLEBP","parentCode":"ID15PSNDZM","faction":null,"truename":"","loginPswd":"e10adc3949ba59abbe56e057f20f883e","payPswd":null,"noPrice":0.00,"isPrice":0.00,"gmtCreate":"2018-12-09T08:56:03.000+0000","gmtModified":null,"userType":0,"userStatus":null,"token":"863fed7fd43cfabbd06d29f96ed48cfe","isDel":0},{"id":38,"username":"255","telno":null,"extensionCode":"ID38GZPXKB","parentCode":"ID15PSNDZM","faction":null,"truename":"","loginPswd":"e10adc3949ba59abbe56e057f20f883e","payPswd":null,"noPrice":0.00,"isPrice":0.00,"gmtCreate":"2018-12-09T08:31:25.000+0000","gmtModified":null,"userType":0,"userStatus":null,"token":"03fd72431ff77f632fd58114795afb27","isDel":0},{"id":16,"username":"han","telno":null,"extensionCode":"ID16RCWBKW","parentCode":"ID15PSNDZM","faction":null,"truename":"","loginPswd":"e10adc3949ba59abbe56e057f20f883e","payPswd":null,"noPrice":0.00,"isPrice":0.00,"gmtCreate":"2018-12-03T08:58:15.000+0000","gmtModified":null,"userType":0,"userStatus":null,"token":"a466f11f1c385411eaee56b8003aee6e","isDel":0}],"firstPage":1,"prePage":1,"nextPage":0,"lastPage":2,"isFirstPage":false,"isLastPage":true,"hasPreviousPage":true,"hasNextPage":false,"navigatePages":8,"navigatepageNums":[1,2]},"success":true};
		const accountLists = datas.childrenUserList.list.map((v,inx)=>{
			return <div className='accountList' key={v.id}>
				<p>用户名&nbsp;&nbsp;&nbsp;&nbsp;：{v.username}</p>
				<p>创建时间：{v.gmtCreate}</p>
			</div>
		});
		this.setState({
			accountLists: accountLists
		});
		// 测试---结束---


		/*let self = this;
		fetch('')
		.then(res => res.json())
		.then(data => {
			if (data.success) {
				
				const accountLists = datas.map((v,inx)=>{
					return <div className='accountList' key={v.id}>
						<p>用户名&nbsp;&nbsp;&nbsp;&nbsp;：{v.username}</p>
						<p>创建时间：{this.chinaTime(v.gmtCreate)}</p>
					</div>
				});
				self.setState({
					userId       : userId,
					accountLists : accountLists,
					datas        : datas,
				})
			} else {
				message.error(data.msg);
			}
		});*/

	}	
	render () {
		const overdueDate = localStorage.getItem('overdueDate');
		const { accountLists } = this.state;
		if (!overdueDate) {
			message.warning('登录失效，请重新登录！');
            return <Redirect push to={'/login'}/>
		}
		return (
			<div className='bill'>
				<div className='returnBox'><Link to='' className='returnBtn'>返回</Link></div>
				<div className='accountBox'>

					<div className='listsBoxs'>
					{accountLists}
					</div>		
				</div>		
			</div>
		);
	}
}


export default BillCom;

